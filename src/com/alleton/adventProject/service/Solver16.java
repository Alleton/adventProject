package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import com.alleton.adventProject.model.Solver15ingredient;
import com.alleton.adventProject.model.Solver16aunt;

public class Solver16 {
	// Solver14rennes
		Vector<Solver16aunt> les_aunts = new Vector<Solver16aunt>();
		int children    = 3;
		int cats        = 7;
		int samoyeds    = 2;
		int pomeranians = 3;
		int akitas      = 0;
		int vizslas     = 0;
		int goldfish    = 5;
		int trees       = 3;
		int cars        = 2;
		int perfumes    = 1	;
	
	public String solver16 (String sfname){
		int happiness = 0 ;
		
		try {
			//Solver7circuit 
			les_aunts =  parselines(sfname) ;
			//System.out.println ("solver13 lesconvives   \r\n " + lesconvives );
			// this should initialyse values ==> affichage console
			System.out.println ( "sfname = " + sfname ) ;
			//System.out.println (table.convivesToString());
			
			// try to solve
			//happiness = solve ( ) ;
			System.out.println ("solver16 done  " + happiness );
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "solver16" ;
	} //solver16

	
	void solve () {
		// for each aunt verify parameters
		
	}
	
	public Vector<Solver16aunt>  parselines(String sfname) {
		

		Vector<Solver16aunt> mes_tantes  = new Vector<Solver16aunt> ();
		String line = "";
		int nblines = 0 ;

		// lecture ticket
		try {
			String ticketfile ;
			//String linet ;
			
			ticketfile = sfname.replace(".", "_ticket.") ;
			
			FileReader filereader = new FileReader(ticketfile);
			BufferedReader reader = new BufferedReader(filereader);
			Solver16aunt tantet = new Solver16aunt();
			while ((line = reader.readLine()) != null) {
				line = line.replace(":", ""); // remove all those ":"
				String[] parts =line.split(" ");
				tantet =  memorise (  tantet ,parts[0]  ,Integer.parseInt( parts[1]) ) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			nblines = 0 ;
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			while ((line = reader.readLine()) != null) {
				
				nblines ++ ;
				line = line.trim() ;
				line = line.replace(",", ""); // remove all those ","
				line = line.replace(":", ""); // remove all those ":"
				// parseline
				System.out.println("parseline line  = " + line ) ;
				String[] parts =line.split(" ");
				Solver16aunt tante = new Solver16aunt();
				
				tante.setSue(Integer.parseInt(parts[1]));
				//tante.setSue(nblines);
				
				
				String field1 = parts[2];
				int fileld1value = Integer.parseInt(parts[3]);
				tante =  memorise (  tante ,field1  , fileld1value ) ;
				
				 field1 = parts[4];
				 fileld1value = Integer.parseInt(parts[5]);
				 tante =  memorise (  tante ,field1  , fileld1value ) ;
				
				 field1 = parts[6];
				 fileld1value = Integer.parseInt(parts[7]);
				 tante =  memorise (  tante ,field1  , fileld1value ) ;
				
				// memorise
				mes_tantes.add(tante);
			}    // line
			reader.close();
			filereader.close();
			System.out.println("Solution parse Solver14 " );
			
			for ( int i =0 ; i < mes_tantes.size() ; i ++ ) {
				System.out.println(" tante " + i + " " + mes_tantes.get(i).auntToString() ) ; 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mes_tantes;
	}
	
	private Solver16aunt memorise ( Solver16aunt tante ,String cle , int valeur ) {
		Solver16aunt matante = tante;
		switch (cle) {
		case "cats": {
			matante.setCats(valeur);
			break ;
		}
		case "samoyeds": {
			matante.setSamoyeds(valeur);
			break ;
		}
		case "pomeranians": {
			matante.setPomeranians(valeur);
			break ;
		}
		case "akitas": {
			matante.setAkitas(valeur);
			break ;
		}
		case "vizslas": {
			matante.setVizslas(valeur);
			break ;
		}
		case "goldfish": {
			matante.setGoldfish(valeur);
			break ;
		}
		case "trees": {
			matante.setTrees(valeur);
			break ;
		}
		case "cars": {
			matante.setCars(valeur);
			break ;
		}
		case "perfumes": {
			matante.setPerfumes(valeur);
			break ;
		}
		case "children": {
			matante.setChildren(valeur);
			break ;
		}
		
		
	} // switch (field1) 

		
		return matante ;
	}
	
}
