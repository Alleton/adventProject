package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import com.alleton.adventProject.model.Solver22Spell;

public class Solver22 {

	public int leastAmount ;
	Vector<Solver22Spell> theSpells  = new Vector<Solver22Spell>(); 
	
	Vector<Solver22Spell> mySpells  = new Vector<Solver22Spell>();
	
	Solver22Situation initialSituation = new Solver22Situation (); 
	
	
	final int	bossHitPoints = 71 ;
	final int	bossDamage = 10 ; 
	final int myHitPoints = 50 ;
	final int myMana = 500 ;
	// declares an array of integers
    int[] hitpoints = new int[2];
	
	
	public String solver22 (String sfname){
		//String moleDepart ;
		System.out.println("---------- solver21 ------------" )  ;
		 parselines( sfname) ;
		 display(theSpells) ;
		 initializeMySpells();
		 display(mySpells) ;
		 display(theSpells) ;
		 
		 
		 initialSituation.setBossPoints(bossHitPoints);
		 initialSituation.setMyPoints(myHitPoints);
		 initialSituation.setMyspells(mySpells);		 
		 initialSituation.setMyMana(myMana);
		 
		 
		 System.out.println("initialSituation");
		 System.out.println(initialSituation.situationToString());
		 
		 
		 System.out.println(" solver21  start "   )  ;
		 
		 //System.out.println(" solver21 day 2 file input  = " + input2  )  ;
			long tStart = System.nanoTime();
			
			testPart1(initialSituation) ;
			
			
			
			long tEnd = System.nanoTime();
			double tDelta =  (double) (tEnd - tStart);
			System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );
			
			
		return "Solver21 "  + leastAmount ;
	} //  end solver21

	
	boolean testPart1 (Solver22Situation oldSituation) {
		
		System.out.println("\n ** Test Part1 ** \n" );
		// teste notre coup puis celui du boss
		//Solver22Situation newSituation = new Solver22Situation (); 
		
		// try to cast a new spell ( one whith lasting == 0 )
		// Vector<Solver22Spell> newSpells  = new Vector<Solver22Spell>();
		// newSituation.setMyspells(oldSituation.getMyspells() );

		
		boolean assezDeMana = false ;
		boolean fini = false ;
		boolean gagne = true;
		
		for ( int i  = 0 ; i < oldSituation.getMyspells().size() ; i++) {

			// spell not running
			
			if (oldSituation.getMyspells().elementAt(i).getSpellLasting() == 0 ) {
				System.out.println("Test Spell " + oldSituation.getMyspells().elementAt(i).getSpellName() ) ;
				int cost = oldSituation.getMyspells().elementAt(i).getSpellCost() ;
				int lasting = oldSituation.getMyspells().elementAt(i).getSpellLasting(); // 0 !!
				
				if ( cost < oldSituation.getMyMana() ) {
					// assez de mana pour essayer
					Solver22Situation newSituation = new Solver22Situation ();
					newSituation.setMyspells(oldSituation.getMyspells() );
					assezDeMana = true ;
					
					// depense de la mana
					newSituation.setMyMana(oldSituation.getMyMana()  - cost);
					
					// ajout lasting a notre spell
					//System.out.println("lasting + " + lasting ) ;
					// System.out.println("lastin du spell  " + theSpells.elementAt(i).getSpellLasting() ) ;
					newSituation.getMyspells().elementAt(i).setSpellLasting(lasting + theSpells.elementAt(i).getSpellLasting());
					
					// Boss Hit
					newSituation.setBossPoints(oldSituation.getBossPoints());
					
					// My His
					newSituation.setMyPoints(oldSituation.getMyPoints());
					
					// display 
					
					System.out.println("newSituation after choosing spell ");
					 System.out.println(newSituation.situationToString());
					 
					 // diminution HitPoints du Boss
					 // parcours les spells
					 // cast those ones whit lasting > 0
					 // decremente this lasting
					 
					 int mHit = oldSituation.getMyPoints() ;
					 int bHit = oldSituation.getBossPoints();
					 int shield = 0;
					
					 for ( int j = 0 ; j < theSpells.size() ; j ++ ) {
						 
						 if (newSituation.getMyspells().elementAt(j).getSpellLasting() > 0   ) {
							 // decease lasting
							 newSituation.getMyspells().elementAt(j).setSpellLasting( newSituation.getMyspells().elementAt(j).getSpellLasting() - 1 );
							 
							 // le boss prends des coups
							 bHit = bHit - newSituation.getMyspells().elementAt(j).getSpellDamage() ;
							 if (bHit <= 0) {
								 System.out.println("Gagne !! ");
								 gagne = true ;
								 fini = true ;
							 }
							 // Healing
							 mHit = mHit +  newSituation.getMyspells().elementAt(j).getSpellHealing() ;
							 
							 //  armor
							 shield = shield + newSituation.getMyspells().elementAt(j).getSpellArmor() ;
							 
							 // gain mana
							
							newSituation.setMyMana(newSituation.getMyMana()  +  newSituation.getMyspells().elementAt(j).getSpellRecharge());
							
						 }   // newSituation.getMyspells().elementAt(j).getSpellLasting() > 0 
					 
					 }     // boucle sur les spells testes j
					 // Boss attack
					 System.out.println("shield " + shield );
					 
					 
					 int bossAttack = bossDamage - shield ;
					 
					 System.out.println("bossAttack " + bossAttack );
					 if ( bossAttack < 1 ) bossAttack = 1 ;
					 // Dead ??
					 mHit = mHit - bossAttack ;
					 if (bHit <= 0) {
						 System.out.println("Perdu !! ");
						 gagne = false ;
						 fini = true ;
					 } // mort
					
					 // mise a jour newSituation
					 // et appel recursif
					 if ( !fini ) {
						 newSituation.setBossPoints(bHit);
						 newSituation.setMyPoints(mHit);
						 
							System.out.println("newSituation after casting spell and defending ");
							 System.out.println(newSituation.situationToString());
					 }
					 
					 
				}  //  cost < oldSituation.getMyMana()
			}		// if (oldSituation.getMyspells().elementAt(i).getSpellLasting() == 0 ) {
		} 			//for ( int i  = 0 ; i < oldSituation.getMyspells().size() ; i++) {
		
		
		
		return  gagne ;
	}
	
	
	
	

	void initializeMySpells ( ) {
		System.out.println("initializeMySpells" ) ;
		for ( int s = 0 ; s< theSpells.size() ; s++) {
			// System.out.println(theSpells.elementAt(s).spellToString());
			Solver22Spell item = theSpells.elementAt(s).deepCopy();
			
			item.setSpellLasting(0);            // au depart rien ..
			mySpells.addElement(item);
			
			
			// mySpells
		}
		
	}
	
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
	}
	
	
} // class
