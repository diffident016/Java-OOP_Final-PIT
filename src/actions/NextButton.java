package actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import frames.*;

public class NextButton implements ActionListener{
	
	ImageIcon eks = new ImageIcon("icons/eks.png");
	
	public void actionPerformed (ActionEvent e) {
		
		Frames f = new Frames();
		
		int i = 0, c = 1;
		boolean ch = true;
						
			for(String s : f.getData()) {
				
				if(s.equals("")) {
					
					Frames.error.setIcon(eks);
					Frames.lError.setText("Missing fields");
					
					if(i == 0) {
						Frames.lFName.setForeground(Color.red);
						Frames.fName.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					else if(i == 1){
						Frames.lLName.setForeground(Color.red);
						Frames.lName.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					else if(i == 2) {
						Frames.mLName.setForeground(Color.red);
						Frames.mName.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					else if(i == 3) {
						Frames.fAddress.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					else if(i == 4) {
						Frames.email.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					else if(i == 5) {
						Frames.mNumber.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					ch = false;
					c--;
				}
				
				else {
					if(i == 0) {
						Frames.lFName.setForeground(Color.BLACK);
						Frames.fName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					else if(i == 1){
						Frames.lLName.setForeground(Color.BLACK);
						Frames.lName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					else if(i == 2) {
						Frames.mLName.setForeground(Color.BLACK);
						Frames.mName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					else if(i == 3) {
						Frames.lAddress.setForeground(Color.BLACK);
						Frames.fAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					else if(i == 4) {
						Frames.lEmail.setForeground(Color.black);
						Frames.email.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					else if(i == 5) {
						Frames.lMobile.setForeground(Color.black);
						Frames.mNumber.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					if(c==1)ch = true;
				}
				
				i++;
			}
			
			if(ch) {
			Frames.frame.dispose();
			f.createPass();
			}
		
	}
}
