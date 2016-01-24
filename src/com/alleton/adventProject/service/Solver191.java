package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;

public class Solver191 {
	int taille  ;
	
	final String electron = "e" ;
	//final String  electron  = "CRnCaSiRnBSiRnFArTiBPTiTiBFArPBCaSiThSiRnTiBPBPMgArCaSiRnTiMgArCaSiThCaSiRnFArRnSiRnFArTiTiBFArCaCaSiRnSiThCaCaSiRnMgArFYSiRnFYCaFArSiThCaSiThPBPTiMgArCaPRnSiAlArPBCaCaSiRnFYSiThCaRnFArArCaCaSiRnPBSiRnFArMgYCaCaCaCaSiThCaCaSiAlArCaCaSiRnPBSiAlArBCaCaCaCaSiThCaPBSiThPBPBCaSiRnFYFArSiThCaSiRnFArBCaCaSiRnFYFArSiThCaPBSiThCaSiRnPMgArRnFArPTiBCaPRnFArCaCaCaCaSiRnCaCaSiRnFYFArFArBCaSiThFArThSiThSiRnTiRnPMgArFArCaSiThCaPBCaSiRnBFArCaCaPRnCaCaPMgArSiRnFYFArCaSiThRnPBPMgAr" ;
	
	
	
	Vector<String> elements     = new Vector<String>(); 	// la liste des elements se transformant
	Vector<String> listGenerate = new Vector<String>(); 	// la lecture
	Vector<String> listAnalyse  = new Vector<String>(); 	// la liste analysee
	
	Vector<String> listDepart = new Vector<String>(); 	// les molecules de depart
	Vector<String> moleAnalysees = new Vector<String>(); 	// les molecules analysees
	
	Vector<String> restictMolecule = new Vector<String>();	// les molecules crees pas en double
	final String  MOLECULE  = "CRnCaSiRnBSiRnFArTiBPTiTiBFArPBCaSiThSiRnTiBPBPMgArCaSiRnTiMgArCaSiThCaSiRnFArRnSiRnFArTiTiBFArCaCaSiRnSiThCaCaSiRnMgArFYSiRnFYCaFArSiThCaSiThPBPTiMgArCaPRnSiAlArPBCaCaSiRnFYSiThCaRnFArArCaCaSiRnPBSiRnFArMgYCaCaCaCaSiThCaCaSiAlArCaCaSiRnPBSiAlArBCaCaCaCaSiThCaPBSiThPBPBCaSiRnFYFArSiThCaSiRnFArBCaCaSiRnFYFArSiThCaPBSiThCaSiRnPMgArRnFArPTiBCaPRnFArCaCaCaCaSiRnCaCaSiRnFYFArFArBCaSiThFArThSiThSiRnTiRnPMgArFArCaSiThCaPBCaSiRnBFArCaCaPRnCaCaPMgArSiRnFYFArCaSiThRnPBPMgAr" ;
	
	String maMoleculeFinale ; 
	int moleculeFinaleLenth ;
	int moleculeFinaleNbMoles ;
	
	
	
	int nbMoles = 0 ;
	int nbMolesRestrict = 0 ;  // nb moles sans doublon
	int maxProfondeur = 6;
	
	
	Solver191 () {
		// constructeur
	}
	
	public String solver191 (String sfname){
		//String moleDepart ;
		System.out.println("---------- solver191 ------------" )  ;
		parselines(sfname);
		
		System.out.println("---------- parselines ------------" + maMoleculeFinale )  ;
		
		display_elements ();
		System.out.println("---------- gener ------------" )  ;
		display_generate ()  ;
		analyse() ;
		System.out.println("---------- analyse ------------" )  ;
		display_analyse () ;
		
		// les transformations possibles sont dans  listAnalyse
		
		// decompose la molecule de depart depuis un vector electron vers un nouveau vecteur
		
		listDepart = moleAnalyse (electron ) ;
		//listDepart contient la premiere molecule a analyser
		
		
		// moleAnalyse ggod
		
		System.out.println("---------- molecule ------------" )  ;
		display_molecule (listDepart) ;

		
		// good
		// genereMoles va etre recursif
		genereMoles(listDepart , 0 ) ;
		
		enregistre (); 
		
		return " Solver 191  fin " + maxProfondeur  ;
	}
	
