package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Arrays;


public class Solver3 {
	public String solver3 (String sfname){
		String line = null;
		int max = 16000 ; 
		int[] [] array = new int [max][max];
		
		// array init
		for ( int i =0 ; i< max  ;i ++){
			for ( int j =0 ; j< max  ;j ++) {
				array [i][j] = 0 ;
			}
		}
		// start is OK
		int x = 8200 ;
		int y   = 8200 ;
		array [x][y] = 1 ;
		
		
		char c ;
		System.out.println(" value3 solver 3 "   ) ;
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			/* relecture premiere ligne  */
			line = reader.readLine();
			
			
			/* lecture deuxieme ligne  */
			while ((line = reader.readLine()) != null) {
				for ( int i = 0 ; i< line.length();i ++ ) {
				c= line.charAt(i);	
				switch (c)
					{
					case '<' :{
						//System.out.println(" char " + c ); 
						x -- ;
						array [x][y] = 1 ;
						break ;
						}
					case '>' :{
						x ++ ;
						array [x][y] = 1 ;
						//System.out.println(" char " + c );
						break ;
						}
					case 'v' :{
						y ++ ;
						array [x][y] = 1 ;
						//System.out.println(" char " + c );
						break ;
						}
					case '^' :{
						y -- ;
						array [x][y] = 1 ;
						//System.out.println(" char " + c );
						break ;
						}
					}
				}
				
			}
			// lecture resultat
			int resultat = 0 ;
			for ( int i =0 ; i< max  ;i ++){
				for ( int j =0 ; j< max  ;j ++) {
					resultat= resultat +array [i][j]  ;
				}
			}
			
			System.out.println(" resultat " + resultat );
				
			
			reader.close();
			filereader.close();
			
			
			try {
				System.out.println(" part 2 " ) ;
				
				// array init
				for ( int i =0 ; i< max  ;i ++){
					for ( int j =0 ; j< max  ;j ++) {
						array [i][j] = 0 ;
					}
				}
				// start is OK
				// start santa claus
				int xs = 8200 ;
				int ys   = 8200 ;
				// and the robot
				int xr   = 8200 ;
				int yr   = 8200 ;
				array [xr][yr] = 1 ;
				//BufferedReader reader2 = new BufferedReader(filereader);
				BufferedReader reader2 = new BufferedReader(new FileReader(sfname));
				line = reader2.readLine();
				line = reader2.readLine();
				
				for ( int i = 0 ; i< line.length();i ++ ){
					c= line.charAt(i);	
					switch (c)
						{
						case '<' :{
							xs -- ;
							break ;
							}
						case '>' :{
							xs ++ ;
							break ;
							}
						case 'v' :{
							ys ++ ;
							break ;
							}
						case '^' :{
							ys -- ;
							break ;
							}
						}
					// System.out.println("xs = "  + xs ) ;
					// System.out.println("ys = "  + ys ) ;
					array [xs][ys] = 1 ;
						

						// change to robot
						i ++ ;
						c= line.charAt(i);	
						switch (c)
							{
							case '<' :{
								xr -- ;
								break ;
								}
							case '>' :{
								xr ++ ;
								break ;
								}
							case 'v' :{
								yr ++ ;
								break ;
								}
							case '^' :{
								yr -- ;
								break ;
								}
							}
						//System.out.println("xr = "  + xr ) ;
						//System.out.println("yr = "  + yr ) ;
						
						array [xr][yr] = 1 ;
						
					
				}
				reader2.close();
				// lecture resultat
				int resultatsantaclaus = 0 ;
				for ( int i =0 ; i< max  ;i ++){
					for ( int j =0 ; j< max  ;j ++) {
						resultatsantaclaus= resultatsantaclaus +array [i][j]  ;
					}
				}
				
				System.out.println(" resultatsantaclaus " + resultatsantaclaus );

			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				throw new IllegalArgumentException("Unable to load " + sfname, e);
				//e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			throw new IllegalArgumentException("Unable to load " + sfname, e);
			//e.printStackTrace();
		}
		return "done part 1";
	
		
	}
	

}
