package com.alleton.adventProject.model;


public class Solver22Situation {

	
	private int[] remainingArray = new int[5];  // 
	private int myPoints ;
	private int bossPoints;
	private int myMana ;
	private int level;
	private int spend ;
	private int armor ;
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
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the myMana
	 */
	public int getMyMana() {
		return myMana;
	}

	/**
	 * @return the remainingArray
	 */
	public int[] getRemainingArray() {
		return remainingArray;
	}
	/**
	 * @param remainingArray the remainingArray to set
	 */
	public void setRemainingArray(int[] remainingArray) {
		this.remainingArray = remainingArray;
	}
	/**
	 * @return the spend
	 */
	public int getSpend() {
		return spend;
	}
	/**
	 * @param spend the spend to set
	 */
	public void setSpend(int spend) {
		this.spend = spend;
	}
	
	/**
	 * @param myMana the myMana to set
	 */
	public void setMyMana(int myMana) {
		this.myMana = myMana;
	}

	/**
	 * @return the myPoints
	 */
	public int getMyPoints() {
		return myPoints;
	}
	/**
	 * @param myPoints the myPoints to set
	 */
	public void setMyPoints(int myPoints) {
		this.myPoints = myPoints;
	}
	/**
	 * @return the bossPoints
	 */
	public int getBossPoints() {
		return bossPoints;
	}
	/**
	 * @param bossPoints the bossPoints to set
	 */
	public void setBossPoints(int bossPoints) {
		this.bossPoints = bossPoints;
	}
	
	public void copyArray (Solver22Situation sourceSituation) {
		for (int i = 0 ; i< this.getRemainingArray().length ; i ++ ) {
			 this.getRemainingArray()[i] = sourceSituation.getRemainingArray()[i] ;
		}
	}
	
	
	public String situationArray(){
		StringBuilder builder = new StringBuilder();
		builder.append( "spells  lasting  = "  ) ;

		for (int i = 0 ; i< this.getRemainingArray().length ; i ++ ) {
			builder.append( this.getRemainingArray()[i] + " ") ;
		}
		builder.append( "\n");

		return  builder.toString();
	}
	
	public String situationToString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0 ; i< this.getRemainingArray().length ; i ++ ) {
			builder.append( this.getRemainingArray()[i] + " ") ;
		}
		
		builder.append( "\n");
		builder.append( "me = " + this.getMyPoints()   + "  : \n" ) ;
		builder.append( "bo = " + this.getBossPoints() + "  : \n" ) ;
		builder.append( "Ma = " + this.getMyMana()     + "  : \n" );
		builder.append( "Ar = " + this.getArmor()      + "  : \n" );
		builder.append( "Sp = " + this.getSpend()      + "  : \n\n " );
		return  builder.toString();
		
	}
	
	public String situationToStringDetail() {
		//String line = "";
		//int nbr = this.nbr_routes ;
		
		StringBuilder builder = new StringBuilder();
		builder.append( "spells    = "  ) ;
		builder.append( "\n");

		for (int i = 0 ; i< this.getRemainingArray().length ; i ++ ) {
			builder.append( this.getRemainingArray()[i] + " ") ;
		}
		
		builder.append( "\n");
		
		builder.append( "Points \n");
		builder.append( "level      = " + this.getLevel()      + "  : \n" ) ;
		builder.append( "myPoints   = " + this.getMyPoints()   + "  : \n" ) ;
		builder.append( "bossPoints = " + this.getBossPoints() + "  : \n" ) ;
		builder.append( "myMana     = " + this.getMyMana()     + "  : \n " );
		builder.append( "Ar = " + this.getArmor()      + "  : \n" );
		builder.append( "Spent      = " + this.getSpend()      + "  : \n\n " );
		return  builder.toString();
		
	}
	@Override
	public String toString() {
		return situationToString();
	}

	
	
}  // class
