package com.aiza.journey.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.aiza.journey.payslip.SalaryItemTypeName;

public class ReadCalculationFile {

	private static final int COL_1_LENGTH = 10;
	private static final int COL_2_LENGTH = 50;
	private static final int COL_3_LENGTH = 18;
	private static final int COL_4_LENGTH = 12;
	private static final int COL_5_LENGTH = 18;
	private static final int COL_6_LENGTH = 18;

	private static final int PART_1_START_COL_1 = 0;
	private static final int PART_1_END_COL_1 = 13;
	private static final int PART_1_START_COL_2 = 14;
	private static final int PART_1_END_COL_2 = 50;
	private static final int PART_1_START_COL_3 = 84;
	private static final int PART_1_END_COL_3 = 94;
	private static final int PART_1_START_COL_4 = 95;
	private static final int PART_1_END_COL_4 = 108;
	private static final int PART_1_START_COL_5 = 111;
	private static final int PART_1_END_COL_5 = 121;
	private static final int PART_1_START_COL_6 = 122;
	private static final int PART_1_END_COL_6 = 135;

	private static final int PART_2_START_COL_1 = 0;
	private static final int PART_2_END_COL_1 = 27;
	private static final int PART_2_START_COL_2 = 83;
	private static final int PART_2_END_COL_2 = 96;
	private static final int PART_2_START_COL_3 = 97;
	private static final int PART_2_END_COL_3 = 109;
	private static final int PART_2_START_COL_4 = 110;
	private static final int PART_2_END_COL_4 = 122;
	private static final int PART_2_START_COL_5 = 123;
	private static final int PART_2_END_COL_5 = 138;
	private static final String PAYSLIP_CALCULATION_URL = "src/main/resources/Berechnung_4.0_20141031.txt";

