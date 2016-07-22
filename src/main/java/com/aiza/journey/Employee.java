package com.aiza.journey;

import java.math.BigDecimal;

public class Employee {
	private Long id;
	private String name;
	private Department department;
	private BigDecimal monthlySalary;
	private int probationThreshold;

	public Employee(Long number, Department department, BigDecimal monthlySalary, int probationThreshold) {
		this(number, "Employee " + number, department, monthlySalary, probationThreshold);
	}

	public Employee(Long id, String name, Department department, BigDecimal monthlySalary, int probationThreshold) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.monthlySalary = monthlySalary;
		this.probationThreshold = probationThreshold;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public BigDecimal getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(BigDecimal monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public int getProbationThreshold() {
		return probationThreshold;
	}

	public void setProbationThreshold(int probationThreshold) {
		this.probationThreshold = probationThreshold;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", monthlySalary="
				+ monthlySalary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((monthlySalary == null) ? 0 : monthlySalary.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (monthlySalary == null) {
			if (other.monthlySalary != null)
				return false;
		} else if (!monthlySalary.equals(other.monthlySalary))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
