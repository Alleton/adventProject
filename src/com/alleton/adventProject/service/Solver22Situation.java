package com.alleton.adventProject.service;

import java.util.Vector;

import com.alleton.adventProject.model.Solver22Spell;

public class Solver22Situation {

	Vector<Solver22Spell> myspells ;
	int myPoints ;
	int bossPoints;
	int myMana ;
	/**
	 * @return the myMana
	 */
	public int getMyMana() {
		return myMana;
	}
	/**
	 * @param myMana the myMana to set
	 */
	public void setMyMana(int myMana) {
		this.myMana = myMana;
	}
	/**
	 * @return the myspells
	 */
	public Vector<Solver22Spell> getMyspells() {
		return myspells;
	}
	/**
	 * @param myspells the myspells to set
	 */
	public void setMyspells(Vector<Solver22Spell> sourceSpells) {
		//this.myspells = myspells.deepCopy();
		
		Vector<Solver22Spell> spells = new Vector<Solver22Spell> () ;
		
		for ( int i = 0 ; i < sourceSpells.size() ; i++) {
			// this.myspells.elementAt(i) = sourceSpells.
			// System.out.println(sourceSpells.elementAt(i).spellToString());
			//this.myspells.setElementAt( sourceSpells.elementAt(i).deepCopy() , i);
			//this.myspells.elementAt(i) = sourceSpells.elementAt(i).deepCopy();
			//this.myspells.addElement(sourceSpells.elementAt(i).deepCopy());
			//spells.addElement(sourceSpells.elementAt(i).deepCopy());
			spells.insertElementAt(sourceSpells.elementAt(i).deepCopy(), i);;
		}
		this.myspells = (Vector<Solver22Spell>) spells.clone() ;
	
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
	
	
	public String situationToString() {
		//String line = "";
		//int nbr = this.nbr_routes ;
		
		StringBuilder builder = new StringBuilder();
		builder.append( "spells    = "  ) ;
		builder.append( "\n");
		for ( int i = 0 ; i< this.getMyspells().size() ; i ++) {
			builder.append( this.getMyspells().elementAt(i).spellToString() );
			builder.append( "\n");
		}
		builder.append( "Points \n");
		builder.append( "myPoints    = " + this.getMyPoints()  + "  : " ) ;
		builder.append( "\n");
		builder.append( "bossPoints    = " + this.getBossPoints()  + "  : " ) ;
		builder.append( "\n");
		builder.append( "myMana        = " + this.getMyMana() + ". \n\n " );
		return  builder.toString();
		
	}
	
	@Override
	public String toString() {
		return situationToString();
	}

	
	
}  // class
