package com.aiza.journey;

public class FunctionInterfaceTest {
	public static void main(String[] argv) {
		Processor stringProcessor = (String str) -> str.length();
		String name = "Java Lambda";
		int length = stringProcessor.getStringLength(name);
		System.out.println(length);

		stringProcessor = (String str) -> str.length();
		length = stringProcessor.getStringLength(name);
		System.out.println(length);
		
	}
}

@FunctionalInterface
interface Processor {
	int getStringLength(String str);
}
