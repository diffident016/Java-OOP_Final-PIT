package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frames.*;

public class LoginAccountButton implements ActionListener{
	public void actionPerformed (ActionEvent e) {
	
	
		Frames f = new Frames();
		
		Frames.frame.dispose();
		f.loginAccount();
	
	
	}
}
