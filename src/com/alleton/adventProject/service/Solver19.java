package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;

public class Solver19 {
	final int taille = 5 ;
	
	//final String electron = "e" ;
	final String  electron  = "CRnCaSiRnBSiRnFArTiBPTiTiBFArPBCaSiThSiRnTiBPBPMgArCaSiRnTiMgArCaSiThCaSiRnFArRnSiRnFArTiTiBFArCaCaSiRnSiThCaCaSiRnMgArFYSiRnFYCaFArSiThCaSiThPBPTiMgArCaPRnSiAlArPBCaCaSiRnFYSiThCaRnFArArCaCaSiRnPBSiRnFArMgYCaCaCaCaSiThCaCaSiAlArCaCaSiRnPBSiAlArBCaCaCaCaSiThCaPBSiThPBPBCaSiRnFYFArSiThCaSiRnFArBCaCaSiRnFYFArSiThCaPBSiThCaSiRnPMgArRnFArPTiBCaPRnFArCaCaCaCaSiRnCaCaSiRnFYFArFArBCaSiThFArThSiThSiRnTiRnPMgArFArCaSiThCaPBCaSiRnBFArCaCaPRnCaCaPMgArSiRnFYFArCaSiThRnPBPMgAr" ;
	String maMoleculeFinale ;
	
	
	Vector<String> elements     = new Vector<String>(); 	// la liste des elements se transformant
	Vector<String> listGenerate = new Vector<String>(); 	// la lecture
	Vector<String> listAnalyse  = new Vector<String>(); 	// la liste analysee
	Vector<String> listMoles    = new Vector<String>(); 	// les molecules crees
	
	Vector<String> listDepart = new Vector<String>(); 	// les molecules de depart
	
	Vector<String> restictMolecule = new Vector<String>();	// les molecules crees pas en double
	final String  MOLECULE  = "CRnCaSiRnBSiRnFArTiBPTiTiBFArPBCaSiThSiRnTiBPBPMgArCaSiRnTiMgArCaSiThCaSiRnFArRnSiRnFArTiTiBFArCaCaSiRnSiThCaCaSiRnMgArFYSiRnFYCaFArSiThCaSiThPBPTiMgArCaPRnSiAlArPBCaCaSiRnFYSiThCaRnFArArCaCaSiRnPBSiRnFArMgYCaCaCaCaSiThCaCaSiAlArCaCaSiRnPBSiAlArBCaCaCaCaSiThCaPBSiThPBPBCaSiRnFYFArSiThCaSiRnFArBCaCaSiRnFYFArSiThCaPBSiThCaSiRnPMgArRnFArPTiBCaPRnFArCaCaCaCaSiRnCaCaSiRnFYFArFArBCaSiThFArThSiThSiRnTiRnPMgArFArCaSiThCaPBCaSiRnBFArCaCaPRnCaCaPMgArSiRnFYFArCaSiThRnPBPMgAr" ;
	
	//final String  MOLECULE  = "HOHOHO" ;
	int nbMoles = 0 ;
	int nbMolesRestrict = 0 ;  // nb moles sans doublon
	
	
	Solver19 () {
		// constructeur
	}
	
	public String solver19 (String sfname){
		//String moleDepart ;
		
		parselines(sfname);
		display_elements ();
		System.out.println("---------- gener ------------" )  ;
		display_generate ()  ;
		analyse() ;
		System.out.println("---------- analyse ------------" )  ;
		display_analyse () ;
		
		// les transformations possibles sont dans  listAnalyse
		
		// decompose la molecule de depart depuis un vector electron vers un nouveau vecteur
		//moleAnalyse (MOLECULE ) ;
		listDepart = moleAnalyse (electron ) ;
		//listDepart contient la premiere molecule a analyser
		
		
		// moleAnalyse ggod
		
		System.out.println("---------- molecule ------------" )  ;
		display_molecule (listDepart) ;

		
		// good
		// genereMoles va etre recursif
		genereMoles(listDepart , 0 ) ;
		
		
		// enregistre (listDepart) ;
		//  System.out.println("toutes les moles " + listDepart.size() );
		System.out.println("toutes les moles sans doublon " + restictMolecule.size() );
		return " Solver 19 " + nbMoles ;
	}
	
