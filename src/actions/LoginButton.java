package actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import frames.Frames;
import user_account.*;


public class LoginButton implements ActionListener{
	public void actionPerformed (ActionEvent e) {
	
		
		Frames f = new Frames();
		UserAccount aA = new UserAccount();
		AccountProcess uA = new AccountProcess();
		ImageIcon eks = new ImageIcon("icons/eks.png");
		
		int c = 0, ct = 1;
		boolean valid = false;
		String userName = "";
		String password= "";
		
		try {
			for(String s : f.getCred()) {
				
				if(s.equals("")) {
					
					Frames.error.setIcon(eks);
					
					if(ct == 1)
						Frames.lError.setText("Required Field");
					else
						Frames.lError.setText("Required Fields");
					
					if(c == 0) {
						Frames.userName.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					else if(c == 1) {
						Frames.password.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
									
					valid = false;
					ct--;
				}
				else {
					if(c == 0) {
						userName = s;
						Frames.userName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					else if(c == 1) {
						password = s;
						Frames.password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
									
					if(ct==1)valid = true;
				}
				
				c++;
			}
			
			if(valid) {
				
				Frames.error.setIcon(null);
				Frames.lError.setText("");
				
				try {
					boolean rtn = uA.loginUsername(userName);
					
					if(rtn) {
						
						int count = uA.getCount();
						
						if(uA.loginPassword(count, password)) {
							System.out.println("Login Successfully");
							
							aA.setUserAccount(uA.getUserInfo());
							f.setBasicInfo(aA.getBasicInfo());
							f.setStatsInfo(aA.getStats());
							Frames.frame.dispose();
							f.setList(uA.getRecordFiles(UserAccount.userName));
							f.dashboard();
						}
						else {
							Frames.password.setBorder(BorderFactory.createLineBorder(Color.RED));
							Frames.error.setIcon(eks);
							Frames.lError.setText("Password is incorrect.");
						}
						
						
					}
					else {					
						Frames.error.setIcon(eks);
						Frames.lError.setText("Username not found.");
					}
				
				}
				catch(Exception ex) {
					ex.printStackTrace();
					System.out.println(ex);
			}
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}	
}