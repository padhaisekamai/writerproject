package com.nishant.writerproject.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Abstract Writer class.
 * @author Nishant.Kumar
 *
 */
public abstract class WriterTest {

	private IWriter writer;

	protected abstract IWriter createWriter() throws IOException;
	protected abstract String getContent() throws IOException;

	@BeforeAll
	public void setup() throws IOException {
		writer = createWriter();
	}

	public IWriter getWriter()
	{
		return writer;
	}

	@Test
	public void callWriteOnceWhenFileExists() throws IOException
	{
		writer.write("WriterCall");
		assertEquals("WriterCall", getContent());
	}

	@Test
	public void callWriteMultipleCall() throws IOException
	{
		writer.write("Hello");
		writer.write("WriterMultiple");
		assertEquals("HelloWriterMultiple", getContent());
	}

	@Test
	public void verifyClose() throws IOException
	{
		writer.write("Hello");
		writer.write("Writer");
		writer.close();
		writer.write("AfterClose");
		assertEquals("HelloWriter", getContent());
	}

}

