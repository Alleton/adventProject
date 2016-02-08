package com.alleton.adventProject.model;

public class Solver21Item {
	private String name ;
	 private int cost;
	 private int damage;
	 private int armor;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	/**
	 * @return the armor
	 */
	public int getArmor() {
		return armor;
	}
	/**
	 * @param armor the armor to set
	 */
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public String itemToString() {
		//String line = "";
		//int nbr = this.nbr_routes ;
		
		StringBuilder builder = new StringBuilder();
		builder.append( " name    = " + this.getName()    + " : " ) ;
		builder.append( " cost    =  " + this.getCost()   + " : " ) ;
		builder.append( " Damage  =  " + this.getDamage() + " : " ) ;
		builder.append( " Armor   =  " + this.getArmor()  + " :"  ) ;
		
		return  builder.toString();
		
	}
}
