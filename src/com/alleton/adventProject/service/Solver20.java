package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;

public class Solver20 {
	public static final int MAX_DELIV = 50;
	public long input = 0 ;
	public long input2 ;
	public long start = 104573 ;
	public String solver20 (String sfname){
		//String moleDepart ;
		System.out.println("---------- solver20 ------------" )  ;
		 parselines( sfname) ;
		 System.out.println(" solver20 file input / 10 = " + input  )  ;
		 input2 = (input / 11 ) * 10 ;
		 
		 
		 
		 System.out.println(" solver20 day 2 file input  = " + input2  )  ;
			long tStart = System.nanoTime();
			
			// input = 19344 ;
		   //test (646591) ;
			// testFact (5) ;
		   testPart2 (6465) ;
		   
			long tEnd = System.nanoTime();
			double tDelta =  (double) (tEnd - tStart);
			System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );
			
			
		return "Solver20 " ;
	} //  end solver20
	
	/*
	 * factorielle de 8 = 40320
 somme diviseurs de 8 = 104572
 factorielle de 9 = 362880
	 */
	
	public boolean test ( long start) {
		System.out.println("test global  " + start);
		boolean ok = false ;
		while ( ! ok ) {
			long totaldiv = 0  ; // elve number 1 gives 1 present anyway
			System.out.println("test " + start);
			for ( int i = 1 ; i<= Math.sqrt(start) ; i ++ ) {
				if ( ( start % i ) == 0 ) {
					// start est divisible par i
					//System.out.println(i  + " et " + ( start / i ));
					totaldiv = totaldiv + i ;
					if ( i != start / i ) { 
						totaldiv = totaldiv + start / i  ;
					}
					// System.out.println( " total div = " + totaldiv);
					
				}
			} // boucle sur diviseurs possibles
			System.out.println("test start = " + start + " total div = " + totaldiv);
			if ( totaldiv >= input) {
				System.out.println("done start = " + start + " total div = " + totaldiv);
				ok = true ;
				break;
			}
			// recommence avec le nb suivant
			start ++ ;
			
			if ( start >= 1362880 ) break ;
			//break ;
		}
		
		
		return ok ;
	} // test

	
	public boolean testPart2 ( int start) {
		System.out.println("test global Part2 " + start);
		// total des colis distribues a la house start 
		boolean ok = false ;
		long diviseur;
		while ( ! ok ) {
			long totaldistrib = 0  ; // elve number 1 gives 1 present anyway
			System.out.println("test " + start);
			for ( int i = 1 ; i<= Math.sqrt(start) ; i ++ ) {
				//elve number i
				if ( ( start % i ) == 0 ) {
					// start est divisible par i
					//System.out.println(i  + " et " + ( start / i ));
					diviseur = start / i; 
					if ( diviseur <= MAX_DELIV) {
						totaldistrib = totaldistrib +  i  ;	
					}
					
					if ( i != start / i && i <= MAX_DELIV ) { 
						totaldistrib = totaldistrib +  diviseur ;
					}
					// System.out.println( " total div = " + totaldiv);
					
				}
			} // boucle sur diviseurs possibles
			System.out.println("test start = " + start + " total div = " + totaldistrib);
			if ( totaldistrib >= input2) {
				System.out.println("done start = " + start + " total div = " + totaldistrib);
				ok = true ;
				break;
			}
			// recommence avec le nb suivant
			start ++ ;
			
			if ( start >= 1362880 ) break ;
			//break ;
		}
		
		
		return ok ;	} //testFact Part2
	
	public boolean testFact ( int start) {
		boolean ok = false ;
		long factorielle ;
		for ( long fac = start ; fac < 11 ; fac ++ ) {
			factorielle = factorielleRecursive (fac) ;
			
			long totaldiv = 0  ; // elve number 1 gives 1 present anyway
			System.out.println("test fact " + start);
			
			for ( int i = 1 ; i<= Math.sqrt(factorielle) ; i ++ ) {
				if ( ( factorielle % i ) == 0 ) {
					// start est divisible par i
					// System.out.println(i  + " et " + ( factorielle / i ));
				
					totaldiv = totaldiv + i ;
					if ( totaldiv != factorielle / i ){
						totaldiv = totaldiv + factorielle / i  ;	
					}
					
					// System.out.println( " total div = " + totaldiv);
					
				}
			} // boucle sur diviseurs possibles
			System.out.println("testFact  = " + fac + " factorielle " +  factorielle + " total div = " + totaldiv);

			if ( totaldiv >= input) {
				System.out.println("done start = " + factorielle + " total div = " + totaldiv);
				ok = true ;
				break;
			}
			// recommence avec le nb suivant
			start ++ ;
			
			if ( start > 1481041 ) break ;
			//break ;
		
			System.out.println(" factorielle de " + fac + " = " + factorielle ) ;
			System.out.println(" somme diviseurs de factorielle de " + fac + " = " + totaldiv ) ;
			if ( totaldiv > input ) {
				ok = true;
				System.out.println(" Done " );
				break ;
			}
		}
		
		return ok ;
	} //testFact
	
	public static long factorielleRecursive(long n) {
	    if (n>1)
	        return n*factorielleRecursive(n-1);
	    else
	        return 1;
	}
	
	public void parselines(String sfname) {
		String line = "";
		// lecture
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			line = reader.readLine();
			
			input = Integer.parseInt(line) / 10 ;
			reader.close();
			
		reader.close();
			
			filereader.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return  ;
	}
} // end class
