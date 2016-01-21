package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

public class Solver19 {
	final int taille = 43 ;
	Vector<String> elements = new Vector<String>(); 
	Vector<String> listGenerate = new Vector<String>();
	
	Solver19 () {
		// constructeur
	}
	
	public String solver19 (String sfname){
		parselines(sfname);
		display_elements ();
		System.out.println("---------- gener ------------" )  ;
		display_generate ()  ;
		return " Solver 19 ";
	}
	
	
	public void display_generate () {
		for ( int i =0 ; i < listGenerate.size() ; i++) {
			System.out.println(listGenerate.elementAt(i));
		}
	}

	public void display_elements () {
		for ( int i =0 ; i < elements.size() ; i++) {
			System.out.println(elements.elementAt(i));
		}
	}

	
	
	public void parselines(String sfname) {
		String line = "";
		// lecture
		//int ligne = 0 ;
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			
				for ( int i = 0 ; i < taille ; i++ ) {
					line = reader.readLine();
					String[] parts =line.split(" ");
					// ajoute element si pas deja connu
					if ( ! elements.contains(parts[0]))	elements.add(parts[0]) ;
					
					//listGenerate
					listGenerate.addElement(parts[0] + ";" + parts[2]);
					
				}
				//ligne ++ ;
				
			reader.close();
			
			
			
			//ligne ++ ;
			
		reader.close();
			
			filereader.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return  ;
	}
	
}
