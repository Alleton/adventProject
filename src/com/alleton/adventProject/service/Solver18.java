package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Solver18 {
	int taille = 100 ;
	int steps = 100 ;
	int tableau_ini[] []  = new int [taille][taille] ;
	int tableau_fin[] []  = new int [taille][taille] ;
	
	final int ON  = 1 ;
	final int OFF = 0 ;
	
	Solver18 () {
		// constructeur
	}
	
	public String solver18 (String sfname){
		 parselines( sfname) ;
		 
		 for ( int step = 0 ;  step < steps ; step ++ ){
			 part2 () ;
			 //display_ini() ;
			 move( step );
			//copy values
			 deepCopy () ;
		 }
		 
		 part2 () ;
		 int resultat = compte() ;
		 display_ini() ;
		 return "solver 18 " +  resultat ;
	}
	
	void part2 (){
		// four lights, one in each corner, are stuck on and can't be turned off. 
		tableau_ini[0] [0]  = ON ;
		tableau_ini[0] [taille-1]  = ON ;
		tableau_ini[taille-1] [0]  = ON ;
		tableau_ini[taille-1] [taille-1]  = ON ;
		
	}
	
	int compte () {
		int res = 0 ;
		for ( int col = 0 ; col < taille ; col ++) {
			for ( int row = 0 ; row < taille ; row ++ ) {
				res = res + tableau_ini[col] [row] ;
			}
		}
		
		return res ;
	}
	
	
	void move (int step ) {
		System.out.println("move = " + step ) ;
		int voisins = 0 ;
		for ( int col = 0 ; col < taille ; col ++) {
			for ( int row = 0 ; row < taille ; row ++) {
				//System.out.println(  tableau_ini[col][row]);
				//tableau_fin[col][row] = voisins_on(col,row);
			voisins =  voisins_on(col,row);
			tableau_fin[col][row] = teste_voisins (tableau_ini[col] [row] , voisins ) ;
			}
		}
		//display();
	}
	
	int teste_voisins ( int old , int voisins ) {
		int res = 0 ;
		if ( old == ON ) {
			// tableau_ini[ligne][i] = ( line.charAt(i) == '.' ? OFF :ON )  ;
			res = ( (voisins ==2) || (voisins == 3) ? ON : OFF ) ;
		} else {
			if ( old == OFF) {
				res = (  (voisins == 3) ? ON : OFF ) ;
			} else {
				System.out.println(" grosse erreur " + old );
			}
		}
		
		return res ;
	}
	
	int voisins_on ( int i , int j ) {
		int v_on = 0 ;
		// teste les 8 voisins
		v_on = v_on + teste ( i-1 ,j-1 ) ;
		v_on = v_on + teste ( i-1 ,j ) ;
		v_on = v_on + teste ( i-1 ,j+1 ) ;
		v_on = v_on + teste ( i ,j-1 ) ;
		v_on = v_on + teste ( i ,j+1 ) ;
		v_on = v_on + teste ( i+1 ,j -1) ;
		v_on = v_on + teste ( i+1 ,j ) ;
		v_on = v_on + teste ( i+1 ,j +1) ;
		return v_on ;
	}
	
	
	int teste ( int i , int j ) {
		int res = 0 ;
		if ((i>=0 && i< taille && j>=0 && j< taille)) {
			res =  tableau_ini[i][j] ;
		}
		
		return  res; 
	}
	
	public void display () {
		System.out.println(" --------------- ");
		for ( int i = 0  ; i < taille ; i++ ) {
			String ligne = "" ;
			for ( int j = 0  ; j < taille ; j++ ) {
				ligne = ligne + " " + tableau_fin[i][j] ; 
			}
			System.out.println(ligne);
		}
		System.out.println(" --------------- ");
		System.out.println("");
	}
	

	public void display_ini () {
		System.out.println(" --------------- ");
		for ( int i = 0  ; i < taille ; i++ ) {
			String ligne = "" ;
			for ( int j = 0  ; j < taille ; j++ ) {
				ligne = ligne + " " + tableau_ini[i][j] ; 
			}
			System.out.println(ligne);
		}
		System.out.println(" --------------- ");
		System.out.println("");
	}

	public void deepCopy () {
		for ( int i = 0 ; i < taille ; i ++) {
			tableau_ini[i] = Arrays.copyOf(tableau_fin[i], taille) ;
		}
	}
	
	
	public void parselines(String sfname) {
		String line = "";
		// lecture
		int ligne = 0 ;
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			while ((line = reader.readLine()) != null) {
				for ( int i = 0 ; i < taille ; i++ ) {
					tableau_ini[ligne][i] = ( line.charAt(i) == '.' ? OFF :ON )  ;
				}
				ligne ++ ;
			}
			reader.close();
			filereader.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return  ;
	}
}
