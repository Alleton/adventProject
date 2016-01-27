package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;

public class Solver191 {
	int taille  ;
	final int SOURCEELECTRON = 3 ;
	final String electron = "e" ;
	
	final String Ar = "Ar" ;
	final String Rn = "Rn" ;
	final String Y = "Y" ;
	
	//final String  electron  = "CRnCaSiRnBSiRnFArTiBPTiTiBFArPBCaSiThSiRnTiBPBPMgArCaSiRnTiMgArCaSiThCaSiRnFArRnSiRnFArTiTiBFArCaCaSiRnSiThCaCaSiRnMgArFYSiRnFYCaFArSiThCaSiThPBPTiMgArCaPRnSiAlArPBCaCaSiRnFYSiThCaRnFArArCaCaSiRnPBSiRnFArMgYCaCaCaCaSiThCaCaSiAlArCaCaSiRnPBSiAlArBCaCaCaCaSiThCaPBSiThPBPBCaSiRnFYFArSiThCaSiRnFArBCaCaSiRnFYFArSiThCaPBSiThCaSiRnPMgArRnFArPTiBCaPRnFArCaCaCaCaSiRnCaCaSiRnFYFArFArBCaSiThFArThSiThSiRnTiRnPMgArFArCaSiThCaPBCaSiRnBFArCaCaPRnCaCaPMgArSiRnFYFArCaSiThRnPBPMgAr" ;
	
	
	
	Vector<String> listGenerate = new Vector<String>(); 	// la lecture
	Vector<String> listAnalyse  = new Vector<String>(); 	// la liste analysee
	
	Vector<String> listDepart = new Vector<String>(); 	// les molecules de depart
	Vector<String> moleAnalysees = new Vector<String>(); 	// les molecules analysees
	
	Vector<String> restictMolecule = new Vector<String>();	// les molecules crees pas en double
	
	String maMoleculeFinale ;         // la molecule finale comme lue
	Vector<String> maMoleculeFinaleV  = new Vector<String>() ; // la molecule finale en tant que vector
	
	Vector<String> sourceV = new Vector<String>();
	Vector<String> butV = new Vector<String>(); 
	
	
	int nbMoles = 0 ;
	int nbMolesRestrict = 0 ;  // nb moles sans doublon
	int maxProfondeur = 8;
	int transfoUtiles ;		//	le nombre de transformation sans les 3 derneires 
	int transfoUtilesFin ;  // avec les 3 dernieres 
	
	
	int nbTransfo = 0 ;
	
	Solver191 () {
		// constructeur
	}
	
