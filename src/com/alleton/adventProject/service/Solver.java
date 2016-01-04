package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Solver {

	
	public Solver (  String sfname) {
	/* **/
		
		//Solver3 Solver3 ;
		
		// read file line by line
		String line = null;
		String splitBy = "#";  
			
		Scanner scanner = null;
				
		try {
		BufferedReader reader = new BufferedReader(new FileReader(sfname));
		/** Lecture premiere ligne pour choix code */
		line = reader.readLine();
		scanner = new Scanner(line);
		scanner.useDelimiter(splitBy);
		int value = (Integer.parseInt(scanner.next()));
		scanner.close();
		
		System.out.println("Tentative de resolution du projet : " + value ) ;
		
		switch (value)
		{
		case 1: {
			System.out.println("Chargement pb " + value ) ; 
			solver1 (sfname);
			break;		
			}
		case 2: {
			System.out.println("Chargement pb " + value ) ; 
			solver2 (sfname);
			break;		
			}
		case 3: {
			System.out.println("Chargement pb " + value ) ; 
			
			Solver3 Solver3 = new Solver3();
			System.out.println("Solution Solver3 " + Solver3.solver3 (sfname));
			
			break;		
			}
		case 4: {
			System.out.println("Chargement pb " + value ) ; 
			Solver4 Solver4 = new Solver4();
			//Solver4 = new solver4();
			System.out.println("Solution Solver4 " + Solver4.solver4(sfname));
			
			break;		
			}

		case 5: {
			System.out.println("Chargement pb " + value ) ; 
			Solver5 Solver5 = new Solver5();
			//
			System.out.println("Solution Solver5 " + Solver5.solver5(sfname));
			
			break;		
			}
		case 6: {
			System.out.println("Chargement pb " + value ) ; 
			Solver6 Solver6 = new Solver6();
			//
			System.out.println("Solution Solver6 " + Solver6.solver6(sfname));
			
			break;		
			}
		case 7: {
			System.out.println("Chargement pb " + value ) ; 
			Solver7 Solver7 = new Solver7();
			//
			System.out.println("Solution Solver7 " + Solver7.solver7(sfname));
			
			break;		
			}

		//case 12: <action12>; break;
		default:
			System.out.println("Pas de tentative de resolution du projet : " + value ) ;
		}
			//close reader
	       
		reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("Unable to load " + sfname, e);
			//e.printStackTrace();
		}

	}
	
	void solver1 (String sfname) {
		/* solver 1 */
		// lecture ligne a decoder
		// read file line by line
		String line = null;
		int nb_ouvrante = 0 ;
		int nb_fermante = 0 ;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(sfname));
			/* relecture premiere ligne  */
			line = reader.readLine();
			/* lecture deuxieme ligne  */
			line = reader.readLine();
			
			// fermeture 
			reader.close();
			
			// Analyse ligne
			for (int i = 0 ; i < line.length() ; i++ ) {
				//
				if ( line.charAt(i) == '(' ) nb_ouvrante ++ ;
				if ( line.charAt(i) == ')' ) nb_fermante ++ ;
				//System.out.println("etage " +  ( nb_ouvrante - nb_fermante ) ) ;
				
			}
			
			System.out.println("nb_ouvrante " + nb_ouvrante ) ;
			System.out.println("nb_fermante " + nb_fermante ) ;
			
			System.out.println("etage " +  ( nb_ouvrante - nb_fermante ) ) ;
			
			// deuxieme partie
			// enter basement
			// Analyse ligne
			nb_ouvrante = 0 ;
			nb_fermante = 0 ;
			for (int i = 0 ; i < line.length() ; i++ ) {
				//
				if ( line.charAt(i) == '(' ) nb_ouvrante ++ ;
				if ( line.charAt(i) == ')' ) nb_fermante ++ ;
							
				if (  ( nb_ouvrante - nb_fermante )  < 0  ) {
					// enter basement
					System.out.println("etage basement  " + (  i + 1 ) ) ;
					break ;
				}
			}
						
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("Unable to load " + sfname, e);
			//e.printStackTrace();
		}
	}
	
	void solver2 (String sfname) {
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
			/* relecture premiere ligne  */
			line = reader.readLine();
			/* lecture deuxieme ligne  */
			//line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				scanner = new Scanner(line);
				scanner.useDelimiter(splitBy);
				array[0] = (Integer.parseInt(scanner.next()));
				array[1] = (Integer.parseInt(scanner.next()));
				array[2] = (Integer.parseInt(scanner.next()));
				
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("Unable to load " + sfname, e);
			//e.printStackTrace();
		}
	
	}	
	
}

