package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver1 {
	String the_solver1 (String sfname) {
		/* solver 1 */
		// lecture ligne a decoder
		// read file line by line
		String line = null;
		int nb_ouvrante = 0 ;
		int nb_fermante = 0 ;
		System.out.println("filename = " + sfname );
		try {
			BufferedReader reader = new BufferedReader(new FileReader(sfname));
			/* lecture premiere ligne  */
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
						
		return " done " ;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("Unable to load " + sfname, e);
			//e.printStackTrace();
		}
	}

}
