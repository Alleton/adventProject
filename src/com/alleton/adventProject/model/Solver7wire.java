package com.alleton.adventProject.model;

public class Solver7wire {
   private String wirename  ;
   private String entry1    ;
   private String entry2    ;
   private int entry1value  ;
   private int entry2value  ;
   private boolean entry1done ;   // true when entry1 calculated
   private boolean entry2done ;   // true when entry2 calculated
   private String operation ;
   private int nboperateurs ;  // 0 pour affectation , 1 pour unaire , 2 binaire 
   private int   wirevalue  ;
   private boolean wiredone ;   // true when wirevalue calculated
   
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
   
   public int getEntry1value (){
	   return entry1value;
   }
   public void setEntry1value ( int entry){
	   this.entry1value = entry ;
   }
   
   public int getEntry2value (){
	   return entry2value;
   }
   public void setEntry2value ( int entry){
	   this.entry2value = entry ;
   }
   
   public boolean getEntry1Done (){
	   return entry1done;
   }
   public void setEntry1Done( boolean entry){
	   this.entry1done = entry ;
   }
   public boolean getEntry2Done (){
	   return entry2done;
   }
   public void setEntry2Done( boolean entry){
	   this.entry2done = entry ;
   }
   
   public String getOperation() {
	   return operation;
   }
   
   public void setOperation ( String oper){
	   this.operation = oper ;
   }
   
   public int getWirevalue (){
	   return wirevalue;
   }
   public void setWirevalue ( int entry){
	   this.wirevalue = entry ;
   }
   
   public int getNboper (){
	   return nboperateurs;
   }
   public void setNboper ( int entry){
	   this.nboperateurs = entry ;
   }
   
   public boolean getDone (){
	   return wiredone;
   }
   public void setDone( boolean entry){
	   this.wiredone = entry ;
   }
   
   
} // end Solver7wire
