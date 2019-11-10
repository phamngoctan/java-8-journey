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
	public void computeIfAbsent_approach() {
		Integer count = countByName.computeIfAbsent("Saturn", key -> 0);
		countByName.put("Saturn", count + 1);
		
		assertThat(countByName.get("Saturn"), Matchers.equalTo(1));
	}
	
	@Test
	public void computeIfPresent_approach() {
		Integer computeIfPresent = countByName.computeIfPresent("Saturn", (k, v) -> v + 1);
		if (computeIfPresent == null) {
			countByName.put("Saturn", 1);
		}
		
		assertThat(countByName.get("Saturn"), Matchers.equalTo(1));
		
		countByName.computeIfPresent("Saturn", (k, v) -> v + 1);
		assertThat(countByName.get("Saturn"), Matchers.equalTo(2));
	}
	
	@Test
	public void compute__approach() {
		countByName.compute("Saturn", (k, v) -> 1 + (v == null ? 0 : v));
		assertThat(countByName.get("Saturn"), Matchers.equalTo(1));
		countByName.compute("Saturn", (k, v) -> 1 + (v == null ? 0 : v));
		assertThat(countByName.get("Saturn"), Matchers.equalTo(2));
	}
	
	@Test
	public void merge_approach() {
		countByName.merge("Saturn", 1, (v1, v2) -> v1 + v2);
		assertThat(countByName.get("Saturn"), Matchers.equalTo(1));
		countByName.merge("Saturn", 4, (v1, v2) -> v1 + v2);
		assertThat(countByName.get("Saturn"), Matchers.equalTo(5));
	}
	
	
}
