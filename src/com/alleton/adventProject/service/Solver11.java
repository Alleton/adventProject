package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver11 {
	//StringBuffer  solution  = new StringBuffer("");
	StringBuffer  newpasswd = new StringBuffer("");
	int linel = 0;
	
	public String solver11 (String sfname){
		//String res = "";
		String line ;
		// int iteration ;
		
		 try {
			 FileReader filereader = new FileReader(sfname);
		 
			 BufferedReader reader = new BufferedReader(filereader);
			 /* lecture ligne  */
			 
			 
			 while ((line = reader.readLine()) != null) {
				 System.out.println(" line " + line );	 
				 //analyse (  line );
				 //solution = StringBuffer(line);
				 StringBuffer  oldpwd  = new StringBuffer(line);
				 
				 
		 		 for ( int  iteration = 1 ; iteration < 1435; iteration ++) {
		 			//solution = StringBuffer(line);
		 			// line = StringBuffer (solution) ;
					 // solution.setLength(0);
					 System.gc(); 
					 //System.out.println(" oldpwd     " + oldpwd.toString()      );
					 
					 System.out.println(" iteration " + ( iteration ) );	 
					 newpasswd =  newpassw (  oldpwd );
					 
					 System.out.println(" newpassw    " + newpasswd.toString()      );
					 linel = line.length() ;
					 oldpwd = newpasswd;
				 }
				 
				 //System.out.println(" solution " + solution );	 
				 
			 }
	
			 reader.close();
			 filereader.close();
		 } catch (IOException e) {
			 throw new IllegalArgumentException("Unable to load " + sfname, e);
		//e.printStackTrace();
	}
		
		return String.valueOf(linel) ;
	} // 
	
	
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
			newpassword.setCharAt(position , (char) (charValue + 1));
		}
		return newpassword;
	}
	
}
