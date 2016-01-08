package com.alleton.adventProject.view;

import java.util.Observer;

import javax.swing.JFrame;

import java.util.Observable;

import javax.swing.JButton;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import com.alleton.adventProject.model.AdventModel;

public class AdventProjectView extends JFrame implements Observer {
	final static boolean RIGHT_TO_LEFT = false;
	final int DAY_GRID = 5;
	
	static final long serialVersionUID = 1;
	
	AdventModel adventmodel ;
	public JPanel      adventpanel;
	private JPanel      GrillePanel ;
	
	public JButton Go = new JButton("Go");
	public JButton test = new JButton("Test");
	public JButton   [][] allButton;
	

	
	public void update(Observable o, Object arg) {
		 
    	this.adventpanel.repaint() ;
    }
	
	public AdventProjectView (  AdventModel adventmodel) {
		//JButton   [][] allButton;
		allButton = new JButton [DAY_GRID][DAY_GRID];
		
		this.adventmodel = adventmodel;
		adventmodel.addObserver(this);

		JPanel adventpanel = new JPanel();
		setPreferredSize(new Dimension(700,200 ));
		add(adventpanel, BorderLayout.NORTH);
		// new panel for grid
		
		GrillePanel = new JPanel(new BorderLayout()); //PREFERRED!
		add(GrillePanel, BorderLayout.SOUTH);
		GrillePanel.setLayout(new GridLayout(DAY_GRID,DAY_GRID));
		
		adventpanel.add(Go);
		adventpanel.add(test);
		int buttonnbr;
		
		for(int colIndex=0; colIndex < DAY_GRID; colIndex++){
			for(int rowIndex=0; rowIndex < DAY_GRID; rowIndex++) {
				buttonnbr = ( rowIndex  +1 )  + (colIndex * DAY_GRID  ) ;
				allButton[colIndex][rowIndex] = new JButton  (String.valueOf(buttonnbr));
				GrillePanel.add ( allButton[colIndex][rowIndex]) ;
				allButton[colIndex][rowIndex].setText ( " " + buttonnbr ) ;
			}
		}
		
				
		add (adventpanel , BorderLayout.CENTER);
		//lesBoutons.add(efface);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		
		pack();
		setVisible(true);
	}
}
