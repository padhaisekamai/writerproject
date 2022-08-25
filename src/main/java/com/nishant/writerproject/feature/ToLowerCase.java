package com.nishant.writerproject.feature;

import java.io.IOException;

import com.nishant.writerproject.impl.IWriter;

/**
 * The class is to convert a given value to LOWER CASE.
 * @author Nishant.Kumar
 *
 */
public class ToLowerCase implements IWriter {
    private IWriter writer;

    public ToLowerCase(IWriter iWriter) {
        writer = iWriter;
    }

    public String convert(String string){
        return string.toLowerCase();
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
    public String toString(){
        return writer.toString();
    }
}
