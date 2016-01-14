package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver11 {
	//StringBuffer  solution  = new StringBuffer("");
	StringBuffer  newpasswd = new StringBuffer("");
	//StringBuffer  oldpwd    = new StringBuffer("");
	int linel = 0;
	char thischar ;
	
	
	public String solver11 (String sfname){
		//String res = "";
		String line ;
		
		 try {
			 FileReader filereader = new FileReader(sfname);
		 
			 BufferedReader reader = new BufferedReader(filereader);
			 /* lecture ligne  */
			 long tStart = System.nanoTime();
			 
			 while ((line = reader.readLine()) != null) {
				 System.out.println(" line " + line );	 
				 //analyse (  line );
				 //solution = StringBuffer(line);
				 StringBuffer  oldpwd  = new StringBuffer(line);
				 
				 
		 		 for ( int  iteration = 1 ; iteration < 1343500 ; iteration ++) {
		 			 System.gc(); 
					 //System.out.println(" oldpwd     " + oldpwd.toString()      );
					 
					 //System.out.println(" iteration " + ( iteration ) );	 
					 newpasswd =  newpassw (  oldpwd );
					 
					 //System.out.println( newpasswd    );
					 if ( validpawd ()) {
						 System.out.println(" newpassw  OK   " + newpasswd.toString()      );
						 break ;
					 } else {
						 //System.out.println(" newpassw  NOK  " + newpasswd.toString()  + ""    );
						 // rien 
					 }
					 
					 linel = line.length() ;
					 oldpwd = newpasswd;
				 }
				 
				 //System.out.println(" solution " + solution );	 
		 		System.out.println(" last pwd " + newpasswd );
		 		
		 		long tEnd = System.nanoTime();
		 		double tDelta =  (double) (tEnd - tStart);
		 		System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );
			 }
	
			 reader.close();
			 filereader.close();
		 } catch (IOException e) {
			 throw new IllegalArgumentException("Unable to load " + sfname, e);
		//e.printStackTrace();
	}
		
		return String.valueOf(linel) ;
	} // 
	
	private boolean validpawd ( ) {
		boolean ok = false ;
		if ( validrequirements1 (  ) ) {
			ok = validrequirements2()  ; // si le premier est bon teste second 
		}
		return ok;
	}
	
	

	private boolean validrequirements1 ( ) {
		boolean ok = false ;
		
		/*
		 * 1 :
Passwords must include one increasing straight of at least three letters, like abc, bcd, cde, and so
 on, up to xyz. They cannot skip letters; abd doesn't count.
		 */
		for ( int i =0 ; i< newpasswd.length() -2  ; i++) {
			// optimisation ??
			thischar = newpasswd.charAt(i) ;
			
			if (( newpasswd.charAt(i) <= 'x' ) &&       			// yz??
					( newpasswd.charAt(i) != 'g' ) &&			// gh i absent
					( newpasswd.charAt(i) != 'h' ) &&			// h i absent 
					( newpasswd.charAt(i) != 'j' ) &&			// jk l absent
					( newpasswd.charAt(i) != 'k' ) &&			// k l absent
					( newpasswd.charAt(i) != 'm' ) &&			// mn o absent et le n pareil
					( newpasswd.charAt(i) != 'n' ) ) {		
				// let s continue because if not cant be OK
				int charval = (int)newpasswd.charAt(i);
				if  ( ((int)newpasswd.charAt(i +1 ) == charval + 1 ) && ( (int)newpasswd.charAt(i + 2 ) == charval + 2 ) ) {
					// next one is + 1 and next next is + 2 
					//System.out.println(" pawd try1  " + pawd  + pawd.charAt(i) + " and " + pawd.charAt(i +1 )) ;
					// that is good for requirements 1
						System.out.println("requirements 1 " + newpasswd );
						ok = true ;
						break ;
					
				} // end next good
				
				
				
			}  // end char <= 'x'  -- car yza cest pas bon 
		}      // end boucle for
		
		
		return ok;
	} // end validrequirements1
	
	private boolean validrequirements2 ( ) {
		boolean ok = false ;
	/*
	 * 2 :
 	 * Passwords must contain at least two different, non-overlapping pairs of letters, like aa, bb, or zz.
	 */
	for ( int i =0 ; i< newpasswd.length() -3  ; i++) {
		// il nous faut au moins 3 lettres apres pour avoir 2 paires
		// optimisation ??
		if ( newpasswd.charAt(i) == newpasswd.charAt(i+1) )  {
			// teste sur le reste
			for ( int j =i+2 ; j< newpasswd.length() - 1  ; j++) {
				if ( newpasswd.charAt(j) == newpasswd.charAt(j+1) )  {
					ok = true ;
					break ;
				} 	// end char(j) = char(j+1)
			} 		// end for j
		} 			// end char(i) = char(i+1)
	}  				// end boucle for i
	return ok;
} // end validrequirements2

	
	private StringBuffer newpassw (  StringBuffer  oldpass) {
		
		StringBuffer  newpassword = new StringBuffer(oldpass);
		
		// incremente last char
		//int charValue = value.charAt(0);
		//int charValue = newpassword.charAt(7);
		//newpassword.setCharAt(7, (char) (charValue + 1));
		
		newpassword = incremente (newpassword , 7) ;
		
		return newpassword;
	}
	
	private StringBuffer incremente (  StringBuffer  oldpass, int position) {
		StringBuffer  newpassword = new StringBuffer(oldpass);
		
		/*
		 * 2 :Passwords may not contain the letters i, o, or l, as these letters 
		 * can be mistaken for other
 		  *characters and are therefore confusing.
 		  *so we skip those letters while incrementing
		 */

		// incremente last char
		//int charValue = value.charAt(0);
		// si le char at position != 'z' alors simple
		if ( newpassword.charAt(position) == 'z' ) {
			// on passe le dernier a 'a'
			// et on incremente le precedent
			newpassword.setCharAt(position , 'a');
			newpassword = incremente ( newpassword , position - 1 ) ;
			
		}else {
			int charValue = newpassword.charAt(position);
			if ( ( newpassword.charAt(position) == 'h' ) || ( newpassword.charAt(position) == 'k' ) || ( newpassword.charAt(position) == 'n' )  ) {
				newpassword.setCharAt(position , (char) (charValue + 2));
			} else {
				newpassword.setCharAt(position , (char) (charValue + 1));
			}
			
		}
		return newpassword;
	}
	
}
