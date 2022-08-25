package com.nishant.writerproject.feature;

import java.io.IOException;

import com.nishant.writerproject.impl.IWriter;

/**
 * The class is to remove 
 * @author Nishant.Kumar
 *
 */
public class StupidRemover implements IWriter{

    private  IWriter writer;
    
    private String stringToRemoveMask;    

    public StupidRemover(IWriter iWriter, String stringToRemoveMask){
        writer = iWriter;
        this.stringToRemoveMask = stringToRemoveMask;
    }

    public String removeMaskString(String string) {
    	String firstChar = stringToRemoveMask.substring(0, 1);
        return string.replaceAll(stringToRemoveMask.toLowerCase(), firstChar.toLowerCase()+"*****")
        		.replaceAll(stringToRemoveMask.toLowerCase().replaceFirst(firstChar, firstChar.toUpperCase()), "S*****")
        		.replaceAll(stringToRemoveMask.toUpperCase(), firstChar.toUpperCase()+"*****");
    }

    @Override
    public void write(String content) throws IOException {
        writer.write(removeMaskString(content));
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