	public void genereMoles (Vector<String> listDepart , int profondeur) {
		profondeur ++ ;
		for ( int i =0 ; i <listDepart.size() ; i++) {
			
			// pour chacune des molecules de listDepart , gerene toutes les molecules possibles
			String maMolecule = listDepart.elementAt(i);
			// on recher cette molecule dans le liste analyse
			int index = elements.indexOf(maMolecule) ;
			// cheche cette molecule dans les sources de tranformation
			if (index  > -1 ) {
				// trouve : il faut creer toutes les nouvelles molecules
				//System.out.println("combien de fils de " + maMolecule ) ; 
				for ( int  j = index ; j<listAnalyse.size(); j++ ) {
					String[] parts =listAnalyse.elementAt(j).split(";");
					//int nbfils = parts.
					if ( parts[0].equals(maMolecule)) {
						String[] fils =parts[1].split(":");
						//nbMoles = nbMoles + fils.length ;
						//System.out.println("Nombre d atomes de " + maMolecule  + " " +  fils.length  ) ;
						//
						String result = "";
						for ( int k = 0 ; k<fils.length ; k ++) {
							result = result + fils[k];
							
						}
						
						// remplacer avec listDepart en param
						//String newM = newMole(i,result);
						String newM = newMole(i,result, listDepart);
						
						
						
						//System.out.println("newM " + newM ) ;
						//result = result + newM ;
						
						nbMoles = nbMoles + 1 ;
						listMoles.addElement(newM) ;
						// display_listMoles() ;
						
						addrestrict (newM );					} 
				}
			} else {
				// pas trouvee : 
				// la molecule resultat est celle de depart
				// System.out.println("add MOLECULE " ) ;
				addrestrict (MOLECULE );
			}
		}
	} // genereMoles
	
	public void addrestrict ( String newMole) {
		if ( !newMole.equals(MOLECULE) ) {
			if ( restictMolecule.indexOf(newMole) < 0 ) {
				// pas trouve on add
				restictMolecule.add(newMole) ;
				nbMolesRestrict ++ ;
			}
		}
	}
	
	
	
	public String newMole (int pos , String mole , Vector<String> laListDesMolecule) {
		// System.out.println("newMole " + pos + " : " + mole )  ;
		String newMolecule = "";
		// debut de la molecule
		for ( int i =0 ; i < pos ; i ++) {
			newMolecule = newMolecule + laListDesMolecule.elementAt(i) ;
		}
		// insertion transformation
		newMolecule = newMolecule + mole ;
		
		// fin de la molecule
		for ( int i = pos +1 ; i < laListDesMolecule.size() ; i ++) {
			newMolecule = newMolecule + laListDesMolecule.elementAt(i) ;
		}
		
		return newMolecule;		
	}
	
	public Vector<String>  moleAnalyse(String mole) {
		System.out.println("---------- moleAnalyse ------------" )  ;
		Vector<String> cetteMoleanalyse = new Vector<String>() ;
		
			//System.out.println("moleAnalyse " + mole  )  ;
			String lettre = "";
			String start  = "";
			for (int  j = 0 ; j< mole.length() ; j++){
				lettre = mole.substring(j, j+1) ;
				// recherche de elemnts crees
				// on ne cree que de VRAIS elements :Majucule + (eventuellement) minuscule
				// on DOIT trouver une majuscule sinon erreur
				
				if ( StringUtils.isAllUpperCase(lettre) || lettre.equals("e")) {
					// recheche une minuscule si pas fini
					if ( j < mole.length() - 1 ) {
						//isAllLowerCase
						if ( StringUtils.isAllLowerCase(mole.substring(j+1, j+2))) {
							// Element en 2 lettres
							start =  lettre + mole.substring(j+1, j+2) ;
							j ++ ;
						}else  {
							start =  lettre ;
						}
						
					} else {
						// derniere lettre  on ajoute
						start =  lettre ;
					} 
					
				} else {
					// pas une majuscule : erreur
					System.out.println("---------- error ------------" )  ;
					System.out.println("mole = " + mole )  ;
					System.out.println("pos  = " + j )  ;
					System.out.println("lettre  = " + lettre )  ;
					
				}
				cetteMoleanalyse.addElement(start);
			}
			return cetteMoleanalyse;
		
	}
	
