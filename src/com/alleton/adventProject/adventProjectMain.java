/**
 * Solve all advent project code
 */
package com.alleton.adventProject;


import com.alleton.adventProject.model.*;
import com.alleton.adventProject.controller.*;
import com.alleton.adventProject.view.*;



/**
 * @author jf
 *
 */
public class adventProjectMain {
	int problem ;

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		final int DAY_GRID = 5;
		
		/* **************** */
		/* MVC              */
		/* **************** */
		AdventModel adventmodel = new  AdventModel();
		AdventProjectView adventprojectview = new AdventProjectView (adventmodel);
		AdventProjectController adventprojectcontroller = new AdventProjectController(adventmodel,adventprojectview );
		
		//addActionListener pour les boutons
		adventprojectview.test.addActionListener(adventprojectcontroller);
		adventprojectview.Go.addActionListener(adventprojectcontroller);
		
		// ajout 25  boutons listener
		for(int colIndex=0; colIndex < DAY_GRID; colIndex++){
			for(int rowIndex=0; rowIndex < DAY_GRID; rowIndex++) {
				adventprojectview.allButton[colIndex][rowIndex].addActionListener(adventprojectcontroller);
				
			}
		}
		
	}

}
