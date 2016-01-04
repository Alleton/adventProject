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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdventGetPropertyValues properties = new AdventGetPropertyValues();		
		System.out.println (properties.getPropValue("AdventFile"));

//		String AdventFile = properties.getPropValue("AdventFile") ;
//		String AdventFolder = properties.getPropValue("AdventFolder") ;
//		System.out.println (properties.getPropValue("AdventFolder"));
		
		/* **************** */
		AdventModel adventmodel = new  AdventModel();
		AdventProjectView adventprojectview = new AdventProjectView (adventmodel);
		AdventProjectController adventprojectcontroller = new AdventProjectController(adventmodel,adventprojectview );
		
		//addActionListener
		adventprojectview.letsgo.addActionListener(adventprojectcontroller);
		adventprojectview.load.addActionListener(adventprojectcontroller);
		
	}

}
