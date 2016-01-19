package com.alleton.adventProject.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import com.alleton.adventProject.model.Solver14rennes ;

public class Solver14 {

	// Solver14rennes
	Vector<Solver14rennes> les_rennes = new Vector<Solver14rennes>();
	
	
	
	
	public String solver14 (String sfname){
		int happiness = 0 ;
		int maxpoints=0;
		
		try {
			les_rennes = parselines(sfname) ;
			System.out.println(" les rennes size " + les_rennes.size() ) ;
			for ( int i = 0 ; i < les_rennes.size() ; i ++ ) {
				System.out.println (les_rennes.elementAt(i).toString());
			}
			// try to solve
			System.out.println("Gagnant = " + solve(2503) ) ;
			
			
			// part 2
			maxpoints = solve2(2503 ) ;
			System.out.println("maxpoints = " + maxpoints ) ;
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "solver14 " + happiness;

	} // end solver14 

	public int solve2(int duree ) {
		int maxpoints = 0 ;
		
		
		for (int sec = 0; sec <= duree ; sec++ ){
			int maxparcouru =0 ;                   // distance max this sec
			
			System.out.println("seconde " +  sec ) ;
			
			// a chaque seconde on calcul la distance parcourue par chaque renne
			for ( int i = 0 ; i < les_rennes.size() ; i ++ ) {
				Solver14rennes ce_renne =  les_rennes.elementAt(i) ;
				System.out.println (ce_renne.toString());
				if ( ce_renne.getTemps_course() < ce_renne.getEndurance()) {
					// il peut encore courrir
					ce_renne.setTemps_course( ce_renne.getTemps_course() + 1 ) ;
					ce_renne.setParcouru(ce_renne.getParcouru() + ce_renne.getVitesse());
					
					
				} else {
					// ce renne est au repos
					// si le repos  est pas fini
					if (  ce_renne.getTemps_repos() < ce_renne.getRespos() ){
						ce_renne.setTemps_repos(ce_renne.getTemps_repos() + 1 );
						
						
					}else {
						ce_renne.setTemps_repos(0)  ; // plus repose
						// il court de nouveau
						ce_renne.setParcouru(ce_renne.getParcouru() + ce_renne.getVitesse());
						ce_renne.setTemps_course(1) ; // pas encore fatigue
					}  // repos pas fini
					
					
				} // renne au repos
				
				// memorise max parcouru ( eveite une autre loop )
				if ( maxparcouru < ce_renne.getParcouru()) {
					maxparcouru =  ce_renne.getParcouru();
				}
				//les_rennes.setElementAt(ce_renne, i);
				
				
				
			} // boucle sur les rennes
			
			// trouver le(s) renne(s) en tete et donner 1 point
			for ( int i = 0 ; i < les_rennes.size() ; i ++ ) {
				Solver14rennes ce_renne =  les_rennes.elementAt(i) ;
				
				if ( ce_renne.getParcouru() == maxparcouru) {
					ce_renne.setPoints(ce_renne.getPoints()+1);
					//les_rennes.setElementAt(ce_renne, i);
				}
			}
			
			
		}     // boucle dureee
		
		// now find the winner and it's points
		
		for ( int i = 0 ; i < les_rennes.size() ; i ++ ) {
			Solver14rennes ce_renne =  les_rennes.elementAt(i) ;
			if ( maxpoints <= ce_renne.getPoints() ) {
				System.out.println (ce_renne.getRenne() + " : " +  ce_renne.getPoints() );
				maxpoints = ce_renne.getPoints() ;
				//les_rennes.setElementAt(ce_renne, i);
			}
		}
		
		
		return maxpoints;
	}
	
	
	public String solve (int duree) {
		/* 
		 * duree = duree de la course
		 */
		String gagnant = "";
		int meilleure_distance =0;
		
		for ( int i = 0 ; i < les_rennes.size() ; i ++ ) {
			System.out.println (les_rennes.elementAt(i).toString());
			Solver14rennes monrenne = les_rennes.elementAt(i);
			int temps_ecoule = 0 ;		//
			int distance = 0 ;			// distance parcourue
			int step = 0 ;				// nombre de periode de course
			while ( temps_ecoule <= ( duree -  monrenne.getEndurance()) ) {
				temps_ecoule = temps_ecoule + monrenne.getEndurance() + monrenne.getRespos();
				distance = distance + monrenne.getVitesse() *  monrenne.getEndurance();
				
			}
			// ce renne  peut encore courrir
			if (temps_ecoule <  duree ) {
				distance = distance + monrenne.getVitesse() * (duree - temps_ecoule) ;
			}
			System.out.println("Renne = " + monrenne.getRenne()  + "  court "+ distance ) ;
			
			if (  meilleure_distance < distance ) {
				meilleure_distance = distance  ;
				gagnant = monrenne.getRenne() ;
				
				
			}
			
		}
		
		
		return gagnant ;
	}
	
	
	public Vector<Solver14rennes>  parselines(String sfname) {
		String line = "";
		int nblines = 0 ;
		 Vector<Solver14rennes> lire_rennes = new Vector<Solver14rennes>();
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			while ((line = reader.readLine()) != null) { 
				line = line.trim() ;
				// parseline
				System.out.println("parseline line  = " + line ) ;
				
				
				String[] parts =line.split(" ");
				Solver14rennes   renne = new Solver14rennes() ;
				renne.setRenne(parts[0]);
				renne.setVitesse(Integer.parseInt(parts[3]));
				renne.setEndurance(Integer.parseInt(parts[6]));
				renne.setRespos(Integer.parseInt(parts[13]));
				
				lire_rennes.add(renne);
				nblines ++ ;
				
			} // end for
			reader.close();
			filereader.close();
			System.out.println("Solution parse Solver14 " );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lire_rennes;
	
		
	}
	
}
