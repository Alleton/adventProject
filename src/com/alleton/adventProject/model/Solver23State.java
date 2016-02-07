package com.alleton.adventProject.model;

/*
 * Machine a etat fini
 */
public class Solver23State {
	
	 int[] reg = new int[2];
	int step ; // le step du programme
	/**
	 * @return the rega
	 */

	/**
	 * @return the step
	 */
	public int getStep() {
		return step;
	}
	/**
	 * @param step the step to set
	 */
	public void setStep(int step) {
		this.step = step;
	}
	

	public int apply ( String instruction , String param1 , int param2 ) {
		System.out.println("apply " + instruction + " " + param1 );
		int registre = 0;
		switch ( param1) {
		case "a":
			registre = 0 ;
			break;
		case "b":
			registre = 1 ;
		break;
		}
		
		switch ( instruction) {
			case "inc" :
				reg[registre] ++ ;
				this.setStep(this.getStep() + 1);
				break ;
			case "hlf" :
				reg[registre] = reg[registre] / 2  ;
				this.setStep(this.getStep() + 1);
				break ;

			case "tpl" :
				reg[registre] = reg[registre] * 3  ;
				this.setStep(this.getStep() + 1);
				break ;
			case "jmp" :
				this.setStep(this.getStep() + Integer.parseInt(param1));
				break ;
			case "jie" :
				if (reg[registre] %2 == 0  ) {
					this.setStep(this.getStep() + param2);
				} else {
					this.setStep(this.getStep() + 1);
				}
			
				break;
				
			case "jio" :
				if (reg[registre] == 1  ) {
					this.setStep(this.getStep() + param2);
				} else {
					this.setStep(this.getStep() + 1);
				}
			
				break;
			default:
				System.out.println("default instruction");
	}
		
		return this.getStep() ;
	}
	
	
	public String stateToString (){
		StringBuilder builder = new StringBuilder();
		builder.append( "state \n"  ) ;

		builder.append("Step " +  this.getStep()) ;
		builder.append(" reg 0 : " + reg[0] );
		builder.append(" reg 1 : " + reg[1] );
		builder.append( "\n");

		return  builder.toString();
	}
	
	
}
