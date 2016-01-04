package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.alleton.adventProject.model.*;

public class Solver7 {
	public String solver7 (String sfname){

	int linenumber =  0 ;
	
	String line ;
	
	String instruction  ;
	int startx ;
	int starty ;
	int endx ;
	int endy ;
	
	String[] tokens ;
	String[] coordinates;
	String delimspace = "[ ]+";   // maybe some double space ??
	String delimcoma = "[,]";
	Solver7circuit solver7circuit ;
	
	
	System.out.println(" value7 solver 7 "   ) ;
	try {
		//Solver7circuit 
		solver7circuit =  parselines(sfname) ;
		// this should initialyse values
		//System.out.println( )
		System.out.println ("solver7circuit.toString()");
		System.out.println (solver7circuit.toString());
	} catch (Exception e) {
		// TODO Auto-generated catch block
	
		//throw new IllegalArgumentException("Unable to load " + sfname, e);
		e.printStackTrace();
	}
	// resultat = countlights() ; 
	
	
	return "solver 76 "  ; 		
		
	} // end solver7 fname
	
	/**
	 * parse 
	 */
	public static Solver7circuit parselines( String sfname) {
		
		Solver7circuit solver7circuit = new Solver7circuit();
		
		String splitBy = " ";  
		String line = "";
		int linenumber = 0;
		Scanner scanner = null;
		
		//Solver7wire wire = new Solver7wire () ;
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);

			/* relecture premiere ligne  */
			line = reader.readLine();
			
			
			/* lecture deuxieme ligne  */
			while ((line = reader.readLine()) != null) {
				Solver7wire wire = new Solver7wire () ;
				System.out.println( line ) ;
			
				scanner = new Scanner(line);
				scanner.useDelimiter(splitBy);
				String first = scanner.next();
				
				if ( isNumeric(first)) {
					wire.setEntryvalue(Integer.parseInt(first));
				}else{
				
					wire.setEntry1(first);
				}
				scanner.close();
				
				System.out.println( first ) ;
				
				
				solver7circuit.getSolver7wire()[linenumber] = wire;
				
				linenumber ++ ;
			} // while lecture ligne
			
			//matrix.getCells()[rowIndex][colIndex] = cell;
			

			reader.close();
			filereader.close();

		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("Execption "  , e);
			//e.printStackTrace();
		}
		return solver7circuit ;
		
	}
	
	private   static boolean isNumeric(String str)
	  {
		return str.matches("\\d+");
	  }
	
} // end class Solver7
