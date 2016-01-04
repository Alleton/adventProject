package com.alleton.adventProject.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import com.alleton.adventProject.model.*;
import com.alleton.adventProject.view.*;
import com.alleton.adventProject.*;
import  com.alleton.adventProject.service.Solver;

public class AdventProjectController implements ActionListener  {

	AdventModel adventmodel ;
	AdventProjectView adventprojectview ;
	Solver solver ;
	
	public AdventProjectController (AdventModel adventmodel,AdventProjectView adventprojectview  ) {
		this.adventmodel = adventmodel;
		this.adventprojectview = adventprojectview ;
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("***** load *******") ;
		// TODO Auto-generated method stub
		if (e.getSource() == adventprojectview.load) {
			System.out.println("******* vue.load ******");
			AdventGetPropertyValues properties = new AdventGetPropertyValues();		
			String AdventFolder = properties.getPropValue("AdventFolder") ;
			JFileChooser chooser = new JFileChooser(AdventFolder);
		        chooser.setMultiSelectionEnabled(false);
		        int option = chooser.showOpenDialog(adventprojectview.adventpanel);
		        if (option == JFileChooser.APPROVE_OPTION) {
		          File sf = chooser.getSelectedFile();
		          System.out.println("******* vue.load " + sf.getName()+ "******");
		         // matrix = Initializer.initialize(SudokuFolder + "/" +  sf.getName());
		          
		          
		  		System.out.println("###############################################");
		  		System.out.println("Tentative de resolution de la matrice suivante");
		  		System.out.println("###############################################");
		  	
		  		solver = new Solver( AdventFolder + "/" + sf.getName()) ;
		}
	}
	}
}

