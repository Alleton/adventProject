package com.alleton.adventProject.model;

public class Solver14rennes {
	private String renne;
	private int vitesse;
	private int endurance;  // temps pendant le quel il peut courir
	private int respos ;      // temps de repos
	private int points ;      // nombre de points gagnes ( part2)
	private int temps_course;
	private int temps_repos;
	private int parcouru;
	
	
	/**
	 * Getters and Setters
	 * 
	 */
	public String getRenne() {
		return renne;
	}
	public void setRenne(String renne) {
		this.renne = renne;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	public int getRespos() {
		return respos;
	}
	public void setRespos(int respos) {
		this.respos = respos;
	}
	

	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	

	public int getTemps_course() {
		return temps_course;
	}
	public void setTemps_course(int temps_course) {
		this.temps_course = temps_course;
	}
	public int getTemps_repos() {
		return temps_repos;
	}
	public void setTemps_repos(int temps_repos) {
		this.temps_repos = temps_repos;
	}


	public int getParcouru() {
		return parcouru;
	}
	public void setParcouru(int parcouru) {
		this.parcouru = parcouru;
	}

	
	public String renneToString() {
		//String line = "";
		//int nbr = this.nbr_routes ;
		
		StringBuilder builder = new StringBuilder();
		builder.append( " name    = " + this.getRenne()  + "  : " ) ;
		//builder.append( " vitesse = " + this.getVitesse()  + "  : " ) ;
		//builder.append( " Endurance = " + this.getEndurance()  + "  : " ) ;
		//builder.append( " Repos    =  " + this.getRespos()  + "  = " ) ;
		builder.append( " temp Repos    =  " + this.getTemps_repos() + " : " ) ;
		builder.append( " temp course   =  " + this.getTemps_course() + " : " ) ;
		builder.append( " parcouru      =  " + this.getParcouru() + " :"  ) ;
		builder.append( " Points   =  " + this.getPoints()  + "  = " ) ;
		
		return  builder.toString();
		
	}

	@Override
	public String toString() {
		return renneToString();
	}

}
