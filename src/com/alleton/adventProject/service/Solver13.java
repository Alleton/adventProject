package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import com.alleton.adventProject.model.Solver13convives;
import com.alleton.adventProject.model.Solver13table;
import com.alleton.adventProject.model.Solver9circuit;
import com.alleton.adventProject.model.Solver9route;

public class Solver13 {
	static Solver13table table ;

	private Solver13convives lesconvives ;
	
	
	public String solver13 (String sfname){
		int happiness = 0 ;
		
		try {
			//Solver7circuit 
			table =  parselines(sfname) ;
			//System.out.println ("solver13 lesconvives   \r\n " + lesconvives );
			// this should initialyse values ==> affichage console
			System.out.println ( "sfname = " + sfname ) ;
			System.out.println (table.convivesToString());
			
			// try to solve
			happiness = solve ( ) ;
			System.out.println ("solver13 done  " + happiness );
			
			System.out.println ("add_me" );
			table = add_me(table) ;
			System.out.println (table.convivesToString());
			happiness = solve ( ) ;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "solver13 " + happiness;

	} // end solver9 

	private int  solve () {
		//Solver9circuit circuit_out  ;
		
		int this_solv = 0 ;
		Vector<String> la_table = new Vector<String>();   // le resultat ..
		// sart  is always 00
		System.out.println ("et alors " );
		
		//all_towns = solver9circuit.v_towns ;                 // start avec l ordre des villes fournies ..
		la_table = table.v_personnes ;
		
		// do the permutations
		// initialize la longueuer du circuit
		 //solver9circuit.setlongueur(99999997);
		 //la_table.setMaxi(0);               // c est pas bien long ..
		table.setMaxi(0);
		 
		//permute (all_towns , 0  ) ;
		permute (la_table , 0) ;
		
		//System.out.println ("solution mini === " + solver9circuit.getlongueur());
		//System.out.println ("solution maxi === " + solver9circuit.getmaxi());
		this_solv = table.getMaxi();
		return this_solv;
	}
	
	/**
	 * 
	 * @param sfname
	 * @return
	 */
	 static void  permute( Vector<String> arr, int k ){
		 int solution =0;
		 int minimum  =  9999999 ;
		 
		 
	        for(int i = k; i < arr.size(); i++){
	            java.util.Collections.swap(arr, i, k);
	            permute(arr, k+1 );
	            java.util.Collections.swap(arr, k, i);
	        }
	        if (k == arr.size() -1){
	            
	        	//solution = longueur_trajet(arr);
	        	solution = happytable (arr) ; 
	        	// System.out.println( arr + " ==> " + solution ) ;
	        	 
	        	// memorise le resultat
	        	// if (  solution  < solver9circuit.getlongueur() ) {
	        	 if (  solution  >= table.getMaxi()) {
	        		 System.out.println( arr + " ==> " + solution ) ;
	        		 System.out.println( "  solution  " + solution ) ;
	        		 //solver9circuit.setlongueur(solution);
	        		 table.setMaxi(solution);
	        	 }
	        	 // pour la hapiness maxi aussi
	        	 if (  solution  < table.getMini()) {
	        		 System.out.println( arr + " ==> " + solution ) ;
	        		 System.out.println( "  solution  mini " + solution ) ;
	        		 //solver9circuit.setlongueur(solution);
	        		 table.setMini(solution);
	        	 }

	        
	        }
	        //System.out.println( " permute end solution = " + solution  ) ;  
	    }
	
	static int happytable(Vector<String> voisins) {
		int happys = 0;
		for ( int i = 0 ; i < voisins.size() -1 ; i ++ ) {
			happys = happys + happyvoisins ( voisins.get(i) , voisins.get(i+1)  ) ; // vers droite
			happys = happys + happyvoisins ( voisins.get(i+1) , voisins.get(i)  ) ; // vers gauche
		}
		// le premier touche le dernier
		happys = happys + happyvoisins ( voisins.get(0) , voisins.get(voisins.size()-1)  ) ; // vers droite
		happys = happys + happyvoisins ( voisins.get(voisins.size()-1) , voisins.get(0)  ) ; // vers droite
		
		return happys ;
	}
	 
	static int happyvoisins ( String gauche , String droite ) {
		int happy = 0 ;
		//System.out.println("happyvoisins  = " + gauche + " " + droite );
		for ( int i = 0 ; i < table.getNblignes() ; i++ ) {
			if ( gauche.equals(table.v_convives[i].getFirst()) && 
					droite.equals(table.v_convives[i].getSecond())	) {
				happy = table.v_convives[i].getHappy() ;
				break ;
			}
			
		}
		
		return happy ;
	}
	 
	 
	
	public static Solver13table parselines ( String sfname) {
		System.out.println("parselines filename = " + sfname );
		Solver13table convives = new Solver13table();
		
		String line = "";
		int nblines = 0 ;
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			while ((line = reader.readLine()) != null) { 
				line = line.trim() ;
				// parseline
				
				
				String[] parts =line.split(" ");
				Solver13convives route = new Solver13convives();
				//route.setTownfrom(parts[0]);
				//route.setTownTo(parts[2]);
				route.setFirst(parts[0]);
				route.setSecond(parts[10].substring(0, parts[10].length() -1 )); // supression . final
				if ( parts[2].equals("gain")) {
					route.setHappy(Integer.parseInt(parts[3]));
				} else {
					route.setHappy(Integer.parseInt(parts[3]) * -1 );
				}
				System.out.println("parseline line  = " + line ) ;
				System.out.println("parseline route = " + route.toString() ) ; 
				// affectation
				//table.getV_convives()[nblines] = route ;
				convives.getV_convives()[nblines] = route ;
				nblines ++ ;
				
				// creation des convives
				// affectation nom de ville
				//} // v_personnes 
				if ( ! convives.v_personnes.contains(parts[0])) {
					convives.v_personnes.addElement(parts[0]);
				}
			} // end for
			reader.close();
			filereader.close();
			System.out.println("Solution Solver13 " );
		} catch (Exception e) {
			e.printStackTrace();
		}
		convives.setNblignes(nblines);
		
		return convives ;
	} // end parse

	/**
	 * add_me add me to list of person 
	 * 	add me <person> ==> 0 et <person> me ==> 0 aux happyness
	 */
	Solver13table add_me(Solver13table table ) {
		// lesconvives.
		int nbvoisins = table.getNblignes() ;
		Solver13table newtable = new Solver13table();
		newtable = table;
		
		for ( int i = 0 ; i < newtable.v_personnes.size() ; i++) {
			Solver13convives route = new Solver13convives();
			//route.setFirst(parts[0]);
			route.setFirst(newtable.v_personnes.get(i));
			route.setSecond("Me");
			route.setHappy(0);
			// save it 
			//convives.getV_convives()[nblines] = route ;
			newtable.getV_convives()[nbvoisins] = route ;
			nbvoisins ++ ;
			// and the other way round
			Solver13convives route2 = new Solver13convives();
			route2.setFirst("Me");
			route2.setSecond(newtable.v_personnes.get(i));
			route2.setHappy(0);
			// save it 
			//convives.getV_convives()[nblines] = route2 ;
			newtable.getV_convives()[nbvoisins] = route2 ;
			nbvoisins ++ ;
			
		}
		// 
		newtable.setNblignes(nbvoisins);
		// ajout Me a la liste des personnes
		newtable.v_personnes.addElement("Me");
		
		
		return newtable ;
	} // end add_me
		
} // end class 
