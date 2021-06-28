package user_account;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;


public class AccountProcess extends UserSchema{
	
	int count = 1;
	static int setCount = 0;
	
	public boolean checkUsername(String username) throws IOException {
	
		
		String line = "";
		List<String> userInfo = new ArrayList<String>();
		List<String> userNames = new ArrayList<String>();
		
		boolean valid = false;
		
		try {
			File file = new File("Accounts.txt");
			FileReader fr = new FileReader(file);	
			BufferedReader br = new BufferedReader(fr);
				
			if(br.read() != -1) {
				while((line = br.readLine()) != null) {
					userInfo.add(line);
				}
			}
			else {
				valid = true;
			}
			
		if(!valid) {	
			for(String s : userInfo) {
				
				StringTokenizer st = new StringTokenizer(s.toString(),"//?//");
				
				for(int a = 0; a < 8; a++) {
					st.nextToken();
				}
				userNames.add(st.nextToken());
			}
			
			for(String s : userNames) {
				if(s.equals(username)) {
					valid = false;
					break;
				}
				else
					valid = true;
			}
		}
		
		fr.close();
		br.close();
		
		}
		catch(Exception ex) {
			File newFile = new File("Accounts.txt");
			FileWriter fileWriter = new FileWriter(newFile);
			valid = true;
			
			fileWriter.close();
		}
		
		return valid;
	}
	
	List<String> userInfo = new ArrayList<String>();
	
	public boolean loginPassword(int count, String password) throws IOException {
	
		userInfo.clear();
		
		String line = "";
		
		boolean valid = false;
		
		try {
			File file = new File("Accounts.txt");
			FileReader fr = new FileReader(file);	
			BufferedReader br = new BufferedReader(fr);
			
			int i = 0;
			while((line = br.readLine()) != null) {
					if(i == count) {
						userInfo.add(line);
						break;
					}
					i++;
			}
			
			StringTokenizer st = new StringTokenizer(userInfo.get(0).toString(),"//?//");
			
			for(int a = 0; a < 9; a++) {
				st.nextToken();
			}
			
			if(password.equals(st.nextToken())){
				valid = true;
			}
			else {
				valid = false;
			}
			
		
		fr.close();
		br.close();
		
		}
		catch(Exception ex) {
			
		}
		
		return valid;
	}
	
	public int getCount() {
		return count;
	}
	
	public List<String> getUserInfo() {
		
		String info = "";
		
		for(String s : userInfo) {
			info += s;
		}
		
		StringTokenizer st = new StringTokenizer(info,"//?//");
		
		userInfo.clear();
		
		while(st.hasMoreTokens()) {
			userInfo.add(st.nextToken());
		}
		
		return userInfo;
	}
	

	
	public boolean loginUsername(String username) throws IOException {
	
		String line = "";
		List<String> userInfo = new ArrayList<String>();
		List<String> userNames = new ArrayList<String>();
		
		boolean valid = false;
		
		try {
			File file = new File("Accounts.txt");
			FileReader fr = new FileReader(file);	
			BufferedReader br = new BufferedReader(fr);
				
			if(br.read() != -1) {
				while((line = br.readLine()) != null) {
					userInfo.add(line);
				}
			}
			else {
				valid = false;
			}
			
		if(!valid) {	
			for(String s : userInfo) {
				
				StringTokenizer st = new StringTokenizer(s.toString(),"//?//");
				
				for(int a = 0; a < 8; a++) {
					st.nextToken();
				}
				userNames.add(st.nextToken());
			}
			
			int i = 0;
			for(String s : userNames) {
				if(s.equals(username)) {
					valid = true;
					count = i;
					break;
				}
				else
					valid = false;
				i++;
			}
		}
		
		fr.close();
		br.close();
		
		}
		catch(Exception ex) {
			File newFile = new File("Accounts.txt");
			FileWriter fileWriter = new FileWriter(newFile);
			fileWriter.close();
		}
		
		return valid;
	}
	
	public void createDir(String username) {
		
		File file = new File("Users/" + username + "/Records");
		file.mkdirs();
		
		file = new File("Users/" + username + "/User_Stats");
		file.mkdirs();
		
		file = new File("Users/" + username + "/Attendance_Records");
		file.mkdirs();
		
	}
	
