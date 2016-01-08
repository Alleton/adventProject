package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;

import com.alleton.adventProject.model.*;

public class Solver7 {

	public String solver7 (String sfname){
	
	
	Solver7circuit solver7circuit ;
	
	
	System.out.println(" value7 solver 7 "   ) ;
	try {
		//Solver7circuit 
		solver7circuit =  parselines(sfname) ;
		// this should initialyse values ==> affichage console
		System.out.println ( "sfname = " + sfname ) ;
		System.out.println (solver7circuit.toString());
		
		// try to solve
		solver7circuit = solve (solver7circuit) ;
		System.out.println (solver7circuit.toString());
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
	
		//throw new IllegalArgumentException("Unable to load " + sfname, e);
		e.printStackTrace();
	}
	// resultat = countlights() ; 
	
	
	return "solver 76 "  ; 		
		
	} // end solver7 fname
	
	/**
	 * parse 
	 * affecte les valeurs initiales de  input au circuit
	 */
	public static Solver7circuit parselines( String sfname) {
		System.out.println("parselines filename = " + sfname );
		Solver7circuit solver7circuit = new Solver7circuit();
		
		String line = "";
		int linenumber = 0;
		
		
		//Solver7wire wire = new Solver7wire () ;
		
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			
			
			/* lecture deuxieme ligne  */
			while ((line = reader.readLine()) != null) {
				System.out.println("parselines line " + line );
				Solver7wire wire = new Solver7wire () ;
				//System.out.println( line ) ;
			
				//System.out.println( "nb mots " + line.trim().split("\\s+").length  );
				int nbparts = line.trim().split("\\s+").length ;
				String[] parts =line.split(" ");
				
				switch (nbparts)
				{
				case 3: {
					//System.out.println("3 valeurs  " + parts[0] + ":" + parts[1] + ":" + parts[2] ) ;
					//System.out.println("Affectation simple");
					wire.setNboper(0); // affectation
					if ( isNumeric(parts[0])) {
						// valeur numerique ==> entry1 value
						wire.setEntry1value(Integer.parseInt(parts[0]));
						wire.setEntry1Done(true);
						// et on affecte le resultat !!
						wire.setWirevalue(Integer.parseInt(parts[0]));
						wire.setDone(true);
					} else {
						// avec3 composant simple ..
						wire.setEntry1( parts[0]);
					}
					// le dernier est le wirename
					wire.setWirename( parts[2]);
					break;		
					}
				case 4: {
					//System.out.println("4 valeurs  " + parts[0] + ":" + parts[1] +":"+ parts[2] + ":" + parts[3] ) ; 
					//System.out.println("Operateur unaire");
					wire.setNboper(1); // unaire
					if ( parts[0].equals("NOT") ) {
						//  seul operateur unaire 
						wire.setOperation( parts[0]);
						wire.setEntry1(parts[1]);
						wire.setWirename(parts[3]);
					} else {
						// avec3 compoasnt simple ..
						System.out.println("*** Erreur Operateur unaire");
					}
					break;		
					}
				case 5: {
					//System.out.println("5 valeurs  " + parts[0] + ":" + parts[1] +":"+ parts[2] + ":" + parts[3]+ ":" + parts[4] ) ; 
					//System.out.println("Operateur binaire");
					wire.setNboper(2); // binaire
					if ( isNumeric(parts[0])) {
						// valeur numerique ==> entry1 value
						wire.setEntry1value(Integer.parseInt(parts[0]));
						wire.setEntry1Done(true);
					} else {
						// 
						wire.setEntry1( parts[0]);
					}
					// la deuxieme partie est l operation
					wire.setOperation(parts[1]);
					// pour le deuxieme argment verification umerique
					
					if ( isNumeric(parts[2])) {
						// valeur numerique ==> entry1 value
						wire.setEntry2value(Integer.parseInt(parts[2]));
						wire.setEntry2Done(true);
					} else {
						// 
						wire.setEntry2( parts[2]);
					}
					// le dernier est le wirename
					wire.setWirename( parts[4]);
					break;		
					}
				}
				
				// Affectation
				solver7circuit.getSolver7wire()[linenumber] = wire;
				
				linenumber ++ ;
			} // while lecture ligne
			
			reader.close();
			filereader.close();

		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("Execption "  , e);
			//e.printStackTrace();
		}
		return solver7circuit ;
	} // end parselines
	
	private   static boolean isNumeric(String str)
	  {
		return str.matches("\\d+");
	  }
	
	/**
	 * le solveur lui mm
	 * @param circuit
	 * @return
	 */
	private Solver7circuit  solve (Solver7circuit circuit_in) {
		Solver7circuit circuit = circuit_in;
		int nbok = 0;
		// first affectations
		for ( int i =0 ; i< circuit.getCircuitSize() ; i++) {
			// System.out.println( " circuit " + i + " " + circuit.getSolver7wire().toString()) ;
			Solver7wire wire = circuit.getSolver7wire()[i] ;
			//System.out.println( " wire  " + i + " " + wire.getWirename()+ " " +" nombre operateurs " + " " + wire.getNboper()) ;
			if (wire.getDone()) {
				nbok = nbok + 1 ;    // compte bon
			} else
			{
				// sinon essayons d'affecter les valeurs d'entree
				// premiere valeur
				if (!wire.getEntry1Done()) {
					// 
					// boucle pour chercher le wire entree1
					for ( int j = 0 ; j < circuit.getCircuitSize() ; j ++) {
						if ( circuit.getSolver7wire()[j].getWirename().equals(wire.getEntry1() ) &&
								circuit.getSolver7wire()[j].getDone()	) {
							// nous avons trouve la source
							wire.setEntry1value(circuit.getSolver7wire()[j].getWirevalue());
							wire.setEntry1Done(true);
							circuit.getSolver7wire()[i] = wire;
							nbok = nbok + 1 ;    // compte bon
							break ;
						} // entry name found and OK
					} // for j
				} // !wire.getEntry1Done

				/* next second entry value */
				if ( (!wire.getEntry2Done()) && (wire.getNboper() == 2)  && (wire.getEntry2Done()== false ) ) {
					// boucle pour chercher le wire entree2
					for ( int j = 0 ; j < circuit.getCircuitSize() ; j ++) {
						//System.out.println("cherche " + wire.getEntry1()  + " = " + circuit.getSolver7wire()[j].getWirename() );
						if ( circuit.getSolver7wire()[j].getWirename().equals(wire.getEntry2() ) &&
								circuit.getSolver7wire()[j].getDone()	) {
							// nous avons trouve la source
							/* System.out.println(  wire.getWirename()+
									             " " + circuit.getSolver7wire()[j].getWirename() +
									             " " + circuit.getSolver7wire()[j].getDone() );
									             */
							wire.setEntry2value(circuit.getSolver7wire()[j].getWirevalue());
							wire.setEntry2Done(true);
							circuit.getSolver7wire()[i] = wire;
							break ;
						} // entry name found and OK
					} // for j
				} // !wire.getEntry2Done
			}
		} // first affectations
		
		/*
		 * second 
		 */
		
		for ( int i =0 ; i< circuit.getCircuitSize() ; i++) {
			// System.out.println( " circuit " + i + " " + circuit.getSolver7wire().toString()) ;
			Solver7wire wire = circuit.getSolver7wire()[i] ;
			// si deja affecte rien
			if ( (!wire.getDone())&& wire.getEntry1Done())  {
				// il faut que le premier operande soit connu ..
				switch (wire.getNboper()) {
					case 0: {
					// si nous avons une valeur numerique ==> affecter
						if (wire.getEntry1Done()) {
							wire.setWirevalue(wire.getEntry1value());
							wire.setDone(true);
							// Affectation
							circuit.getSolver7wire()[i] = wire;
						} // wire.getEntry1Done
					break ;
				}     // end case 0
				case 1 : {
					// bitwise NOT opers on signed ...
					long lg = wire.getEntry1value() ;
					
					wire.setWirevalue( (int) (~lg & 0xffff )  );
					wire.setDone(true);
					// Affectation
					circuit.getSolver7wire()[i] = wire;
										break ;
					}    // case 1 ( NOT )
				case 2 : {
					// binary operator
						if ( wire.getEntry2Done() == true){
							// 2 operandes Ok
							System.out.println( " circuit " + i + " " + circuit.getSolver7wire().toString()) ;
							int e1 = wire.getEntry1value();
							int e2 = wire.getEntry2value();
							
							switch (wire.getOperation()) {
							
							case "AND" : {
								wire.setWirevalue( e1 & e2 ) ;
								wire.setDone(true);
								nbok = nbok + 1 ;    // compte bon
								break ;
								} //end AND
							case "OR" : {
								wire.setWirevalue( e1 | e2 ) ;
								wire.setDone(true);
								nbok = nbok + 1 ;    // compte bon
								break ;
								} //end OR
							case "LSHIFT" : {
								wire.setWirevalue( e1 << e2 ) ;
								wire.setDone(true);
								nbok = nbok + 1 ;    // compte bon
								break ;
								} // LSHIFT ;
							case "RSHIFT" : {
								wire.setWirevalue( e1 >>> e2 ) ;
								wire.setDone(true);
								nbok = nbok + 1 ;    // compte bon
								break ;
								} // LSHIFT ;

							} // switch getOperation
							wire.setDone(true);
							// Affectation
							circuit.getSolver7wire()[i] = wire;

						}     // wire.getEntry2Done() == true
							break ;
					}    // binary operator

				}        // switch
			}            // !wire.getDone
		}                // for ( int i =0 
		if  ( (nbok < circuit.getCircuitSize())){
			// let's sart another turn
			 circuit = solve ( circuit) ;
		}
		
		return circuit ;
	}  // end solve
} // end class Solver7
