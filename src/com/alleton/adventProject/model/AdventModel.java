package com.alleton.adventProject.model;




import java.util.Observable;

public class AdventModel extends Observable{
    private boolean existe;

    void setExiste(boolean existe) {
	this.existe = existe;
	setChanged();
	notifyObservers();
    } 

    
    boolean getExiste() {
	return existe;
    }   
}

