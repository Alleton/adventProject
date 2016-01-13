package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver10 {
	StringBuffer  solution = new StringBuffer("");
	StringBuffer  probleme = new StringBuffer("");
	private Chrono chrono = new Chrono () ;
	int linel = 0;
	
	public String solver10 (String sfname){
		//String res = "";
		String line ;
		// int iteration ;
		long startiteration = 0   ;
		
		 try {
			 FileReader filereader = new FileReader(sfname);
		 
			 BufferedReader reader = new BufferedReader(filereader);
			 /* lecture ligne  */
			 
		 
			 while ((line = reader.readLine()) != null) {
				 System.out.println(" line " + line );	 
				 chrono.start();          // 
				 solution.append(line) ;
				 //analyse (  line );
		
		 		 for ( int  iteration = 1 ; iteration <= 40; iteration ++) {
		
		 			//line = solution.toString() ;
		 			probleme.setLength(0);
		 			probleme.append(solution) ;
		 			//System.out.println(" at start iteration probleme = " + probleme); 
		 			
		 			solution.setLength(0);
					 System.gc(); 
					 System.out.println(" iteration " + ( iteration ) );	 
					 System.out.println(" duree iteration " +  Long.toString(  chrono.getTimeElapsed() - startiteration ))  ;
					 startiteration =  chrono.getTimeElapsed() ;
					 //System.out.println(" before iteration probleme = " + probleme);
					 analyse (  0 );
					 //analyse (  line );
					 probleme.setLength(0);
					 probleme.append(solution) ;
					 //System.out.println(" inside iteration solution = " + solution);
					 //System.out.println(" inside iteration probleme = " + probleme);
					 System.out.println(" length line " + probleme.length() );	 
					 
					 linel = line.length() ;
					 
				 }
		 		System.out.println(" duree " + Long.toString(chrono.getFinalTimeElapsed() ) ) ;
				 //System.out.println(" solution " + solution );	 
				 
			 }
	
			 reader.close();
			 filereader.close();
		 } catch (IOException e) {
			 throw new IllegalArgumentException("Unable to load " + sfname, e);
		//e.printStackTrace();
	}
		
		return String.valueOf(probleme.length()) ;
	} // 
	
	private void  analyse ( int start ) {
		char c ;
		// System.out.println( "analyse line probleme :" + probleme + ":"  + " = " + probleme.length() ) ;
		// String ligne = probleme.substring(start,probleme.length());
		 int linelength = probleme.substring(start ,probleme.length()).length();
		
		
		//System.out.println( "analyse line :" + ligne + ":"  + " = "+ linelength) ;
		//System.out.println( "analyse line : start " + start + ":"  + " = "+ linelength) ;
		
		// ligne vide ??
		//if (ligne.length() == 0 ) {
		if (probleme.length() == start ) {
			 //return line;
		} else {
		 c= probleme.charAt(start);
		 // serai-ce le dernier character ??
		 if (probleme.length() == start + 1) {
			 //System.out.println( "begore line.length() == 1: " + solution ) ;
			 //solution = solution + "1" + c ;
			 solution.append('1');
			 solution.append(c);
			 //System.out.println( "after line.length() == 1: " + solution ) ;
			 //return line;
		 }else {
			 // pas fin de ligne , boucle
			 int i = 1 ;
			 
			 while ( i <linelength  ){
				 if ( c == probleme.charAt(start + i ) )  {
					 // on continue
					 i ++ ;  
					 while ( ( i <linelength ) && (c == probleme.charAt(start + i ) )  ){
						 // System.out.println( "reste le char c ? " + c + " at " + i )  ;
						 i ++ ;
					 }
					 // System.out.println( " on finit par c dans la boucle .. il faut ajouter le nb char " +  i + " :" + c ) ;
					 // System.out.println( " on finit par c dans la boucle si fini seulement"  ) ;
					 if (linelength ==  i  ) {
						// System.out.println( "before : " + solution ) ;
						 //solution = solution + i + c ;
						 solution.append(i);
						 solution.append(c);
						//  System.out.println( "after  : " + solution ) ;
					 } else {
						 // System.out.println( "on finit par c dans la boucle rien : " + solution ) ;
						 	 
					 }
					 //System.out.println( "before : " + solution ) ;
					 
				 
				 } else {
					 if (linelength ==  i- 1 ) {
						 // fin de ligne
						 // System.out.println( " on finit par c .. il faut ajouter le nb char " +  i + " :" + c ) ;
						 //solution = solution + i + c ;
						 solution.append(i);
						 solution.append(c);
						 i ++ ;
						 // System.out.println( "Fin de ligne .. done " + solution ) ;
						 return ;
					 } else {
						 // ben c est pas fini
						 //System.out.println( "before pas fini : " + solution ) ;
						 //solution = solution + i + c ;
						 solution.append(i);
						 solution.append(c);
						 // System.out.println( "after  pas fini : " + solution ) ;
						 
						 
						 if (probleme.length() > start + i ){
							 //System.out.println( "reste a analyse line :" + ligne.substring(i, linelength) + ":" ) ;
							 analyse (start + i  ) ;
							 	 
						 }
						 else {
							 System.out.println( "reste a analyse line error  line     :" +  probleme.substring( start + i, linelength) );
							 System.out.println( "reste a analyse line error  i        :" + i  + ":" ) ;
						 }
						 //System.out.println( " this one return analyse solution = " + solution  ) ; 
						 return ;
					 }
				
				 }  // else de c == line.charAt(i))
				 // on finit par c ..
				 //System.out.println( " on finit par c .. il faut ajouter le nb char " +  i + " :" + c ) ;
				 //System.out.println( " return on finit par c = " + solution  ) ;
			 }   //  while ( i <linelength  
					 
		 } // end (line.length() == 1)
		} // end (line.length() == 0)
		 // System.out.println( " return analyse solution = " + solution  ) ;
		 System.out.println( " return analyse solution = " + solution.length()  ) ;
		 //System.out.println( " return analyse solution = " + solution  ) ;
		 return ;
	} // analyse
}
