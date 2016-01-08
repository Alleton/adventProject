package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;

public class Solver9 {
	public String solver9 (String sfname){
		String line ;
		int resultat = 0 ;
		int linelength =0;
		int encodelength   = 0 ;
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			while ((line = reader.readLine()) != null) { 
				line = line.trim() ;
				
				//System.out.println("line  =  " + line  ) ;
				//charcode = analyse(line) ;
				linelength = linelength + line.length();
				
				
			} // end for
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "solver9 ";

	} // end solver9 
			
}
