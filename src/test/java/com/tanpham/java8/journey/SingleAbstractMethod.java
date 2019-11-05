package com.tanpham.java8.journey;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SingleAbstractMethod {
	public static void main(String[] args) {
		final ArrayList<Integer> list = (ArrayList<Integer>) IntStream
				.rangeClosed(1, 20).boxed().collect(Collectors.toList());

		Integer max1 = list.stream()
				.peek(i -> System.out.println(i))
				.max((x, y) -> {
					return x.compareTo(y);
				}).get();
		System.out.println("Max with compare to: " + max1); //
		
		Integer max2 = list.stream()
//				.peek(i -> System.out.println(i))
				.max(Integer::max)
				.get();
		System.out.println("Max with Integer::max: " + max2); //(x, y) -> x.compareTo(y)
//		System.out.println(list.stream().min(Integer::min).get());
		
		SingleAbstractMethod sam = new SingleAbstractMethod();
		
		Integer max3 = list.stream()
//			.map((a, b, c, d, e) -> {formatUnsignedInt})
			.max(sam.comp::compareTo)
			.get()
			;
		System.out.println("Max with Function<T, U, R>: " + max3); //(x, y) -> x.compareTo(y)
		
		list.stream()
				.filter(k -> k != 0)
				.reduce(0, (x,y) -> x+y)
				;
		
	}
	
	Function<Integer, Integer, Integer> comp = (first, second) -> Integer.compare(first, second);
	static IAddable testIAddable = (first, second) -> first + second;
}

interface Function<T, U, R> {
	 R compareTo(T i1, U i2);
}

interface Function2<T, U, R, K> {
	 K compareTo(T i1, U i2, R i3);
}


class AddableTest {
	// Lambda expression using existing method
	IAddable addableViaMethodReference = this::addThemUp;

	// Add given two integers
	private int addThemUp(int i1, int i2) {
		return i1 + i2;
	}
}

interface IAddable {
	int addThemUp(int i1, int i2);
}
