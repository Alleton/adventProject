package com.alleton.adventProject.service;
//import com.alleton.adventProject.model.AdventModel;

public class Solver {

	
	public Solver ( int problem , String sfname) {
		//AdventModel adventmodel = new AdventModel ();
		
		try {
			System.out.println("");
		System.out.println("Tentative de resolution du projet : " + problem ) ;
		
		switch (problem)
		{
		case 1: {
			System.out.println("Chargement pb " + problem ) ; 
			// solver1 (sfname);
			Solver1 solver1 = new Solver1 ();
			System.out.println("Solution Solver1 " + solver1.the_solver1(sfname));		
			break;		
			}
		case 2: {
			System.out.println("Chargement pb " + problem ) ; 
			Solver2 solver2 = new Solver2 ();
			System.out.println("Solution Solver2 " + solver2.the_solver2(sfname));		
			
			break;		
			}
		case 3: {
			System.out.println("Chargement pb " + problem ) ; 
			
			Solver3 Solver3 = new Solver3();
			System.out.println("Solution Solver3 " + Solver3.solver3 (sfname));
			
			break;		
			}
		case 4: {
			System.out.println("Chargement pb " + problem ) ; 
			Solver4 Solver4 = new Solver4();
			//Solver4 = new solver4();
			System.out.println("Solution Solver4 " + Solver4.solver4(sfname));
			
			break;		
			}

		case 5: {
			System.out.println("Chargement pb " + problem ) ; 
			Solver5 Solver5 = new Solver5();
			//
			System.out.println("Solution Solver5 " + Solver5.solver5(sfname));
			
			break;		
			}
		case 6: {
			System.out.println("Chargement pb " + problem ) ; 
			Solver6 Solver6 = new Solver6();
			//
			System.out.println("Solution Solver6 " + Solver6.solver6(sfname));
			
			break;		
			}
		case 7: {
			System.out.println("Chargement pb " + problem ) ; 
			Solver7 Solver7 = new Solver7();
			//
			System.out.println("Solution Solver7 " + Solver7.solver7(sfname));
			
			break;		
			}
		case 8: {
			System.out.println("Chargement pb " + problem ) ; 
			Solver8 Solver8 = new Solver8();
			//
			System.out.println("Solution Solver8 " + Solver8.solver8(sfname));
			
			break;		
			}
		case 9: {
			System.out.println("Chargement pb " + problem ) ; 
			Solver9 Solver9 = new Solver9();
			//
			System.out.println("Solution Solver9 " + Solver9.solver9(sfname));
			
			break;		
			}

		case 10: {
			System.out.println("Chargement pb " + problem ) ; 
			Solver10 Solver10 = new Solver10();
			//
			System.out.println("Solution Solver10 " + Solver10.solver10(sfname));
			
			break;		
			}
		case 11: {
			System.out.println("Chargement pb " + problem ) ; 
			// Solver8 Solver8 = new Solver8();
			//
			//System.out.println("Solution Solver8 " + Solver8.solver8(sfname));
			
			break;		
			}

		default:
			System.out.println("Pas de tentative de resolution du projet : " + problem ) ;
		}
			//close reader
	       
		} catch (Exception e) {
			//throw new IllegalArgumentException("Unable to load " + sfname, e);
			e.printStackTrace();
		}

	}
	
	
		
	
}

