package com.alleton.adventProject.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Vector;

/*import org.json.JSONTokener;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
//import org.json.
 * 
 */
import com.fasterxml.jackson.core.JsonFactory ;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.FileInputStream;



import javax.json.*;

import com.alleton.adventProject.model.Solver12object;


public class Solver12 {

	String  line = new String("");
	int linel = 0;
	char thischar ;
	int resultat =0;
	int resultat2 =0;
	
	Vector<Solver12object> nos_objets  = new Vector<Solver12object>  (500);
	

	public int solver12 (String sfname){
		
		//String line ;
		long tStart ;

		try {
			FileReader filereader = new FileReader(sfname);

			BufferedReader reader = new BufferedReader(filereader);
			/* lecture ligne  */
			tStart = System.nanoTime();


			while ((line = reader.readLine()) != null) {
				//System.out.println(" line " + line );
				linel = line.length() ;
				resultat = parseline();         // appel de parseline simple
				long tEnd = System.nanoTime();
				double tDelta =  (double) (tEnd - tStart);
				System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );

				System.out.println(parseline2(line));
				//
				
			}

			long tEnd = System.nanoTime();
			double tDelta =  (double) (tEnd - tStart);
			System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );

			
			
			reader.close();
			filereader.close();

		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to load " + sfname, e);
			//e.printStackTrace();
		}
		
		long tEnd = System.nanoTime();
		double  tDelta =  (double) (tEnd - tStart);
		System.out.println(" duree en sec " + ( tDelta / 1000000000.0 ) );


		return resultat ;
	} // end solver12
	
	private int parseline () {
		//System.out.println(" parseline " + line );
		int numberlength = 0;
		
		for ( int i = 0 ; i< linel ; i++){
			//System.out.println(" parseline i    = " + i );
			//System.out.println(" parseline char = " + line.charAt( start + i  ) );
			
			if ( !Character.isDigit( line.charAt(  i  ) ) && line.charAt( i ) != '-' ) {
				 // pas un digit ni le signe moins
				// rien, 
			 } else {
				 // we found a first char as probably digit  .. minus signe pb 
				 StringBuffer  newnumberString = new StringBuffer(line.charAt(  i ));
				 newnumberString.append(line.charAt( i )) ;
				 numberlength = 0 ;
				 for ( int j = 1 ; j <  linel   ; j++) {
					 //i++ ;         // on est passe au char suivant
					 if ( !Character.isDigit( line.charAt(  i  +j ) ) ) {
						 // pas un digit
						 // break this inside loop
						 break ;
					 } else {
						 // continue
						 newnumberString.append(line.charAt( i+j )) ;
						 numberlength ++ ;
						 // next we continue 
						 
					 } // else  !Character.isDigit( line.charAt( start + i  +j  
					 
				 } // end for j
				 i = i + numberlength ; 
				 // resultat a memoriser
				 //System.out.println("number == " + newnumberString ) ;
				 resultat = resultat +  Integer.parseInt(newnumberString.toString());
				 //System.out.println("resultat == " + resultat ) ;
			 } // end else !Character.isDigit( line.charAt( start + i  ) )
			
		} // end for ( int i = 0 ; i< linel-start ; i++){
		
		
		return resultat ;
	}
	

	private int parseline2 ( String line) {
		// System.out.println(" parseline " + line );
		int resultat2 = 0 ;
		int numberlength = 0;
		//String keylist = new String[];
		String key ;
		String valeur;
		int    valint;
		int obj_nbr  = 0 ; //  start object will be 1
		int obj_curr = 0 ; // current object is 0
		
// objet root
        // new Solver12object
        // Solver12object solver12object = new Solver12object();
        // add it to nos_objets
        //nos_objets.addElement(solver12object);

		
		
	      try{

	    	  JsonFactory f = new JsonFactory();
	    	     JsonParser parser = f.createParser(line);
	    	     JsonToken token = parser.nextToken();
	    	     
	    	     // c reate first object 
	    	     Solver12object solver12object0 = new Solver12object();
  	           solver12object0.setEnclosing_object(0);
  	           solver12object0.setValeur(0);
  	           solver12object0.setValide(true);
  	           // add it to nos_objets
  	           System.out.println("initial  Object : " + solver12object0.toString() ) ;
  	           nos_objets.add( solver12object0);
  	           
	    	     while (token != null) {
	    	        if (token.equals(JsonToken.START_ARRAY)) {
	    	           // System.out.println("Start Array : " + token.toString());
		    	           Solver12object solver12object = new Solver12object(); 
		    	           solver12object = (Solver12object) nos_objets.get(obj_curr) ;
		    	           solver12object.setArray_depth(solver12object.getArray_depth() + 1  );
		    	           // memorise
		    	           nos_objets.set(obj_curr, solver12object) ;
		    	           

	    	        } else if (token.equals(JsonToken.END_ARRAY)) {
	    	           // System.out.println("End Array : " + token.toString());
		    	           // System.out.println("Start Array : " + token.toString());
		    	           Solver12object solver12object = new Solver12object(); 
		    	           solver12object = (Solver12object) nos_objets.get(obj_curr) ;
		    	           solver12object.setArray_depth(solver12object.getArray_depth() - 1  );
		    	           // memorise
		    	           nos_objets.set(obj_curr, solver12object) ;

	    	        } else if (token.equals(JsonToken.START_OBJECT)) {
	    	          // System.out.println("Start Object : " + token.toString());
	    	           //new Solver12object
	    	           //Solver12object solver12object = new Solver12object();
	    	           // set enclosing 
	    	           obj_nbr = obj_nbr + 1 ;                       // il y a un nouvel objet
	    	           Solver12object solver12object = new Solver12object();
	    	           solver12object.setEnclosing_object(obj_curr);
	    	           solver12object.setValeur(0);
	    	           solver12object.setValide(true);
	    	           // add it to nos_objets
	    	           System.out.println("Start Object : " + solver12object.toString() ) ;
	    	           nos_objets.add( solver12object);
	    	           // objetc courant = dernier objet du vecteur
	    	           obj_curr = obj_nbr ; 
	    	           System.out.println("Start Object : " + token.toString() + obj_curr );
	    	           System.out.println("Start Object : " + solver12object.toString() ) ;
	    	           
	    	           
	    	        } else if (token.equals(JsonToken.END_OBJECT)) {
	    	           System.out.println("End Object : " + token.toString() + " : " +  obj_curr );
	    	           // objet courant == enclosing
	    	           Solver12object solver12object = new Solver12object(); 
	    	           solver12object = (Solver12object) nos_objets.get(obj_curr) ;
	    	           
	    	           obj_curr = solver12object.getEnclosing_object() ;
	    	           
	    	           solver12object = (Solver12object) nos_objets.get(obj_curr) ; 
	    	           System.out.println("Continue with Object : " + solver12object ) ;
	    	           System.out.println("Continue Object : "  + obj_curr );
	    	           
	    	           
	    	        
	    	        } else if (token.equals(JsonToken.FIELD_NAME)) {
	    	           //System.out.println("Field Name : " + token.toString());
	    	           //String fieldname = parser.getCurrentName();
	    	           //System.out.println("Field Name : " + fieldname);
	    	           
	    	        } else if (token.equals(JsonToken.VALUE_FALSE)) {
	    	           //System.out.println("Value False : " + token.toString());
	    	        } else if (token.equals(JsonToken.VALUE_NULL)) {
	    	           //System.out.println("Value Null : " + token.toString());
	    	        } else if (token.equals(JsonToken.VALUE_NUMBER_FLOAT)) {
	    	           //System.out.println("Value Number Float : " + token.toString());
	    	        
	    	        } else if (token.equals(JsonToken.VALUE_NUMBER_INT)) {
	    	          //System.out.println("Value Number Int : " + token);
	    	          resultat2 = resultat2 + parser.getIntValue()  ;
	    	          Solver12object solver12object = new Solver12object(); 
	    	          solver12object = (Solver12object) nos_objets.get(obj_curr) ;
	    	          solver12object.setValeur( solver12object.getValeur() + parser.getIntValue()   );
	    	           // memorise
	    	           nos_objets.set(obj_curr, solver12object) ;
	    	           
	    	          
	    	          
	    	          
	    	        //getIntValue
	    	          
	    	        } else if (token.equals(JsonToken.VALUE_STRING)) {
	    	           //System.out.println("Value String : " + token);
	    	           String value_string = parser.getValueAsString() ;
	    	           //System.out.println("Value Name : " + value_string );
	    	           if (value_string.equals("red")){
	    	        	   System.out.println("Value red !!!");
	    	        	   Solver12object solver12object = new Solver12object(); 
	 	    	           solver12object = (Solver12object) nos_objets.get(obj_curr) ;
	 	    	           if ( solver12object.getArray_depth() == 0  ) {
	 	    	        	   // not in an array
	 	    	        	  System.out.println("Value red !!! object " + obj_curr  );
	 	    	        	  solver12object.setValide(false);
	 	    	        	 System.out.println("Value red !!! object " + solver12object.toString()  );
	 	    	        	// memorise
	 		    	           nos_objets.set(obj_curr, solver12object) ;
	 		    	           
	 	    	           }
	 	    	          
	    	        	   
	    	           }
	    	        
	    	        } else if (token.equals(JsonToken.VALUE_TRUE)) {
	    	           //System.out.println("Value True : " + token.toString());
	    	        } else {
	    	           System.out.println("Something else : " + token.toString());
	    	        }
	    	        
	    	        System.out.println("lecture next token " ) ;
	    	        token = parser.nextToken();
	    	     }
	    	     
	    	     System.out.println("resultat2 : " + resultat2);
	    	     
	    	     //  
	    	     // if a objet is invalid so are his childrens ..
	    	     for ( int i =0  ; i< nos_objets.size() ; i ++ ) {
	    	    	 //System.out.println ( nos_objets.get(i).toString());
	    	    	 
	    	    	 if ( !nos_objets.get(i).isValide()  ) {
	       	        	invalidate_childs (i) ; // recursif
	       	           	}
	    	    	 }

	    	     
	    	     
	    	     // comptage
	    	     int compteur = 0 ;
	    	     for ( int i =0  ; i< nos_objets.size() ; i ++ ) {
	    	    	 //System.out.println ( nos_objets.get(i).toString());
	    	    	 
	    	    	 if ( nos_objets.get(i).isValide()) {
	    	    		 compteur = compteur + nos_objets.get(i).getValeur() ;	 
	    	    	 } else {
	    	    		 System.out.println ( nos_objets.get(i).getValeur() ) ;
	    	    	 }
	    	    	 
	    	     }
	    	     System.out.println("resultat2 compte = " + compteur);
	    	     
	      }catch(Exception pe){
	  		
	          //System.out.println("position: " + pe.getPosition());
	          System.out.println(pe);
	       }

		
		
		// System.out.println("resultat2 == " + resultat2 ) ;
		return numberlength ;
	} // end parseline2

	void  invalidate_childs ( int childrenof) {
		 // if a objet is invalid so are his childrens ..
	     for ( int i =0  ; i< nos_objets.size() ; i ++ ) {
	    	 //System.out.println ( nos_objets.get(i).toString());
	    	 
	    	 if ( nos_objets.get(i).getEnclosing_object() == childrenof ) {
	    		Solver12object solver12object = new Solver12object(); 
   	           	solver12object = (Solver12object) nos_objets.get(i) ;
   	            solver12object.setValide(false);
   	        	nos_objets.set(i, solver12object) ;
   	        	invalidate_childs (i) ; // recursif
	    	           
   	           	}
	    	 }
		
	}
	
	
} // end class
