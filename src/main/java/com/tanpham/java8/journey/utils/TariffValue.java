package com.tanpham.java8.journey.utils;

import java.math.BigDecimal;

public class TariffValue {
	private BigDecimal taxableIncome;
	private BigDecimal rate;

	public TariffValue(BigDecimal taxableIncome, BigDecimal rate) {
		this.taxableIncome = taxableIncome;
		this.rate = rate;
	}

	public BigDecimal getTaxableIncome() {
		return taxableIncome;
	}

	public void setTaxableIncome(BigDecimal taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "TariffValue [taxableIncome=" + taxableIncome + ", rate=" + rate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((taxableIncome == null) ? 0 : taxableIncome.hashCode());
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
		TariffValue other = (TariffValue) obj;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (taxableIncome == null) {
			if (other.taxableIncome != null)
				return false;
		} else if (!taxableIncome.equals(other.taxableIncome))
			return false;
		return true;
	}

}
