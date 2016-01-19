package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import com.alleton.adventProject.model.Solver15ingredient;;


public class Solver15 {

	// Solver15ingredient
	Vector<Solver15ingredient> les_ingredients = new Vector<Solver15ingredient>();	
		
		Solver15(){
				
		}
		
	/**
	 * solver	
	 * @param sfname
	 * @return
	 */
	
	
	public String solver15 (String sfname){
		int maxpoints=0;
		
		try {
			les_ingredients =  parselines(sfname) ;
			// verif parse OK
			for ( int i = 0 ; i < les_ingredients.size() ; i++ ) {
				System.out.println (les_ingredients.elementAt(i).toString());
			}
			
			//try to solve
			maxpoints =  solve(100) ;
			System.out.println("maxi = " + maxpoints ) ;
			
			/*
			// part 2
			maxpoints = solve2(2503 ) ;
			System.out.println("maxpoints = " + maxpoints ) ;
				*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "solver15 " + maxpoints;
	} // end solver14 

	int solve(int total_ing) {
		int result = 0 ;
		
		
			// pour tous les melanges 1er ingredient
		//for ( int i = 0 ; i <= total_ing ; i ++ ) {
		for ( int i1 = 0 ; i1 <= total_ing ; i1 ++ ) {
			int reste1 = total_ing - i1 ;    // reste pour autre ingredient
			for ( int i2 = 0 ; i2 <= reste1 ; i2 ++ ) {
				int reste2 = reste1 - i2 ;
				for ( int i3 = 0 ; i3 <= reste2 ; i3 ++ ){
					int reste3 = reste2 - i3 ;
					
					int capa = 0 ;
					int dura = 0;
					int flavo = 0 ;
					int txtu = 0 ;
					int calo = 0;
					int inter = 0 ;
					// calcul capacity
					capa = capa + ( i1 * les_ingredients.elementAt(0).getCapacity() ) ;
					capa = capa + ( i2 * les_ingredients.elementAt(1).getCapacity() ) ;
					capa = capa + ( i3 * les_ingredients.elementAt(2).getCapacity() ) ;
					capa = capa + ( reste3 * les_ingredients.elementAt(3).getCapacity() ) ;
					if (capa < 0) capa = 0 ; // elimine les negas
					
					// calcul durability
					dura = dura + ( i1 * les_ingredients.elementAt(0).getDurability() ) ;
					dura = dura + ( i2 * les_ingredients.elementAt(1).getDurability() ) ;
					dura = dura + ( i3 * les_ingredients.elementAt(2).getDurability() ) ;
					dura = dura + ( reste3 * les_ingredients.elementAt(3).getDurability() ) ;
					if (dura < 0) dura = 0 ; // elimine les negas

					// flavor
					flavo = flavo + ( i1 * les_ingredients.elementAt(0).getFlavor() ) ;
					flavo = flavo + ( i2 * les_ingredients.elementAt(1).getFlavor() ) ;
					flavo = flavo + ( i3 * les_ingredients.elementAt(2).getFlavor() ) ;
					flavo = flavo + ( reste3 * les_ingredients.elementAt(3).getFlavor() ) ;
					if (flavo < 0) flavo = 0 ; // elimine les negas

					// texture
					txtu = txtu + ( i1 * les_ingredients.elementAt(0).getTexture()) ;
					txtu = txtu + ( i2 * les_ingredients.elementAt(1).getTexture()) ;
					txtu = txtu + ( i3 * les_ingredients.elementAt(2).getTexture()) ;
					txtu = txtu + ( reste3 * les_ingredients.elementAt(3).getTexture()) ;
					if (txtu < 0) txtu = 0 ; // elimine les negas

					// calories
					calo = calo + ( i1 * les_ingredients.elementAt(0).getCalories()) ;
					calo = calo + ( i2 * les_ingredients.elementAt(1).getCalories()) ;
					calo = calo + ( i3 * les_ingredients.elementAt(2).getCalories()) ;
					calo = calo + ( reste3 * les_ingredients.elementAt(3).getCalories()) ;
					
					// resultat intermediaire
					inter = capa * dura * flavo * txtu ;
					if ( ( calo == 500 ) &&  ( inter > result ) ){
						result = inter ;
						
						System.out.println("points  pour i = " + i1 + " i2 = " + i2  +
								" i3 = " + i3  + " reste3 = " + reste3  + " inter = " + inter ) ;
						
					}

					
				}	// for i3
			}	// for i2
			System.out.println("points  pour i = " + i1 + " reste = " + reste1 + " = " + result ) ;
		}      // for i1
		 
		
		
		return result ;
	}
	
	
	public Vector<Solver15ingredient>  parselines(String sfname) {
		String line = "";
		int nblines = 0 ;
		 //Vector<Solver14rennes> lire_rennes = new Vector<Solver14rennes>();
		Vector<Solver15ingredient> mes_ingr = new Vector<Solver15ingredient>() ;
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			while ((line = reader.readLine()) != null) { 
				line = line.trim() ;
				line = line.replace(",", ""); // remove all those ","
				// parseline
				System.out.println("parseline line  = " + line ) ;
				String[] parts =line.split(" ");
				Solver15ingredient ingredient = new Solver15ingredient();
				//les_ingredients
				
				ingredient.setIngredient(parts[0]);
				ingredient.setCapacity(Integer.parseInt(parts[2]));
				ingredient.setDurability(Integer.parseInt(parts[4]));
				ingredient.setFlavor(Integer.parseInt(parts[6]));
				ingredient.setTexture(Integer.parseInt(parts[8]));
				ingredient.setCalories(Integer.parseInt(parts[10]));
	
				
				mes_ingr.add(ingredient) ;
				
				nblines ++ ;
				
			} // end for
			reader.close();
			filereader.close();
			System.out.println("Solution parse Solver14 " );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mes_ingr ;
	} // end parseline	
	
}
