package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;

import com.alleton.adventProject.model.Solver23State;
//import java.util.Vector;

public class Solver23 {
	final int nbInstructions = 46 ;
	String[] programInstructions = new String[nbInstructions] ; 
	String[] param1 = new String[nbInstructions] ;
	int[] param2 = new int[nbInstructions] ; // param2 est tjrs un int
	int step = 0 ;
	int limite = 60 ; /// pour se limiter
	int nbsteps = 0 ;
	
	Solver23State theState = new Solver23State() ;
	
	public String solver23 (String sfname){
		
		
		System.out.println("---------- solver23 ------------" )  ;
		parselines( sfname) ;
			//display(theSpells) ;
		
		System.out.println(theState.stateToString());
		// int new pos  = theState.apply( instruction , param 1 , param2 )
		
		while ( ( step >=0 ) && ( step < nbInstructions) && (nbsteps < limite)) {
			step  = theState.apply( programInstructions[step] , param1[step] , param2[step] ) ;
			nbsteps ++ ;
			System.out.println("now nbsteps " + nbsteps + " "  + theState.stateToString() ) ;
		}
		
		return ("Solver23 "  + theState.stateToString() ) ;
		} //  end solver23

		
		
		
		/*
		 * public void parselines(String sfname)
		 * cree les spells
		 */
		public void parselines(String sfname) {
			
			String line = "";
			
			try {
				System.out.println(" lire "  + sfname );
				FileReader filereader = new FileReader( sfname );
				BufferedReader reader = new BufferedReader(filereader);
				line = reader.readLine();
				int i = 0 ;
				while ( line != null   && ! line.equals("") ) {
					//String correct = line.replaceAll("\\s+", " ");
					String correct = line.replaceAll(",", "");
					String[] parts =correct.split(" ");
					programInstructions[i] = parts[0] ;
					param1[i] = parts[1];
					if ( parts.length > 2 )
						param2[i] = Integer.parseInt(parts[2]) ;
						i ++ ;
						line = reader.readLine();
					}
				reader.close();
				filereader.close();
			} catch (Exception e) { 
				e.printStackTrace();
			}
			
			for ( int i = 0   ; i < nbInstructions ; i ++ ) {
				System.out.println(programInstructions[i] + " " + param1[i] + " " + param2[i] );
			}
			
			return  ;

		} // parseline
		
		

}
