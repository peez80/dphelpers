package de.stiffi.DPHelpers.Swing;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public abstract class DPTestApplication extends JFrame {
	public DPTestApplication() {
		super("DPTestApplication");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		createGUI();
		setBounds(0,0,600,400);
		pack();
		setVisible(true);
	}
	
	public abstract void createGUI();
	
	
}
