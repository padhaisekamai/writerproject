package com.nishant.writerproject.impl;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class is an implementation of FileWriter.
 * @author Nishant.Kumar
 *
 */
public class FileWriter implements IWriter {

    java.io.FileWriter fileWriter;
    private boolean isClosed;
    Path path;

    public FileWriter(String file) throws IOException {
        fileWriter = new java.io.FileWriter(file);
        path = Paths.get(file);
    }

    @Override
    public void write(String string) throws IOException {
        if (!isClosed){
            fileWriter.write(string);
            fileWriter.flush();
        }
    }

    public void close()
    {
        isClosed = true;
    }

	//@Override
	public void write(String string, Boolean isThreasafeRequired) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
