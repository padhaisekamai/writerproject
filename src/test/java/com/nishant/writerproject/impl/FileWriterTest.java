package com.nishant.writerproject.impl;

import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The File Writer implementation.
 * @author Nishant.Kumar
 *
 */
public class FileWriterTest extends WriterTest{

    String filepath = "testFileRiter.txt";

    public String readFile() throws IOException {
        return Files.lines(Paths.get(filepath)).collect(joining(""));
    }

    @Override
    protected IWriter createWriter() throws IOException { 
        return new FileWriter(filepath);
    }

    @Override
    protected String getContent() throws IOException {
        return Files.newBufferedReader(Paths.get(filepath)).readLine();
    }
}