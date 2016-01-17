package com.alleton.adventProject.model;

//import java.util.Vector;



public class Solver13convives {
	private String first ;
	private String second ;
	private int    happy  ;
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public int getHappy() {
		return happy;
	}
	public void setHappy(int happy) {
		this.happy = happy;
	}
	
	   public String toString(){
		   return ( this.getFirst() + " next to " + this.getSecond() + " gives " + this.getHappy()) ;
	   }
}
