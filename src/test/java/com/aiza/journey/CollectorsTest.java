package com.aiza.journey;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsTest {
	private static final int PASS_THRESHOLD = 50;

	public static void main(String[] args) {
		List<Employee> employees = prepareEmployee();
		
		// Find highest-paid employee
		Optional<Employee> highestPaid = employees.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getMonthlySalary)));
		if (highestPaid.isPresent()) {
			System.out.println(highestPaid.get());
		}

		// Group employees by department
		Map<Department, List<Employee>> byDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		// Find highest-paid employee by department
		// Comparator<Employee> salaryComparator = (o1, o2)->o1.getMonthlySalary().compareTo(o2.getMonthlySalary());
		// Comparator<Employee> salaryComparator = Comparator.comparing(Employee::getMonthlySalary);
		Map<Department, Optional<Employee>> highestPaidByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getMonthlySalary))));
		highestPaidByDept.forEach((k, v) -> {
			System.out.println(k + " employee name: " + v.get().getName() + " with salary: " + v.get().getMonthlySalary());
		});
		
		// Partition students into passing and failing
		Map<Boolean, List<Employee>> passingFailing = employees.stream()
				.collect(Collectors.partitioningBy(s -> s.getProbationThreshold() >= PASS_THRESHOLD));
		passingFailing.forEach((k, v) -> {
			if (k == true) {
				v.stream().forEach(l -> {
					System.out.println("Passing employee: " + l.getName() + " probation threshold: " + l.getProbationThreshold());
				});
			} else {
				v.stream().forEach(l -> {
					System.out.println("Failure employee: " + l.getName() + " probation threshold: " + l.getProbationThreshold());
				});
			}
		});
	}

	private static List<Employee> prepareEmployee() {
		List<Employee> employees = new ArrayList<>();

		Department dept1 = new Department(1L);
		Department dept2 = new Department(2L);

		Employee emp1 = new Employee(1L, dept1, new BigDecimal(1000), 10);
		Employee emp2 = new Employee(2L, dept2, new BigDecimal(4000), 60);
		Employee emp3 = new Employee(3L, dept2, new BigDecimal(5000), 30);
		Employee emp4 = new Employee(4L, dept1, new BigDecimal(2000), 50);
		Employee emp5 = new Employee(5L, dept1, new BigDecimal(9000), 60);
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		return employees;
	}
}
