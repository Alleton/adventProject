package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solver2 {
	
	String the_solver2 (String sfname) {
		/* solver 2 */
		// lecture ligne a decoder
		// read file line by line
		String line = null;
		Scanner scanner = null;
		String splitBy = "x";  
		int[] array = new int[3];
		int surfacetotale = 0 ;
		int ribbontotal   = 0 ;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(sfname));
			
			/* lecture lignes  */
			
			while ((line = reader.readLine()) != null) {
				scanner = new Scanner(line);
				scanner.useDelimiter(splitBy);
				array[0] = (Integer.parseInt(scanner.next()));
				array[1] = (Integer.parseInt(scanner.next()));
				array[2] = (Integer.parseInt(scanner.next()));
				scanner.close();
				
				Arrays.sort(array);
				
				System.out.println(" valuel " + array[0]  ) ;
				System.out.println(" valuew " + array[1]  ) ;
				System.out.println(" valueh " + array[2]  ) ;
				
				// 3 times the smallest side
				// 2 times each other
				
				int surface = ( 3 *   array[0] * array[1] )  +  
						      ( 2 *   array[0] * array[2] )  +
						      ( 2 *   array[1] * array[2] )  ;
				
				int ribbon =(2 * array[0] )+
					    	(2 * array[1] )+
					    	(array[0]  * array[1] * array[2] );
					    	
				System.out.println(" surface " + surface  ) ;
				surfacetotale = surfacetotale + surface ;
				ribbontotal   = ribbontotal + ribbon ;
				
				//part 2
				
				
			}
			
			System.out.println(" surfacetotale " + surfacetotale  ) ;
			System.out.println(" ribbontotal   " + ribbontotal  ) ;
			reader.close();
			return "Done Solver2"; 
		} catch (IOException e) {
			// 
			throw new IllegalArgumentException("Unable to load " + sfname, e);
			//e.printStackTrace();
		}
	}
}
