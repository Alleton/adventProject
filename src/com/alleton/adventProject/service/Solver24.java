package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Solver24 {
	Integer[] pack = new Integer[29] ; // param2 est tjrs un int
	
	int nbpack = 0;
	Integer totalWeight=0;
	Integer balancedWeight=0;
	int minPackG1 = 99 ;
	long miniq  = Long.parseLong("905925792351", 10);
	// miniq = 405925792351 ;
	
	public String solver24 (String sfname){
		
		parselines (sfname);
		long tStart = System.nanoTime();
		// fait le 1er groupe
		for ( int i =0 ; i < nbpack ; i++) {
			// limite la recherche a des packs assez gros
			if ( remaining(i) >= balancedWeight) {
				// possible de tester
				Vector<Integer> Group1 = new Vector<Integer>();
				Group1.addElement(i);
				
				if (charge1(Group1,i+1)  ) {
					System.out.println("group1 done +++++++++++++++++");
				}
			} else {
				System.out.println("remaining(i) < balancedWeight");
				break ;
			}
			
		}
		
		long tEnd = System.nanoTime();
		double tDelta =  (double) (tEnd - tStart);
		System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );
		
		return ("Solver24 " + minPackG1 + " miniq " + miniq) ;
	}
	
	public boolean charge1 (Vector<Integer> group1 , int start) {
		boolean done = false ;
		// System.out.println("group1 test " + groupToString(group1) +  "  start = " + start );
		int poidsGroup1 = poidsGroupe(group1) ;
		if ( remaining(start) >= balancedWeight - poidsGroup1 ) {
		
		
		// fait le 1er groupe
		for ( int i =start ; i < nbpack ; i++) {
			if ( poidsGroup1 + pack[i] <= balancedWeight ){
				Vector<Integer> newGroup1 = new Vector<Integer>();
				newGroup1 = copyVector (group1) ;
				newGroup1.addElement(i);
				// System.out.println(groupToString(newGroup1));
				if (poidsGroupe(newGroup1) == balancedWeight  ) {
					done = true ;
					
						System.out.println("done = true " + " newGroup1.size() " + newGroup1.size() ) ;
						//System.out.println(groupToString(newGroup1));
	
						// fait le 2eme groupe
						for ( int j =0 ; j < nbpack ; j++) {
							// ne pas tester pack ds newGroup1
							if ( remainingG2 (  group1 ,j) >= balancedWeight) {

								if ( !newGroup1.contains(j)) {
									Vector<Integer> Group2 = new Vector<Integer>();
									Group2.addElement(j);
									if (charge2(newGroup1,Group2 ,j+1)  ) {
										System.out.println("group2 done +++++++++++++++++");
										if ( minPackG1 >= newGroup1.size()) {
											minPackG1 = newGroup1.size()  ;
											long qu = quantum(newGroup1);
											System.out.println("done = true  minPackG1 = " + minPackG1 + " quantum "  + qu ) ;
											System.out.println(groupToString(newGroup1)) ;
											
											if ( miniq > qu ) {
												miniq = qu ;
												
											}
										}
										break ;
									}
								} else {
									//System.out.println("newGroup1.contains(j) " + j);
								}
							} else {
								//System.out.println("remaining( group1, start) < balancedWeight " );
								break ;
							}
						}  // fin 2 eme groupe
						
					} else {
						// poidsGroupe(newGroup1) < balancedWeight	
						// boucle si le nombre de pack est inf a minPackG1
						if ( newGroup1.size() < minPackG1 ) {
							done = charge1 (newGroup1,i+1 ) ;				
						}
			
					}
				} else {
					// poidsGroup1 + pack[i] <= balancedWeight
				}
			} //for ( int i =start ; i < nbpack ; i++)
		}  else {
			//System.out.println("charge1  remaining(start) >= balancedWeight  ");
			//remaining(start) >= balancedWeight 
		}
		
		return done;
	}  // charge1
	
	public boolean charge2 (Vector<Integer> group1 ,Vector<Integer> group, int start) {
		boolean done = false ;
		// System.out.println("group2 test avec group1 " + groupToString(group1)  + "  Group2 = " + groupToString(group) ) ;
		// limite la recherche a des ensemble de packs assez gros
		if ( remainingG2 (  group1 ,start) >= balancedWeight - poidsGroupe(group)) {
//			// possible de tester
			for ( int i = start ; i < nbpack ; i ++ ) {
				if ( !group1.contains(i)) {
					Vector<Integer> newGroup2 = new Vector<Integer>();
					newGroup2 = copyVector (group) ;
					newGroup2.addElement(i);	
					if (poidsGroupe(newGroup2) == balancedWeight  ) {
						//System.out.println("++++++++++++++ Group2 done "  + groupToString(newGroup2) ) ; 
						// done = true ;
						// i = nbpack  ; // pas la peine de continuer
						System.out.println("Group2 == "  + groupToString(newGroup2)) ;

						// fait le 3eme groupe
						for ( int j =0 ; j < nbpack ; j++) {
							// ne pas tester pack ds newGroup1
							if ( remainingG3 (  group1 ,newGroup2  ,j) >= balancedWeight) {

								//  ( (!group1.contains(i)) && !(group2.contains(i)) )
								
								if ( (!group1.contains(j)) && !(newGroup2.contains(j)) ) {
									Vector<Integer> Group3 = new Vector<Integer>();
									Group3.addElement(j);
									done = charge3(group1,newGroup2 ,Group3,j+1) ; 
									if (done  ) {
										System.out.println("group3 done +++++++++++++++++");
										j = nbpack ; // ok
										if ( minPackG1 >= group1.size()) {
											minPackG1 = group1.size()  ;
											long qu = quantum(group1);
											System.out.println("done = true  minPackG1 = " + minPackG1 + " quantum "  + qu ) ;
											System.out.println(groupToString(group1)) ;
											 
											if ( miniq > qu ) {
												miniq = qu ;
												
											}
										}
										break ;
									}
								} else {
									//System.out.println("newGroup1.contains(j) " + j);
								}
							} else {
								//System.out.println("remaining( group1, start) < balancedWeight " );
								break ;
							}
						}  // fin 2 eme groupe

					} else {
						if (poidsGroupe(newGroup2) < balancedWeight  ) {
							// recursif
							done = charge2(group1,newGroup2,i+1) ;
							if ( done ){
								i = nbpack; //  pas la peine de continuer
					
							}
						}
					}
				}
			}
//				System.out.println("group1 done +++++++++++++++++");
			} else {
				//System.out.println("remaining(group1, start) < balancedWeight " );
			}
		
		return done;
	} // charge2
	

	public boolean charge3 (Vector<Integer> group1 ,Vector<Integer> group2 ,Vector<Integer> group, int start) {
		boolean done = false ;
		// System.out.println("group2 test avec group1 " + groupToString(group1)  + "  Group2 = " + groupToString(group) ) ;
		// limite la recherche a des ensemble de packs assez gros
		if ( remainingG3 (  group1 ,group2,start) >= balancedWeight - poidsGroupe(group)) {
//			// possible de tester
			for ( int i = start ; i < nbpack ; i ++ ) {
				if ( ( (!group1.contains(i)) && !(group2.contains(i)) ) ) {
					Vector<Integer> newGroup3 = new Vector<Integer>();
					newGroup3 = copyVector (group) ;
					newGroup3.addElement(i);	
					if (poidsGroupe(newGroup3) == balancedWeight  ) {
						System.out.println("++++++++++++++ Group done "  + groupToString(newGroup3) ) ; 
						done = true ;
						i = nbpack  ; // pas la peine de continuer 
					} else {
						if (poidsGroupe(newGroup3) < balancedWeight  ) {
							// recursif
							done = charge3(group1, group2,newGroup3,i+1) ;
							if ( done ){
								i = nbpack; //  pas la peine de continuer
							}
						}
					}
				}
			}
//				System.out.println("group1 done +++++++++++++++++");
			} else {
				//System.out.println("remaining(group1, start) < balancedWeight " );
			}
		
		return done;
	} // charge3
	
	
	
	public long quantum (Vector<Integer> group ) {
		long q = 1 ;
		for ( int i = 0 ; i < group.size() ;  i ++) {
			q = q * pack[group.elementAt(i)] ;
		}
		return q;
	}
	
	public int remaining ( int start) {
		int remain = 0 ;
		for ( int i = start ; i < nbpack ; i ++ ) {
			remain = remain + pack[i];
		}
		return remain;
	}
	
	
	public int remainingG2 ( Vector<Integer> group1  ,int start) {
		int remain = 0 ;
		for ( int i = start ; i < nbpack ; i ++ ) {
			if ( !group1.contains(i)) {
				remain = remain + pack[i];
			}	
		}
		return remain;
	}

	public int remainingG3 ( Vector<Integer> group1 ,  Vector<Integer> group2 ,int start) {
		int remain = 0 ;
		for ( int i = start ; i < nbpack ; i ++ ) {
			if ( (!group1.contains(i)) && !(group2.contains(i)) )  {
				remain = remain + pack[i];
			}	
		}
		return remain;
	}

	
	public int poidsGroupe (Vector<Integer> group) {
		int poids = 0 ;
		for ( int i = 0 ; i < group.size() ; i++) {
			poids = poids + pack[group.elementAt(i)] ;
		}
		
		
		return poids;
	}
	
	
	public Vector<Integer> copyVector (Vector<Integer> group ) {
		Vector<Integer> newGroup = new Vector<Integer> ();
		for ( int i = 0 ; i< group.size() ; i++) {
			newGroup.addElement(group.elementAt(i));
		}
		return newGroup ;
	}
			
	public String groupToString ( Vector<Integer> group ){
		long q = 1;
		StringBuilder builder = new StringBuilder();
		builder.append( " group "  ) ;

		for (int i= 0 ; i < group.size() ; i++ ) {
			builder.append(" pacjk " + group.elementAt(i) ) ; 
		}
		builder.append( "\n");
		
		for (int i= 0 ; i < group.size() ; i++ ) {
			builder.append(" poids " + pack[group.elementAt(i) ]) ; 
			q = q * pack[group.elementAt(i) ];
		}
		builder.append(" quantum =  " + q ) ;
		return  builder.toString();
	}
	
	public void parselines(String sfname) {
		
		String line = "";
		
		try {
			System.out.println(" lire "  + sfname );
			FileReader filereader = new FileReader( sfname );
			BufferedReader reader = new BufferedReader(filereader);
			line = reader.readLine();
			nbpack = 0 ;
			while ( line != null   && ! line.equals("") ) {
				//String correct = line.replaceAll("\\s+", " ");
				pack[nbpack] = Integer.parseInt(line) ;
				totalWeight = totalWeight + Integer.parseInt(line) ;
				nbpack ++ ;
				line = reader.readLine();
				}
			reader.close();
			filereader.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		 Arrays.sort(pack, Collections.reverseOrder());
		for ( int i = 0   ; i < nbpack ; i ++ ) {
			System.out.println("pack " + i + " " + pack[i] );
		}
		System.out.println("totalWeight " + totalWeight );
		balancedWeight = totalWeight / 4 ;
		System.out.println("balancedWeight " + balancedWeight );
		return  ;

	} // parseline

}
