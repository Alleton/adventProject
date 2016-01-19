package com.alleton.adventProject.model;

public class Solver12object {
	private int enclosing_object ;	// le num de papa
	private int valeur ;  			// la valeur de cete objet 
	private boolean valide ;		// true si pas red
	private int array_depth;		// profondeur array
	
	
	

	public int getEnclosing_object() {
		return enclosing_object;
	}
	public void setEnclosing_object(int enclosing_object) {
		this.enclosing_object = enclosing_object;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public int getArray_depth() {
		return array_depth;
	}
	public void setArray_depth(int array_depth) {
		this.array_depth = array_depth;
	}
	
	
	public String object12ToString() {
		//String line = "";
		
		StringBuilder builder = new StringBuilder();
			
				
			// builder.append("\r\n");		
		
			
			//System.out.println( line ) ;
			builder.append( "papa   "  + this.getEnclosing_object()     + "  : " ) ; 
			builder.append( "value  "  + this.getValeur() + "  : " ) ;
			builder.append( "valide "  + this.isValide() + "  : " ) ;
			builder.append( "array  "  + this.getArray_depth()  + ":" ) ;
			builder.append("\r\n");
		return  builder.toString();
		
	}
	
	@Override
	public String toString() {
		return object12ToString();
	}
}
