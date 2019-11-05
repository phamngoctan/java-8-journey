package com.tanpham.java8.journey.exceptionhandling;

import java.util.Arrays;
import java.util.List;

public class MainApplication {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
		list.forEach(HandlingConsumer.handlingConsumerBuilder(i->Thread.sleep(i)));
	}
}
