package com.alleton.adventProject.model;

public class Solver7circuit {
	private Solver7wire[] solver7wires ;
	private int circuitsize = 339 ;
	
	public Solver7circuit () {
		solver7wires = new Solver7wire [circuitsize] ;
	}
	
	
	/**
	 * Setter and getters
	 * @param solver7wires
	 */
	
	public Solver7wire[] getSolver7wire () {
		return solver7wires;
	}
	
	public void setSolver7wires( Solver7wire[] solver7wires){
		this.solver7wires = solver7wires ;
	}
	
	
	public int getCircuitSize() {
		return circuitsize;
	}

	public void setCircuitSize(int size) {
		this.circuitsize = size;
	}
	
	/**
	 * display wires
	 */
	
	public String circuitToString() {
		//String line = "";
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n");	
		for (int i = 0; i < this.getCircuitSize(); i++) {
			builder.append(" (" + i +") ");
				
			// builder.append("\r\n");		
		
			Solver7wire wire = this.solver7wires[i] ;
			
			//System.out.println( line ) ;
			builder.append( wire.getWirename()    + "  = " ) ;
			builder.append( wire.getEntry1()      + "  : " ) ; 
			builder.append( wire.getEntry1value() + "  : " ) ;
			builder.append( wire.getEntry1Done()  + "  : " ) ;
			builder.append( wire.getEntry2()      + "  : " ) ; 
			builder.append( wire.getEntry2value() + "  : " ) ;
			builder.append( wire.getEntry2Done()  + "  : " ) ;
			builder.append( wire.getOperation()   + "  : " ) ;
			builder.append( wire.getNboper ()     + "  : " ) ;
			builder.append ( wire.getDone()       + "  : " ) ;
			builder.append( wire.getWirevalue()   + "  : " ) ;
			
			builder.append("\r\n");
		}
		return  builder.toString();
		
	}
	
	@Override
	public String toString() {
		return circuitToString();
	}
	
}
