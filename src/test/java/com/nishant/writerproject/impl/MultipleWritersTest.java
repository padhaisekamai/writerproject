package com.nishant.writerproject.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.nishant.writerproject.feature.DuplicateRemover;
import com.nishant.writerproject.feature.ToLowerCase;
import com.nishant.writerproject.feature.StupidRemover;
import com.nishant.writerproject.feature.ToUpperCase;

/**
 * The class is to test Multiple Writer with feature.
 * @author Nishant.Kumar
 *
 */
public class MultipleWritersTest {


	@Test
	public void testUpperCaseStupidAndDuplicateRemover() throws IOException {
		StringWriter stringWriter = new StringWriter();
		ToUpperCase upperCaseConverter = new ToUpperCase(stringWriter);
		StupidRemover stupidRemover = new StupidRemover(upperCaseConverter, "stupid");
		IWriter multiWriter = new DuplicateRemover(stupidRemover);
		multiWriter.write("Nishant stupid stupid Kumar");
		assertEquals("NISHANT S***** KUMAR", multiWriter.toString());
	}


	@Test
	public void stupidRemoverOnLowerWithFileWriter() throws IOException {
		FileWriter fileWriter = new FileWriter("testFileRiter.txt");
		ToLowerCase lowerCaseConverter = new ToLowerCase(fileWriter);
		StupidRemover stupidRemover = new StupidRemover(lowerCaseConverter, "stupid");
		IWriter multiWriter = new DuplicateRemover(stupidRemover);
		multiWriter.write("nishant kumar stupid stupid");
		multiWriter.close();
		multiWriter = new ToUpperCase(fileWriter);
		multiWriter.write("nishant roliwal stupid stupid");
		assertEquals("nishant kumar s*****", new FileWriterTest().readFile());
	}

	@Test
	public void stupidRemoverOnUpper() throws IOException {
		StringWriter stringWriter = new StringWriter();
		DuplicateRemover duplicateRemover = new DuplicateRemover(stringWriter);
		StupidRemover stupidRemover = new StupidRemover(duplicateRemover, "stupid");
		ToUpperCase multiWriter = new ToUpperCase(stupidRemover);
		multiWriter.write("nishant stupid kumar stupid kumar");
		assertEquals("NISHANT S***** KUMAR", multiWriter.toString());
	}

	@Test
	public void duplicateRemoverOnStupidRemover() throws IOException {
		StringWriter stringWriter = new StringWriter();
		DuplicateRemover duplicateWriter = new DuplicateRemover(stringWriter);
		StupidRemover multiWriter = new StupidRemover(duplicateWriter, "stupid");
		multiWriter.write("Nishant Nishant stupid stupid Kumar");
		assertEquals("Nishant s***** Kumar", multiWriter.toString());
	}

}
