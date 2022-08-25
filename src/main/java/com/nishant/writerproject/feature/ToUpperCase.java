package com.nishant.writerproject.feature;

import java.io.IOException;

import com.nishant.writerproject.impl.IWriter;

/**
 * The class is to convert a given value to UPPER CASE.
 * @author Nishant.Kumar
 *
 */
public class ToUpperCase implements IWriter {

	private static IWriter writer;

	public ToUpperCase(IWriter iWriter) {
		writer = iWriter;
	}
	
	public static IWriter build() {
		return writer;
	}

	public String convert(String string) {
		return string.toUpperCase();
	}

	@Override
	public void write(String content) throws IOException {
		writer.write(convert(content));
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}

	@Override
	public String toString() {
		return writer.toString();
	}
}
