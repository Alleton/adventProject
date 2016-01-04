package com.alleton.adventProject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AdventGetPropertyValues {
	/*
	 * read properties from Sudoku.properties file
	 * in default "bin" folder   
	 * and return one property
	 */
	public String getPropValue( String propName )  {
		 
		String result = "";
		Properties prop = new Properties();
		String propFileName = "adventProject.properties";
				
		InputStream input = null;
		 
		try {
	 
			 input = getClass().getClassLoader().getResourceAsStream(propFileName);
			
			// load the properties file
			prop.load(input);
	 
			// get the property value and return it 
			result = prop.getProperty(propName);
			return result;
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
