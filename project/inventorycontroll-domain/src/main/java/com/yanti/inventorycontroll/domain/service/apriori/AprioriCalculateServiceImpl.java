package com.yanti.inventorycontroll.domain.service.apriori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.paukov.combinatorics3.Generator;
import org.springframework.stereotype.Service;

import com.yanti.inventorycontroll.domain.bean.apriori.AprioriCalculateServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriCalculateServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.apriori.ItemTransaction;
import com.yanti.inventorycontroll.domain.model.apriori.HApriori;
import com.yanti.inventorycontroll.domain.model.apriori.HAprioriCriteria;
import com.yanti.inventorycontroll.domain.model.apriorisupport.HAprioriSupport;
import com.yanti.inventorycontroll.domain.model.apriorisupport.HAprioriSupportCriteria;
import com.yanti.inventorycontroll.domain.model.apriorisupportitem.HAprioriSupportItem;
import com.yanti.inventorycontroll.domain.model.apriorisupportitem.HAprioriSupportItemCriteria;
import com.yanti.inventorycontroll.domain.repository.apriori.HAprioriRepository;
import com.yanti.inventorycontroll.domain.repository.apriorisupport.HAprioriSupportRepository;
import com.yanti.inventorycontroll.domain.repository.apriorisupportitem.HAprioriSupportItemRepository;
import com.yanti.inventorycontroll.domain.repository.requestitem.TRequestItemRepository;

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

	private List<ItemTransaction> allTransactionItem;
	private HashMap<List<Long>, Integer> nItemTransaction;
	private int minSupport;
	private int minConfidence;
	private int totalTransaction;
	private Long userId;
	private Date currentDate;

	public AprioriCalculateServiceOutputBean execute(AprioriCalculateServiceInputBean input) {
		AprioriCalculateServiceOutputBean output = new AprioriCalculateServiceOutputBean();
		try {
			prepareInitialData(input);
			
			deletePreviousData(input);
			
			List<LinkedHashMap<List<Long>, Integer>> KItemSet = calculateKItemSet();
			if(KItemSet.isEmpty()) {
				output.setSuccess(false);
				output.setMessage("Tidak ditemukan nilai yang sesuai, support terlalu besar.");
				return output;
			} else {
				Long aprioriId = saveApriori(input);
				saveSupportResult(KItemSet, aprioriId);
				output.setSuccess(true);
			}
		} catch (Exception e) {
			log.error("Error ", e);
			output.setSuccess(false);
			output.setMessage("Terjadi kesalahan, silahkan periksa kembali.");
		}
		return output;
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

	private List<LinkedHashMap<List<Long>, Integer>> calculateKItemSet() {
		List<LinkedHashMap<List<Long>, Integer>> KItemSet = new ArrayList<>();
		LinkedHashMap<List<Long>, Integer> itemSetSupport = new LinkedHashMap<>();

		List<List<Long>> itemSet = getDistinctItems();
		int nItemSet = 1;
		do {
			itemSetSupport = calculateItemSetSupport(itemSet);

			if (nItemSet > 1) {
				KItemSet.add(itemSetSupport);
			}

			nItemSet++;
			if (!itemSetSupport.isEmpty()) {
				List<Long> kItem = getEligibleItem(itemSetSupport);
				itemSet = getItemCombination(kItem, nItemSet);
			}
		} while (!itemSetSupport.isEmpty() && !itemSet.isEmpty());
		return KItemSet;
	}

	private List<List<Long>> getItemCombination(List<Long> kItem, int nItemSet) {
		List<List<Long>> itemCombination = Generator.combination(kItem).simple(nItemSet).stream().collect(Collectors.toList());
		return itemCombination;
	}

	private List<Long> getEligibleItem(LinkedHashMap<List<Long>, Integer> itemSetSupport) {
		List<Long> remainingItem = new ArrayList<>();
		List<List<Long>> itemSet = new ArrayList<>(itemSetSupport.keySet());
		for (List<Long> items : itemSet) {
			remainingItem.addAll(items);
		}
		return remainingItem.stream().distinct().collect(Collectors.toList());
	}

	private LinkedHashMap<List<Long>, Integer> calculateItemSetSupport(List<List<Long>> itemSet) {
		LinkedHashMap<List<Long>, Integer> itemSetSupport = new LinkedHashMap<>();
		for (List<Long> items : itemSet) {
			int totalN = (int) allTransactionItem.stream().filter(t -> t.getItems().containsAll(items)).count();
			int support = ((totalN * 100) / totalTransaction);
			if (support >= minSupport) {
				itemSetSupport.put(items, support);
				nItemTransaction.put(items, totalN);
			}
		}
		return itemSetSupport;
	}

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
			aprioriSupportRepo.deleteByCriteria(aprioriSupportC);
			aprioriRepo.deleteByPrimaryKey(apriori.getAprioriId());
		}
	}
	
	private void prepareInitialData(AprioriCalculateServiceInputBean input) {
		this.allTransactionItem = requestItemRepo.selectAllItemTransaction(input.getOrganizationId());
		this.nItemTransaction = new HashMap<>();
		this.totalTransaction = allTransactionItem.size();
		this.minSupport = input.getMinSupport();
		this.minConfidence = input.getMinConfidence();
		this.userId = input.getUserAccountId();
		this.currentDate = new Date();
	}
}
