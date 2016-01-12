package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import com.alleton.adventProject.model.Solver9circuit;
import com.alleton.adventProject.model.Solver9route;

public class Solver9 {
	static Solver9circuit solver9circuit ;
	static int TheSolution ;
	
	public String solver9 (String sfname){
		int longueur = 0 ;
		
		try {
			//Solver7circuit 
			solver9circuit =  parselines(sfname) ;
			// this should initialyse values ==> affichage console
			System.out.println ( "sfname = " + sfname ) ;
			System.out.println (solver9circuit.toString());
			
			// try to solve
			longueur = solve ( ) ;
			System.out.println ("solver9circuitdone  " + longueur );
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "solver9 ";

	} // end solver9 
	
	private int  solve () {
		//Solver9circuit circuit_out  ;
		
		int this_solv = 0 ;
		Vector<String> all_towns = new Vector<String>();    // le resultat ..
		// sart  is always 00
		System.out.println ("et alors " );
		
		all_towns = solver9circuit.v_towns ;                 // start avec l ordre des villes fournies .. 
		
		// do the permutations
		// initialize la longueuer du circuit
		 solver9circuit.setlongueur(99999997);
		 solver9circuit.setmaxi(0);               // c est pas bien long ..
		 permute (all_towns , 0  ) ;
		
		System.out.println ("solution mini === " + solver9circuit.getlongueur());
		System.out.println ("solution maxi === " + solver9circuit.getmaxi());
		return this_solv;
	}


	 static void  permute( Vector<String> arr, int k ){
		 int solution ;
		 
	        for(int i = k; i < arr.size(); i++){
	            java.util.Collections.swap(arr, i, k);
	            permute(arr, k+1 );
	            java.util.Collections.swap(arr, k, i);
	        }
	        if (k == arr.size() -1){
	            
	        	solution = longueur_trajet(arr);
	        	// System.out.println( arr + " ==> " + solution ) ;
	        	 
	        	// memorise le resultat
	        	 if (  solution  < solver9circuit.getlongueur() ) {
	        		 System.out.println( arr + " ==> " + solution ) ;
	        		 System.out.println( "  solution  " + solution ) ;
	        		 solver9circuit.setlongueur(solution);
	        	 }
	        	 // pou rla longueur maxi aussi
	        	 if (  solution  > solver9circuit.getmaxi() ) {
	        		 System.out.println( arr + " ==> " + solution ) ;
	        		 System.out.println( "  solution  maxi " + solution ) ;
	        		 solver9circuit.setmaxi(solution);
	        	 }
	        }
	       
	    }
	
	
	static  int longueur_trajet (Vector<String> towns  ) {
		int longueur = 0 ;
		for ( int i = 0 ; i < towns.size() - 1 ; i++ ) {
			
			longueur = longueur +  distance_entre ( towns.get(i), towns.get(i+1)  ) ;
			
			
		}
		return longueur;
	}
	
	static int distance_entre ( String town_from , String town_to ) {
		int distance =0;
		// lookup town_from , town_to dans cet ordre
		for ( int i =0 ; i< solver9circuit.getRoutesNbr() ; i ++) {
			if ( ( solver9circuit.getSolverroute()[i].getTownfrom().equals(town_from) ) &&
					( solver9circuit.getSolverroute()[i].getTownto().equals(town_to) ) ) {
				distance = solver9circuit.getSolverroute()[i].getDistance() ;
				break ;
			}
			// les memes dans l autre sens
				if ( ( solver9circuit.getSolverroute()[i].getTownfrom().equals(town_to) ) &&
						( solver9circuit.getSolverroute()[i].getTownto().equals(town_from) ) ) {
					distance = solver9circuit.getSolverroute()[i].getDistance() ;
					break ;
				}
		}
		
		// System.out.println (" distance " +  town_from + " " + town_to + " = " + distance) ;
		return distance ;
	}
	
	
	private Solver9circuit  solve (Solver9circuit circuit_in, int start) {
		Solver9circuit circuit_out = circuit_in ;
		long lsolver9 = 99999999 ;
		long this_sol = 0 ;
		// sart  is always 00
		if (circuit_in.circuitToString().equals("")){
			System.out.println ("et alors " );
		}
		return circuit_out;
	}
	
	
	
	public static Solver9circuit parselines ( String sfname) {
		System.out.println("parselines filename = " + sfname );
		Solver9circuit solver9circuit = new Solver9circuit();
		
		String line = "";
		int nblines = 0 ;
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			while ((line = reader.readLine()) != null) { 
				line = line.trim() ;
				// parseline
				String[] parts =line.split(" ");
				Solver9route route = new Solver9route();
				route.setTownfrom(parts[0]);
				route.setTownTo(parts[2]);
				route.setDistance(Integer.parseInt(parts[4]));
				// affectation
				solver9circuit.getSolverroute()[nblines] =route ;
				nblines ++ ;
				
				// affectation nom de ville
				// la premiere ne suffit pas  :=)
				if ( ! solver9circuit.v_towns.contains(parts[0]) ) {
					// cette ville n'est pas encore dans notre vector
					solver9circuit.v_towns.add(parts[0]) ;
				} // 
				if ( ! solver9circuit.v_towns.contains(parts[2]) ) {
					// cette ville n'est pas encore dans notre vector
					solver9circuit.v_towns.add(parts[2]) ;
				} //
				
			} // end for
			solver9circuit.setRouteNbr(nblines);
			reader.close();
			filereader.close();
			System.out.println("Solution Solver9 " );
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return solver9circuit ;
		
	}
	
	
}
