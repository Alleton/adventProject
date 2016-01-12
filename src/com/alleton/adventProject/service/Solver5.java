package com.alleton.adventProject.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Solver5 {
	public String solver5 (String sfname){
		int linenumbernice = 0 ;
		String line ;
		
		String lettre  ;
		int nbvoyelles ;
		
		System.out.println(" value5 solver 5 "   ) ;
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			
			/* lecture lignes  */
			while ((line = reader.readLine()) != null) {
				// linenumber ++ ;
				
				Boolean lettredouble = false ;
				// It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
				nbvoyelles = 0 ;
				for ( int i = 0 ; i< line.length();i ++ ){
					lettre = line.substring(i, i+1) ;
					if ( lettre.matches("[aeiou]")){
						nbvoyelles ++ ;
					}  // end compare voyelle
				}      // end analyse 1  line
	
				if ( nbvoyelles >= 3 ) {
					// continue 
					//It contains at least one letter that appears twice in a row,
					// like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
					for ( int i = 0 ; i< line.length()-1 ; i ++ ){
						//lettre = line.substring(i, i+1) ;
						// System.out.println(" lettre " + lettre ) ;
						if ( line.charAt(i) == line.charAt(i + 1 )){
							lettredouble = true ;
						}  // end compare double
					}       // end analyse 2  line
					
				if (lettredouble ) {
					// System.out.println("line "  + linenumber  + "  " + line +  " lettredouble ") ;
					// It does not contain the strings ab, cd, pq, or xy,
					//even if they are part of one of the other requirements.
					if (( line.matches(".*ab.*") 
							|| line.matches(".*cd.*") 
							|| line.matches(".*pq.*")
							|| line.matches(".*xy.*")) )  {
						// no good 
						// System.out.println(" not good ab ") ;
					} else linenumbernice ++ ;
				}
					
					
					// linenumbernice ++ ;
				}
				
			} // end read lines
			reader.close();
			filereader.close();
			
			System.out.println(" nice ones first method " + linenumbernice ) ;
			} catch (IOException e) {
				throw new IllegalArgumentException("Unable to load " + sfname, e);
				//e.printStackTrace();
			}
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			
			// linenumber = 0 ; 
			linenumbernice = 0 ;
			/* lecture  lignes  */
			while ((line = reader.readLine()) != null) {
				// linenumber ++ ;
				
				// select 2 letters
				// System.out.println(" line " + line ) ;
				// It contains a pair of any two letters that appears at least twice in the string without overlapping,
				// like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
				
				for ( int i = 0 ; i< line.length()-2 ; i ++ ){
					// as we take 2 letters must stop at line.length()-2
					lettre = line.substring(i, i+2) ; // this first two letters
					//System.out.println(" lettre " + lettre ) ;
					// now look to the end to find those 2 letters
					if ( line.substring(i+2, line.length()).matches(".*" + lettre + ".*")) {
						// ok we continue
						// now 
						// It contains at least one letter which repeats with exactly one letter between them,
						//like xyx, abcdefeghi (efe), or even aaa.
						// we read the same line for each char and find it ( or not ) 2 space after
						for ( int j = 0 ; j< line.length()-2 ; j ++ ){
							if ( line.charAt(j) == line.charAt(j + 2 )){
								linenumbernice ++ ;
								break ;
							}  // end compare double
						}
						break ;  // do not count them twice ...
					} // end if 2 same letters 
					
				} // end for int i
				//if (linenumber > 5 ) break ;
			} // end read lines
			reader.close();
			filereader.close();
			
		System.out.println(" nice ones  " + linenumbernice ) ;
		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to load " + sfname, e);
			//e.printStackTrace();
		}
		
		return "ok part 2 ";
	
		
	}
}
