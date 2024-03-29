package com.yanti.inventorycontroll.domain.service.apriori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.paukov.combinatorics3.Generator;
import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.exception.BusinessException;

import com.yanti.inventorycontroll.domain.bean.apriori.AprioriCalculateServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriCalculateServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.apriori.ItemTransaction;
import com.yanti.inventorycontroll.domain.model.apriori.HApriori;
import com.yanti.inventorycontroll.domain.model.apriori.HAprioriCriteria;
import com.yanti.inventorycontroll.domain.model.aprioriassociation.HAprioriAssociation;
import com.yanti.inventorycontroll.domain.model.aprioriassociation.HAprioriAssociationCriteria;
import com.yanti.inventorycontroll.domain.model.aprioriassociationitem.HAprioriAssociationItem;
import com.yanti.inventorycontroll.domain.model.aprioriassociationitem.HAprioriAssociationItemCriteria;
import com.yanti.inventorycontroll.domain.model.apriorisupport.HAprioriSupport;
import com.yanti.inventorycontroll.domain.model.apriorisupport.HAprioriSupportCriteria;
import com.yanti.inventorycontroll.domain.model.apriorisupportitem.HAprioriSupportItem;
import com.yanti.inventorycontroll.domain.model.apriorisupportitem.HAprioriSupportItemCriteria;
import com.yanti.inventorycontroll.domain.model.item.MItem;
import com.yanti.inventorycontroll.domain.repository.apriori.HAprioriRepository;
import com.yanti.inventorycontroll.domain.repository.aprioriassociation.HAprioriAssociationRepository;
import com.yanti.inventorycontroll.domain.repository.aprioriassociationitem.HAprioriAssociationItemRepository;
import com.yanti.inventorycontroll.domain.repository.apriorisupport.HAprioriSupportRepository;
import com.yanti.inventorycontroll.domain.repository.apriorisupportitem.HAprioriSupportItemRepository;
import com.yanti.inventorycontroll.domain.repository.item.MItemRepository;
import com.yanti.inventorycontroll.domain.repository.requestitem.TRequestItemRepository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AprioriCalculateServiceImpl implements AprioriCalculateService {

	@Inject
	private TRequestItemRepository requestItemRepo;
	@Inject
	private HAprioriRepository aprioriRepo;
	@Inject
	private HAprioriSupportRepository aprioriSupportRepo;
	@Inject
	private HAprioriSupportItemRepository aprioriSupportItemRepo;
	@Inject
	private HAprioriAssociationRepository aprioriAssociationRepo;
	@Inject
	private HAprioriAssociationItemRepository aprioriAssociationItemRepo;
	@Inject
	private MItemRepository itemRepo;

	private List<ItemTransaction> allTransactionItem;
	private int minSupport;
	private int minConfidence;
	private int maxSuppTimesConf;
	private int totalTransaction;
	private Long userId;
	private Date currentDate;

	@Data
	class FinalRule {
		private String rules;
		private Integer support;
		private Integer confidence;
		private Integer suppTimesConf;
		private List<Long> itemId;
	}
	
	public AprioriCalculateServiceOutputBean execute(AprioriCalculateServiceInputBean input) {
		AprioriCalculateServiceOutputBean output = new AprioriCalculateServiceOutputBean();
		try {
			prepareInitialData(input);

			deletePreviousData(input);

			List<LinkedHashMap<List<Long>, Integer>> KItemSet = generateKItemSet();

			List<LinkedHashMap<List<Long>, Integer>> kItemAssociation = generateAssociationRule(KItemSet);
			
			List<FinalRule> finalRules = determineFinalRules(KItemSet, kItemAssociation);

			Long aprioriId = saveApriori(input);
			saveSupportResult(KItemSet, aprioriId);
			saveAssociationResult(finalRules, aprioriId);
			output.setSuccess(true);
		} catch (BusinessException e) {
			log.error("Error ", e);
			output.setSuccess(false);
			output.setMessage(e.getResultMessages().getList().get(0).getText());
		}
		return output;
	}

	private void saveAssociationResult(List<FinalRule> finalRules, Long aprioriId) {
		for(FinalRule rule : finalRules) {
			Long aprioriAssociationId = saveAprioriAssociation(rule, aprioriId);
			saveAprioriAssociationItem(rule.getItemId(), aprioriAssociationId);
		}		
	}

	private void saveAprioriAssociationItem(List<Long> itemIds, Long aprioriAssociationId) {
		for(Long itemId : itemIds) {
			HAprioriAssociationItem apprioriAssociationItem = new HAprioriAssociationItem();
			apprioriAssociationItem.setAprioriAssociationId(aprioriAssociationId);
			apprioriAssociationItem.setItemId(itemId);
			apprioriAssociationItem.setCreatedBy(userId);
			apprioriAssociationItem.setCreatedDate(currentDate);
			apprioriAssociationItem.setUpdatedBy(userId);
			apprioriAssociationItem.setUpdatedDate(currentDate);
			aprioriAssociationItemRepo.insert(apprioriAssociationItem);
		}
	}

	private Long saveAprioriAssociation(FinalRule rule, Long aprioriId) {
		HAprioriAssociation apprioriAssociation = new HAprioriAssociation();
		apprioriAssociation.setAprioriId(aprioriId);
		apprioriAssociation.setRules(rule.getRules());
		apprioriAssociation.setSupport(rule.getSupport());
		apprioriAssociation.setConfidence(rule.getConfidence());
		apprioriAssociation.setSupportConfidence(rule.getSuppTimesConf());
		apprioriAssociation.setCreatedBy(userId);
		apprioriAssociation.setCreatedDate(currentDate);
		apprioriAssociation.setUpdatedBy(userId);
		apprioriAssociation.setUpdatedDate(currentDate);
		aprioriAssociationRepo.insert(apprioriAssociation);
		return apprioriAssociation.getAprioriAssociationId();
	}

	private void saveSupportResult(List<LinkedHashMap<List<Long>, Integer>> kItemSet, Long aprioriId) {
		int kItem = 2;
		for (LinkedHashMap<List<Long>, Integer> itemSet : kItemSet) {
			for (Entry<List<Long>, Integer> set : itemSet.entrySet()) {
				Long aprioriSupportId = saveAprioriSupport(aprioriId, kItem, set.getValue());
				int sequence = 1;
				for (Long itemId : set.getKey()) {
					saveAprioriSupportItem(aprioriSupportId, itemId, sequence);
					sequence++;
				}
			}
			kItem++;
		}
	}

	private void saveAprioriSupportItem(Long aprioriSupportId, Long itemId, int sequence) {
		HAprioriSupportItem aprioriSupportItem = new HAprioriSupportItem();
		aprioriSupportItem.setAprioriSupportId(aprioriSupportId);
		aprioriSupportItem.setItemId(itemId);
		aprioriSupportItem.setSeq(sequence);
		aprioriSupportItem.setCreatedBy(userId);
		aprioriSupportItem.setCreatedDate(currentDate);
		aprioriSupportItem.setUpdatedBy(userId);
		aprioriSupportItem.setUpdatedDate(currentDate);
		aprioriSupportItemRepo.insert(aprioriSupportItem);
	}

	private Long saveAprioriSupport(Long aprioriId, int kItem, Integer support) {
		HAprioriSupport aprioriSupport = new HAprioriSupport();
		aprioriSupport.setAprioriId(aprioriId);
		aprioriSupport.setKItem(kItem);
		aprioriSupport.setSupport(support);
		aprioriSupport.setCreatedBy(userId);
		aprioriSupport.setCreatedDate(currentDate);
		aprioriSupport.setUpdatedBy(userId);
		aprioriSupport.setUpdatedDate(currentDate);
		aprioriSupportRepo.insert(aprioriSupport);
		return aprioriSupport.getAprioriSupportId();
	}

	private Long saveApriori(AprioriCalculateServiceInputBean input) {
		HApriori apriori = new HApriori();
		apriori.setOrganizationId(input.getOrganizationId());
		apriori.setMinSupport(input.getMinSupport());
		apriori.setMinConfidence(input.getMinConfidence());
		apriori.setCreatedBy(userId);
		apriori.setCreatedDate(currentDate);
		apriori.setUpdatedBy(userId);
		apriori.setUpdatedDate(currentDate);
		aprioriRepo.insert(apriori);
		return apriori.getAprioriId();
	}

	/** 
	 * Berfungsi untuk membangun final rules dari item set confidence yang didapat
	 * @param kItemSet
	 * @param kItemAssociation
	 * @return
	 */
	private List<FinalRule> determineFinalRules(List<LinkedHashMap<List<Long>, Integer>> kItemSet, List<LinkedHashMap<List<Long>, Integer>> kItemAssociation) {
		List<FinalRule> finalRules = new ArrayList<>();
		for(LinkedHashMap<List<Long>, Integer> itemAssociation : kItemAssociation) {
			for(Entry<List<Long>, Integer> association : itemAssociation.entrySet()) {
				FinalRule rule = new FinalRule();
				rule.setRules(createRules(association.getKey()));
				rule.setSupport(findSupport(association.getKey(), kItemSet));
				rule.setConfidence(association.getValue());
				rule.setSuppTimesConf((rule.getSupport() * rule.getConfidence())/100);
				rule.setItemId(association.getKey());
				finalRules.add(rule);
				
				// Untuk menentukan nilai tertinggi dari support * confidencenya
				if(rule.getSuppTimesConf() > maxSuppTimesConf)
					maxSuppTimesConf = rule.getSuppTimesConf();
			}
		}
		return finalRules;
	}
	
	private Integer findSupport(List<Long> key, List<LinkedHashMap<List<Long>, Integer>> kItemSet) {
		for(LinkedHashMap<List<Long>, Integer> itemSet : kItemSet) {
			for(Entry<List<Long>, Integer> set : itemSet.entrySet()) {
				if(set.getKey().containsAll(key))
					return set.getValue();
			}
		}
		return 0;
	}

	/**
	 * Berfungsi untuk membangun kalimat dari kombinasi barang yang didapat
	 * misal set barang 1, 2, 3, 4 -> jika meminta 1, 2, 3, maka meminta 4
	 * misal set barang 6, 5 -> jika meminta 6, maka meminta 5
	 * @param key
	 * @return
	 */
	String createRules(List<Long> key) {
		String rules = "Jika meminta";
		for (int i = 0; i < key.size(); i++) {
			MItem item = itemRepo.selectByPrimaryKey(key.get(i));
			if (i == key.size() - 1) {
				rules += "maka meminta " + item.getItemName();
			} else {
				rules += " " + item.getItemName() + ", ";
			}
		}
		return rules;
	}

	/** 
	 * Bergfungsi untuk membangun asosiasi dari item set support yang didapat
	 * @param kItemSet
	 * @return
	 */
	private List<LinkedHashMap<List<Long>, Integer>> generateAssociationRule(List<LinkedHashMap<List<Long>, Integer>> kItemSet) {
		List<LinkedHashMap<List<Long>, Integer>> kItemAssociation = new ArrayList<>();
		LinkedHashMap<List<Long>, Integer> itemSetConfidence = new LinkedHashMap<>();

		for (LinkedHashMap<List<Long>, Integer> itemSet : kItemSet) { // Fn => [f2 = [{1,2}=1, {3,4}=2], f2 = [{1,2,3}=3]]
			for (Entry<List<Long>, Integer> kItem : itemSet.entrySet()) { // f2= [{1,2}=1, {3,4}=2]
				itemSetConfidence = calculateAssociationConfidence(kItem.getKey(), kItem.getValue()); // {1,2}
				if (!itemSetConfidence.isEmpty())
					kItemAssociation.add(itemSetConfidence);
			}
		}

		return kItemAssociation;
	}
	
	/**
	 * Berfungsi untuk menghitung asosiasi dari data atencendent dengan total transaksinya
	 * @param itemsKn
	 * @param support
	 * @return
	 */
	private LinkedHashMap<List<Long>, Integer> calculateAssociationConfidence(List<Long> itemsKn, Integer support) {
		LinkedHashMap<List<Long>, Integer> itemSetConfidence = new LinkedHashMap<>();
		List<List<Long>> ruleCombination = determineRuleCombination(itemsKn);

		for (List<Long> combination : ruleCombination) {
			List<Long> antecendent = combination.subList(0, itemsKn.size() - 1); // misal a, b, c, d -> jika meminta a, b, c, maka meminta d, atencenden adalah a,b,c
			int totalN = getTotalTransaction(combination);
			int totalAntecendent = getTotalTransaction(antecendent);
			int confidence = (totalN * 100) / totalAntecendent;
			if (confidence >= minConfidence)
				itemSetConfidence.put(combination, confidence);
		}
		return itemSetConfidence;
	}

	List<List<Long>> determineRuleCombination(List<Long> itemsKn) {
		List<List<Long>> ruleCombination = new ArrayList<>();
		ruleCombination.add(itemsKn);
		int n = itemsKn.size();
		for (int i = 1; i < n; i++) {
			List<Long> combination = new ArrayList<>();
			combination.addAll(itemsKn.subList(i, n));
			combination.addAll(itemsKn.subList(0, i));
			ruleCombination.add(combination);
		}
		return ruleCombination;
	}

	/**
	 * Berfungsi untuk mencari kombinasi barang dan menghitung masing-masing supportnya lalu dibandingkan dengan minSupport yang diminta
	 * 
	 * @return
	 */
	private List<LinkedHashMap<List<Long>, Integer>> generateKItemSet() {
		List<LinkedHashMap<List<Long>, Integer>> KItemSet = new ArrayList<>();
		LinkedHashMap<List<Long>, Integer> itemSetSupport = new LinkedHashMap<>();

		List<List<Long>> itemSet = getDistinctItems();
		int nItemSet = 1;
		do {
			itemSetSupport = calculateItemSetSupport(itemSet);
			if (nItemSet > 5)
				throw new BusinessException("Hasil tidak sesuai, support terlalu kecil.");
			else if (nItemSet > 1 && !itemSetSupport.isEmpty())
				KItemSet.add(itemSetSupport);

			nItemSet++;
			if (!itemSetSupport.isEmpty()) {
				List<Long> kItem = getEligibleItem(itemSetSupport);
				itemSet = getItemCombination(kItem, nItemSet);
			}
		} while (!itemSetSupport.isEmpty() && !itemSet.isEmpty());

		if (KItemSet.isEmpty())
			throw new BusinessException("Tidak ditemukan hasil yang sesuai dikarenakan nilai support yang terlalu besar atau data transaksi yang kurang komprehensif.");

		return KItemSet;
	}

	/** 
	 * Berfungsi untuk membuat kombinasi dari sisa barang misal barang [8, 9, 4, 69] itemset 2
	 * maka hasilnya [[8, 9], [8, 4], [8, 69], [9, 4], [9, 69], [4, 69]], dst
	 * @param kItem
	 * @param nItemSet
	 * @return
	 */
	private List<List<Long>> getItemCombination(List<Long> kItem, int nItemSet) {
		List<List<Long>> itemCombination = Generator.combination(kItem).simple(nItemSet).stream().collect(Collectors.toList());
		return itemCombination;
	}

	/**
	 * berfungsi untuk mengecek barang apa saja yang masih sesudai dengan minimal support
	 * misal dari k-item-set2 yang lolos adalah 2item set A: {barang 1, barang 2}, set B: {barang 2, barang 4}
	 * berarti data barang yang dapat dihitung lebih lanjut adalah barang 1, barang 2, dan barang 4
	 * @param itemSetSupport
	 * @return
	 */
	private List<Long> getEligibleItem(LinkedHashMap<List<Long>, Integer> itemSetSupport) {
		List<Long> remainingItem = new ArrayList<>();
		List<List<Long>> itemSet = new ArrayList<>(itemSetSupport.keySet());
		for (List<Long> items : itemSet) {
			remainingItem.addAll(items);
		}
		return remainingItem.stream().distinct().collect(Collectors.toList());
	}

	/**
	 * Berfungsi untuk menghitung nilai support dari item set barang dan dibandingkan dengan minimal supportnya, misal 
	 * k-item set 1 : bolpoint -> total transaksi yang berisi bolpoint / total transaksi
	 * k-item set 2 : bolpoint, kertas -> total transaksi yang berisi bolpoint, kertas / total transaksi
	 * @param itemSet
	 * @return
	 */
	private LinkedHashMap<List<Long>, Integer> calculateItemSetSupport(List<List<Long>> itemSet) {
		LinkedHashMap<List<Long>, Integer> itemSetSupport = new LinkedHashMap<>();
		for (List<Long> items : itemSet) {
			int totalN = getTotalTransaction(items);
			int support = ((totalN * 100) / totalTransaction);
			if (support >= minSupport)
				itemSetSupport.put(items, support);
		}
		return itemSetSupport;
	}

	/**
	 * berfungsi untuk mengecek transaksi yang berisi barang tertentu
	 * @param items
	 * @return
	 */
	private int getTotalTransaction(List<Long> items) {
		return (int) allTransactionItem.stream().filter(t -> t.getItems().containsAll(items)).count();
	}
	
	/**
	 * Befungsi untuk menyusun informasi barang menjadi bentuk tabular sesuai dengan data permintaan
	 * contoh ItemTransaction(requestId=21, items=[8, 9]) diubah menjadi List index 1 untuk transaksi 1 berisi barang {8,9}
	 * @return
	 */
	private List<List<Long>> getDistinctItems() {
		List<Long> items = new ArrayList<>();
		List<List<Long>> itemSet = new ArrayList<>();
		for (ItemTransaction transaction : allTransactionItem) {
			for (Long item : transaction.getItems()) {
				if (!items.contains(item)) {
					itemSet.add(Arrays.asList(item));
					items.add(item);
				}
			}
		}
		return itemSet;
	}

	/**
	 * Befungsi menghapus hasil apriori yang sebelumnya pernah dihitung berdasarkan minSUpport, minConfindence, bidang
	 * data sebelumnya akan dihapus karena apriori yang ditampilkan ke halaman apriori hanya hasil terbaru saja
	 * @param input
	 */
	private void deletePreviousData(AprioriCalculateServiceInputBean input) {
		HAprioriCriteria aprioriC = new HAprioriCriteria();
		aprioriC.createCriteria().andMinSupportEqualTo(input.getMinSupport()).andMinConfidenceEqualTo(input.getMinConfidence()).andOrganizationIdEqualTo(input.getOrganizationId());
		List<HApriori> aprioriList = aprioriRepo.selectByCriteria(aprioriC);
		for(HApriori apriori : aprioriList) {
			
			HAprioriSupportCriteria aprioriSupportC = new HAprioriSupportCriteria();
			aprioriSupportC.createCriteria().andAprioriIdEqualTo(apriori.getAprioriId());
			List<HAprioriSupport> apprioriSupport = aprioriSupportRepo.selectByCriteria(aprioriSupportC);
			for(HAprioriSupport support : apprioriSupport) {
				
				HAprioriSupportItemCriteria aprioriSupportItemC = new HAprioriSupportItemCriteria();
				aprioriSupportItemC.createCriteria().andAprioriSupportIdEqualTo(support.getAprioriSupportId());
				aprioriSupportItemRepo.deleteByCriteria(aprioriSupportItemC);
			}
			
			HAprioriAssociationCriteria aprioriAssociationC = new HAprioriAssociationCriteria();
			aprioriAssociationC.createCriteria().andAprioriIdEqualTo(apriori.getAprioriId());
			List<HAprioriAssociation> apprioriAssociation = aprioriAssociationRepo.selectByCriteria(aprioriAssociationC);
			for(HAprioriAssociation association : apprioriAssociation) {
				
				HAprioriAssociationItemCriteria aprioriAssociationItemC = new HAprioriAssociationItemCriteria();
				aprioriAssociationItemC.createCriteria().andAprioriAssociationIdEqualTo(association.getAprioriAssociationId());
				aprioriAssociationItemRepo.deleteByCriteria(aprioriAssociationItemC);
			}
			
			aprioriSupportRepo.deleteByCriteria(aprioriSupportC);
			aprioriAssociationRepo.deleteByCriteria(aprioriAssociationC);
			aprioriRepo.deleteByPrimaryKey(apriori.getAprioriId());
		}
	}

	
	/**
	 * Berfungsi untuk set nilai nilai local variable yang digunakan selama proses perhitungan, dan mengambil semua 
	 * data permintaan dan barang yang diminta contoh permintaan A berisi barang 1 dan barang 2 >> ItemTransaction(requestId=21, items=[8, 9])
	 * @param input
	 */
	private void prepareInitialData(AprioriCalculateServiceInputBean input) {
		this.allTransactionItem = requestItemRepo.selectAllItemTransaction(input.getOrganizationId()); // ambil semua permintaan secara detail 
		this.totalTransaction = allTransactionItem.size();
		this.minSupport = input.getMinSupport();
		this.minConfidence = input.getMinConfidence();
		this.maxSuppTimesConf = 0;
		this.userId = input.getUserAccountId();
		this.currentDate = new Date();
	}
}
