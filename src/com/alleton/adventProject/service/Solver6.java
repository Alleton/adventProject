package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver6 {
	int max = 999 ; 
	int lampeon = 1 ;  
	int lampeoff = 0 ;  // the array initailize to 0 as all start turned off
	// the grid
	int [] [] grid = new int [max +1 ][max + 1];	
	int resultat ;
	
		// internals
		void turnoff (int sx , int sy , int ex , int ey) {
			// turnoff ligths between bounds
			//System.out.println(" turn off "  +sx + ":" + sy + ":" + ex + ":" + ey ) ;
			for ( int i = sx ; i <= ex; i ++) {
				for ( int j = sy ; j <= ey; j ++) {
					// grid [i][j] = lampeoff ;
					// second part decrease by 1 limit to 0
					grid [i][j] = Math.max( grid [i][j] - 1   , 0 );
				}
			}
		}
		
		/*
		 * turn on lights 
		 */
		private void turnon (int sx , int sy , int ex , int ey) {
			// turnon ligths between bounds
			//System.out.println(" turn on "  +sx + ":" + sy + ":" + ex + ":" + ey ) ;
			for ( int i = sx ; i <= ex; i ++) {
				for ( int j = sy ; j <= ey; j ++) {
					// grid [i][j] = lampeon ;
					// second part 
					grid [i][j] = grid [i][j] + 1 ; // easy
				}
			}
		}
		
		/*
		 * toggle lights 
		 */
		private void toggle (int sx , int sy , int ex , int ey) {
			// toggle ligths between bounds
			//System.out.println(" toggle "  +sx + ":" + sy + ":" + ex + ":" + ey ) ;
			for ( int i = sx ; i <= ex; i ++) {
				for ( int j = sy ; j <= ey; j ++) {
					/* part1 
					 if ( grid [i][j] == lampeon ) 
					 
						grid [i][j] = lampeoff ;
					 else grid [i][j] = lampeon ;
					 */
					/* The phrase toggle actually means that you should increase
					 *  the brightness of those lights by 2.
					 */
					grid [i][j] = grid [i][j] + 2 ;
				}
			}
		}

		
		int countlights () {
			int total = 0 ;
			System.out.println( "Counts on at " ) ;
			for ( int i = 0 ; i <= max; i ++) {
				for ( int j = 0 ; j <= max ; j ++) {
					// Part 2 total brigthneess
					total = total + grid [i][j] ;
				}
			}
			return total;
		}  // end countlights

	public String solver6 (String sfname){

	int linenumber =  0 ;
	
	String line ;
	
	String instruction  ;
	int startx ;
	int starty ;
	int endx ;
	int endy ;
	
	String[] tokens ;
	String[] coordinates;
	String delimspace = "[ ]+";   // maybe some double space ??
	String delimcoma = "[,]";
	
	
	
	System.out.println(" value6 solver 6 "   ) ;
	try {
		FileReader filereader = new FileReader(sfname);
		BufferedReader reader = new BufferedReader(filereader);
		/* lecture  lignes  */
		while ((line = reader.readLine()) != null) {
			linenumber ++ ;
			// parse line
			
			tokens = line.split(delimspace);  // we got all parts
			// maybe turn + off/on ot toggle
			if ( tokens[0].equals("turn")) {
				// on or off
				instruction = tokens[0] + tokens[1] ; 
				// startx = Integer.parseInt(tokens[2])
				// let's split x and y 
				coordinates = tokens[2].split(delimcoma) ;
				startx = Integer.parseInt(coordinates[0]);
				starty = Integer.parseInt(coordinates[1]);
				// next token has to be "through"
				if ( !tokens[3].equals("through")) {
					System.out.println(" Erreur parse line " + linenumber ) ;
				}
				coordinates = tokens[4].split(delimcoma) ;
				endx = Integer.parseInt(coordinates[0]);
				endy = Integer.parseInt(coordinates[1]);
				
			} else 
				{
				instruction = tokens[0];
				coordinates = tokens[1].split(delimcoma) ;
				startx = Integer.parseInt(coordinates[0]);
				starty = Integer.parseInt(coordinates[1]);
				// next token has to be "through"
				if ( !tokens[2].equals("through")) {
					System.out.println(" Erreur parse line " + linenumber ) ;
				}
				coordinates = tokens[3].split(delimcoma) ;
				endx = Integer.parseInt(coordinates[0]);
				endy = Integer.parseInt(coordinates[1]);
				}
			// print this ...
			//System.out.println("  parse line " + linenumber );
			//System.out.println( instruction + ":" +startx + ":" + starty + ":" + endx + ":" + endy ) ; 

			switch (instruction)
			{
			case "turnoff": {
				turnoff (startx , starty , endx , endy ) ;
				break;		
				}
			case "turnon": {
				turnon (startx , starty , endx , endy ) ;
				break;
			}
			case "toggle": {
				toggle (startx , starty , endx , endy ) ;
				break;
			}
			}
			
		} // while lecture ligne
		System.out.println(" end read "  ) ;
		reader.close();
		filereader.close();
		
	} catch (IOException e) {
		throw new IllegalArgumentException("Unable to load " + sfname, e);
		//e.printStackTrace();
	}

 
	return "solver 6 " + countlights() ; 
	
	} // end constructor with sfname

} // end class
