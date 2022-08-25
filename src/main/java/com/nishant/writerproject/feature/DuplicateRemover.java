package com.nishant.writerproject.feature;

import java.io.IOException;

import com.nishant.writerproject.impl.IWriter;

/**
 * The class is to remove duplicate.
 * @author Nishant.Kumar
 *
 */
public class DuplicateRemover implements IWriter {

    private IWriter writer;

    public DuplicateRemover(IWriter iWriter) {
        writer = iWriter;
    }

    public String convert(String string) {
        return removeDuplicate(string);
    }

    /**
     * The method performs logic to remove duplicate from string.
     * @param string
     * @return
     */
    public String removeDuplicate(String string) {
        StringBuilder sb = new StringBuilder();
        for(String s : string.split(" ")) {
        	if(!sb.toString().contains(s)) {
        		sb.append(s + " ");
        	}
        }
        return sb.toString().trim();
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
