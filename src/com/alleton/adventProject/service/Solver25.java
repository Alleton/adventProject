package com.alleton.adventProject.service;

import java.math.BigInteger;

public class Solver25 {
	
//	final int finalRow = 2947;
//	final int finalCol = 3029;
	
	final int finalRow = 3030 + 2947;
	
	final BigInteger start =  BigInteger.valueOf(20151125) ;
	final BigInteger MULTIPLY =  BigInteger.valueOf(252533) ;
	final BigInteger DIVIDER =  BigInteger.valueOf(33554393) ;
	
	//BigInteger matrice[][] = new  BigInteger [finalRow][finalRow];
	// matrice row , col
	
	
	public String solver25 (String sfname) {
		long tStart = System.nanoTime();
		
		
		//matrice[0][0] =  start;
		int row = 2 ;
		
		//row = 1 ;
		BigInteger x = start  ;
		
		while (  row < finalRow -1   ) {
			x = calculate (x);
			// matrice[row] [0] = x;
			System.out.println("row = " + (row  )  + " x = "  + x );
			//int col =0 ;
			//matrice[row + 1 ][0] = calculate (matrice[row ][0]);
			//System.out.println(matriceToString());
			int col = 1   ;
				for ( int irow = row  -1   ; irow > 0 ; irow -- ) {
						x = calculate (x);
						//matrice[irow] [col  ] = x;
						//System.out.println("irow "  + irow + " col = " + col );
						//System.out.println(matriceToString());
						col ++ ;
						if ( col == 3029) {
							System.out.println("irow = " + irow  + "col == 3029  x = " + x);
						}
					
				}
				
			row ++ ;
			
		}
		
		long tEnd = System.nanoTime();
		double tDelta =  (double) (tEnd - tStart);
		System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );

		
		return ("Solver25") ;
	}
	

	
	public BigInteger calculate ( BigInteger source) {
		BigInteger but = source.multiply(MULTIPLY).mod(DIVIDER) ;
		
		//but = mod ( (source * MULTIPLY) ,DIVIDER) ; 
		return but;
				
	}
	
//	private String  matriceToString () {
//		StringBuilder builder = new StringBuilder();
//		builder.append( " matrice \n"  ) ;
//		for ( int row=0 ; row < finalRow ; row ++) {
//			for ( int col=0 ; col < finalRow ; col ++) {
//				//builder.append( matrice[row][col] + "\t") ;
//			}
//			builder.append("\n");
//		}
//		return builder.toString();
//	}
	
}