	public void genereMoles (Vector<String> listDepart , int profondeur) {
		String maMole = new String () ;
		boolean doublon = false;
		
		profondeur ++ ;
		/*
		System.out.println(" " ) ; 
		System.out.println("  genereMoles  " ) ;
		System.out.println("  genereMoles  profondeur  " + profondeur ) ;
		System.out.println("  genereMoles  a partir de " +  listDepart.toString() ) ;
		System.out.println(" " ) ;
		*/
		
		for ( int i =0 ; i <listDepart.size() ; i++) {
			
			// pour chacune des molecules de listDepart , gerene toutes les molecules possibles
			String maMolecule = listDepart.elementAt(i);
			// on recher cette molecule dans le liste analyse
				// trouve : il faut creer toutes les nouvelles molecules
				//System.out.println("combien de fils de " + maMolecule ) ; 
				for ( int  j = 0  ; j<listAnalyse.size(); j++ ) {
					// System.out.println( "profondeur = " + profondeur + " fils " + j +  " dans listAnalyse " + listAnalyse.elementAt(j) ) ;
					String[] parts =listAnalyse.elementAt(j).split(";");
					
					//System.out.println("i ds 
					 
					
					//int nbfils = parts.
					if ( parts[0].equals(maMolecule)) {
						//System.out.println("parts[0].equals(maMolecule)  " + parts[0] + " == "  + maMolecule) ; 
						// System.out.println("parts[1]                     " + parts[1] ) ;
						String[] fils =parts[1].split(":");
						//nbMoles = nbMoles + fils.length ;
						//System.out.println("Nombre d atomes de " + maMolecule  + " " +  fils.length  ) ;
						//
						Vector<String>  result = new Vector<String>();
						for ( int k = 0 ; k<fils.length ; k ++) {
							result.add(fils[k]) ;
						}
						
						
						// remplacer avec listDepart en param
						//String newM = newMole(i,result);
						// String newM = newMole(i,result, listDepart);
						Vector<String> resultMoles = newVMole (i,result, listDepart); // le resultat sous forme de vecteur
						// System.out.println("new vector Mole " + resultMoles.toString() ) ;
						// TODO transforme en string , compare a MOLECULE
						// et ajoute ( restrict ) a moles analysees
						maMole = UneMoleToString(resultMoles) ;
						doublon= addrestrict (profondeur , maMole ) ;
						
						if ( !doublon) {
						
						// System.out.println("new String Mole  " + profondeur + " : " + maMole ) ;
						//System.out.println("new String Mole  " + profondeur + " : "  ) ;
						if ( maMole.equals(maMoleculeFinale)) {
							// on a fini ce morceau !!
							System.out.println("+++++++++++ Gagne ++++++++ " + profondeur ) ; 
							System.out.println("new String Mole  " + profondeur + " : " + maMole ) ;
							maxProfondeur= profondeur ;      // ceci permettra de limiter la casse !!
							// inutile de rafaire des transfo cela sera de trop
						} else {
							// teste cette molecule pas trop longue
							// moleculeFinaleNbMoles
							if ( resultMoles.size() < moleculeFinaleLenth  )	{
								// teste cette molecule pas deja cree avec une profondeur moindre ..
								if ( profondeur < maxProfondeur -1 ) {
									// resursivite !!!! 
									//  genereMoles (Vector<String> listDepart , int profondeur)
									// System.out.println("Test new vector Mole " + resultMoles.toString() ) ;
									genereMoles (resultMoles , profondeur  ) ;
								}
							}
						}
						nbMoles = nbMoles + 1 ;
						
					} // !doublon
					}  //  parts[0].equals(maMolecule)
				}
			
		}
	} // genereMoles
	
