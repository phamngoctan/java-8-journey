package com.tanpham.java8.journey;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.tanpham.java8.journey.Department;
import com.tanpham.java8.journey.Employee;

public class CollectorsTest {
	private static final int PASS_THRESHOLD = 50;

	public static void main(String[] args) {
		// join
		String creditorAddressLine = new ArrayList<>(Arrays.asList("hello, world".split(","))).stream().map(String::trim).collect(Collectors.joining(" "));
		System.out.println(creditorAddressLine);
		String testStr = String.join("-", "java", "is", "the", "best");
		System.out.println(testStr);
		String testNullJoin = String.join(" ", null, "hello");
		System.out.println(testNullJoin);
		
		List<Employee> employees = prepareEmployee();
		
		// Find highest-paid employee
		Optional<Employee> highestPaid = employees.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getMonthlySalary)));
		if (highestPaid.isPresent()) {
			System.out.println(highestPaid.get());
		}

		// Find highest-paid employee by department
		// Comparator<Employee> salaryComparator = (o1, o2)->o1.getMonthlySalary().compareTo(o2.getMonthlySalary());
		// Comparator<Employee> salaryComparator = Comparator.comparing(Employee::getMonthlySalary);
		Map<Department, Optional<Employee>> highestPaidByDept = employees.stream()
//				.peek(d -> System.out.println("Debug: " + d))
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getMonthlySalary))));
		
		highestPaidByDept.forEach((k, v) -> {
			System.out.println(k + " employee name: " + v.get().getName() + " with salary: " + v.get().getMonthlySalary());
		});
		
		// Partition students into passing and failing
		Map<Boolean, List<Employee>> passingFailing = employees.stream()
//				.peek(d -> System.out.println("Debug: " + d))
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
		
		// Counting number of passed probation employee 
		Long numberEmployeePassedProbation = employees.stream()
			.filter(e -> e.getProbationThreshold() >= PASS_THRESHOLD)
			.collect(Collectors.counting());
		System.out.println("Total passed employee: " + numberEmployeePassedProbation);
		
		// Total salary that company has to pay in one month
		BigDecimal totalMonthlySalary = employees.stream()
				.filter(e -> e != null)
				.map(e -> e.getMonthlySalary())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("Total salary that company has to pay in one month: " + totalMonthlySalary);
		
		// Get highest paid salary first solution
		BigDecimal maxPaidValueFirstSolution = employees.stream()
			.filter(e -> e != null)
			.max(Comparator.comparing(Employee::getMonthlySalary)).get().getMonthlySalary();
		System.out.println("Highest paid salary: " + maxPaidValueFirstSolution);
		
		// Get highest paid salary first solution
		BigDecimal maxPaidValueSecondSolution = employees.stream()
			.filter(e -> e != null)
			.map(e -> e.getMonthlySalary())
			.max(Comparator.naturalOrder()).get();
		System.out.println("Highest paid salary: " + maxPaidValueSecondSolution);
		
		// Group employees by department, the value is a List
		Map<Department, List<Employee>> byDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		byDept.forEach((k, v) -> {
			v.stream().forEach(l -> {
				System.out.println("Way 1: Department name: " + k.getDepartmentName() + " employee: " + l.getName());
			});
		});
		
		// Group employees by department, the value is a Set
		Map<Department, Set<Employee>> byDeptWithSetEmployeeValue = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
		byDeptWithSetEmployeeValue.forEach((k, v) -> {
			v.stream().forEach(l -> {
				System.out.println("Way 2: Department name: " + k.getDepartmentName() + " employee: " + l.getName());
			});
		});
		
		// Average passed score
		Double averagePassedScore = employees.stream()
				.filter(e -> e != null && e.getProbationThreshold() >= PASS_THRESHOLD)
				.map(e -> e.getProbationThreshold())
				.collect(Collectors.averagingInt(Integer::intValue));
		System.out.println("Avarage passed score of company: " + averagePassedScore);
		
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
