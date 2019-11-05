package com.tanpham.java8.journey.payslip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum SalaryItemTypeName {
	NOT_FOUND(0, "Not found"),
	MONTHLY_SALARY(1000, "Monatslohn"), 
	HOURLY_SALARY(1005, "Stundenlohn"),
	LESSONS_SALARY(1006, "Lektionenlohn"),
	FEES(1010,"Honorare"),
	RESIDENCE_ALLOWANCE(1033,"Ortszulage"),
	OVERTIME_HOURS_125_PERCENTAGE(1061,"Ueberstunden 125"),
	OVERTIME(1065,"Ueberzeit"),
	ON_CALL_COMPENSATION(1071,"Pikettentsch\\w+digung"),
	SUNDAY_SUPPLEMENT(1073,"Sonntagszulage"),
	VACATION_COMPENSATION(1160,"Ferienverg\\w+tung"),
	HOLIDAY_COMPENSATION(1161,"Feiertagsentsch\\w+digung"),
	_13_MONTHLY_SALARY(1200,"13. Monatslohn"),
	GRATUITY(1201,"Gratifikation"),
	SPECIAL_ALLOWANCE(1212,"Sonderzulage"),
	SENIORITY_ALLOWANCE(1230,"Dienstaltersgeschenke"),
	CAPITAL_PERFORMANCE_WITH_PREVENTIVE_CHARACTER(1410,"Kapitalleistung mit Vorsorgecharakter"),
	BOARD_COMPENSATION(1500,"Verwaltungsratshonorar"),
	FREE_MEALS(1900,"Gratisverpflegung"),
	FREE_APARTMENT(1902,"Gratiswohnung"),
	PRIVATE_SHARE_COMPANY_CAR(1910,"Privatanteil Gesch\\w+ftswagen"),
	CHEAPENING_APARTMENT(1950,"Verbilligung Mietwohnung"),
	EMPLOYEE_SHARES(1961,"Arbeitnehmeraktien"),
	EMPLOYEE_STOCK_OPTIONS(1962,"Mitarbeiteroptionen"),
	KTG_EMPLOYEE_PART_PAIED_BY_EMPLOYER(1971,"Vom AG \\w+bern. AN-Anteil KTG"),
	BVG_EMPLOYEE_PART_PAIED_BY_EMPLOYER(1972,"Vom AG \\w+bern. AN-Anteil BVG"),
	BVG_PURCHASE_EMPLOYEE_PART_PAIED_BY_EMPLOYER(1973,"Vom AG \\w+bern. AN-Anteil Einkauf BVG"),
	PILLAR_3B_PAIED_BY_EMPLOYER(1976,"Vom Arbeitgeber \\w+bern. S\\w+ule 3 b"),
	PILLAR_3A_PAIED_BY_EMPLOYER(1977,"Vom Arbeitgeber \\w+bern. S\\w+ule 3 a"),
	TRAINING_COSTS(1980,"Weiterbildung (Lohnausweis)"),
	EO_DAILY_ALLOWANCE(2000,"EO-Taggeld"),
	MILITARY_SERVICE_FUND(2005,"Milit\\w+rdienstkasse (MDK)"),
	ACCIDENT_DAILY_ALLOWANCE(2030,"Unfall-Taggeld"),
	SICKNESS_DAILY_ALLOWANCE(2035,"Kranken-Taggeld"),
	CORRECTION_DAILY_ALLOWANCES(2050,"Korrektur Taggelder"),
	SALARY_DEDUCTION_KA_OR_SW(2060,"Lohnabzug KA/SW (ML)"),
	SALARY_LOSS_KA_OR_SW(2065,"Lohnausfall KA/SW (SL)"),
	ALV_COMPENSATION(2070,"ALV-Entschädigung"),
	WAITING_PERIOD_KA_OR_SW(2075,"Karenztag KA/SW"),
	CHILD_ALLOWANCE(3000,"Kinderzulage"),
	BIRTH_ALLOWANCE(3032,"Geburtszulage"),
	NET_OR_GROSS_SETOFF(4900,""),
	GROSS_SALARY(5000,"Bruttolohn"),
	AHV_CONTRIBUTIONS(5010,"AHV-Beitrag"),
	ALV_CONTRIBUTION(5020,"ALV-Beitrag"),
	ALVZ_CONTRIBUTION(5030,"ALVZ-Beitrag"),
	NBUV_CONTRIBUTION(5040,"NBUV-Beitrag BT"),
	UVGZ_CONTRIBUTION_1(5041,"UVGZ-Beitrag .* 11"),
	UVGZ_CONTRIBUTION_2(5042,"UVGZ-Beitrag .* 12"),
	UVGZ_CONTRIBUTION_3(5043,""),
	UVGZ_CONTRIBUTION_4(5044,""),
	KTG_CONTRIBUTION_1(5045,"KTG-Beitrag .* 11"),
	KTG_CONTRIBUTION_2(5046,"KTG-Beitrag .* 12"),
	KTG_CONTRIBUTION_3(5047,""),
	KTG_CONTRIBUTION_4(5048,""),
	BVG_CONTRIBUTION(5050,"BVG-Beitrag"),
	BVG_PURCHASE_CONTRIBUTIONS(5051,"BVG-Einkaufs-Beitr\\w+ge"),
	QST_DEDUCTION(5060,""),
	DEDUCTION_PRIVATE_SHARE_COMPANY_CAR(5080,"Abzug Privatanteil Gesch\\w+ftwagen"),
	EQUALISE_IN_KIND(5100,"Ausgleich Naturalleistungen"),
	EQUALISE_CASH_BENEFITS(5110,"Ausgleich geldwerte Vorteile"),
	EQUALISE_BVG_CONTRIBUTIONS_EMPLOYER(5111,"Ausgleich BVG-Beitr\\w+ge AG"),
	EQUALISE_BVG_PURCHASE_EMPLOYER(5112,"Ausgleich BVG-Einkauf AG"),
	TRAVEL_EXPENSE(6000,"Reisespesen"),
	EFFECTIVE_EXPENSES_EXPATRIATES(6020,"Effektive Spesen Expatriates"),
	FLAT_RATE_ENTERTAINMENT_EXPENSES(6040,"Pauschale Repr\\w+sentationsspesen"),
	FLAT_RATE_CAR_EXPENSES(6050,"Pauschale Autospesen"),
	REMAINING_FLAT_RATE_EXPENSES(6070,"Uebrige Pauschalspesen"),
	NET_SALARY(6500,"Nettolohn"),
	PAYING_OUT(6600,""),
	AHV_BASE(9010,"AHV-Basis"),
	AHV_SALARY(9011,"AHV-Lohn"),
	NOT_AHV_DUTY(9012,"Nicht AHV-pflichtig"),
	ALV_BASE(9020,""),
	ALV_SALARY(9021,"ALV-Lohn"),
	ALVZ_SALARY(9022,"ALVZ-Lohn"),
	NOT_ALV_DUTY(9023,"Nicht ALV-pflichtig"),
	UVG_BASE(9030,"UVG-Basis"),
	UVG_SALARY(9031,"UVG-Lohn"),
	UVGZ_BASE(9040,"UVGZ-Basis"),
	UVGZ_SALARY_1(9041,"UVGZ-Lohn 11"),
	UVGZ_SALARY_2(9042,"UVGZ-Lohn 12"),
	UVGZ_SALARY_3(9043,""),
	UVGZ_SALARY_4(9044,""),
	KTG_BASE(9050,"KTG-Basis"),
	KTG_SALARY_1(9051,"KTG-Lohn 11"),
	KTG_SALARY_2(9052,"KTG-Lohn 12"),
	KTG_SALARY_3(9053,""),
	KTG_SALARY_4(9054,""),
	BVG_BASE(9060,""),
	BVG_SALARY(9061,""),
	QST_SALARY(9070,""),
	QST_RATE_DETERMINING_SALARY(9071,"");
	
	private String germanName;
	private Integer code;

	SalaryItemTypeName(Integer sitCode, String german) {
		this.germanName = german;
		this.code = sitCode;
	}
	
	public String getGermanName() {
		return germanName;
	}

	public void setGermanName(String germanName) {
		this.germanName = germanName;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public static String fromGermanName(String german) {
		for (SalaryItemTypeName sitEnum : SalaryItemTypeName.values()) {
			if (sitEnum.germanName.isEmpty()) 
				continue;
			Pattern pattern = Pattern.compile(sitEnum.germanName, Pattern.UNICODE_CHARACTER_CLASS);
			Matcher matcher = pattern.matcher(german);
			Pattern contraryPattern = Pattern.compile(german, Pattern.UNICODE_CHARACTER_CLASS);
			Matcher contraryMatcher = contraryPattern.matcher(sitEnum.germanName);
			if (matcher.find() || contraryMatcher.find()) {
				if (sitEnum.equals(_13_MONTHLY_SALARY)) {
					return "13_MONTHLY_SALARY";
				}
				return sitEnum.toString();
			}
		}
		return SalaryItemTypeName.NOT_FOUND.toString();
	}
	
	public static String fromGermanNameToCode(String german) throws IllegalArgumentException {
		for (SalaryItemTypeName sitEnum : SalaryItemTypeName.values()) {
			if (sitEnum.germanName.isEmpty()) 
				continue;
			Pattern pattern = Pattern.compile(sitEnum.germanName, Pattern.UNICODE_CHARACTER_CLASS);
			Matcher matcher = pattern.matcher(german);
			Pattern contraryPattern = Pattern.compile(german, Pattern.UNICODE_CHARACTER_CLASS);
			Matcher contraryMatcher = contraryPattern.matcher(sitEnum.germanName);
			if (matcher.find() || contraryMatcher.find()) {
				return sitEnum.code.toString();
			}
		}
		throw new IllegalArgumentException("Salary item type has name so it must have code also");
	}

}