	public String solver191 (String sfname){
		//String moleDepart ;
		System.out.println("---------- solver191 ------------" )  ;
		parselines(sfname);
		
		System.out.println("---------- parselines done ------------"  )  ;
		System.out.println("maMoleculeFinale ") ;
		System.out.println(maMoleculeFinale ) ;
		display_molecule (maMoleculeFinaleV) ;
		
		//System.out.println("---------- gener ------------" )  ;
		//display_generate ()  ;
		
		// les transformations possibles sont dans  sourceV et butV
		long tStart = System.nanoTime();
		// optimisation
		transfoUtilesFin = butV.size()   ; 
		transfoUtiles = butV.size()  - SOURCEELECTRON  ;
		
		
		//genereMoles (maMoleculeFinale , 0) ;
		
		
		
		nbTransfo = compte() ;
		
		long tEnd = System.nanoTime();
		double tDelta =  (double) (tEnd - tStart);
		System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );
		
		
		return " Solver 191  fin " + nbTransfo  ;
	}
	
	/*
	 * compte
	 * compte le nombre de transfo necessaires pour reduire la chaine de depart
	 */
	public int compte () {
		int cpt = 0 ;
		// remove Yx : elimine tous les Y
		System.out.println(" remove Y "  + removeY ()  );
		display_molecule (maMoleculeFinaleV) ;
		
		// premieire passe rapide
		// elimine toutes les molecules de type RnxAr
		System.out.println ("removeRnxAr passe 1 ") ;
		cpt = removeRnxAr ( ) ;
		
		System.out.println("after removeRnxAr " ) ;
		display_molecule (maMoleculeFinaleV) ;
		
		
		// 
		cpt = cpt  + shrink () ;
		
		System.out.println("after shrink " ) ;
		display_molecule (maMoleculeFinaleV) ;
		
		
		System.out.println(" shrink "  + cpt  );
		
		// deuxieme passe
		// elimine toutes les molecules de type RnxAr
		
		System.out.println ("removeRnxAr passe 2 ") ;
		cpt = cpt + removeRnxAr ( ) ;
		display_molecule (maMoleculeFinaleV) ;
		
		// troiseme passe
		System.out.println ("removeRnxAr passe 3 ") ;
		cpt = cpt + removeRnxAr ( ) ;
		display_molecule (maMoleculeFinaleV) ;
		
		// quatrieme passe
		System.out.println ("removeRnxAr passe 4 ") ;
		cpt = cpt + removeRnxAr ( ) ;
		display_molecule (maMoleculeFinaleV) ;
		
		// 5eme passe
		System.out.println ("removeRnxAr passe 5 ") ;
		cpt = cpt + removeRnxAr ( ) ;
		display_molecule (maMoleculeFinaleV) ;
		
		// 6eme passe
		System.out.println ("removeRnxAr passe 6 ") ;
		cpt = cpt + removeRnxAr ( ) ;
		display_molecule (maMoleculeFinaleV) ;
				
		return cpt;
	}
	
	/* 
	 * shrink
	 */
	int shrink (){
		int cpt =0 ;
		for ( int i = maMoleculeFinaleV.size() - 1  ; i > 2  ; i--) {
			// en descendant 
			if ( !maMoleculeFinaleV.elementAt(i).equals(Ar)  && 
					 !maMoleculeFinaleV.elementAt(i  ).equals(Rn)  )  {
				if ( !maMoleculeFinaleV.elementAt(i - 1 ).equals(Rn)  ){
			
					maMoleculeFinaleV.removeElementAt(i);
					cpt = cpt + 1 ;
					//i = i- 1 ;
				}
			}
		}

		
		
		
		return cpt;
		
	}
	
	
	/*
	 * removeY
	 * 
	 * * compte le nombre de transfo necessaires pour reduire la chaine de depart
	 * de toutes les molecules Y 
	 * et les retire du vector ainsi que leur suivant
	 */
	public int removeY (){
		int cpt = 0 ;
		for ( int i = maMoleculeFinaleV.size() - 1  ; i > 2  ; i--) {
			// en descendant 
			if (maMoleculeFinaleV.elementAt(i).equals(Y)) {
				maMoleculeFinaleV.removeElementAt(i);
				maMoleculeFinaleV.removeElementAt(i);
				cpt = cpt + 2 ;
			}
		}
		System.out.println("after removeY " ) ;
		display_molecule (maMoleculeFinaleV) ;
		return cpt;
	}
	
	
	
	/*
	 * removeRnxAr
	 * compte le nombre de transfo necessaires pour reduire la chaine de depart
	 * de toutes les molecules de type RnxAr
	 * et les retire du vector
	 */
	public int removeRnxAr () {
		System.out.println(" compteRnxAr " ) ;
		System.out.println(" maMoleculeFinaleV.size() "  +  maMoleculeFinaleV.size() )  ;
		int nbTransfo = 0 ;
		for ( int i = maMoleculeFinaleV.size() - 1  ; i > 2  ; i--) {
			// en descendant 
			if (maMoleculeFinaleV.elementAt(i).equals(Ar)) {
				// on a trouve 
				
				if (maMoleculeFinaleV.elementAt(i-2).equals(Rn)) {
					System.out.println(" compteRnxAr trouve at " + i ) ;
					nbTransfo ++ ;
					// System.out.println(" remove  maMoleculeFinaleV " + maMoleculeFinaleV.elementAt(i-2) ) ;
					maMoleculeFinaleV.removeElementAt(i-2);
					//System.out.println(" remove  maMoleculeFinaleV " + maMoleculeFinaleV.elementAt(i-2) ) ;
					maMoleculeFinaleV.removeElementAt(i-2);
					// System.out.println(" remove  maMoleculeFinaleV " + maMoleculeFinaleV.elementAt(i-2) ) ;
					maMoleculeFinaleV.removeElementAt(i-2);
					// on retire toujours la premiere pour eviter un test
					i = i - 3 ; // on a retire 3 elements
				}
			}
			
		}
		
		display_molecule (maMoleculeFinaleV) ;
		return nbTransfo ;
	}
	
		
	/*
	 * 
	 */
	
	public String  moleAnalyse(String mole , boolean finale) {
		StringBuilder builder = new StringBuilder();
		
		
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
				//cetteMoleanalyse.addElement(start);
				//builder.append(start + ":") ;
				builder.append(start ) ;
				if ( finale ) {
					//System.out.println("maMoleculeFinaleV  + " + start )  ;
					maMoleculeFinaleV.addElement(start);
				}
				
			}
			return   builder.toString();
		
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
	

	
	//list moles
	public void display_molecule (Vector<String> moles) {
		StringBuilder builder = new StringBuilder();
		for ( int i =0 ; i < moles.size() ; i++) {
			//System.out.println(moles.elementAt(i));
			builder.append(moles.elementAt(i));
			
		}
		System.out.println("display molecule " ) ;
		System.out.println("display molecule Length = " + moles.size() ) ;
		System.out.println(builder.toString() ) ;
	} //display_molecule
	
	
	public void parselines(String sfname) {
		String line = "";
		// lecture
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			line = reader.readLine();
			while ( line != null   && ! line.equals("") ) {
				//System.out.println ( "line "  + line  ) ;
					taille ++ ;
					String[] parts =line.split(" ");
					// ajoute element si pas deja connu
					
					// listGenerate
					listGenerate.addElement(parts[0] + ";" + parts[2]);
					line = reader.readLine();
				
			}
			maMoleculeFinale = moleAnalyse (reader.readLine() ,true ); // le but
			//moleculeFinaleLenth = maMoleculeFinale.length();    // permets de s'arreter a temps ...
			//moleculeFinaleNbMoles = moleAnalyse(maMoleculeFinale).size();
			
			//System.out.println ("moleculeFinaleNbMoles " + moleculeFinaleNbMoles ) ;
			//System.out.println ("maMoleculeFinale " + maMoleculeFinale ) ; 
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

