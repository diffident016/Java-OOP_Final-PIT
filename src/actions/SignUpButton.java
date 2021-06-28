package actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import frames.Frames;
import user_account.*;


public class SignUpButton implements ActionListener{
	public void actionPerformed (ActionEvent e){
		
		ImageIcon eks = new ImageIcon("icons/eks.png");
		AccountProcess uA = new AccountProcess();
		
		
		String userInfo = "", userName = "";
		
		Frames f = new Frames();
		
		int c = 0, ct = 1;
		boolean valid = true;
		
		for(String s : f.getData1()) {
			if(s.equals("")) {
				
				Frames.error.setIcon(eks);
				Frames.lError.setText("Required Field");
				
				if(c == 0) {
					Frames.userName.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
				else if(c == 1) {
					Frames.password.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
				else if(c == 2) {
					Frames.cPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
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
					Frames.password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				}
				else if(c == 2) {
					Frames.cPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				}
				
				if(ct==1)valid = true;
			}
			
			c++;
		}
		
		if(valid) {
			
			try {
				boolean rtn = uA.checkUsername(userName);
				
				if(rtn) {
					Frames.userName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					
					if(f.vPass()) {
						
						if(Frames.agree.isSelected()) {
							for(String s : f.getData()) {
								userInfo += s;
								userInfo += "//?//";
							}
							
							int i = 1, z = f.getData1().size();
							for(String s : f.getData1()) {
								userInfo += s;
								
								if(i == 3)break;
								
								if(i < z) {
									userInfo += "//?//";
								}
								i++;
								
							}
							File file = new File("Accounts.txt");
							FileReader fr = new FileReader(file);	
							BufferedReader br = new BufferedReader(fr);
							
							List<String> usersAcc = new ArrayList<String>();
							String readLine;
							
							if((readLine = br.readLine()) != null) {
								usersAcc.add(readLine);
								while((readLine = br.readLine()) != null){
									usersAcc.add(readLine);
								}
								
								usersAcc.add(userInfo);
								
								FileWriter fileWriter = new FileWriter(file);
								
								for(String s : usersAcc) {
									fileWriter.write(s);
									fileWriter.write("\n");
								}
								
								fileWriter.close();	
								
								uA.createDir(userName);
								
								JOptionPane.showMessageDialog(null, "Account has been created successfully.");
								Frames.frame.dispose();
								f.intro();
							
							}
							else {
							
							FileWriter fileWriter = new FileWriter(file);
							fileWriter.write(userInfo);
							fileWriter.write("\n");
							fileWriter.close();	
							
							uA.createDir(userName);
							
							JOptionPane.showMessageDialog(null, "Account has been created successfully.");
							Frames.frame.dispose();
							f.intro();
							}
							
						br.close();
						fr.close();
						}
						else {
							Frames.error.setIcon(eks);
							Frames.lError.setText("Please accept the user agreements.");
						}
							
					}
					else {
						Frames.error.setIcon(eks);
						Frames.lError.setText("Password does not matched.");
						Frames.cPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					
					
				}
				else {
					Frames.error.setIcon(eks);
					Frames.lError.setText("Username is already taken.");
					Frames.userName.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			
			}catch(Exception ex) {
				System.out.print(ex);
			}
		}
	}
}
