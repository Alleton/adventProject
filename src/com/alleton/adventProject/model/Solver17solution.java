package com.alleton.adventProject.model;

import java.util.Vector;

public class Solver17solution {
	private Vector<Integer> une_solutions = new Vector<Integer>() ;

	public Solver17solution() {	
	}
	
	public Solver17solution(Vector<Integer> solution) {	
		this.une_solutions = (Vector<Integer>) solution.clone() ;
	}

	
	/**
	 * @return the une_solutions
	 */
	public Vector<Integer> getUne_solutions() {
		return une_solutions;
	}

	/**
	 * @param une_solutions the une_solutions to set
	 */
	public void setUne_solutions(Vector<Integer> une_solutions) {
		this.une_solutions = une_solutions;
	}

	public void addunElement(Integer recip) {
		// TODO Auto-generated method stub
		// this.addElement(recip);
		this.une_solutions.addElement(recip);
	}

	public int size () {
		return this.une_solutions.size() ;
	}

	public void removeLast () {
		this.une_solutions.remove(this.une_solutions.size()-1) ;
	}

	
	public String ToString () {
		return this.une_solutions.toString() ;
	}
	
	public void clear () {
		this.une_solutions.clear();
	}
	
	public Vector<Integer> clone () {
		return this.une_solutions  ;
	}
	
}
