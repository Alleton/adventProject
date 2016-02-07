package com.alleton.adventProject.service;

public class Chrono {
	 private long deb,fin;
	  /** Methode qui permet de demarrer le chronometre
	   */
	  public void start(){
		   deb = (long)System.currentTimeMillis();
	  }
	  /** Methode qui retourne le temps ecoulé depuis le demarrage du chronomètre
	   *@return long representant le temps ecoule
	   */
	  public long getTimeElapsed(){
	    return ( (long)System.currentTimeMillis() ) -deb;
	  }
	  /** Methode qui stop le chronomètre et conserve le temps ecoule depuis son demarrage
	   */
	  public void stop(){
	    fin=System.currentTimeMillis();
	  }
	  /** Methode qui retourne le temps ecoule entre le demarrage(methode start()) et l'arret du chronomètre (methode stop())
	   *@return long représentant le temps ecoule
	   */
	  public long getFinalTimeElapsed(){
	    return ( getTimeElapsed() - deb );
	  }
}
