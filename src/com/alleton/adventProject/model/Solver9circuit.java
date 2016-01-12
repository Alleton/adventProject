package com.alleton.adventProject.model;

import java.util.Vector;

public class Solver9circuit {
	private Solver9route[] solver9routes;
	private int nbr_routes = 28 ;
	public Vector<String> v_towns = new Vector<String>();
	public int longueur ;
	private int maxi ;
	
	
	/* 
	 * Constructeur
	 */
	public Solver9circuit () {
		solver9routes  = new Solver9route [nbr_routes];
	}
	/**
	 * Setter and getters
	 * @param solver7wires
	 */
	
	public Solver9route[] getSolverroute () {
		return solver9routes;
	}

	public void setSolver9route (Solver9route[] solver9routes){
		this.solver9routes = solver9routes ;
	}
	
	public int getRoutesNbr() {
		return nbr_routes;
	}

	public void setRouteNbr(int size) {
		this.nbr_routes = size;
	}
	
	
	public int getlongueur() {
		return longueur;
	}

	public void setlongueur(int longueur) {
		this.longueur = longueur;
	}
	
	public int getmaxi() {
		return maxi;
	}

	public void setmaxi(int maxi) {
		this.maxi = maxi;
	}
	
	
	public String circuitToString() {
		//String line = "";
		//int nbr = this.nbr_routes ;
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n");	
		for (int i = 0; i < this.getRoutesNbr(); i++) {
			builder.append(" (" + i +") ");
				
			
			Solver9route route = this.solver9routes[i] ;
			
			builder.append( route.getTownfrom()    + "  = " ) ;
			builder.append( route.getTownto()    + "  : " ) ; 
			builder.append( route.getDistance() + "  : " ) ;
			
			
			builder.append("\r\n");
			
		}
		
		builder.append("Vector Towns");
		builder.append (this.v_towns) ;
		builder.append("\r\n");
		
		builder.append("Trajet  Towns");
		builder.append (this.longueur) ;
		builder.append("\r\n");
		
		
		return  builder.toString();
		
	}

	@Override
	public String toString() {
		return circuitToString();
	}
	
}
