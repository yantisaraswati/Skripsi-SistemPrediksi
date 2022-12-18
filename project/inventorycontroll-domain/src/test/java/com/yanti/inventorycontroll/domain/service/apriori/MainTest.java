package com.yanti.inventorycontroll.domain.service.apriori;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.yanti.inventorycontroll.domain.dto.movingaverage.RequestedItem;

import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class MainTest {

	@Tested
	private AprioriCalculateServiceImpl target;
		
	@Test
	public void test_containsAll() {
		List<Integer> setA = Arrays.asList(1,2,3,4);
		List<Integer> setB = Arrays.asList(1,4,2,3);
		List<Integer> findA = Arrays.asList(1,2);
		List<Integer> findB = Arrays.asList(2,1);
		
		System.out.println(setA.containsAll(findA));
		System.out.println(setA.containsAll(findB));
		System.out.println(setB.containsAll(findA));
		System.out.println(setB.containsAll(findB));
	}
	
	@Test
	public void test_determineRuleCombination() {
		System.out.println(target.determineRuleCombination(Arrays.asList(1L,2L)));
		System.out.println(target.determineRuleCombination(Arrays.asList(1L,2L,3L,4L,5L)));
	}
	
	@Test
	public void test_createRules() {
		System.out.println(target.createRules(Arrays.asList(1L,1L)));
		System.out.println(target.createRules(Arrays.asList(1L,1L,1L,1L)));
	}
	
	@Test
	public void testCheck() {
		List<Integer> nums = Arrays.asList(3,4);
		
		int n = 2;
		Double forecast = null;
		for(int i = 0; i < nums.size(); i++) {
			Double error = (i < n) ? null : nums.get(i) - forecast;
			System.out.println(forecast + " " + error);
			forecast = check(nums, i, n);
		}
		System.out.println(forecast/n);
	}
	
	Double check(List<Integer> nums, int i, int n) {
		if(i - (n - 1) < 0)
			return null;
		
		List<Integer> itemInTimeFrame = nums.subList(i - (n - 1), i+1);
		return (double) itemInTimeFrame.stream().reduce(0,Integer::sum) / (double) n;
	}
}
