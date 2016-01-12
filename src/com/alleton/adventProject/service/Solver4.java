package com.alleton.adventProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solver4 {
	
	
	public String solver4 (String sfname){
		String line ;
		String md5   ;  
		String inputcode ;
		try {
			FileReader filereader = new FileReader(sfname);
			BufferedReader reader = new BufferedReader(filereader);
			/* lecture premiere ligne  */
			line = reader.readLine();
			
			// let's go
			md5 = getMD5(line) ;
			
			reader.close();
		
			filereader.close();
		
			for ( int i = 1; i < 10000000 ; i ++ ) {
				inputcode = line + i ;
				//System.out.println(" input "  + inputcode ) ;
				md5 = getMD5(inputcode) ;
				//System.out.println( i + "  do  "  +  md5 ) ;
				
				if ( md5.startsWith("000000")){
					System.out.println(" input "  + inputcode ) ;
					System.out.println( i + "  do  "  +  md5 ) ;
					
					System.out.println(" start with 0 , value  " + i + "  result md5 : " + md5 ) ;
				break ;
				}
				
				
				
				
			}
			
			
			System.out.println( md5 ) ;
		 // line = "Solver 4 ok" ;
		return md5;
		}catch (IOException e) {
			// TODO Auto-generated catch block
		
			throw new IllegalArgumentException("Unable to load " + sfname, e);
			//e.printStackTrace();
		}
	}	
	
	static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
 
 
    
}
