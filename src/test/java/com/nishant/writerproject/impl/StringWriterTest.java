package com.nishant.writerproject.impl;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;


public class StringWriterTest extends WriterTest {

	private StringWriter string;

	@BeforeAll
	public void setUp(){
		string = new StringWriter();
	}

	@Override
	protected IWriter createWriter() throws IOException {
		return new StringWriter();
	}

	@Override
	protected String getContent() {
		return getWriter().toString();
	}
}