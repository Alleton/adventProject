package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Vector;

import com.alleton.adventProject.model.Solver16aunt;

public class Solver17 {

	public String solver17 (String sfname){
		int day17_1 = 150;
		
		Vector<Integer> les_recipients = new Vector<Integer>();
		les_recipients = parselines (sfname) ;
		System.out.println(les_recipients);
		// Collection.sort() sorts the collection in ascending order
	    Collections.sort(les_recipients ,Collections.reverseOrder());
	    System.out.println(les_recipients);
		// il faut commencer par le + grand 

	    return "";
	}
	
	/*
	 * Solve part1
	 */
	int solve1(Vector<Integer> mes_recipients) {
		
		return 0;
	}
	
	
	/*readfile
	 * 
	 */
	public Vector<Integer> parselines(String sfname) {
		Vector<Integer> mes_recip  = new Vector<Integer> ();
		String line = "";
		// lecture 
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			while ((line = reader.readLine()) != null) {
				String[] parts =line.split(" ");
				mes_recip.add(Integer.parseInt( parts[0])) ;
			}
			reader.close();
			filereader.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return mes_recip ;
	}
	
}
