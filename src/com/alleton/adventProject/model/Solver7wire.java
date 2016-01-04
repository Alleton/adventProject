package com.alleton.adventProject.model;

public class Solver7wire {
   private String wirename ;
   private String entry1   ;
   private String entry2   ;
   private int entryvalue  ;
   private String operation ;
   
   /*
    * getter and setters
    */
   public String getWirename () {
	   return wirename;
   }
   public void setWirename ( String wire){
	   this.wirename =  wire ;
   }
   
   public String getEntry1() {
	   return entry1;
   }
   
   public void setEntry1 ( String entry){
	   this.entry1 = entry ;
   }
   
   public String getEntry2() {
	   return entry2;
   }
   
   public void setEntry2 ( String entry){
	   this.entry2 = entry ;
   }
   
   public int getEntryvalue (){
	   return entryvalue;
   }
   public void setEntryvalue ( int entry){
	   this.entryvalue = entry ;
   }
   
   public String getOperation() {
	   return operation;
   }
   
   public void setOperation ( String oper){
	   this.operation = oper ;
   }
   
   
} // end Solver7wire
