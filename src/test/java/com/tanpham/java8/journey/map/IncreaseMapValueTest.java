package com.tanpham.java8.journey.map;

import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
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
		countByName.put("Saturn", countByName.get("Saturn") + 1);
		
		assertThat(countByName.get("Saturn"), Matchers.equalTo(1));
	}
	
	@Test
	public void getOrDefault_approach() {
		int count = countByName.getOrDefault("Saturn", 0);
		countByName.put("Saturn", count + 1);
		
		assertThat(countByName.get("Saturn"), Matchers.equalTo(1));
	}
	
	@Test
	public void computeIfAbsent_() {
		
	}
	
}
