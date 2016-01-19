package com.alleton.adventProject.model;

import java.util.Vector;

public class Solver13table {
	//private Solver9route[] solver9routes;
	public Solver13convives[] v_convives ;
	public Vector<String> v_personnes = new Vector<String>();
	private int maxi ;
	private int mini ;
	private int nblignes;
	

	/* 
	 * Constructeur
	 */
	public Solver13table () {
		v_convives  = new Solver13convives [160];
	}
	
	/*
	 * getters and setters
	 */
	
	
	public Solver13convives[] getV_convives() {
		return v_convives;
	}


	public void setV_convives(Solver13convives[] v_convives) {
		this.v_convives = v_convives;
	}


	
	public int getMaxi() {
		return maxi;
	}


	public void setMaxi(int maxi) {
		this.maxi = maxi;
	}

	public int getMini() {
		return mini;
	}

	public void setMini(int mini) {
		this.mini = mini;
	}

	
	public Vector<String> getV_personnes() {
		return v_personnes;
	}

	public void setV_personnes(Vector<String> les_personnes) {
		this.v_personnes = les_personnes;
	}
	public int getNblignes() {
		return nblignes;
	}

	public void setNblignes(int nblignes) {
		this.nblignes = nblignes;
	}

	
	
	public String convivesToString() {
		//String line = "";
		//int nbr = this.nbr_routes ;
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n");	
		for (int i = 0; i < this.v_personnes.size()         ; i++) {
			//builder.append(" (" + i +") ");
				
			
			builder.append( this.v_personnes.get(i)   + "  = " ) ;
			
			
			builder.append("\r\n");
		}
			
		
		builder.append("La liste des happynes \r\n");
		for ( int i =0  ; i < this.nblignes ; i ++) {
			builder.append( this.getV_convives()[i] ) ;
			builder.append("\r\n");
		}
		
		builder.append("Vector maxi");
		builder.append (this.maxi) ;
		builder.append("\r\n");
		
		builder.append("Trajet  mini");
		builder.append (this.mini) ;
		builder.append("\r\n");
		
		
		return  builder.toString();
		
	}

	@Override
	public String toString() {
		return convivesToString();
	}

}