	@Override
	public void editRecord(int selected, String newData, String username, String recName)throws IOException{
		
		String line = "";
		List<String> newRec1 = new ArrayList<String>();
		
		System.out.println(selected);
		
		try {
			File file = new File("Users/" + username + "/Records/" + recName + ".csv");
			FileReader fr = new FileReader(file);	
			BufferedReader br = new BufferedReader(fr);
							
			int i = 0, ii = 0;
			while((line = br.readLine()) != null) {
				if(ii != 0) {
					if(i == selected) {
						newRec1.add(newData);
					}
					else {
						System.out.println(line);
						newRec1.add(line);
					}
					i++;
				}
				else {
					newRec1.add(line);
				}
				ii++;
			}
			
			FileWriter fw = new FileWriter(file);
			
			for(String s : newRec1) {
				fw.write(s);
				fw.write("\n");
			}
			
			fw.close();
			fr.close();
			br.close();
		
		}
		catch(Exception ex) {
			
		}
		
	}
	
	public void addRecord(String add, String recName, String username) {
		
		String line = "";
		List<String> newRec = new ArrayList<String>();
		int no = 0;
		
		UserAccount uA = new UserAccount();
		
		try {
			try {
				File file = new File("Users/" + username + "/Records/" + recName + ".csv");
				FileReader fr = new FileReader(file);	
				BufferedReader br = new BufferedReader(fr);
								
				int i = 0;
				while((line = br.readLine()) != null) {
					if(i != 0)no++;
					newRec.add(line);
					i++;
				}
				
				no++;
				newRec.add(String.valueOf(no) + "," + add);
				
				FileWriter fw = new FileWriter(file);
				
				for(String s : newRec) {
					fw.write(s);
					fw.write("\n");
				}
				
				fw.close();
				fr.close();
				br.close();
			
			}
			catch(Exception ex) {
				File newFile = new File("Users/" + username + "/Records/" + recName + ".csv");
				FileWriter fileWriter = new FileWriter(newFile);

				uA.setStats(1);
				fileWriter.write("No.,Student ID,Last Name,First Name,M.I.,Grade/Year Level.,Course/Section");
				fileWriter.write("\n");
				no++;
				fileWriter.write(String.valueOf(no) + "," + add);
				fileWriter.write("\n");
				fileWriter.close();
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Please save & close your sheet.");
		}
		
	}
	
	
	public List<String> readRecord(String username, String recName) {
		List<String> readRec = new ArrayList<String>();
		String line = "";
		
		try {
			
			File file = new File("Users/" + username + "/Records/" + recName + ".csv");
			FileReader fr = new FileReader(file);	
			BufferedReader br = new BufferedReader(fr);
			
			int i = 0;
			while((line = br.readLine()) != null) {
				if(i!=0)readRec.add(line);
				i++;
			}
			
			fr.close();
			br.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
				
		return readRec;
	}
	
	public File[] getRecordFiles(String username) {
				
		File folder = new File("Users/" + username + "/Records/");
		
		File[] myFiles = folder.listFiles();
		
		return myFiles;
	}
	
	
	public void attendanceSet(String username, String recName){
		
		List<String> readRec =  readRecord(username,recName);
		List<String> newRec = new ArrayList<String>();
		List<String> newCnt = new ArrayList<String>();
		String line = "";
		int column = 0;
		String addC = "";
			
		try {
				int count = 0;
				
				
				File file = new File("Users/" + username + "/Attendance_Records/" + "AttCount_"+ recName + ".csv");
				FileReader fr = new FileReader(file);	
				BufferedReader br = new BufferedReader(fr);
				
				while((line = br.readLine()) != null) {
					newCnt.add(line);
					System.out.println(line);
				}
				
				fr.close();
				br.close();
				
				file = new File("Users/" + username + "/Attendance_Records/" + recName + ".csv");
				fr = new FileReader(file);	
				br = new BufferedReader(fr);
				
				while((line = br.readLine()) != null) {
					newRec.add(line);
					System.out.println(line);
					count++;
				}
				
				fr.close();
				br.close();
				
				StringTokenizer st = new StringTokenizer(newRec.get(0), ",");
				
				while(st.hasMoreTokens()) {
					st.nextToken();
					column++;
				}
				
				if((column - 7) > 0) {
					for(int a = 0; a < (column - 7); a++) {
						addC+= "A";
						if(a != (column - 7) - 1)addC += ",";
					}
				}
				
				
				if(count != readRec.size()-1) {
					for(int a = count; a < readRec.size(); a++) {
						 newRec.add(String.valueOf(a+1) + "," + addC);
						 newCnt.add("Never" + "," + "0" + "," + "0" + "," + "0" + "," + "S");
					}
				}
				
				file = new File("Users/" + username + "/Attendance_Records/" + recName + ".csv");
				FileWriter fw = new FileWriter(file);

				for(String s : newRec) {
					fw.write(s);
					fw.write("\n");
				}
				
				fw.close();
				
				file = new File("Users/" + username + "/Attendance_Records/" + "AttCount_"+ recName + ".csv");
				fw = new FileWriter(file);
				
				for(String s : newCnt) {
					fw.write(s);
					fw.write("\n");
				}
				
				fw.close();
				
				
			}
			catch(Exception e) {
				try {
				File newFile = new File("Users/" + username + "/Attendance_Records/" + recName + ".csv");
				FileWriter fw = new FileWriter(newFile);
				
				count = readRec.size();
				
				for(int a = 0; a < count; a++) {
					fw.write("S");
					fw.write("\n");
				}
				fw.close();

				newFile = new File("Users/" + username + "/Attendance_Records/" + "AttCount_"+ recName + ".csv");
				fw = new FileWriter(newFile);
				
				for(int a = 0; a < count; a++) {
					fw.write("Never" + "," + "0" + "," + "0" + "," + "0" + "," + "S");
					fw.write("\n");
				}
				
				fw.close();
				
				newFile = new File("Users/" + username + "/Attendance_Records/" + "firstCheck_"+ recName + ".csv");
				fw = new FileWriter(newFile);
				fw.close();
				
				newFile = new File("Users/" + username + "/Attendance_Records/" + "dateCheck_" + recName + ".csv");
				fw = new FileWriter(newFile);
				fw.close();
				
				}catch(Exception ex) {
				}
			}
		
	}
	
	public void deleteRecord(int selected, int type, String username, String recName) throws IOException{
		
		List<String> readRec = new ArrayList<String>();
		List<String> newRec = new ArrayList<String>();
		List<String> newCnt = new ArrayList<String>();
		
		File File1 = new File("Users/" + username + "/Records/" + recName + ".csv");
		File File2 = new File("Users/" + username + "/Attendance_Records/" + recName + ".csv");
		File File3 = new File("Users/" + username + "/Attendance_Records/" + "AttCount_" + recName + ".csv");
		File File4 = new File("Users/" + username + "/Attendance_Records/" + "dateCheck_" + recName + ".csv");
		File File5 = new File("Users/" + username + "/Attendance_Records/" + "firstCheck_" + recName + ".csv");
		
		UserAccount uA = new UserAccount();
		
		if(type == 1) {
			
			FileReader fr1 = new FileReader(File1);	
			FileReader fr2 = new FileReader(File2);	
			FileReader fr3 = new FileReader(File3);	
			BufferedReader br1 = new BufferedReader(fr1);
			BufferedReader br2 = new BufferedReader(fr2);
			BufferedReader br3 = new BufferedReader(fr3);
						
			String line = "";
			int i = 0, ii = 0;
			
			while((line = br1.readLine()) != null) {
				
				if(ii != 0) {
					if(i != selected) {
					readRec.add(line);
					}
					i++;
				}
				else {
					readRec.add(line);
				}
				ii++;
			}
			br1.close();
			fr1.close();
			
			i= 0;
			ii=0;
			
			while((line = br2.readLine()) != null) {
				if(ii != 0) {	
					if(i != selected) {
						newRec.add(line);
					}
					i++;
				}
				else {
					newRec.add(line);
				}
				ii++;
				
			}
			
			br2.close();
			fr2.close();
			
			i = 0;
			ii = 0;
			
			while((line = br3.readLine()) != null) {
				if(ii != 0) {	
					if(i != selected) {
						newCnt.add(line);
					}
					i++;
				}
				else {
					newCnt.add(line);
				}
			}
			
			br3.close();
			fr3.close();
			
			FileWriter fw = new FileWriter(File1);
			
			for(String s : readRec) {
				fw.write(s);
				fw.write("\n");
			}
			fw.close();
			
			fw = new FileWriter(File2);
			
			for(String s: newRec) {
				fw.write(s);
				fw.write("\n");
			}
			fw.close();
			
			fw = new FileWriter(File3);
			
			for(String s : newCnt) {
				fw.write(s);
				fw.write("\n");
				
			}
			fw.close();
		}
		else if(type == 2){
			
			RandomAccessFile raf = new RandomAccessFile(File1,"rw");
			raf.close();
			File1.delete();
			raf = new RandomAccessFile(File2,"rw");
			raf.close();
			File2.delete();
			raf = new RandomAccessFile(File3,"rw");
			raf.close();
			File3.delete();
			raf = new RandomAccessFile(File4,"rw");
			raf.close();
			File4.delete();
			raf = new RandomAccessFile(File5,"rw");
			raf.close();
			File5.delete();
			
			System.out.println("Det");
			
			uA.setStats(4);
		}
	}
	
	public void recordAttendance(int count, char state, String username, String recName) throws IOException{
		
		List<String> newRec = new ArrayList<String>();
		List<String> newCnt = new ArrayList<String>();
		
		Date dates = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd");
		
		UserAccount uA = new UserAccount();
		
		String currentDate = sdf1.format(dates);
		String colDate = sdf2.format(dates);
		
		int c = 0;
		
		File File1 = new File("Users/" + username + "/Attendance_Records/" + recName + ".csv");
		File File2 = new File("Users/" + username + "/Attendance_Records/" + "AttCount_" + recName + ".csv");
		File File3 = new File("Users/" + username + "/Attendance_Records/" + "firstCheck_" + recName + ".csv");
		File File4 = new File("Users/" + username + "/Attendance_Records/" + "dateCheck_" + recName + ".csv");
		
		FileReader fr1 = new FileReader(File1);	
		FileReader fr2 = new FileReader(File2);	
		FileReader fr3 = new FileReader(File3);	
		FileReader fr4 = new FileReader(File4);
		BufferedReader br1 = new BufferedReader(fr1);
		BufferedReader br2 = new BufferedReader(fr2);
		BufferedReader br3 = new BufferedReader(fr3);
		BufferedReader br4 = new BufferedReader(fr4);
		
			
		uA.setStats(2);
		uA.setStats(3);
		
		String checkDate = "";
		
			String rowDate = br4.readLine();
			
			if(rowDate == null) {
				checkDate = colDate + ",";
			}
			else if(rowDate != colDate){
				checkDate = rowDate + colDate + ",";
			}
			
			br4.close();
		
		
		FileWriter fw4 = new FileWriter(File4);
		fw4.write(checkDate);
		fw4.close();
		
		
		String line = "", line1 = "";
	
		c = 0;
		
		while((line = br2.readLine()) != null) {
			
			line1 = br1.readLine();
			
			if(count == c) {
				
				int P = 0, A = 0, L = 0; 
				char S = 'A';
				String pastDate = "";
				StringTokenizer st = new StringTokenizer(line, ",");
				
				pastDate = st.nextToken();
				P = Integer.parseInt(st.nextToken());
				A = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());
				S = st.nextToken().charAt(0);
				
				if(!(pastDate.equals(currentDate))){
					if(state == 'P')P++;
					else if(state == 'A')A++;
					else if(state == 'L')L++;
					
					S = state;
					newCnt.add(currentDate + "," + String.valueOf(P) + "," + String.valueOf(A) + "," + String.valueOf(L) + "," + S);
					
					if(line1.equals("S")) {
						newRec.add(state + ",");
						System.out.println("hahaha");
					}
					else {
						newRec.add(line1 + state + ",");
						System.out.println("hfafawa");
					}
					
					System.out.println(newRec.get(c));
				}
				else {
					
					if(S == 'P')P--;
					else if(S == 'A')A--;
					else if(S == 'L')L--;
					
					if(state == 'P')P++;
					else if(state == 'A')A++;
					else if(state == 'L')L++;
					
					S = state;
					
					
					newCnt.add(currentDate + "," + String.valueOf(P) + "," + String.valueOf(A) + "," + String.valueOf(L) + "," + S);
					
					StringTokenizer st1 = new StringTokenizer(line1, ",");
					
					int counts = 0;
					while(st1.hasMoreTokens()) {
						st1.nextToken();
						counts++;
					}
					
					st1 = new StringTokenizer(line1, ",");
					
					String newS = "";
					
					for(int a = 0; a < counts-1; a++) {
						newS += st1.nextToken();
					}
					
					newRec.add(newS + state + ",");
				}
				
			}
			else {
				newCnt.add(line);
				newRec.add(line1);
			}
			c++;
		}
		
		br2.close();
		br1.close();
		
		FileWriter fw1 = new FileWriter(File1);
		
		for(String s : newRec) {
			//System.out.println(s);
			fw1.write(s);
			fw1.write("\n");
		}
		fw1.close();
		
		FileWriter fw2 = new FileWriter(File2);
		
		for(String s : newCnt) {
			fw2.write(s);
			fw2.write("\n");
		}
		fw2.close();
		
		if(br3.readLine() == null) {
			
			FileWriter fw3 = new FileWriter(File3);
			
			fw3.write(currentDate);
			fw3.close();
		}
		br3.close();		
		
		/*line = "";
		c = 0;
		for(String s : readRec) {
			if(count == c) {
				line = s;
				break;
			}
			c++;
		}	
	*/
	}
	
	public int columnCount(String username, String recName) {
		
		File File = new File("Users/" + username + "/Attendance_Records/" + "dateCheck_" + recName + ".csv");
		
		int count = 0;
		 
		try {
			
			FileReader fr = new FileReader(File);	
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			
			StringTokenizer st = new StringTokenizer(line, ",");
			
			while(st.hasMoreTokens()) {
				st.nextToken();
				count++;
			}
			
			br.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return count;
		
	}
	
	public String showDate(String username, String recName) {
		
		File File = new File("Users/" + username + "/Attendance_Records/" + "AttCount_" + recName + ".csv");
		File File1 = new File("Users/" + username + "/Attendance_Records/" + "firstCheck_" + recName + ".csv");
		
		String column = "";
		
		try {
			
			FileReader fr = new FileReader(File);	
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			
			StringTokenizer st = new StringTokenizer(line, ",");
			
			column += st.nextToken() + "   TO: ";
			br.close();
			
			fr = new FileReader(File1);	
			br = new BufferedReader(fr);
			
			column += br.readLine();
			
			br.close();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return column;
	}
	
	
	public Object[][] displayAtt(String username, String recName){
		
		List<String> newCnt = new ArrayList<String>();
		
		try {
		File File = new File("Users/" + username + "/Attendance_Records/" + "AttCount_" + recName + ".csv");
		FileReader fr = new FileReader(File);	
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		
		while((line = br.readLine()) != null) {
			newCnt.add(line);
		}
		br.close();
		}
		catch(Exception ex) {
			
			
		}
		Object [][] dispA = new Object[newCnt.size()][3];
		
		int i = 0;
		for(String s : newCnt) {
			
			StringTokenizer st = new StringTokenizer(s, ",");
			
			st.nextToken();
			dispA[i][0] = st.nextToken();
			dispA[i][1] = st.nextToken();
			dispA[i][2] = st.nextToken();
			
			i++;
		}
		
		return dispA;
		
	}
	
	public Object[][] toDisplay(String username,String recName, int index){
		
		List<String> readRec =  readRecord(username,recName);
		List<String> newCnt = new ArrayList<String>();
		List<String> all = new ArrayList<String>();
		
		try {
			File File = new File("Users/" + username + "/Attendance_Records/" + "AttCount_" + recName + ".csv");
			FileReader fr = new FileReader(File);	
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line,",");
				st.nextToken();
				st.nextToken();
				st.nextToken();
				st.nextToken();
				newCnt.add(st.nextToken());
			}
			br.close();
			
			int i = 0;
			for(String s: readRec) {
				
				String rec = "";
				
				StringTokenizer st = new StringTokenizer(s,",");
				
				for(int a = 0; a < 5; a++) {
					rec += st.nextToken();
					rec += ",";
				}
				
				all.add(rec + "," + newCnt.get(i));
				if(i == index)break;
				i++;
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Here!");
			ex.printStackTrace();
		}
		
		Object [][] disp = new Object[all.size()][6];
		
		int i = 0;
		for(String s : all) {
			StringTokenizer st = new StringTokenizer(s,",");
			
			int j = 0;
			while(st.hasMoreTokens()) {
				disp[i][j] = st.nextToken();
				j++;
			}
			i++;
		}
		
		return disp;
	}
	
}
