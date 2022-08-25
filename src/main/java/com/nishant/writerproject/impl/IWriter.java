package com.nishant.writerproject.impl;
import java.io.IOException;

/**
 * The writer interface.
 * @author Nishant.Kumar
 *
 */
public interface IWriter {
	
	public  void write(String string) throws IOException;
	
	//public  void write(String string, Boolean isThreasafeRequired) throws IOException;
	
	public void close() throws IOException;
	
}

