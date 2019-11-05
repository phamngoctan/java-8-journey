package com.tanpham.java8.journey.oreilly.section1;

import java.io.InputStream;

@FunctionalInterface
public interface InputStreamOpener {

	InputStream open(String input);
	
}
