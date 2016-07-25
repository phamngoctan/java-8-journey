package com.aiza.journey.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TariffChecking {
	private static final String FILE_URL_OF_OW_2013 = "src/main/resources/tar13ow.txt";

	public static void main(String[] args) throws IOException {
		TariffChecking checkTariff = new TariffChecking();
		BigDecimal taxableIncome = new BigDecimal(113000);
		String tariffCode = "B2+";
		List<String> tariffCodeMatchedLineList = checkTariff.getCorrespondingListFromTariffCode(tariffCode);
		List<TariffValue> taxableIncomeRange = checkTariff.decodeLineStrToTaxableIncome(tariffCodeMatchedLineList, taxableIncome); //new BigDecimal(110000)
		taxableIncomeRange.forEach(k -> {
			System.out.println(k);
		});
		
		TariffValue nearestOrEqualTariffValue = taxableIncomeRange.stream()
			.max(Comparator.comparing(TariffValue::getTaxableIncome)).get();
		System.out.println(nearestOrEqualTariffValue.getTaxableIncome() + " --> rate: " + nearestOrEqualTariffValue.getRate());
	}

	public List<String> getCorrespondingListFromTariffCode(String tariffCodes) throws IOException {
		return Files.lines(Paths.get(FILE_URL_OF_OW_2013))
				.parallel() // for parallel processing
				.filter(line -> line.length() > 2)
				.filter(line -> line.toLowerCase().contains(tariffCodes.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	public List<TariffValue> decodeLineStrToTaxableIncome(List<String> tariffCodeMatchedLineList, final BigDecimal limit) {
		return tariffCodeMatchedLineList.stream()
				.map(str -> {
					String taxableIncomeStrBeforeDot = str.substring(25, 31);
					String taxableIncomeStrAfterDot = str.substring(32, 33);
					BigDecimal taxableIncome = new BigDecimal(taxableIncomeStrBeforeDot + "." + taxableIncomeStrAfterDot);
					String rateStrBeforeDot = str.substring(55, 57);
					String rateStrAfterDot = str.substring(58, 59);
					BigDecimal rate = new BigDecimal(rateStrBeforeDot + "." + rateStrAfterDot);
					return new TariffValue(taxableIncome, rate);
				})
				.filter(t -> {
					if (limit != null) {
						return t.getTaxableIncome().compareTo(limit) <= 0;
					} else {
						return true;
					}
				})
				.sorted(Comparator.comparing(TariffValue::getTaxableIncome))
				.collect(Collectors.toList())
				;
	}
	
}
