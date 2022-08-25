package com.nishant.writerproject.impl;

import com.nishant.writerproject.feature.AbstractFeature;
import com.nishant.writerproject.feature.IWriterFeature;

/**
 * This class is an implementation of String writer class.
 * @author Nishant.Kumar
 *
 */
public class StringWriter implements IWriter{
	private StringBuffer stringTS = new StringBuffer();
    private StringBuilder stringValue = new StringBuilder();
    private boolean isOpen = true;
    
    private IWriterFeature writerFeature;
    
    StringWriter(){
    	
    }

    public StringWriter(String string) {
		write(string);
	}
    
    public static StringWriter addFeature(IWriter writer) {
		return (StringWriter) writer;
    }
    
    public void write(String string) {
        if (isOpen){
        	stringValue = stringValue.append(string);
        }
    }
    
    public void write(final String string, final Boolean isThreasafeRequired) {
        if (isOpen){
        	if(isThreasafeRequired != null && isThreasafeRequired)
        		stringTS = stringTS.append(string);
        	else
        		stringValue = stringValue.append(string);
        }
    }

    public String toString() {
        return stringValue.toString();
    }

    public void close() {
        isOpen = false;
    }
}