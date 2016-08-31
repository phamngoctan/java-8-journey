package com.aiza.journey.sample;

import java.time.LocalDate;
import java.util.List;

public class FunctionalInterfaceDemoUsing {

	@FunctionalInterface
	public interface PayslipCalculation {
		public Payslip getPayslipFromList(int monthFrom, int yearFrom);
	}

	private List<Payslip> payslips;
	private List<Payslip> substitutions;
	
	public Payslip getPayslipSubstitution(int monthFrom, int yearFrom) {
		String month = (monthFrom < 10) ? "0" + monthFrom : monthFrom + "";
		String date = yearFrom + "-" + month + "-" + "01T00:00:00.000Z";
		return getPayslipSubstitutionByPeriodFrom(date);
	}
	
	public Payslip getPayslipFromOriginalList(int monthFrom, int yearFrom) {
		String month = (monthFrom < 10) ? "0" + monthFrom : monthFrom + "";
		String date = yearFrom + "-" + month + "-" + "01T00:00:00.000Z";
		return getPayslipByPeriodFrom(date);
	}
	
	public static void main(String[] args) {
		FunctionalInterfaceDemoUsing fi = new FunctionalInterfaceDemoUsing();
		int monthFrom = 10;
		int yearFrom = 2013;
		fi.sealPayslip(monthFrom , yearFrom , fi::getPayslipSubstitution);
	}
	
	private void sealPayslip(int monthFrom, int yearFrom, PayslipCalculation payslipCalculation) {
		Payslip payslip = payslipCalculation.getPayslipFromList(monthFrom, yearFrom);
		// Do some other thing
	}
	
	private Payslip getPayslipByPeriodFrom(String date) {
		Payslip payslip = null;
		for (Payslip p : payslips) {
			if (p != null) {
				if (p.getPeriodFrom().equals(date)) {
					return p;
				}
			}
		}
		return payslip;
	}
	
	private Payslip getPayslipSubstitutionByPeriodFrom(String date) {
		Payslip payslip = null;
		for (Payslip p : substitutions) {
			if (p != null) {
				if (p.getPeriodFrom().equals(date)) {
					return p;
				}
			}
		}
		return payslip;
	}
	
	class Payslip {
		LocalDate periodFrom;

		public LocalDate getPeriodFrom() {
			return periodFrom;
		}

		public void setPeriodFrom(LocalDate periodFrom) {
			this.periodFrom = periodFrom;
		}
		
	}
	
}