	/**
	 * analyse
	 * prends les resultats de listGenerate et les analyse dans listAnalyse
	 */
	public void analyse() {
		System.out.println("---------- gener ------------" )  ;
		for ( int i =0 ; i<listGenerate.size() ;i ++ ){
			String gener =  listGenerate.elementAt(i);
			String lettre = "";
			//for (int j = 0 ; j< )
			String[] parts =gener.split(";");
			String start = parts[0] + ";" ;      // on respecte cette formulation
			// la chaine a analyser
			String anal  = parts[1];
			//System.out.println("analyser " + anal  )  ;
			for (int  j = 0 ; j< anal.length() ; j++){
				lettre = anal.substring(j, j+1) ;
				// recherche de elemnts crees
				// on ne cree que de VRAIS elements :Majucule + (eventuellement) minuscule
				// on DOIT trouver une majuscule sinon erreur
				
				if ( StringUtils.isAllUpperCase(lettre)) {
					// recheche une minuscule si pas fini
					if ( j < anal.length() - 1 ) {
						//isAllLowerCase
						if ( StringUtils.isAllLowerCase(anal.substring(j+1, j+2))) {
							// Element en 2 lettres
							start = start  + lettre + anal.substring(j+1, j+2) + ":";
							j ++ ;
						} else {
							start = start + lettre + ":";
						}
						
					} else {
						// derniere lettre  on ajoute
						start = start + lettre + ":";
					} 
					
				} else {
					// pas une majuscule : erreur
					System.out.println("---------- error ------------" )  ;
					System.out.println("anal = " + anal )  ;
					System.out.println("pos  = " + j )  ;
					System.out.println("lettre  = " + lettre )  ;
					
				}
			}
			listAnalyse.addElement(start);
		}
	}
	
	
	public void display_generate () {
		for ( int i =0 ; i < listGenerate.size() ; i++) {
			//System.out.println(listGenerate.elementAt(i));
		}
	}

	public void display_listDesMoles (Vector<String> moles){
		for ( int i = 0 ; i < moles.size() ; i ++) {
			//System.out.println(moles.elementAt(i));
			
		}
	}
	
	
	public void display_elements () {
		for ( int i =0 ; i < elements.size() ; i++) {
			//System.out.println(elements.elementAt(i));
		}
	}

	// listAnalyse
	public void display_analyse () {
		for ( int i =0 ; i < listAnalyse.size() ; i++) {
			//System.out.println(listAnalyse.elementAt(i));
		}
	}
	
	//list moles
	public void display_molecule (Vector<String> moles) {
		for ( int i =0 ; i < moles.size() ; i++) {
			//System.out.println(moles.elementAt(i));
		}
	}


	public void parselines(String sfname) {
		String line = "";
		// lecture
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			line = reader.readLine();
			while ( line != null   && ! line.equals("") ) {
				System.out.println ( "line "  + line  ) ;
					// taille ++ ;
					String[] parts =line.split(" ");
					// ajoute element si pas deja connu
					if ( ! elements.contains(parts[0]))	elements.add(parts[0]) ;
				
					// listGenerate
					listGenerate.addElement(parts[0] + ";" + parts[2]);
					line = reader.readLine();
				
			}
			maMoleculeFinale = reader.readLine(); // le but
			System.out.println ("maMoleculeFinale " + maMoleculeFinale ) ; 
			reader.close();
			
		reader.close();
			
			filereader.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return  ;
	}
	/*
	public void parselines1(String sfname) {
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
	*/
	
	public void enregistre (Vector<String> moles) {
		try {
			PrintWriter writer = new PrintWriter("Day19_1.log", "UTF-8");
			for ( int i = 0 ; i < moles.size() ; i ++) {
				writer.println( moles.elementAt(i)  );
			}
			writer.println( "------------------" ) ;
			writer.close();	
		}catch (Exception e) { 
			e.printStackTrace();
		}
		
		try {
			PrintWriter writer = new PrintWriter("Day19_1_restict.log", "UTF-8");
			for ( int i = 0 ; i < restictMolecule.size() ; i ++) {
				writer.println( restictMolecule.elementAt(i)  );
			}
			writer.println( "------------------" ) ;
			writer.close();	
		}catch (Exception e) { 
			e.printStackTrace();
		}
		
	} // enregistre
	
}
