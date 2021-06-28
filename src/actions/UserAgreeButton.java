package actions;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserAgreeButton implements ActionListener{
	public void actionPerformed (ActionEvent e) {
	
	try  {  
	
	File file = new File("Agreement.txt");   
	
	if(!Desktop.isDesktopSupported()){  
		System.out.println("not supported");  
		return;  
	}  
	
	Desktop desktop = Desktop.getDesktop();  
	
	if(file.exists())        
		desktop.open(file);              
	}  
	catch(Exception a)  {  
		a.printStackTrace();  
	}  
	
	}
}
