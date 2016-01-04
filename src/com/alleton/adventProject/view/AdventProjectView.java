package com.alleton.adventProject.view;

import java.util.Observer;

import javax.swing.JFrame;

import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import com.alleton.adventProject.model.AdventModel;


public class AdventProjectView extends JFrame implements Observer {
	final static boolean RIGHT_TO_LEFT = false;
	static final long serialVersionUID = 1;
	
	AdventModel adventmodel ;
	public JPanel      adventpanel;
	
	public JButton letsgo = new JButton("letsgo");
	public JButton load = new JButton("Load");
	
	public void update(Observable o, Object arg) {
		 
    	this.adventpanel.repaint() ;
    }
	
	public AdventProjectView (  AdventModel adventmodel) {
		this.adventmodel = adventmodel;
		adventmodel.addObserver(this);

		JPanel adventpanel = new JPanel();
		
		adventpanel.add(letsgo);
		adventpanel.add(load);
		
		add (adventpanel , BorderLayout.CENTER);
		//lesBoutons.add(efface);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		
		pack();
		setVisible(true);
	}
}
