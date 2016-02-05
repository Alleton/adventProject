package com.alleton.adventProject.model;

public class Solver22Spell {

	String spellName;
	int spellCost ;
	int spellDamage;
	int spellHealing;
	int spellArmor;
	int spellLasting;
	int spellRecharge;
	


	/**
	 * @return the spellName
	 */
	public String getSpellName() {
		return spellName;
	}

	/**
	 * @param spellName the spellName to set
	 */
	public void setSpellName(String spellName) {
		this.spellName = spellName;
	}

	/**
	 * @return the spellCost
	 */
	public int getSpellCost() {
		return spellCost;
	}

	/**
	 * @param spellCost the spellCost to set
	 */
	public void setSpellCost(int spellCost) {
		this.spellCost = spellCost;
	}

	/**
	 * @return the spellDamage
	 */
	public int getSpellDamage() {
		return spellDamage;
	}

	/**
	 * @param spellDamage the spellDamage to set
	 */
	public void setSpellDamage(int spellDamage) {
		this.spellDamage = spellDamage;
	}

	/**
	 * @return the spellHealing
	 */
	public int getSpellHealing() {
		return spellHealing;
	}

	/**
	 * @param spellHealing the spellHealing to set
	 */
	public void setSpellHealing(int spellHealing) {
		this.spellHealing = spellHealing;
	}

	/**
	 * @return the spellArmor
	 */
	public int getSpellArmor() {
		return spellArmor;
	}

	/**
	 * @param spellArmor the spellArmor to set
	 */
	public void setSpellArmor(int spellArmor) {
		this.spellArmor = spellArmor;
	}

	/**
	 * @return the spellLasting
	 */
	public int getSpellLasting() {
		return spellLasting;
	}

	/**
	 * @param spellLasting the spellLasting to set
	 */
	public void setSpellLasting(int spellLasting) {
		this.spellLasting = spellLasting;
	}

	/**
	 * @return the spellRechage
	 */
	public int getSpellRecharge() {
		return spellRecharge;
	}

	/**
	 * @param spellRechage the spellRechage to set
	 */
	public void setSpellRecharge(int spellRecharge) {
		this.spellRecharge = spellRecharge;
	}
	
	/*
	 * Getters & Setters
	 */
	
	public Solver22Spell deepCopy (){
		Solver22Spell item = new Solver22Spell();
		
		item.setSpellName    (this.getSpellName()  ) ;
		item.setSpellCost    (this.getSpellCost()   );
		item.setSpellDamage    (this.getSpellDamage()  ) ;
		item.setSpellHealing    (this.getSpellHealing())   ;
		item.setSpellArmor   (this.getSpellArmor()   );
		item.setSpellLasting   (this.getSpellLasting())   ;
		item.setSpellRecharge   (this.getSpellRecharge())  ;
		
		
		return item;
	}
	
	
	public String spellToString() {
		//String line = "";
		//int nbr = this.nbr_routes ;
		
		StringBuilder builder = new StringBuilder();
		
		builder.append( "n = " + this.getSpellName()  + "  : " ) ;
		//builder.append( "c = " + this.getSpellCost()  + "  : " ) ;
		//builder.append( "D = " + this.getSpellDamage()  + "  : " ) ;
		//builder.append( "H = " + this.getSpellHealing()  + "  : " ) ;
		// builder.append( "A = " + this.getSpellArmor()  + "  : " ) ;
		builder.append( "L  = " + this.getSpellLasting()  + "  : " ) ;
		// builder.append( "R  = " + getSpellRecharge()  ) ;
		
		return  builder.toString();
		
	}
	
	@Override
	public String toString() {
		return spellToString();
	}

	
}
