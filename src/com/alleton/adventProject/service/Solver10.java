package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver10 {
	String solution = "";
	
	public String solver10 (String sfname){
		//String res = "";
		String line ;
		// int iteration ;
		
		 try {
			 FileReader filereader = new FileReader(sfname);
		 
			 BufferedReader reader = new BufferedReader(filereader);
			 /* lecture ligne  */
			 
		 
			 while ((line = reader.readLine()) != null) {
				 System.out.println(" line " + line );	 
				 analyse (  line );
		
		 		 for ( int  iteration = 1 ; iteration < 40; iteration ++) {
		
		 			line = solution ;
					 solution = "";
					 System.out.println(" iteration " + ( iteration ) + " ligne = " + line + "  sol = " +   solution );	 
					 analyse (  line );
					 // System.out.println(" line " + line );	 
				 }
				 
				 System.out.println(" solution " + solution );	 
				 
			 }
	
			 reader.close();
			 filereader.close();
		 } catch (IOException e) {
			 throw new IllegalArgumentException("Unable to load " + sfname, e);
		//e.printStackTrace();
	}
		
		return solution ;
	} // 
	
	private void  analyse ( String line ) {
		char c ;
		//int nbchar = 1 ; // we got 1 char c
		//String resultat = "";
		//String reste = "";
		int linelength = line.length() ;
		
		//System.out.println( "analyse line :" + line + ":" ) ;
		
		// ligne vide ??
		if (line.length() == 0 ) {
			 //return line;
		} else {
		 c= line.charAt(0);	
		 // serai-ce le dernier character ??
		 if (line.length() == 1) {
			 //System.out.println( "begore line.length() == 1: " + solution ) ;
			 solution = solution + "1" + c ;
			 //System.out.println( "after line.length() == 1: " + solution ) ;
			 //return line;
		 }else {
			 // pas fin de ligne , boucle
			 int i = 1 ;
			 
			 while ( i <linelength  ){
				 if ( c == line.charAt(i)){
					 // on continue
					 i ++ ;  
					 while ( ( i <linelength ) && (c == line.charAt(i))  ){
						 // System.out.println( "reste le char c ? " + c + " at " + i )  ;
						 i ++ ;
					 }
					 // System.out.println( " on finit par c dans la boucle .. il faut ajouter le nb char " +  i + " :" + c ) ;
					 // System.out.println( " on finit par c dans la boucle si fini seulement"  ) ;
					 if (line.length() ==  i  ) {
						// System.out.println( "before : " + solution ) ;
						 solution = solution + i + c ;
						//  System.out.println( "after  : " + solution ) ;
					 } else {
						 // System.out.println( "on finit par c dans la boucle rien : " + solution ) ;
						 	 
					 }
					 //System.out.println( "before : " + solution ) ;
					 
				 
				 } else {
					 if (line.length() ==  i- 1 ) {
						 // fin de ligne
						 // System.out.println( " on finit par c .. il faut ajouter le nb char " +  i + " :" + c ) ;
						 solution = solution + i + c ;
						 i ++ ;
						 // System.out.println( "Fin de ligne .. done " + solution ) ;
						 return ;
					 } else {
						 // ben c est pas fini
						 // System.out.println( "before pas fini : " + solution ) ;
						 solution = solution + i + c ;
						 //System.out.println( "after  pas fini : " + solution ) ;
						 //i ++ ;
						 if  ( !line.substring(i, linelength).equals("") )  {
							 // System.out.println( "reste a analyse line :" + line.substring(i, linelength) + ":" ) ;
							 analyse (line.substring(i, linelength)) ;
							 	 
						 }
						 else {
							 System.out.println( "reste a analyse line error  line     :" + line + ":" ) ;
							 //System.out.println( "reste a analyse line error iteration :" + this.i + ":" ) ;
							 System.out.println( "reste a analyse line error  i        :" + i  + ":" ) ;
							 System.out.println( "reste a analyse line error :" + line.substring(i, linelength) + ":" ) ;
						 }
							 
						 return ;
					 }
					        
				 
				
				 }  // else de c == line.charAt(i))
				 // on finit par c ..
				 //System.out.println( " on finit par c .. il faut ajouter le nb char " +  i + " :" + c ) ;
				  
				 //solution = solution + i + c ;
				 //System.out.println( " return on finit par c = " + solution  ) ;
			 }   //  while ( i <linelength  
					 
		 } // end (line.length() == 1)
		} // end (line.length() == 0)
		 System.out.println( " return analyse solution = " + solution  ) ; 
		 return ;
	} // analyse

}
