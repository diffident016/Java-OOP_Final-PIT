package user_account;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;


public class UserAccount {
	
	
	public static String firstName;
	public static String lastName;
	public static String mI;
	public static String email;
	public static String address;
	public static String mNumber;
	public static String userName;
	public static String gender;
	public static String age;
	public String occupation;
	private String password;
	int recCount = 0;
	int chkCount = 0;
	String lstChk = "Never";
	
	
	
	public UserAccount() {
				
	}
	
	
	public void setUserAccount(List<String> userInfo) {
		
		for(String s: userInfo) {
			System.out.println(s);
		}
		
		firstName = userInfo.get(0);
		lastName = userInfo.get(1);
		mI = userInfo.get(2);
		email = userInfo.get(3);
		address = userInfo.get(4);
		mNumber = userInfo.get(5);
		gender = userInfo.get(6);
		age = userInfo.get(7);
		userName = userInfo.get(8);
		password = userInfo.get(9);
		
	}
	
	public void setPass(String password) {
		this.password = password;
	}
	
	public String getPass() {
		return password;
	}
	
	
	public List<String> getBasicInfo() {
		List<String> userInfo = new ArrayList<String>();
		
		userInfo.add(lastName+ ", " + firstName + " " + mI);
		userInfo.add(occupation);
		
		return userInfo;
	}
	
	public void setStats(int a) throws IOException {
		
		try {
			
		File file = new File("Users/" + userName + "/User_Stats/" + userName + "_Stats.txt");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		FileReader fr = new FileReader(file);	
		BufferedReader br = new BufferedReader(fr);
		
		String rd = "";
		
		if((rd = br.readLine()) == null) {
			FileWriter fw = new FileWriter(file);
			
			fw.write(recCount+ "," + chkCount + "," + lstChk);
			fw.close();
		}
		else {
			StringTokenizer st = new StringTokenizer(rd.toString(),",");
			recCount = Integer.parseInt(st.nextToken());
			chkCount = Integer.parseInt(st.nextToken());
			lstChk = st.nextToken();
		}
		
		br.close();
	
		switch(a) {
		
		case 1: recCount++;
		break;
		case 2: 
			if(!(lstChk.equals(sdf.format(date))))chkCount++;
		break;
		case 3: 
			if(!(lstChk.equals(sdf.format(date))))lstChk = sdf.format(date);
		break;
		case 4: if(recCount > 0)recCount--;
		break;
		}
			FileWriter fw = new FileWriter(file);
			fw.write(recCount+ "," + chkCount + "," + lstChk);
			fw.close();
		}
		catch(Exception e) {
			File file = new File("Users/" + userName + "/User_Stats/" + userName + "_Stats.txt");
			FileWriter fw = new FileWriter(file);
			fw.write(recCount+ "," + chkCount + "," + lstChk);
			fw.close();
			System.out.println(e);
		}
		
	}
	
	
	
	public List<String> getStats() throws IOException {
		File file = new File("Users/" + userName + "/User_Stats/" + userName + "_Stats.txt");
		
		List<String> userStats = new ArrayList<String>();
		
		while(true) {	
			try {
				FileReader fr = new FileReader(file);	
				BufferedReader br = new BufferedReader(fr);
				
				String rd = "";
				
				if((rd = br.readLine()) == null) {
					FileWriter fw = new FileWriter(file);
					
					fw.write(recCount+ "," + chkCount + "," + lstChk);
					fw.close();
				}
				else {
					StringTokenizer st = new StringTokenizer(rd.toString(),",");
					recCount = Integer.parseInt(st.nextToken());
					chkCount = Integer.parseInt(st.nextToken());
					lstChk = st.nextToken();
					break;
				}
				br.close();
				
			}
			catch(Exception ex) {
				FileWriter fw = new FileWriter(file);
				
				fw.write(recCount+ "," + chkCount + "," + lstChk);
				fw.close();
			}
		
		}
		
		userStats.add(String.valueOf(recCount));
		userStats.add(String.valueOf(chkCount));
		userStats.add(lstChk);
		
		return userStats;
	}
	
}
