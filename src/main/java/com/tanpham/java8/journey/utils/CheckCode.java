package com.tanpham.java8.journey.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckCode {
	private static final String fileUrl = "src/main/resources/qst1.txt";

	public static void main(String[] args) {
		List<String> scenarioCodes2 = Arrays.asList("1000", "1061", "1212", "2000", "2005", "2030", "2035", "2050", "5000",
				"5010", "5020", "5030", "5040", "5045", "5050", "9030", "9031", "9040", "9041", "5041", "9050", "9051", "9070", "9071");
		checkScenario(2, scenarioCodes2);
		
		List<String> scenarioCodes3 = Arrays.asList("1000", "1010", "5000", "9020", "9021", "5020", "9022", "5030", "5040",
				"9010", "5010", "9030", "9031", "9040", "9070", "9071");
		checkScenario(3, scenarioCodes3);
		
		List<String> scenarioCodes4 = Arrays.asList("1000", "5000", "9010", "5010", "5020", "5030", "5050", "9020", "9021",
				"9022", "9070", "9071");
		checkScenario(4, scenarioCodes4);
	}

	private static void checkScenario(int scenario, List<String> codes) {
		System.out.println("====================== " + scenario);
		CheckCode checkCodeClass = new CheckCode();
		Map<Boolean, List<String>> passingFailing = checkCodeClass.checkCollectionOfCode(codes);
		passingFailing.forEach((k, v) -> {
			if (k == true) {
				System.out.println("Passing Code: " + v);
			} else {
				System.out.println("Failure Code: " + v);
			}
		});
	}
	
	public void checkCase() {
		
	}
	
	public boolean checkCode(String code) throws IOException {
		boolean result = Files.lines(Paths.get(fileUrl))
				.parallel() // for parallel processing
				.filter(line -> line.length() > 2) // to filter some lines by a predicate
				.map(String::trim) // to change line
				.anyMatch(line -> line.toLowerCase().contains(code.toLowerCase()));
		return result;
	}

	public Map<Boolean, List<String>> checkCollectionOfCode(List<String> codes) {
		Map<Boolean, List<String>> result = codes.stream()
				.filter(c -> c != null)
				//.peek(c -> System.out.println("Debug " + c))
				.sorted( (c, c1) -> c.compareTo(c1))
				.collect(Collectors.partitioningBy(c -> {
					try {
						return checkCode(c);
					} catch (Exception e) {
						e.printStackTrace();
						return false;
					}
				}));
		return result;
	}
}
