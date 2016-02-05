package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import com.alleton.adventProject.model.Solver22Situation;
import com.alleton.adventProject.model.Solver22Spell;

public class Solver22 {

	Vector<Solver22Spell> theSpells  = new Vector<Solver22Spell>(); 
	Solver22Situation initialSituation = new Solver22Situation (); 
	
//	final int	bossHitPoints = 71 ;
//	final int	bossDamage = 10 ; 
	final int	bossHitPoints = 13 ;
	final int	bossDamage = 8 ; 

	
//	final int myHitPoints = 50 ;
//	final int myMana = 500 ;
	final int myHitPoints = 10 ;
	final int myMana = 250 ;

	
	final int minSpellCost = 53;
	
	
	final int maxLevel = 6 ; //
	int level = 0 ; // at start
	int minSpent = 99999 ;
	
	
	public String solver22 (String sfname){
		System.out.println("---------- solver21 ------------" )  ;
		parselines( sfname) ;
		//display(theSpells) ;
		
		// set lasting to 0
		initializeInitialSituation();
		System.out.println("initialSituation");
		//System.out.println(initialSituation.situationToString());
		 
		System.out.println(" solver21  start "   )  ;
		 
		long tStart = System.nanoTime();
			
		testPart1(initialSituation) ;         // THis is it
			
		long tEnd = System.nanoTime();
		double tDelta =  (double) (tEnd - tStart);
		System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );
		// minSpent	
		return "Solver21 "  + minSpent ;
	} //  end solver21

	
	boolean testPart1 (Solver22Situation oldSituation) {
		boolean fini = false ;

		int thisLevel = oldSituation.getLevel() ;
		
		if ( thisLevel > maxLevel) {
			 System.out.println("\n ** maxLevel ** \n") ;
			return true;
		} else {
			thisLevel ++ ;
		}
		System.out.println("** Part1  level " + thisLevel  );
		
		
		System.out.println( "old situ \n"  + oldSituation.situationToStringDetail()  );
		if ( oldSituation.getSpend() > minSpent ) {
			System.out.println("trop ");
			return true ;
		}
		
		if ( oldSituation.getMyPoints() <= 0 ) {
			System.out.println("mort ");
			return true ;
		}
		
		
		if ( minSpellCost > oldSituation.getMyMana() ) {
			System.out.println("Pas assez de Mana ");
			return true ;
		}
		
		// My turn
		// Creation et initialisation nouvelle situation

		Solver22Situation newSitu = new Solver22Situation ();
		newSitu.setMyMana(oldSituation.getMyMana());
		newSitu.copyArray(oldSituation); // variable intermediaire
		// level
		newSitu.setLevel(thisLevel);

		int mHit = oldSituation.getMyPoints() ;
		int bHit = oldSituation.getBossPoints();
		int shield = 0;
		
		// My Turn 
		// boucle sur tous les spells en cours
		
		System.out.println("My turn start effects");
		for ( int j = 0 ; j < theSpells.size() ; j ++ ) {
			 // j est le numero de spell teste
			if ((oldSituation.getRemainingArray()[j] > 0 )) { 
				 // decrease lasting
				 newSitu.getRemainingArray()[j] = newSitu.getRemainingArray()[j] - 1 ;
				 
				 // le boss prends des coups
				 bHit = bHit - theSpells.elementAt(j).getSpellDamage() ;
				 
				 // Healing
				 mHit = mHit +  theSpells.elementAt(j).getSpellHealing() ;
				 
				 //  armor
				 //newSitu.setArmor(    theSpells.elementAt(j).getSpellArmor() );
				 shield = shield + theSpells.elementAt(j).getSpellArmor() ;
				 
				 // gain mana mana
				 newSitu.setMyMana( newSitu.getMyMana() + theSpells.elementAt(j).getSpellRecharge() ) ;
				 
			 }   // newSituation.getMyspells().elementAt(j).getSpellLasting() > 0 

		 }  // j est le numero de spell teste
		
		

		System.out.println("My turn end effects");
		newSitu.setBossPoints(bHit);
		newSitu.setMyPoints(mHit);
		newSitu.setLevel(thisLevel);
		newSitu.setArmor(shield);
		System.out.println( newSitu.situationToStringDetail()  );
		
		
		System.out.println("My turn start new spell");
//		boolean assezDeMana = false ;
		
		for ( int i  = 0 ; i < theSpells.size() ; i++) {
			// try to cast a new spell ( one whith lasting == 0 )
			// spell not running
			// i est le numero du spell
			
				
			if ( newSitu.getRemainingArray()[i] == 0  ){	
				
				//System.out.println(theSpells.elementAt(i).getSpellName().substring(0,1)   + thisLevel )  ;
				System.out.println("\n\n Try " + theSpells.elementAt(i).getSpellName() + " Level "   + thisLevel )  ;
				
				int cost   = theSpells.elementAt(i).getSpellCost() ;
				// 2 variable sintermediaires
				int bHitInterne = bHit;
				int mHitInterne = mHit ;
				
				
				if ( cost < newSitu.getMyMana() )   {
					System.out.println(" assez de mana " + newSitu.getMyMana() ) ;
					// assez de mana pour essayer
					// et pas trop de depenses
					
					// creation nouvelle situation
					Solver22Situation newSituation = new Solver22Situation ();
					newSituation.setLevel(thisLevel);
					
					// Spent setSpend ( pas mis a jour dans remaining
					newSituation.setSpend(oldSituation.getSpend() + cost );
					// depense de la mana mis a jour en cas de recharge
					newSituation.setMyMana(newSitu.getMyMana()  - cost);

					
					// spells lasting
					//System.out.println("old situation + " + oldSituation.situationArray() ) ; 
					// newSituation.setRemainingArray(oldSituation.getRemainingArray());
					newSituation.copyArray(newSitu);
					

					// ajout lasting a notre spell
					//Correction : instant or not
					if (  theSpells.elementAt(i).getSpellLasting() == 1) {
						// immediate
						
						bHitInterne = bHitInterne - theSpells.elementAt(i).getSpellDamage() ;
						mHitInterne = mHitInterne + theSpells.elementAt(i).getSpellHealing() ;
					} else {
						newSituation.getRemainingArray()[i] =  theSpells.elementAt(i).getSpellLasting();
					}
					
					
		
				 if (bHitInterne <= 0) {
					 System.out.println("Gagne !! ");
					 System.out.println("Avec choix spell " + theSpells.elementAt(i).getSpellName() ) ;
					 System.out.println(" au cout de " +  cost  + " Soit au total "  + newSituation.getSpend() );
					 System.out.println( oldSituation.situationToString()  + "\n\n ");
					 
					 fini = true ;
					 // minSpent
					 if ( newSituation.getSpend() < minSpent ) {
						 minSpent = newSituation.getSpend();
						 System.out.println("Gagne !! new mini = "  + minSpent )  ;
					 }
				 }     // bHitInterne <= 0
				
				 
				 
				 
				newSituation.setBossPoints(bHitInterne);
				newSituation.setMyPoints(mHitInterne);
				newSituation.setLevel(thisLevel);
				//newSituation.setArmor(newSitu.getArmor());
					
					// Boss Turn
					System.out.println("Boss turn "  );
					System.out.println("New Situ = " + newSituation.situationToStringDetail() ) ;
					System.out.println("New Situ before spells = poison "  + newSituation.getRemainingArray()[3] ) ;
					shield = 0 ; 
					// boucle sur tous les spells en cours
					for ( int j = 0 ; j < theSpells.size() ; j ++ ) {
						 // j est le numero de spell teste
						fini = false ;
						if (newSituation.getRemainingArray()[j] > 0 ) { 
							 
							 // decrease lasting
							newSituation.getRemainingArray()[j] = newSituation.getRemainingArray()[j] - 1 ;
							 // le boss prends des coups
							 bHitInterne = bHitInterne - theSpells.elementAt(j).getSpellDamage() ;
							 // Healing
							 mHitInterne = mHitInterne +  theSpells.elementAt(j).getSpellHealing() ;
							//  armor
							 //newSitu.setArmor(    theSpells.elementAt(j).getSpellArmor() );
							 shield = shield + theSpells.elementAt(j).getSpellArmor() ;
							 							 
							 // gain mana mana
							 newSituation.setMyMana( newSituation.getMyMana() + theSpells.elementAt(j).getSpellRecharge() ) ;
							 
						 }   // newSituation.getMyspells().elementAt(j).getSpellLasting() > 0 
						
					 }  // j est le numero de spell teste
					System.out.println("New Situ = poison "  + newSituation.getRemainingArray()[3] ) ;
					
					newSituation.setBossPoints(bHitInterne);
					newSituation.setMyPoints(mHitInterne);
					newSituation.setLevel(thisLevel);
					newSituation.setArmor(shield);
					System.out.println("New Situ after Boss Turn start = " + newSituation.situationToStringDetail() ) ;	
					
//
				 if (bHitInterne <= 0) {
					 System.out.println("Gagne !! ");
					 System.out.println("Avec choix spell " + theSpells.elementAt(i).getSpellName() ) ;
					 System.out.println(" au cout de " +  cost  + " Soit au total "  + newSituation.getSpend() );
					 System.out.println( oldSituation.situationToString()  + "\n\n ");
					 
					 fini = true ;
					 // minSpent
					 if ( newSituation.getSpend() < minSpent ) {
						 minSpent = newSituation.getSpend();
						 System.out.println("Gagne !! new mini = "  + minSpent )  ;
					 }
				if (mHitInterne <=0 ) {
					 System.out.println("Perdu !! ");
					 System.out.println("Avec choix spell " + theSpells.elementAt(i).getSpellName() ) ;
					 System.out.println( oldSituation.situationToString()  + "\n\n ");
					 fini = true ;
				}
					 
					
				 }     // boucle sur les spells en cours j

				 // attaque du boss
				 
				int bossAttack = bossDamage - shield ;
					 
				//System.out.println("bossAttack " + bossAttack );
				if ( bossAttack < 1 ) bossAttack = 1 ;
					
				// Dead ??
				mHitInterne = mHitInterne - bossAttack ;
				System.out.println("after boss attack mHit " + mHitInterne ) ;
				//System.out.println("mHit " + mHit );
				if (mHitInterne <= 0) {
					System.out.println("Perdu");
					 fini = true ;
				} // mort
					
				// mise a jour newSituation
				// et appel recursif
				if ( !fini ) {
					System.out.println(" => appel recursif "  );
					newSituation.setBossPoints(bHitInterne);
					newSituation.setMyPoints(mHitInterne);
					newSituation.setLevel(thisLevel);
					
					System.out.println("newSituation");
					System.out.println(newSituation.situationToString());
						// boolean testPart1 (Solver22Situation oldSituation)
						// test c est la peine
					if ( minSpellCost <= newSituation.getMyMana() ) {
						fini = testPart1(newSituation) ;
					} else {
						System.out.println("Pas assez de mana to cast a spell");
					}
							
				} else {
					 System.out.println("fini " + fini ) ;
				}
					 
				}  //  cost < oldSituation.getMyMana()
				else {
					System.out.println("Pas assez mana ");
				}
			}		// if (oldSituation.getMyspells().elementAt(i).getSpellLasting() == 0 ) {
		} 		//for ( int i  = 0 ; i < oldSituation.getMyspells().size() ; i++) {
				// fin de boucje de test des spells
		// System.out.println("fini "  + thisLevel ) ;
		return  fini ;
	} //testPart1
	
	
	void initializeInitialSituation () {
		System.out.println("initializeInitialSituation" ) ;
		initialSituation.setBossPoints(bossHitPoints);
		initialSituation.setMyPoints(myHitPoints);
		initialSituation.setMyMana(myMana);
		initialSituation.setLevel(0);
		initialSituation.setSpend(0);
		
		for ( int s = 0 ; s< theSpells.size() ; s++) {
			initialSituation.getRemainingArray()[s] = 0 ;
		}
	
	}		// initializeInitialSituation
	
	
	
	
	/*
	 * public void parselines(String sfname)
	 * cree les spells
	 */
	public void parselines(String sfname) {
		
		String line = "";
		
		try {
			System.out.println(" lire "  + sfname.substring(0,sfname.length()-4) + "Spells.txt" );
			FileReader filereader = new FileReader( sfname.substring(0,sfname.length()-4) + "Spells.txt" );
			BufferedReader reader = new BufferedReader(filereader);
			line = reader.readLine();
			while ( line != null   && ! line.equals("") ) {
				String correct = line.replaceAll("\\s+", " ");
				
				//System.out.println ( "line "  + line  ) ;
					String[] parts =correct.split(" ");
					Solver22Spell item = new Solver22Spell();
					
					item.setSpellName(parts[0]);
					item.setSpellCost(Integer.parseInt(parts[1]));
					item.setSpellDamage(Integer.parseInt(parts[2]));
					item.setSpellHealing(Integer.parseInt(parts[3]));
					item.setSpellArmor(Integer.parseInt(parts[4]));
					item.setSpellLasting(Integer.parseInt(parts[5]));
					item.setSpellRecharge(Integer.parseInt(parts[6]));
					
					theSpells.addElement(item);
					
					
					
					line = reader.readLine();
				}
			reader.close();
			filereader.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return  ;

	} // parseline
	
	public void display ( Vector<Solver22Spell> aSpell ) {
		
		for ( int s = 0 ; s< aSpell.size() ; s++) {
			System.out.println("spell s " + s  ) ;
			System.out.println(aSpell.elementAt(s).spellToString());
		}
	}  //display
	
} // class
