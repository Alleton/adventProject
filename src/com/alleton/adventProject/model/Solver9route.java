package com.alleton.adventProject.model;

public class Solver9route {
	  private String townfrom  ;
	  private String townto  ;
	  private int distance;
	  /*
	    * getter and setters
	    */
	   public String getTownfrom () {
		   return   this.townfrom  ;
	   }
	   public void setTownfrom ( String townfrom){
		   this.townfrom =  townfrom ;
	   }
	   
	   public String getTownto () {
		   return   this.townto  ;
	   }
	   public void setTownTo( String to){
		   this.townto =  to ;
	   } 
	   
	   
	   public int getDistance ( ){
		   return this.distance;
	   }
	   
	   public void setDistance ( int distance){
		   this.distance =   distance;
	   }
	   
	   
	   public String toString(){
			return "{"+ this.getTownfrom() +" à "+ this.getTownto() +  " -dist: " + this.distance + "}";
		    }
}
