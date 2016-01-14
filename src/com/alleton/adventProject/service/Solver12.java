package com.alleton.adventProject.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver12 {

	String  maligne = new String("");
	int linel = 0;
	char thischar ;


	public int solver12 (String sfname){
		int resultat =0;
		String line ;

		try {
			FileReader filereader = new FileReader(sfname);

			BufferedReader reader = new BufferedReader(filereader);
			/* lecture ligne  */
			long tStart = System.nanoTime();


			while ((line = reader.readLine()) != null) {
				System.out.println(" line " + line );	 
			}

			long tEnd = System.nanoTime();
			double tDelta =  (double) (tEnd - tStart);
			System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );

			reader.close();
			filereader.close();

		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to load " + sfname, e);
			//e.printStackTrace();
		}


		return resultat ;
	} // end solver12
	
	private int parseline ( int start) {
		return 0 ;
	}
	
	
} // end class
