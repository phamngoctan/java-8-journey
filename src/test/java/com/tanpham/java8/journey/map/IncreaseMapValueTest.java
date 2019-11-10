package com.tanpham.java8.journey.map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class IncreaseMapValueTest {
	
	private Map<String, Integer> countByName;
	
	@Before
	public void init() {
		countByName = new HashMap<>();
	}
	
	@Test
	public void putIfAbsent_approach() {
		countByName.putIfAbsent("Saturn", 0);
//		countByName.put
	}
	
}
