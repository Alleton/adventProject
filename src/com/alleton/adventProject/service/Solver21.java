	package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;


import java.util.Vector;

import com.alleton.adventProject.model.Solver21Item;



public class Solver21 {
	//Vector<Solver12object> nos_objets  = new Vector<Solver12object>  (500);
	Vector<Solver21Item> theWeapons  = new Vector<Solver21Item>();
	// Armor
	Vector<Solver21Item> theArmors  = new Vector<Solver21Item>();
	// Rings
		Vector<Solver21Item> theRings  = new Vector<Solver21Item>();
	
	final int	bossHitPoints = 109 ;
	final int	bossDamage = 8 ; 
	final int bossArmor =  2 ;
	final int myHitPoints = 100 ;	
		
	int costWeapon = 0;
	int damageWeapon = 0 ;
	
	int costArmor = 0 ;
	int armorArmor = 0;

	int ringNumber = 0 ;
	int costGauche = 0 ;
	int damageGauche = 0 ;
	int armorGauche = 0 ;
	
	int costDroite = 0 ;
	int damageDroite = 0 ;
	int armorDroite = 0 ;
	
	
	String shopkeeperItem = "Chainmail" ;

	int coutMax = 0 ;
	
	int shopkeeperCost = 0;
	int shopkeeperDamage = 0;
	int shopkeeperArmor = 0;
	
	
	// cherche le type d item fourni par le shopkeeper
	boolean isweapon = false ;
	boolean isarmor = false ;
	boolean isring = false ;
	
		
	public String solver21 (String sfname){
		//String moleDepart ;
		System.out.println("---------- solver21 ------------" )  ;
		 parselines( sfname) ;
		 System.out.println(" solver21  = "   )  ;
		 
		 
		 
		 //System.out.println(" solver21 day 2 file input  = " + input2  )  ;
			long tStart = System.nanoTime();
			
			// input = 19344 ;
		   //test (646591) ;
			// testFact (5) ;
		   // testPart2 (6465) ;
		   
			//int cout = coutePart1 () ;
			
			int cout = part2 () ;
			
			long tEnd = System.nanoTime();
			double tDelta =  (double) (tEnd - tStart);
			System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );
			
			
		return "Solver21 "  + coutMax ;
	} //  end solver21
	
	
	public int part2() {
		//the shopkeeper is working with the boss, 
		//and can persuade you to buy whatever items he wants.
		//String shopkeeperItem = theWeapons.elementAt(4).getName() ;
		
		// exemple
		// int result =   coutePart2 (shopkeeperItem) ;
		/*
			Vector<Solver21Item> theWeapons  = new Vector<Solver21Item>();
	// Armor
	Vector<Solver21Item> theArmors  = new Vector<Solver21Item>();
	// Rings
		Vector<Solver21Item> theRings  = new Vector<Solver21Item>();
		*/
		// shopkeeper gives a weapon
		for ( int w = 0 ; w< theWeapons.size() ; w++) {
			coutePart2 (theWeapons.elementAt(w).getName() ) ;
		}
		
		// shopkeeper gives an armor
		for ( int a = 0 ; a < theArmors.size() ; a ++) {
			coutePart2 (theArmors.elementAt(a).getName()) ;
		}
		
		// shopkeeper gives a ring
		
		for ( int r = 0 ; r < theRings.size() ; r ++ ) {
			coutePart2 (theRings.elementAt(r).getName() ) ; 
		}
		
		
		return 0 ;
	}
	
	/*
	 * coutePart2 (String item)
	 * item is what shopkeeper decide
	 */
	
	public int coutePart2 (String item) {
		int res = 0 ;
		
		// cherche le type item fourni
		
		for ( int arme = 0 ; arme < theWeapons.size() ; arme ++ ) {
			// teste les armures
			if  (theWeapons.elementAt(arme).getName().equals(item) ) {
				shopkeeperCost = theWeapons.elementAt(arme).getCost() ;
				shopkeeperDamage = theWeapons.elementAt(arme).getDamage() ;
				shopkeeperArmor = theWeapons.elementAt(arme).getArmor() ;
				
				isweapon = true ;
				
				System.out.println(" isweapon " + isweapon  + " " + item) ;
			} 
			else {
				System.out.println(theWeapons.elementAt(arme).getName()  + " !=  "  + item  ) ;
			}
		}
		
		if ( !isweapon ) {
			for ( int armure = 0 ; armure < theArmors.size() ; armure ++   ) {
				// teste les armures
				if  (theArmors.elementAt(armure).getName().equals(item) ) {
					shopkeeperCost = theArmors.elementAt(armure).getCost() ;
					shopkeeperDamage = theArmors.elementAt(armure).getDamage() ;
					shopkeeperArmor = theArmors.elementAt(armure).getArmor() ;
					isarmor = true ;
					System.out.println(" isarmor " + isarmor + " " + item ) ;
				} 	
				else {
					System.out.println(theArmors.elementAt(armure).getName() + " !=  "  + item  ) ;
				}
			} 
		
			if ( ! isarmor )  {
				for ( int main = 0 ; main < theRings.size() ; main ++ ) {
					if  (theRings.elementAt(main).getName().equals(item) ) {
						shopkeeperCost = theRings.elementAt(main).getCost() ;
						shopkeeperDamage = theRings.elementAt(main).getDamage() ;
						shopkeeperArmor =  theRings.elementAt(main).getArmor() ;
						ringNumber = main ;
						isring = true ;
						System.out.println(" isring " + isring + " " + item) ;
					}
				} 	// for rings 
			}  		//	! isarmor
		}			//  ! isweapon
		
		
		// teste les armes
		
		// arme fournie
		System.out.println(" ************************** " ) ;
		System.out.println("arme fournie " + item) ;
		System.out.println(" isweapon " + isweapon  )  ;
		System.out.println(" isarmor " + isarmor  ) ;
		System.out.println(" isring " + isring ) ;
		System.out.println(" ************************** " ) ;
		
		
		
		if ( isweapon ) {
			// 
			System.out.println("arme fournie  isweapon " + isweapon ) ;
			costWeapon = shopkeeperCost;
			damageWeapon  = shopkeeperDamage ;
			res = testArmure (item, item) ;
		} else {
			System.out.println("arme  non fournie  isweapon " + isweapon ) ;
			for ( int arme = 0 ; arme < theWeapons.size() ; arme ++ ) {
				costWeapon = theWeapons.elementAt(arme).getCost() ;
				damageWeapon  = theWeapons.elementAt(arme).getDamage() ;
				res= testArmure (item , theWeapons.elementAt(arme).getName()) ;
			}
		}				// arme
		
		return  res ;
	}  // public int coutePart2 (String item) 
	

	/*
	 *  testArmure ( String Theweapon) 
	 *  test les armures connaissant la weapon
	 */
	public int testArmure ( String item ,String Theweapon) {
		// nous connaissons la weapon
		
		System.out.println("testArmure  item " + item + " arme  : avec arme  " + Theweapon  ) ;
		int res = 0;
		if ( isarmor ) {
			System.out.println("armure fournie  isarmor " + isarmor +  " "  + shopkeeperItem ) ;
			costArmor = shopkeeperCost ;
			armorArmor = shopkeeperArmor ;
			testGauche (  item , Theweapon , shopkeeperItem ) ;
			
		} else {
			// teste toutes les armures
			for ( int armure = 0 ; armure < theArmors.size() ; armure ++   ) {
				
				costArmor = theArmors.elementAt(armure).getCost() ;
				armorArmor = theArmors.elementAt(armure).getArmor() ;
				testGauche ( item ,  Theweapon , theArmors.elementAt(armure).getName() ) ;
			}			// armure
			
		}
		
		return  res ;
	} // 	public int testArmure ( String Theweapon) {
	
	
	public int testGauche ( String item , String Theweapon , String TheArmor) {
		
		System.out.println("testGauche : avec arme  " + Theweapon   + " et armure  " + TheArmor ) ;
		int res = 0 ;

		if ( isring ) {
			costGauche = shopkeeperCost ;
			damageGauche = shopkeeperDamage ;
			armorGauche =  shopkeeperArmor ;
			
			res = testDroite (  item ,  Theweapon ,  TheArmor , ringNumber , theRings.elementAt(ringNumber).getName()) ;
			
		} else {
			// teste le anneaux main gauche
			for ( int gauche = 0 ; gauche < theRings.size() ; gauche ++ ) {
				costGauche = theRings.elementAt(gauche).getCost() ;
				damageGauche = theRings.elementAt(gauche).getDamage() ;
				armorGauche =  theRings.elementAt(gauche).getArmor() ;
				
				res = testDroite (  item ,  Theweapon ,  TheArmor , gauche , theRings.elementAt(gauche).getName()) ;
			}		// gauche
			
		}
		
		

		
		return  res ;
	}
	
	
	public int testDroite ( String item , String Theweapon , String TheArmor , int gauche , String Gauche) {
		// teste les anneaux main droite
		System.out.println("testDroite : avec arme  " + Theweapon   + " et armure  " + TheArmor  + " main gauche " + Gauche) ;
		int res = 0 ;
		for ( int droite = 0 ; droite < theRings.size() ; droite ++ ) {
			// on ne peut avoir 2 fois le mm anneau !!
			if ( droite != gauche  || gauche == 0 ) {
				damageDroite = theRings.elementAt(droite).getDamage() ;
				armorDroite =  theRings.elementAt(droite).getArmor() ;
				costDroite = theRings.elementAt(droite).getCost() ;
				
				//
				// total weapon damage
				int weapon = damageWeapon +  damageGauche + damageDroite ;
				// total armor
				int armor = armorArmor + armorGauche + armorDroite ;
				
				// total cost
				
				res = costWeapon + costArmor + costGauche + costDroite ;
				
				// System.out.println ( "Weapon  "  + weapon + " Armor  " + armor + " Cost " + totalCost   ) ;
				if ( !test (  weapon ,  armor )  ) {
					/* 
					 System.out.println ( "test perdu  Weapon  "  + weapon + " Armor  " + armor + " Cost " + res   ) ;
					 
					System.out.println ( "Weapon  "  + Theweapon  + " " + damageWeapon ) ;
					System.out.println ( "Armor   "  + TheArmor   + " " + armorArmor );
					System.out.println ( "Gauche  "  + theRings.elementAt(gauche).getName() 
							+ " dam  " + damageGauche + " arm " +  armorGauche);
					System.out.println ( "Droite  "  + theRings.elementAt(droite).getName() 
							+ " dam  " + damageDroite + " arm " +  armorDroite);
					System.out.println ( "Soit " + res );
					*/
					if ( res > coutMax ) {
						coutMax = res ;
						System.out.println ( " YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY " ) ;
						System.out.println ("weapon " + weapon);
						System.out.println ("armor  " + armor ) ;
						System.out.println ( "Weapon  "  + Theweapon ) ;
						System.out.println ( "Armor   "  + TheArmor);
						System.out.println ( "Gauche  "  + theRings.elementAt(gauche).getName() );
						System.out.println ( "Droite  "  + theRings.elementAt(droite).getName() );
						System.out.println ( "Soit " + res );
						
					}
					
					
					System.out.println ( "" )  ;
				}	
			}
			
			
		}	// droite
	
		
		return coutMax ;
	}
	
	
	
	public int coutePart1 () {
		int coutMin = 9999 ;
		// teste les armes
		for ( int arme = 0 ; arme < theWeapons.size() ; arme ++ ) {
			// teste les armures
			damageWeapon  = theWeapons.elementAt(arme).getDamage() ;
			costWeapon = theWeapons.elementAt(arme).getCost() ;
			
			for ( int armure = 0 ; armure < theArmors.size() ; armure ++   ) {

				int armorArmor = theArmors.elementAt(armure).getArmor() ;
				int costArmor = theArmors.elementAt(armure).getCost() ;

				// teste le anneaux main gauche
				for ( int gauche = 0 ; gauche < theRings.size() ; gauche ++ ) {
					int damageGauche = theRings.elementAt(gauche).getDamage() ;
					int armorGauche =  theRings.elementAt(gauche).getArmor() ;
					int costGauche = theRings.elementAt(gauche).getCost() ;
					
					// teste les anneaux main droite
					for ( int droite = 0 ; droite < theRings.size() ; droite ++ ) {
						// on ne peut avoir 2 fois le mm anneau !!
						if ( droite != gauche ) {
							int damageDroite = theRings.elementAt(droite).getDamage() ;
							int armorDroite =  theRings.elementAt(droite).getArmor() ;
							int costDroite = theRings.elementAt(droite).getCost() ;
							
							//
							// total weapon damage
							int weapon = damageWeapon +  damageGauche + damageDroite ;
							// total armor
							int armor = armorArmor + armorGauche + armorDroite ;
							
							// total cost
							
							int totalCost = costWeapon + costArmor + costGauche + costDroite ;
							
							// System.out.println ( "Weapon  "  + weapon + " Armor  " + armor + " Cost " + totalCost   ) ;
							if ( test (  weapon ,  armor )  ) {
								System.out.println ( "Weapon  "  + weapon + " Armor  " + armor + " Cost " + totalCost   ) ;
								if ( coutMin > totalCost ) {
									coutMin = totalCost ;
									System.out.println ( "Weapon  "  + theWeapons.elementAt(arme).getName() ) ;
									System.out.println ( "Armor   "  + theArmors.elementAt(armure).getName() );
									System.out.println ( "Weapon  "  + theRings.elementAt(gauche).getName() );
									System.out.println ( "Weapon  "  + theRings.elementAt(droite).getName() );
								}
								System.out.println ( "" )  ;
							}	
						}
						
					}	// droite
				}		// gauche
			}			// armure
		}				// arme
		
		return coutMin ;
	}
	

	/*
	 *  test
	 *  return true if myDeath >= bossDeath 
	 */
	boolean test ( int weapon , int armor ) {
		boolean ok = false ;
		// en combien de coup suis-je mort
		int myReduction =  bossDamage - armor ;
		if (myReduction < 1) myReduction = 1 ;  // mini 1 damage
		int myDeath = myHitPoints / myReduction ; // nb de coup pour mourrir
		// s'il reste un peu de vie ..
		if ( myHitPoints % myReduction > 0   ) myDeath ++ ; 
		
		// et le boss ??
		
		int bossReduction =  weapon - bossArmor ;
		if (bossReduction < 1) bossReduction = 1 ;  // mini 1 damage
		int bossDeath = bossHitPoints / bossReduction ; // nb de coup pour mourrir
		if ( bossHitPoints % bossReduction > 0   ) bossDeath ++ ; 
		
		if (myDeath >= bossDeath ) {
			// gagne !!
			//System.out.println ( "Gagne  me " +  myDeath + " le boss " + bossDeath ) ;
			ok = true ;
		} else {
			System.out.println ( "Dead  me " +  myDeath + " le boss " + bossDeath ) ;
			ok = false ;
		}
		
		
		return ok ;
	}

	public void parselines(String sfname) {
		// parselinesType(String sfname , String itempType) {
		parselinesType( sfname ,  "Weapons") ;
		parselinesType( sfname ,  "Armors") ;
		parselinesType( sfname ,  "Rings") ;
		return  ;
	} //parselines
	
	
	public void parselinesType(String sfname , String itempType) {
		String line = "";
		
		try {
			System.out.println(" lire "  + sfname.substring(0,sfname.length()-4) + itempType + ".txt" );
			FileReader filereader = new FileReader( sfname.substring(0,sfname.length()-4) + itempType + ".txt" );
			BufferedReader reader = new BufferedReader(filereader);
			int i=0;
			line = reader.readLine();
			while ( line != null   && ! line.equals("") ) {
				String correct = line.replaceAll("\\s+", " ");
				
				//System.out.println ( "line "  + line  ) ;
					String[] parts =correct.split(" ");
					Solver21Item item = new Solver21Item();
					item.setName(parts [0]);
					item.setCost(Integer.parseInt(parts[1]));
					item.setDamage(Integer.parseInt(parts[2]));
					item.setArmor(Integer.parseInt(parts[3]));
					// ajoute element au type 
					if (itempType == "Weapons") {
						theWeapons.addElement(item);
						System.out.println("weapon " + theWeapons.elementAt(i).itemToString() ) ;
					}
					// Armors
					if (itempType == "Armors") {
						theArmors.addElement(item);
						System.out.println("Armors " + theArmors.elementAt(i).itemToString() ) ;
					}
					// Rings
					if (itempType == "Rings") {
						theRings.addElement(item);
						System.out.println("Rings " + theRings.elementAt(i).itemToString() ) ;
					}
					i ++ ;
					line = reader.readLine();
				}
			reader.close();
			filereader.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return  ;

	}
	
	
}
