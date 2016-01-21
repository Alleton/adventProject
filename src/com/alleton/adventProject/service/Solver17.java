package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Vector;

import com.alleton.adventProject.model.Solver17solution;

public class Solver17 {

	Vector<Integer> les_recipients = new Vector<Integer>();
	// Solver17solution une_solution =  new Solver17solution();
	Vector<Solver17solution>  les_solution   = new Vector<Solver17solution> ();
	int nbsolutions  = 0;
	
	int total_containers;  // nombre total de container sera initialise a la fin de la lecture
	int maxi_reste = 0 ;   // a chaque solution sera teste avec le nb de container utilises
	int nb_de_maxi = 0 ;   // a chaque solution sera modifie en fonction de maxi_reste
			
	
	
	public int solver17 (String sfname){
		int day17_1 = 150;
		int resultat = 0 ;
		Solver17solution one_solution =  new Solver17solution();
		
		les_recipients = parselines (sfname) ;
		total_containers = les_recipients.size() ;
		System.out.println(" nb containers " + total_containers );
		resultat =  resultat + solve1( les_recipients  ,  one_solution , day17_1 ) ;
		System.out.println("maxi_reste " +  maxi_reste + " nb_de_maxi " + nb_de_maxi );
		
	    return resultat ;
	}
	
	/**
	 * 
	 * @param mes_recipients
	 * @param mes_solutions
	 * @param reste
	 * @return
	 */
	int solve1(Vector<Integer> mes_recipients  , Solver17solution une_solution , int reste) {
		//int nbsolutions  = 0;
		solve1_recursif( mes_recipients  ,  une_solution , reste) ;
		
		
		return nbsolutions  ;
	}
	
	
	
	/**
	 * Solve part1 recusif 
	 * @param mes_recipients
	 * @param mes_solutions
	 * @param reste
	 * @return
	 */
	
	void solve1_recursif(Vector<Integer> ces_recipients  , Solver17solution une_solution , int reste) {
		//int nbsolutions =0;
		//System.out.println("reste          "  + reste );
		//System.out.println("ces_recipients "  + ces_recipients );
		//System.out.println(" ------------------------------------ ");
		
		
		Vector<Integer> mes_recipients =  (Vector<Integer>) (ces_recipients.clone());
		Solver17solution la_solution  = new Solver17solution(une_solution.clone()) ; 
		
		if  ( mes_recipients.size() >0 ) {
		
		
		if (reste == somme (mes_recipients )) {
			//System.out.println(" +++++++++++++++++++++++++++ ");
			nbsolutions ++;
			System.out.println("la solution  " + nbsolutions  + " " +  la_solution.ToString() + " + " + mes_recipients );
			
			compare ( la_solution.size() + mes_recipients.size()  ) ;
			
			// pas la peine de detailler
			}
			// 
		if ( reste < somme (mes_recipients ) )  {
			// memorise capacite de premier
			int premier = mes_recipients.elementAt(0);
			// retire le premier de la liste
			mes_recipients.removeElementAt(0) ;
			// teste toutes les solutions ne commencant pas par le premier
				
				
			// suivant la comparaison du reste et du premier element 3 cas
			if ( reste > premier  ) {
				System.out.println("Solution ne  commencant pas par " + premier );
				solve1_recursif( mes_recipients  ,  une_solution , reste) ;

				//  teste toutes les solutions commencant par le premier 
				System.out.println("Solution  commencant par " + premier );
				la_solution.addunElement(premier);
			    // il faut continuer a tester avec ce debut de solution
			    // avec un reste a distribue diminue
				solve1_recursif( mes_recipients  ,  la_solution , reste - premier) ;	
			}
			if ( reste == premier  ) {
			    // c est une solution
			    //System.out.println(" +++++++++++++++++++++++++++ ");
				nbsolutions ++;
				System.out.println("la solution  " + nbsolutions  + " " + la_solution.ToString()  + " : " + premier );
				compare ( la_solution.size() + 1  ) ;
				
			    // il faut continuer sans cette solution
				// le reste est inchage
				solve1_recursif( mes_recipients  ,  une_solution , reste) ;
			}
			if ( reste < premier  ) {
			    solve1_recursif( mes_recipients  ,  une_solution , reste) ;
			}
			    

		}				//   reste < somme (mes_recipients )
		else {
			System.out.println("reste   trop       "  + reste );
		}
			
		
		}  // plus recipients ..
	return ;
	}

	
	  /** Renvoie la somme des éléments du Vector d'entiers spécifié.
	   *  @param v le Vector.
	   *  @return la somme.
	   */
	  public static int somme(Vector<Integer> v) {
	    int s=0;
	    for (int i=0; i<v.size();i++) s += ((Integer)v.elementAt(i)).intValue();
	    return s;
	    }
	
	
	  /**
	   * test maxi_reste et nb containers used
	   * 
	   * @return
	   */
	  
	  public void compare ( int used ) {
		  System.out.println("compare " + used );
		  if (  ( total_containers - used ) > maxi_reste ) {
			  maxi_reste = total_containers - used ;
			  nb_de_maxi = 1 ;
			  System.out.println("maxi_reste " +  maxi_reste + " nb_de_maxi " + nb_de_maxi );
			  
		  } else {
		  if (  ( total_containers - used ) ==  maxi_reste ) {
			  nb_de_maxi ++ ;
			  System.out.println("maxi_reste " +  maxi_reste + " nb_de_maxi " + nb_de_maxi );
		  }
		  }
	  }
	  
	  
	  
	/** readfile
	 * @param sfname
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
		Collections.sort(mes_recip ,Collections.reverseOrder());
		return mes_recip ;
	}
	
}
