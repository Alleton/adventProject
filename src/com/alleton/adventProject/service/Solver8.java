package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;

import com.alleton.adventProject.model.Solver7circuit;

public class Solver8 {
	Character escapechar = '\\';
	Character quotechar = '"';
	
	
	public String solver8 (String sfname){
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
				resultat = resultat + analyse(line);
				
				// encode
				encodelength = encodelength + encode (line) ;
				
			} // end for
			
			reader.close();
			filereader.close();
			System.out.println("linelength " +linelength  ) ;
			System.out.println("in memory " +resultat  ) ;
			System.out.println("Soit  " + ( linelength - resultat )  ) ;
			System.out.println(" ****** part 2 **") ; 
			System.out.println("encodelength " +encodelength  ) ;
			linelength = 0 ; 
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return "solver 8 "  ; 		
		
	} // end solver8 fname

	/* encodage
	 * 
	 */
	private int encode (String line) {
		int encoded     = 0;
		// do not need to encode both starting and endig " as it makes for + 2
		for ( int i =1 ; i< line.length() - 1 ;i++){
				// we need one more char after escape ..
				Character ch;
				ch = line.charAt(i);
				if (ch.equals(escapechar) ){
					encoded ++ ;
				}
				if (ch.equals(quotechar) ){
					encoded ++ ;
				}
			}
		
		return encoded + 4 ; // wa encode the exterior double quote ..
	}
	
	
	
	/* analyse
	 * 
	 */
	private int analyse (String line) {
		int inmemory    = 0;
		int numnbr      = 0;
		
		line = line.substring(1,line.length() - 1 ) ; // eliminate double quote
		
		//System.out.println("analize line  =  " + line  ) ;
		inmemory = inmemory + line.length();
		// now we check for escape \

		// loop over line for escape
		for ( int i =0 ; i< line.length() - 1 ;i++){
			// we need one more char after escape ..
			Character ch;
		
			ch = line.charAt(i);
			
			if (ch.equals(escapechar) ){
				// test for escaped escape
				
				if ( line.charAt(i +1) ==(escapechar) ) {
					inmemory -- ;
					 i ++ ;  // the second escape does not count as the starting point of escape seq
				}
			
				// test for doublequote
				if ( i < line.length() - 1) {
					if ( line.charAt(i +1) ==(quotechar) ) {
				
						inmemory -- ;
						i ++ ;  // do not analyse this quote
					}
				} // end  i < line.length() - 1)

				// test for numeric 
				// we need 4 more char after escape
				if ( i < line.length() - 3 ) {
					if ( line.charAt(i +1) ==('x') ) {
						// test for 2 numerics
						if ( isHexa (line.substring(i+2,i+4))) {
							//System.out.println("is isHexa  : " + line.substring(i+2,i+4) );
							inmemory = inmemory - 3 ;  // un seul char au lieu de 4
							numnbr = numnbr + 1 ;
							
						}
					}
				}
			}       // end ch.equals(escapeseq) 
		}           // end for 
	
		
		return  inmemory ;
	} // end analyse
	private   static boolean isHexa(String str)
	  {
		// return str.matches("\\d+");
		try {
			Integer outputDecimal = Integer.parseInt(str, 16);
			return true;
		}catch(NumberFormatException ne){
			// Printing a warning message if the input is not a valid hex number
			// System.out.println("Invalid Input");
			return false;
		}
		//return true;
	  }

}