	/*
	 * boolean addrestrict (newMole)
	 * ajoute newMole a la liste restrict
	 * retourne true si c est un doublon
	 */
	public boolean addrestrict ( int prof , String newMole) {
		boolean isdoublon = false ;
		String newrestrict = newMole + ";" + prof ;
/*		
		if ( !newMole.equals(MOLECULE) ) {
			if ( restictMolecule.indexOf(newMole) < 0 ) {
				// pas trouve on add
				restictMolecule.add(newMole) ;
				nbMolesRestrict ++ ;
			} else {
				restictMolecule.add("doublon " + newMole) ;
				isdoublon = true ;
			}
		}
	*/	
	
		for( int i = 0 ; i < restictMolecule.size() ; i++ ) {
			// if ( restictMolecule.elementAt(i).)
			String[] parts =restictMolecule.elementAt(i).split(";");
			if (( parts[0].equals(newMole)) && ( Integer.parseInt(parts[1]) <= prof)) {
					// c est un doublon ou pire
					isdoublon = true ;
					newrestrict = newrestrict + "; doublon " ;
					// pour le test
					// restictMolecule.addElement(newMole + ";" + prof + "; doublon") ;
			} else {
				// restictMolecule.addElement(newMole + ";" + prof);
			}
		}
		
		if ( !isdoublon) restictMolecule.addElement(newrestrict);
	
		
		return isdoublon ;
	}
	
	String UneMoleToString (Vector<String> mole ) {
		StringBuilder builder = new StringBuilder();
		for ( int i = 0 ; i < mole.size() ; i++) {
			builder.append(mole.elementAt(i)) ;
		}						
		
		return  builder.toString();
		
		
	}
	
	public Vector<String> newVMole (int pos , Vector<String> mole , Vector<String> laListDesMolecule) {
		Vector<String> newVMoleRes = new Vector<String>(); ;
		for ( int i =0 ; i < pos ; i ++) {
			newVMoleRes.addElement( laListDesMolecule.elementAt(i)  );
		}
		// insertion transformation
		// newVMoleRes.addElement( mole ) ;
		for ( int i =0 ; i < mole.size() ; i++) {
			newVMoleRes.add(mole.elementAt(i)) ;
		}
		
		// fin 
		for ( int i = pos +1 ; i < laListDesMolecule.size()  ; i ++) {
			newVMoleRes.addElement( laListDesMolecule.elementAt(i)  );
		}
		
		return newVMoleRes;
	}
	
	
	
	public String newMole (int pos , String mole , Vector<String> laListDesMolecule) {
		//System.out.println("newMole " + pos + " : " + mole )  ;
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
			// System.out.println("analyser " + anal  )  ;
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
			System.out.println(listGenerate.elementAt(i));
		}
	}

	public void display_listDesMoles (Vector<String> moles){
		for ( int i = 0 ; i < moles.size() ; i ++) {
			System.out.println(moles.elementAt(i));
			
		}
	}
	
	
	public void display_elements () {
		for ( int i =0 ; i < elements.size() ; i++) {
			System.out.println(elements.elementAt(i));
		}
	}

	// listAnalyse
	public void display_analyse () {
		for ( int i =0 ; i < listAnalyse.size() ; i++) {
			System.out.println(listAnalyse.elementAt(i));
		}
	}
	
	//list moles
	public void display_molecule (Vector<String> moles) {
		for ( int i =0 ; i < moles.size() ; i++) {
			System.out.println(moles.elementAt(i));
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
					taille ++ ;
					String[] parts =line.split(" ");
					// ajoute element si pas deja connu
					if ( ! elements.contains(parts[0]))	elements.add(parts[0]) ;
				
					// listGenerate
					listGenerate.addElement(parts[0] + ";" + parts[2]);
					line = reader.readLine();
				
			}
			maMoleculeFinale = reader.readLine(); // le but
			moleculeFinaleLenth = maMoleculeFinale.length();    // permets de s'arreter a temps ...
			moleculeFinaleNbMoles = moleAnalyse(maMoleculeFinale).size();
			System.out.println ("moleculeFinaleNbMoles " + moleculeFinaleNbMoles ) ;
			System.out.println ("maMoleculeFinale " + maMoleculeFinale ) ; 
			reader.close();
			
		reader.close();
			
			filereader.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return  ;
	}
	
	public void enregistre () {
		
		try {
			PrintWriter writer = new PrintWriter("Day19_1_restrict.log", "UTF-8");
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
