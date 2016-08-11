package com.aiza.journey.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TariffChecking {
	private static final String TARIFF_C0_PLUS = "C0+";
	private static final String TARIFF_B2Y = "B2Y";
	private static final String FILE_URL_OF_OW_2013 = "src/main/resources/tar13ow.txt";
	private static final String FILE_URL_OF_LU_2013 = "src/main/resources/tar13lu.txt";
	private static final String FILE_URL_OF_OW_2016 = "src/main/resources/tar16ow.txt";

	public static void main(String[] args) throws IOException {
		TariffChecking checkTariff = new TariffChecking();
		
		// Handle for 2013, canton ow
		BigDecimal taxableIncome = new BigDecimal(14000);
		TariffValue nearestOrEqualTariffValue = checkTariff.getNearestOrEqualTariffValue("B2+", taxableIncome, FILE_URL_OF_OW_2013);
		System.out.println("OW TaxableIncome to get rate: " + taxableIncome + " Nearest taxable value: "
				+ nearestOrEqualTariffValue.getTaxableIncome() + " --> rate: " + nearestOrEqualTariffValue.getRate());
		
		// Hanlde for 2013, canton lu for tariff code: C0d
		BigDecimal taxableIncomeLu = new BigDecimal(36000);
		TariffValue nearestOrEqualTariffValue2 = checkTariff.getNearestOrEqualTariffValue("C0d", taxableIncomeLu, FILE_URL_OF_LU_2013);
		System.out.println("LU TaxableIncome to get rate: " + taxableIncomeLu + " Nearest taxable value: "
				+ nearestOrEqualTariffValue2.getTaxableIncome() + " --> rate: " + nearestOrEqualTariffValue2.getRate());
		
		// Hanlde for 2013, canton lu for tariff code: C0+
		BigDecimal taxableIncomeLuDiffTariffCode = new BigDecimal(5000);
		TariffValue nearestOrEqualTariffValue3 = checkTariff.getNearestOrEqualTariffValue(TARIFF_C0_PLUS, taxableIncomeLuDiffTariffCode, FILE_URL_OF_LU_2013);
		System.out.println("LU 2013 for tariff " + TARIFF_C0_PLUS + " TaxableIncome to get rate: " + taxableIncomeLuDiffTariffCode + " Nearest taxable value: "
				+ nearestOrEqualTariffValue3.getTaxableIncome() + " --> rate: " + nearestOrEqualTariffValue3.getRate());
		
		// Handle for 2016, canton lu for tariff code: B2Y
		BigDecimal taxableIncomeLu2016 = new BigDecimal(14000);
		TariffValue nearestOrEqualTariffValue4 = checkTariff.getNearestOrEqualTariffValue(TARIFF_B2Y, taxableIncomeLu2016, FILE_URL_OF_OW_2016);
		System.out.println("OW 2016 for tariff " + TARIFF_B2Y + " TaxableIncome to get rate: " + taxableIncomeLu2016 + " Nearest taxable value: "
				+ nearestOrEqualTariffValue4.getTaxableIncome() + " --> rate: " + nearestOrEqualTariffValue4.getRate());
	}
	
	public TariffValue getNearestOrEqualTariffValue(String tariffCode, BigDecimal taxableIncome, String fileUrl) throws IOException {
		List<String> tariffCodeMatchedLineList = getCorrespondingListFromTariffCode(tariffCode, fileUrl);
		List<TariffValue> taxableIncomeRange = decodeLineStrToTaxableIncome(tariffCodeMatchedLineList, taxableIncome);
		/*taxableIncomeRange.stream()
			.forEach(k -> {
				System.out.println(k);
			});*/
		TariffValue nearestOrEqualTariffValue = taxableIncomeRange.stream()
			.max(Comparator.comparing(TariffValue::getTaxableIncome)).get();
		return nearestOrEqualTariffValue;
	}

	public List<String> getCorrespondingListFromTariffCode(String tariffCode, String fileUrl) throws IOException {
		return Files.lines(Paths.get(fileUrl))
//				.parallel() // for parallel processing
				.filter(line -> line.length() > 2)
				.filter(line -> line.toLowerCase().contains(tariffCode.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	public List<TariffValue> decodeLineStrToTaxableIncome(List<String> tariffCodeMatchedLineList, final BigDecimal limit) {
		return tariffCodeMatchedLineList.stream()
				.map(str -> {
					String taxableIncomeStrBeforeDot = str.substring(24, 31);
					String taxableIncomeStrAfterDot = str.substring(31, 33);
					BigDecimal taxableIncome = new BigDecimal(taxableIncomeStrBeforeDot + "." + taxableIncomeStrAfterDot);
					String rateStrBeforeDot = str.substring(54, 57);
					String rateStrAfterDot = str.substring(57, 59);
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