	public static void main(String[] args) throws IOException {
		boolean shouldShowDuplicate = false;

		List<Employee> employees = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(PAYSLIP_CALCULATION_URL))) {
			String line = br.readLine();

			int countEmployee = 1;
			boolean startEmployee = false;
			boolean startBlock1 = false;
			boolean startBlock2 = false;
			boolean startWritingEmployee = false;
			StringBuilder sbBlock1 = new StringBuilder();
			StringBuilder sbBlock2 = new StringBuilder();

			while (line != null) {
				Pattern patternForStartEmployee = Pattern.compile(
						"Muster AG: Testjahr                                201", Pattern.UNICODE_CHARACTER_CLASS);
				if (patternForStartEmployee.matcher(line).find()) {
					startEmployee = true;
				}
				Pattern patternForStartBlock1 = Pattern.compile("1000 .* Monatslohn", Pattern.UNICODE_CHARACTER_CLASS);
				if (patternForStartBlock1.matcher(line).find()) {
					startBlock1 = true;
				}
				if (startEmployee && startBlock1) {
					sbBlock1.append(line);
					sbBlock1.append(System.lineSeparator());
					Pattern patternForEndBlock1 = Pattern.compile("6500 .* Nettolohn", Pattern.UNICODE_CHARACTER_CLASS);
					if (patternForEndBlock1.matcher(line).find()) {
						startBlock1 = false;
					}
				}

				if (line.toLowerCase().contains("AHV-Basis".toLowerCase())) {
					startBlock2 = true;
				}
				if (startEmployee && startBlock2) {
					sbBlock2.append(line);
					sbBlock2.append(System.lineSeparator());
					if (line.toLowerCase().contains("KTG-Lohn 12".toLowerCase())) {
						startBlock2 = false;
						startWritingEmployee = true;
					}
				}

				if (startWritingEmployee) {
					Employee emp = new ReadCalculationFile().new Employee();
					emp.setEmployeeName("Employee " + countEmployee
							+ ": ===================================================================");
					emp.setBlock1(sbBlock1.toString());
					emp.setBlock2(sbBlock2.toString());
					employees.add(emp);

					sbBlock1.setLength(0);
					sbBlock2.setLength(0);
					countEmployee++;
					startWritingEmployee = false;
					startEmployee = false;
				}
				line = br.readLine();
			}
		}
		for (Employee employee : employees) {
			// if (employee.getEmployeeName().contains("30"))
			// continue;
			System.err.println(employee.getEmployeeName());
			//| code  | name                                          | 01.2013 - 02.2013 |         03.2013   | 04.2013 - 10.2013 | 11.2013 - 12.2013 |
			String codeHeader = fillTextWithSpace("code", COL_1_LENGTH);
			String nameHeader = fillTextWithSpace("name", COL_2_LENGTH);
			String janToFebHeader = fillTextWithSpace("01.2013 - 02.2013", COL_3_LENGTH);
			String marchHeader = fillTextWithSpace("03.2013", COL_4_LENGTH);
			String aprToOctHeader = fillTextWithSpace("04.2013 - 10.2013", COL_5_LENGTH);
			String novToDecHeader = fillTextWithSpace("11.2013 - 12.2013", COL_6_LENGTH);
			System.out.format("| %s | %s | %s | %s | %s | %s | \r\n", codeHeader, nameHeader, janToFebHeader,
					marchHeader, aprToOctHeader, novToDecHeader);
			ReadCalculationFile.readPartOne(employee.getBlock1(), shouldShowDuplicate);
			ReadCalculationFile.readPartTwo(employee.getBlock2(), shouldShowDuplicate);
		}
	}

	private static void readPartTwo(String partTwoText, boolean shouldShowDuplicate) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(partTwoText.getBytes());
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while ((line = reader.readLine()) != null) {
			String code = "";
			String germanName = "";
			String duration1 = "";
			String duration2 = "";
			String duration3 = "";
			String duration4 = "";
			if (!line.isEmpty() && line.trim().length() >= PART_2_END_COL_1 + 1) {
				germanName = readPartTwoFirstColumn(line);
				if (line.length() > PART_2_END_COL_2 + 1) {
					duration1 = readPartTwoSecondColumn(line);
				}
				if (line.length() > PART_2_END_COL_3 + 1) {
					duration2 = readPartTwoThirdColumn(line);
				}
				if (line.length() > PART_2_END_COL_4 + 1) {
					duration3 = readPartTwoForthColumn(line);
				}
				if (line.length() > PART_2_END_COL_5 + 1) {
					duration4 = readPartTwoFifthColumn(line);
				}

				code = fillTextWithSpace(SalaryItemTypeName.fromGermanNameToCode(germanName.trim()), COL_1_LENGTH);
				String englishCodeName = !germanName.isEmpty() ? SalaryItemTypeName.fromGermanName(germanName.trim())
						: "";
				englishCodeName = fillTextWithSpace(englishCodeName, COL_2_LENGTH);
				duration1 = formatText(duration1, COL_3_LENGTH);
				duration2 = formatText(duration2, COL_4_LENGTH);
				duration3 = formatText(duration3, COL_5_LENGTH);
				duration4 = formatText(duration4, COL_6_LENGTH);

				if (!shouldShowDuplicate) {
					if (!duration1.trim().isEmpty() || !duration2.trim().isEmpty() || !duration3.trim().isEmpty()
							|| !duration4.trim().isEmpty()) {
						System.out.format("| %s | %s | %s | %s | %s | %s | \r\n", code, englishCodeName, duration1,
								duration2, duration3, duration4);
					}
				} else {
					System.out.format("| %s | %s | %s | %s | %s | %s | \r\n", code, englishCodeName, duration1,
							duration2, duration3, duration4);
				}
			}
		}
	}

	public static void readPartOne(String partOneText, boolean shouldShowDuplicate) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(partOneText.getBytes());
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while ((line = reader.readLine()) != null) {
			String code = "";
			String germanName = "";
			String duration1 = "";
			String duration2 = "";
			String duration3 = "";
			String duration4 = "";
			if (!line.isEmpty() && line.trim().length() >= PART_1_END_COL_1 + 1) {
				code = readPartOneFirstColumn(line);
				if (!isNumeric(code)) {
					continue;
				}
				if (line.length() > PART_1_END_COL_2 + 1) {
					germanName = readPartOneSecondColumn(line);
				}
				if (line.length() > PART_1_END_COL_3 + 1) {
					duration1 = readPartOneThirdColumn(line);
				}
				if (line.length() > PART_1_END_COL_4 + 1) {
					duration2 = readPartOneForthColumn(line);
				}
				if (line.length() > PART_1_END_COL_5 + 1) {
					duration3 = readPartOneFifthColumn(line);
				}
				if (line.length() > PART_1_END_COL_6 + 1) {
					duration4 = readPartOneSixthColumn(line);
				}

				code = fillTextWithSpace(code, COL_1_LENGTH);
				String englishCodeName = !germanName.isEmpty() ? SalaryItemTypeName.fromGermanName(germanName.trim())
						: "";
				englishCodeName = fillTextWithSpace(englishCodeName, COL_2_LENGTH);
				duration1 = formatText(duration1, COL_3_LENGTH);
				duration2 = formatText(duration2, COL_4_LENGTH);
				duration3 = formatText(duration3, COL_5_LENGTH);
				duration4 = formatText(duration4, COL_6_LENGTH);

				if (!shouldShowDuplicate) {
					if (!duration1.trim().isEmpty() || !duration2.trim().isEmpty() || !duration3.trim().isEmpty()
							|| !duration4.trim().isEmpty()) {
						System.out.format("| %s | %s | %s | %s | %s | %s | \r\n", code, englishCodeName, duration1,
								duration2, duration3, duration4);
					}
				} else {
					System.out.format("| %s | %s | %s | %s | %s | %s | \r\n", code, englishCodeName, duration1,
							duration2, duration3, duration4);
				}
			}
		}
	}

	private static String formatText(String text, int lengthToFill) {
		text = replaceCharByAnotherChar(text, "'", "");
		text = fillTextWithSpace(text, lengthToFill);
		return text;
	}
	
	private static String readPartOneFirstColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_1, PART_1_END_COL_1);
	}

	private static String readPartOneSecondColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_2, PART_1_END_COL_2);
	}

	private static String readPartOneThirdColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_3, PART_1_END_COL_3);
	}

	private static String readPartOneForthColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_4, PART_1_END_COL_4);
	}

	private static String readPartOneFifthColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_5, PART_1_END_COL_5);
	}

	private static String readPartOneSixthColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_6, PART_1_END_COL_6);
	}

	private static String readPartTwoFirstColumn(String line) {
		return extractLineByPosition(line, PART_2_START_COL_1, PART_2_END_COL_1);
	}

	private static String readPartTwoSecondColumn(String line) {
		return extractLineByPosition(line, PART_2_START_COL_2, PART_2_END_COL_2);
	}

	private static String readPartTwoThirdColumn(String line) {
		return extractLineByPosition(line, PART_2_START_COL_3, PART_2_END_COL_3);
	}

	private static String readPartTwoForthColumn(String line) {
		return extractLineByPosition(line, PART_2_START_COL_4, PART_2_END_COL_4);
	}

	private static String readPartTwoFifthColumn(String line) {
		return extractLineByPosition(line, PART_2_START_COL_5, PART_2_END_COL_5);
	}

	private static String extractLineByPosition(String line, int start, int end) {
		return line.substring(start, end);
	}

	public static String fillTextWithSpace(String text, int lengthToFill) {
		String filledText = text.trim();
		if (text.trim().length() < lengthToFill) {
			for (int i = 0; i < lengthToFill - text.trim().length(); i++) {
				filledText += " ";
			}
		}
		return filledText;
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public static String replaceCharByAnotherChar(String str, String fromChar, String toChar) {
		return str.replaceAll(fromChar, toChar);
	}
	
	public class Employee {
		private String employeeName;
		private String block1;
		private String block2;

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public String getBlock1() {
			return block1;
		}

		public void setBlock1(String block1) {
			this.block1 = block1;
		}

		public String getBlock2() {
			return block2;
		}

		public void setBlock2(String block2) {
			this.block2 = block2;
		}

		@Override
		public String toString() {
			return "Employee [employeeName=" + employeeName + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((block1 == null) ? 0 : block1.hashCode());
			result = prime * result + ((block2 == null) ? 0 : block2.hashCode());
			result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (block1 == null) {
				if (other.block1 != null)
					return false;
			} else if (!block1.equals(other.block1))
				return false;
			if (block2 == null) {
				if (other.block2 != null)
					return false;
			} else if (!block2.equals(other.block2))
				return false;
			if (employeeName == null) {
				if (other.employeeName != null)
					return false;
			} else if (!employeeName.equals(other.employeeName))
				return false;
			return true;
		}

		private ReadCalculationFile getOuterType() {
			return ReadCalculationFile.this;
		}
	}

}
