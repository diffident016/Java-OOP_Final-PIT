package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import actions.*;
import user_account.AccountProcess;
import user_account.UserAccount;



public class Frames {
	
	public static JFrame frame;
	public static JPanel panel;
	public static JTextField fName;
	public static JTextField lName;
	public static JTextField mName;
	public static JTextField fAddress;
	public static JTextField email;
	public static JTextField mNumber;
	public static JTextField userName;
	public static JPasswordField password;
	public static JPasswordField cPassword;
	public static JSpinner age;
	public static JRadioButton male;
	public static JRadioButton female;
	public static JComboBox<Object> occupation;
	public static JLabel lFName;
	public static JLabel lLName;
	public static JLabel mLName;
	public static JLabel lEmail;
	public static JLabel lMobile;
	public static JLabel lAddress;
	public static JLabel error;
	public static JLabel lError;
	public static JCheckBox agree;
	
	public List<String> userInfo = new ArrayList<String>();
	public List<String> userInfo1 = new ArrayList<String>();
	String [] infoS = {"","","","","","","","1"};
	
	Colors cl = new Colors();
	
	ImageIcon eks = new ImageIcon("icons/eks.png");
	ImageIcon logo = new ImageIcon("icons/logo.png");
	ImageIcon bg = new ImageIcon("icons/bg.png");
	ImageIcon lock = new ImageIcon("icons/padlock.png");
	ImageIcon username = new ImageIcon("icons/user.png");
	
	public void intro() {
				
		frame = new JFrame("Attendance Checker  v0.1");
		Panel panel = new Panel();
		JLabel bgImage = new JLabel(bg);
		bgImage.setBounds(0,0,415,203);
		panel.add(bgImage);

		frame.setIconImage(logo.getImage());
		frame.setSize(430, 450);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    panel.setBackground(new Color(83,121,141));
	    frame.add(panel);
	    panel.setLayout(null);
	    
	    JButton create = new JButton("Create Account");
	    create.setBounds(130,240,150,40);
	    create.addActionListener(new CreateAccountButton());
	    create.setForeground(Color.white);
	    create.setBackground(new Color(0,128,128));
	    create.setFocusPainted(false);
	    panel.add(create);
	    
	    JButton login = new JButton("Login Account");
	    login.setBounds(130,300,150,40);
	    login.addActionListener(new LoginAccountButton());
	    login.setForeground(Color.white);
	    login.setBackground(new Color(0,128,128));
	    panel.add(login);
	   
	    
	    JLabel dev = new JLabel("Developed by: Marvin Tagolimot");
	    dev.setBounds(225,390,200,20);
	    dev.setForeground(Color.white);
	    panel.add(dev);
	    
	    frame.setVisible(true);
	}
	
	
	
	public static JLabel checker;
	public static JLabel occupations;
	public static JLabel chkCount;
	public static JLabel recCount;
	public static JLabel lastChk;
	
	String info1[] = new String[2];
	String info2[] = new String[3];
	static String listRec[];
	
	public String[] setList(File[] files) {
		
		int i = 0;
		for(File fil : files) {
			if(fil.isFile()) {
				i++;
			}
		}
		listRec = new String[i];
		
		i = 0;
		for(File fil : files) {
			if(fil.isFile()) {
				listRec[i] = fil.getName();
				listRec[i] = listRec[i].substring(0, listRec[i].length()-4);
			}
			i++;
		}
		
		return listRec;
	}
	
	public void setBasicInfo(List<String> basicInfo) {
		
			
		info1[0] = basicInfo.get(0);
		info1[1] = basicInfo.get(1);
		
	}
	
	public void setStatsInfo(List<String> statsInfo) {
		
		
		info2[0] = statsInfo.get(1);
		info2[1] = statsInfo.get(0);
		info2[2] = statsInfo.get(2);
		
	}
	
	public static JTextField recName;
	public static JTextField sId;
	public static JTextField gradeYL;
	public static JTextField crSec;
	public static JLabel recNamel;
	static JList<String> list;
	JTable myTable;
	JTable myTable2;
	String lastRec = "";
	static JTabbedPane tp;
	Object [][] rowData;
	String sInfo[] = {"","","","","","",""};
	static JTable myTable1;
	static JLabel record;
	static JLabel stName;
	static JLabel stId;
	static JLabel grdlvl;
	static JLabel crsSec;
	static JButton present;
	static JButton absent;
	static JButton late;
	static JButton refresh;
	static JTextField fName1;
	static JTextField lName1;
	static JTextField mName1;
	static JTextField sId1;
	static JTextField gradeYL1;
	static JTextField crSec1;
	int number = 0;
	
	String openSheet = "";
	int index = 0;
	static boolean once = true;
	static int selected = 0;
	static boolean colCreated = false;
	
	public void dashboard() {
		
		frame = new JFrame("Attendance Checker  v0.1");
	    frame.setVisible(true);
	    frame.setSize(650, 600);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setIconImage(logo.getImage());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel panel = new JPanel();
	    panel.setPreferredSize(new Dimension(250, 190));
	    panel.setBackground(cl.bgColor());
	    
	    JLabel h1 = new JLabel("User Information:");
	    h1.setBounds(10, 25, 250, 20);
	    h1.setForeground(Color.BLACK);
	    h1.setFont (h1.getFont ().deriveFont (13f));
	    panel.add(h1);
	    
	    JLabel name = new JLabel("Checker: ");
	    name.setBounds(15, 55, 80, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    panel.add(name);
	    
	    checker = new JLabel(); 
	    checker.setText(" " + info1[0]);
	    checker.setBounds(90,55,145,25 );
	    checker.setBorder(BorderFactory.createLineBorder(Color.gray));
	    panel.add(checker);
	    
	    JLabel l4 = new JLabel("Username:");
	    l4.setBounds(15, 85, 80, 25);
	    l4.setForeground(cl.fontColor());
	    l4.setFont (l4.getFont ().deriveFont (12f));
	    panel.add(l4);
	    
	    JLabel da = new JLabel(" " + UserAccount.userName); 
	   // occupations.setText(" " + info1[1]);
	    da.setBounds(90,85,145,25 );
	    da.setBorder(BorderFactory.createLineBorder(Color.gray));
	    panel.add(da);
	    
	    JLabel l3 = new JLabel("Checked Times:");
	    l3.setBounds(15, 115, 100, 25);
	    l3.setForeground(cl.fontColor());
	    l3.setFont (l3.getFont ().deriveFont (12f));
	    panel.add(l3);
	    
	    chkCount = new JLabel();
	    chkCount.setBounds(115, 115, 120, 25);
		chkCount.setText(" " + info2[0]);
		
	    chkCount.setBorder(BorderFactory.createLineBorder(Color.gray));
	    panel.add(chkCount);
	    
	    JLabel l5 = new JLabel("No. of records:");
	    l5.setBounds(15, 145, 100, 25);
	    l5.setForeground(cl.fontColor());
	    l5.setFont (l5.getFont ().deriveFont (12f));
	    panel.add(l5);
	    
	    recCount = new JLabel();
	    recCount.setBounds(115, 145, 120, 25);
		recCount.setText(" " + info2[1]);
		
	    recCount.setBorder(BorderFactory.createLineBorder(Color.gray));
	    panel.add(recCount);
	    
	    JLabel l2 = new JLabel("Last Checked:");
	    l2.setBounds(15, 175, 100, 25);
	    l2.setForeground(cl.fontColor());
	    l2.setFont (l2.getFont ().deriveFont (12f));
	    panel.add(l2);
	    
	    lastChk = new JLabel();
	    lastChk.setBounds(115, 175, 120, 25);
	    lastChk.setText(" " + info2[2]);
		
	    lastChk.setBorder(BorderFactory.createLineBorder(Color.gray));
	    panel.add(lastChk);
	    
	    JButton moreInfo = new JButton("More Info");
	    moreInfo.setBounds(20,220,90,25);
	    moreInfo.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		Object [] ob = {"Name: "+ UserAccount.firstName + ", " + UserAccount.mI + " " + UserAccount.lastName,
	    				"Address: " + UserAccount.address,
	    				"Email: " + UserAccount.email,
	    				"Mobile Number: " + UserAccount.mNumber,
	    				"Age: " + UserAccount.age,
	    				"Gender: " + UserAccount.gender};
	    		
	    		JOptionPane.showMessageDialog(null, ob, "User Information",JOptionPane.PLAIN_MESSAGE);
	    		
	    	}
	    });
	    panel.add(moreInfo);
	    
	    JButton logOut = new JButton("Logout");
	    logOut.setBounds(130,220,80,25);
	    logOut.addActionListener(new LoginAccountButton());
	    panel.add(logOut);
	    
	    
	    JLabel l1 = new JLabel("Select your record:");
	    l1.setBounds(15, 270, 180, 25);
	    l1.setForeground(cl.fontColor());
	    l1.setFont (l1.getFont ().deriveFont (12f));
	    panel.add(l1);
	    
	    DefaultListModel<String> mList = new DefaultListModel<String>();
		list = new JList<String>(mList);
		
		for(String s : listRec) {
			mList.addElement(s);
		}
		
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        list.addListSelectionListener(new ListSelectionListener() {
        	
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
            	
            	AccountProcess aP = new AccountProcess();
            	
                if (arg0.getValueIsAdjusting()) {
                	
                if(tp.getSelectedIndex() == 0) {
                	
                	Object readData[][] = setdashField(aP.readRecord(UserAccount.userName, list.getSelectedValue().toString()));
                	
                	stName.setText(" "+readData[0][2].toString().toUpperCase() + ", " + readData[0][3].toString() + " " + readData[0][4].toString());
                	stId.setText(" " + readData[0][1].toString());
                	grdlvl.setText(" " + readData[0][5].toString());
                	crsSec.setText(" " + readData[0][6].toString());
                	
					aP.attendanceSet(UserAccount.userName, list.getSelectedValue().toString());
										
                	record.setText(" "+list.getSelectedValue().toString());
                	present.setEnabled(true);
                	absent.setEnabled(true);
                	late.setEnabled(true);                	
                	
                }
                
                else if(tp.getSelectedIndex() == 1){
                	
                	String recName1 = list.getSelectedValue().toString(); 
                	recName.setText(recName1);
                	
                	Object[][] 	rowData1 = setdashField(aP.readRecord(UserAccount.userName, recName.getText()));
		    	  	
					DefaultTableModel model = (DefaultTableModel) myTable.getModel();
					
					for (int x = model.getRowCount() - 1; x >= 0; x--) {
	    			    model.removeRow(x);
	    			}
					
		    	  	for(int a = 0; a < rowData1.length; a++) {
		    	  		model.addRow(new Object[] {rowData1[a][0],rowData1[a][1],
		    	  				rowData1[a][2],rowData1[a][3],rowData1[a][4],rowData1[a][5],
		    	  				rowData1[a][6]});
		    	  	}
                	
                }
                
                }
           
            }

        });
        
        JScrollPane js = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        js.setBounds(15,300,220, 150);
        panel.add(js);
        
        JButton openRec = new JButton("Open Record");
	    openRec.setBounds(20,460,200,25);
	    openRec.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		AccountProcess aP = new AccountProcess();
	    		
	    		JFrame frame2 = new JFrame("Attendance Checker  v0.1");
	    		
	    	    frame2.setSize(650, 600);
	    	    frame2.setResizable(false);
	    	    frame2.setLocationRelativeTo(null);
	    	    frame2.setIconImage(logo.getImage());
	    	    frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	    
	    	    JPanel panel3 = new JPanel();
	    	    panel3.setBackground(cl.bgColor());
	    	    panel3.setLayout(null);
	    	    
	    	    JLabel myRecord = new JLabel("RECORD NAME: ");
	    	    myRecord.setBounds(20, 10, 120, 25);
	    	    myRecord.setFont (myRecord.getFont ().deriveFont (13f));
	    	    panel3.add(myRecord);
	    	    
	    	    myRecord = new JLabel(list.getSelectedValue());
	    	    myRecord.setBounds(130, 10, 120, 25);
	    	    myRecord.setFont (myRecord.getFont ().deriveFont (13f));
	    	    panel3.add(myRecord);
	    	    
	    	    myRecord = new JLabel("FROM: ");
	    	    myRecord.setBounds(260, 10, 100, 25);
	    	    myRecord.setFont (myRecord.getFont ().deriveFont (13f));
	    	    panel3.add(myRecord);
	    	    
	    	    myRecord = new JLabel(aP.showDate(UserAccount.userName, list.getSelectedValue()));
	    	    myRecord.setBounds(310, 10, 300, 25);
	    	    myRecord.setFont (myRecord.getFont ().deriveFont (13f));
	    	    panel3.add(myRecord);
	    	    
	    	    
	    	    	    	    
	    	    Object[] columnNames = {"No.","Student ID","Last Name", "First Name", "M.I.", "Grade/Year Lvl.", "Course/Sec.", "Present"
	    	    		,"Absent", "Late", "Grade %"};
			    
			    JTable myTable2 = new JTable(new DefaultTableModel(new Object[][]{{}}, columnNames));
			    DefaultTableModel model3 = (DefaultTableModel) myTable2.getModel();
			    model3.removeRow(0);
	    	    
			    TableColumnModel tcm = myTable2.getColumnModel();
			    tcm.getColumn(0).setPreferredWidth(40);    
			    tcm.getColumn(1).setPreferredWidth(90);    
			    tcm.getColumn(2).setPreferredWidth(90);   
			    tcm.getColumn(3).setPreferredWidth(90);    
			    tcm.getColumn(4).setPreferredWidth(40);
			    tcm.getColumn(5).setPreferredWidth(90);
			    tcm.getColumn(6).setPreferredWidth(80);
			    tcm.getColumn(7).setPreferredWidth(50);
			    tcm.getColumn(8).setPreferredWidth(50);
			    tcm.getColumn(9).setPreferredWidth(50);
			    tcm.getColumn(10).setPreferredWidth(50);
			    
			    myTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    
			    for (int x = model3.getRowCount() - 1; x >= 0; x--) {
    			    model3.removeRow(x);
    			}
	    		
	    	  	Object[][] rowData1 = setdashField(aP.readRecord(UserAccount.userName, list.getSelectedValue().toString()));
	    	  	Object [][] rowData2 = aP.displayAtt(UserAccount.userName, list.getSelectedValue());
	    	  	
	    	  	
	    	  	double grading[] = new double[rowData1.length];
	    	  	
	    	  	
	    	  	for(int a = 0; a < rowData1.length; a++) {
	    	  		double P = Double.parseDouble(rowData2[a][0].toString());
		    	  	double A = Double.parseDouble(rowData2[a][1].toString());
		    	  	double L = Double.parseDouble(rowData2[a][2].toString());
	    	  		
		    	  	double total = P - (A + (L* 0.5));
		    	  	
	    	  		double count = P + A + L;
	    	  		grading[a] = total/count * 100;
	    	  		
	    	  		if(grading[a] < 0) {
	    	  			grading[a] += 100;
	    	  		}
	    	  	}
	    	  	for(int a = 0; a < rowData1.length; a++) {
	    	  		model3.addRow(new Object[] {rowData1[a][0],rowData1[a][1],
	    	  				rowData1[a][2],rowData1[a][3],rowData1[a][4],rowData1[a][5],
	    	  				rowData1[a][6], rowData2[a][0], rowData2[a][1],rowData2[a][2], String.valueOf(grading[a]) + "%" });
	    	  	}
	    	  	
	    	  	JScrollPane js = new JScrollPane(myTable2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	            js.setBounds(10,50,615, 500);
	            panel3.add(js);
	            
	    	    frame2.setVisible(true);
	    	    frame2.add(panel3);
	    	    
	    	    
	    		
	    	}
	    });
	    openRec.setEnabled(false);
	    panel.add(openRec);
	    
        
	    JPanel panel_2 = new JPanel();
	    panel_2.setPreferredSize(new Dimension(430, 500));
	    panel_2.setBackground(cl.bgColor());
	    panel.setLayout(null);
	    panel_2.setLayout(null);
	    
	    
	    JPanel checkAt = new JPanel();
	    JPanel addAtt = new JPanel();
	    JPanel deleteRec = new JPanel();
	    JPanel delEd = new JPanel();
	    
	    int a = 0;
	    if(a == 0) {
		    //Add Attendance
		    addAtt.setBackground(cl.bgColor());
		    addAtt.setLayout(null);
		    h1 = new JLabel("Add record or student to your record:");
		    h1.setBounds(15, 10, 250, 20);
		    h1.setForeground(cl.fontColor());
		    h1.setFont (h1.getFont ().deriveFont (12f));
		    addAtt.add(h1);
		    
		    name = new JLabel("Record Name");
		    name.setBounds(20, 30, 120, 25);
		    name.setForeground(cl.fontColor());
		    name.setFont (name.getFont ().deriveFont (12f));
		    addAtt.add(name);
		    
		    recName = new JTextField(20);
		    recName.setBounds(20, 55, 307, 25);
		    //fName.setText(infoS[0]);
		    addAtt.add(recName);
		    
		    name = new JLabel("First Name");
		    name.setBounds(20, 85, 80, 25);
		    name.setForeground(cl.fontColor());
		    name.setFont (name.getFont ().deriveFont (12f));
		    addAtt.add(name);
		    
		    fName = new JTextField(20);
		    fName.setBounds(20, 110, 100, 25);
		    fName.setText(infoS[0]);
		    addAtt.add(fName);
		    
		    name = new JLabel("Last Name");
		    name.setBounds(128, 85, 80, 25);
		    name.setForeground(cl.fontColor());
		    name.setFont (name.getFont ().deriveFont (12f));
		    addAtt.add(name);
		    
		    lName = new JTextField(30);
		    lName.setBounds(128, 110, 137, 25);
		    lName.setText(infoS[1]);
		    addAtt.add(lName);
		    
		    name = new JLabel("M.I.");
		    name.setBounds(275, 85, 80, 25);
		    name.setForeground(cl.fontColor());
		    name.setFont (name.getFont ().deriveFont (12f));
		    addAtt.add(name);
		    
		    mName = new JTextField(30);
		    mName.setBounds(275, 110, 52, 25);
		    mName.setText(infoS[2]);
		    addAtt.add(mName);
		    
		    name = new JLabel("Student ID");
		    name.setBounds(20, 140, 80, 25);
		    name.setForeground(cl.fontColor());
		    name.setFont (name.getFont ().deriveFont (12f));
		    addAtt.add(name);
		    
		    sId = new JTextField(20);
		    sId.setBounds(20, 165, 307, 25);
		    addAtt.add(sId);
		        
		    name = new JLabel("Grade/Year Level");
		    name.setBounds(20, 190, 120, 25);
		    name.setForeground(cl.fontColor());
		    name.setFont (name.getFont ().deriveFont (12f));
		    addAtt.add(name);
		    
		    gradeYL = new JTextField(20);
		    gradeYL.setBounds(20, 215, 148, 25);
		    addAtt.add(gradeYL);
		    
		    Object[] columnNames = {"No.","Student ID","Last Name", "First Name", "M.I.", "Grade/Year Lvl.", "Course/Sec."};
		    
		    myTable = new JTable(new DefaultTableModel(new Object[][]{{}}, columnNames));
		    DefaultTableModel model = (DefaultTableModel) myTable.getModel();
		    model.removeRow(0);
		    
		    TableColumnModel tcm = myTable.getColumnModel();
		    tcm.getColumn(0).setPreferredWidth(40);    
		    tcm.getColumn(1).setPreferredWidth(90);    
		    tcm.getColumn(2).setPreferredWidth(90);   
		    tcm.getColumn(3).setPreferredWidth(90);    
		    tcm.getColumn(4).setPreferredWidth(40);
		    tcm.getColumn(5).setPreferredWidth(90);
		    tcm.getColumn(6).setPreferredWidth(80);
		    
		    myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		    
		    name = new JLabel("Course/Section");
		    name.setBounds(178, 190, 120, 25);
		    name.setForeground(cl.fontColor());
		    name.setFont (name.getFont ().deriveFont (12f));
		    addAtt.add(name);
		    
		    crSec = new JTextField(20);
		    crSec.setBounds(178, 215, 148, 25);
		    addAtt.add(crSec);
		    
		    JButton checkAtt = new JButton("Add");
		    checkAtt.setBounds(45,250,90,25);
		    checkAtt.addActionListener(new ActionListener() {
		    	public void actionPerformed (ActionEvent aa){
		    		
		    		AccountProcess aP = new AccountProcess();
		    		UserAccount uA = new UserAccount();
		  		    		
		    		String newFields[] = {"","","","","","",""};
	
		    		int i = 0;
		    		int c = 0, ct = 1;
		    		boolean valid = false;
		    		
		    		for(String s : getAddField()) {
		    			if(s.isEmpty()) {
		    				
		    				if(c == 0) {
		    					recName.setBorder(BorderFactory.createLineBorder(Color.RED));
		    				}
		    				else if(c == 1) {
		    					sId.setBorder(BorderFactory.createLineBorder(Color.RED));
		    				}
		    				else if(c == 2) {
		    					lName.setBorder(BorderFactory.createLineBorder(Color.RED));
		    				}
		    				else if(c == 3) {
		    					fName.setBorder(BorderFactory.createLineBorder(Color.RED));
		    				}
		    				else if(c == 5) {
		    					gradeYL.setBorder(BorderFactory.createLineBorder(Color.RED));
		    				}
		    				else if(c == 6) {
		    					crSec.setBorder(BorderFactory.createLineBorder(Color.RED));
		    				}
		    				
		    				if(c != 4) {
			    				valid = false;
			    				ct--;
		    				}
		    			}
		    			else {
		    				if(c == 0) {
		    					recName.setBorder(BorderFactory.createLineBorder(Color.gray));
		    				}
		    				else if(c == 1) {
		    					sId.setBorder(BorderFactory.createLineBorder(Color.gray));
		    				}
		    				else if(c == 2) {
		    					lName.setBorder(BorderFactory.createLineBorder(Color.gray));
		    				}
		    				else if(c == 3) {
		    					fName.setBorder(BorderFactory.createLineBorder(Color.gray));
		    				}
		    				else if(c == 5) {
		    					gradeYL.setBorder(BorderFactory.createLineBorder(Color.gray));
		    				}
		    				else if(c == 6) {
		    					crSec.setBorder(BorderFactory.createLineBorder(Color.gray));
		    				}
		    				if(ct==1)valid = true;
		    			}
		    			
		    			c++;
		    		}
		    		
		    		if(valid) {
		    			
		    		i = 0;
		    		for(String s : getAddField()) {
		    			if(i == 0) {
		    				newFields[i] = s;				
		    			}
		    			else {
		    				for(int a = 0; a < s.length(); a++) {
		    					if((int)s.charAt(a) != 44) {
		    						newFields[i] += s.charAt(a);
		    					}
		    				}
		    			}
		    			i++;
		    		}
		    		
		    		
		    		String addRec = "";
		    		
		    		for(int a = 1; a < 7; a++) {
		    			addRec += newFields[a];
		    			if(a < 6)
		    			addRec += ",";
		    		}
		    		
		    		fName.setText("");
		    		lName.setText("");
		    		mName.setText("");
		    		sId.setText("");
		    		
		    		
		    		aP.addRecord(addRec, newFields[0], UserAccount.userName);
		    	
		    		try {
						List<String> stats = uA.getStats();
						chkCount.setText(stats.get(1));
						recCount.setText(stats.get(0));
						lastChk.setText(stats.get(2));
						recNamel.setText(recName.getText());
					} catch (IOException e2) {
						e2.printStackTrace();
					}
		    		
		    		setList(aP.getRecordFiles(UserAccount.userName));
		    		
		    		mList.removeAllElements();
		    		
		    		for(String s : listRec) {
		    			mList.addElement(s);
		    		}
		    		
		    		
		    		DefaultTableModel model = (DefaultTableModel) myTable.getModel();
		    		
		    		
		    		if(!(lastRec.equals(recName.getText()))) {
		    			for (int x = model.getRowCount() - 1; x >= 0; x--) {
		    			    model.removeRow(x);
		    			}
		    		}
		    		
		    		lastRec = recName.getText();
		    		
		    		for (int x = model.getRowCount() - 1; x >= 0; x--) {
	    			    model.removeRow(x);
	    			}
		    		
		    	  	Object[][] rowData1 = setdashField(aP.readRecord(UserAccount.userName, newFields[0]));
		    	  	
		    	  	
		    	  	for(int a = 0; a < rowData1.length; a++) {
		    	  		model.addRow(new Object[] {rowData1[a][0],rowData1[a][1],
		    	  				rowData1[a][2],rowData1[a][3],rowData1[a][4],rowData1[a][5],
		    	  				rowData1[a][6]});
		    	  	}
		    	  	
		    		}
		    		else {
		    			JOptionPane.showMessageDialog(null, "Missing field/s.");
		    			
		    		}
		    	}
		    });
		    addAtt.add(checkAtt);
		    
		    JButton add = new JButton("Use Sheet");
		    add.setBounds(155,250,100,25);
		    add.addActionListener(new ActionListener() {
		    	public void actionPerformed (ActionEvent e){
		    		
		    		AccountProcess aP = new AccountProcess();
		    		
		    		JTextField newRec = new JTextField();
		    		
		    		String records [] = setList(aP.getRecordFiles(UserAccount.userName));
		    		
		    		JComboBox<String> existRec = new JComboBox<String>(records);
		    		
		    		
		    		Object[] ob = {
		    				"New Record: ", newRec,
		    				"------------------------------ OR ------------------------------",
		    				"User existing records:", existRec
		    		};
		    		
		    		Object[] op = {"Create new", "Use existing"};
		    		
		    		while(true) {
		    			try {
							int ch = JOptionPane.showOptionDialog(null,
								    ob,
								    "Use Sheet",
								    JOptionPane.YES_NO_CANCEL_OPTION,
								    JOptionPane.PLAIN_MESSAGE,
								    null, 
								    op,
								    null);
				    		
				    		if(ch == 0) {
				    			String newRecord = newRec.getText();
				    			openSheet = newRecord;
				    			
				    			if(newRecord.isEmpty()) {
				    				newRec.setBorder(BorderFactory.createLineBorder(Color.RED));
				    			}
				    			else {
				    				newRec.setBorder(BorderFactory.createLineBorder(Color.GRAY));
				    				String empty = "";
				    				aP.addRecord(empty, newRecord, UserAccount.userName);
				    				try  {  
				    					
				    					File file = new File("Users/"+ UserAccount.userName + "/Records/"+newRecord + ".csv");   
				    					
				    					if(!Desktop.isDesktopSupported()){  
				    						System.out.println("not supported");  
				    						return;  
				    					}  
				    					
				    					Desktop desktop = Desktop.getDesktop();  
				    					
				    					if(file.exists())        
				    						desktop.open(file);     
				    					
				    					refresh.setEnabled(true);
				    					break;
				    					}  
				    					catch(Exception a)  {  
				    						a.printStackTrace();  
				    					}  
				    			}
				    		}
				    		else if(ch == 1){
				    			try  {  
			    					String openRec = existRec.getSelectedItem().toString();
				    				openSheet = openRec;
			    					File file = new File("Users/"+ UserAccount.userName + "/Records/"+ openRec + ".csv");   
			    					
			    					if(!Desktop.isDesktopSupported()){  
			    						System.out.println("not supported");  
			    						return;  
			    					}  
			    					
			    					Desktop desktop = Desktop.getDesktop();  
			    					
			    					if(file.exists())        
			    						desktop.open(file);     
			    					refresh.setEnabled(true);
			    					break;
			    					}  
			    					catch(Exception a)  {  
			    						a.printStackTrace();  
			    					}  
				    		}
				    		else {
				    			break;
				    		}
				    		
		    			}catch(Exception ex) {
		    				ex.printStackTrace();  
		    			}
		    		}
		    	}});
		    addAtt.add(add);
	        		    
		    
		    name = new JLabel("Record: ");
		    name.setBounds(20, 290, 120, 25);
		    name.setForeground(cl.fontColor());
		    name.setFont (name.getFont ().deriveFont (12f));
		    addAtt.add(name);
		    
		    recNamel = new JLabel();
		    recNamel.setBounds(70, 290, 130, 25);
		    recNamel.setForeground(cl.fontColor());
		    recNamel.setBorder(BorderFactory.createLineBorder(Color.gray));
		    recNamel.setFont (recNamel.getFont ().deriveFont (12f));
		    addAtt.add(recNamel);
		    
		    refresh = new JButton("Refresh");
		    refresh.setBounds(220,290,90,25);
		    refresh.setEnabled(false);
		    refresh.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    	
		    		UserAccount uA = new UserAccount();
		    		AccountProcess aP = new AccountProcess();
		    		
		    		try {
						List<String> stats = uA.getStats();
						chkCount.setText(stats.get(1));
						recCount.setText(stats.get(0));
						lastChk.setText(stats.get(2));
						recNamel.setText(recName.getText());
					} catch (IOException e2) {
						e2.printStackTrace();
					}
		    		
		    		try {
		    		setList(aP.getRecordFiles(UserAccount.userName));
		    		}
		    		catch(Exception ex) {
		    			System.out.println(ex);
		    		}
		    		mList.removeAllElements();
		    		
		    		for(String s : listRec) {
		    			mList.addElement(s);
		    		}
		    		
		    		
		    		DefaultTableModel model = (DefaultTableModel) myTable.getModel();
		    				    		
		    		
		    		for (int x = model.getRowCount() - 1; x >= 0; x--) {
	    			    model.removeRow(x);
	    			}
		    		
		    		recName.setText(openSheet);
		    		
		    	  	Object[][] rowData1 = setdashField(aP.readRecord(UserAccount.userName, openSheet));
		    	  	
		    	  	
		    	  	for(int a = 0; a < rowData1.length; a++) {
		    	  		model.addRow(new Object[] {rowData1[a][0],rowData1[a][1],
		    	  				rowData1[a][2],rowData1[a][3],rowData1[a][4],rowData1[a][5],
		    	  				rowData1[a][6]});
		    	  	}
		    	  	
		    	}
		    });
		    addAtt.add(refresh);
		    
		    JScrollPane tb = new JScrollPane(myTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    tb.setBounds(20,325, 320, 165);
		    
		    addAtt.add(tb);
	    
	    }
	    
	    //Check Now
	    checkAt.setBackground(cl.bgColor());
	    checkAt.setLayout(null);
	    
	    Date dates = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    
	    h1 = new JLabel("DATE:");
	    h1.setBounds(200, 10, 50, 25);
	    h1.setForeground(cl.fontColor());
	    h1.setFont (h1.getFont ().deriveFont (12.6f));
	    checkAt.add(h1);
	    
	    JLabel date = new JLabel(sdf.format(dates).toString());
	    date.setBounds(250, 10, 80, 25);
	    date.setFont (h1.getFont ().deriveFont (12.6f));
	    checkAt.add(date);
	    
	    h1 = new JLabel("Student Information:");
	    h1.setBounds(15, 40, 250, 25);
	    h1.setForeground(cl.fontColor());
	    h1.setFont (h1.getFont ().deriveFont (12.6f));
	    checkAt.add(h1);
	    
	    name = new JLabel("Record : ");
	    name.setBounds(20,70, 80, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    checkAt.add(name);
	    
	    record = new JLabel(sInfo[0]);
	    record.setBounds(90,70, 230, 25);
	    record.setForeground(cl.fontColor());
	    record.setBorder(BorderFactory.createLineBorder(Color.gray));
	    record.setFont (record.getFont ().deriveFont (12f));
	    checkAt.add(record);
	    
	    name = new JLabel("Student Name: ");
	    name.setBounds(20,105, 120, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    checkAt.add(name);
	    
	    stName = new JLabel(sInfo[1]);
	    stName.setBounds(120, 105, 200, 25);
	    stName.setBorder(BorderFactory.createLineBorder(Color.gray));
	    stName.setFont (stName.getFont ().deriveFont (12f));
	    checkAt.add(stName);
	    
	    name = new JLabel("Student ID: ");
	    name.setBounds(20,135, 120, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    checkAt.add(name);
	    
	    stId = new JLabel(sInfo[2]);
	    stId.setBounds(120, 135, 200, 25);
	    stId.setBorder(BorderFactory.createLineBorder(Color.gray));
	    stId.setFont (stId.getFont ().deriveFont (12f));
	    checkAt.add(stId);
	    
	    name = new JLabel("Grade/Year Level: ");
	    name.setBounds(20,165, 120, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    checkAt.add(name);
	    
	    grdlvl = new JLabel(sInfo[3]);
	    grdlvl.setBounds(130, 165, 190, 25);
	    grdlvl.setBorder(BorderFactory.createLineBorder(Color.gray));
	    grdlvl.setFont (grdlvl.getFont ().deriveFont (12f));
	    checkAt.add(grdlvl);
	    
	    name = new JLabel("Course/Section: ");
	    name.setBounds(20,195, 120, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    checkAt.add(name);
	    
	    crsSec = new JLabel(sInfo[4]);
	    crsSec.setBounds(130, 195, 190, 25);
	    crsSec.setBorder(BorderFactory.createLineBorder(Color.gray));
	    crsSec.setFont (crsSec.getFont ().deriveFont (12f));
	    checkAt.add(crsSec);
	    
	    present = new JButton("Present");
	    present.setBounds(20,250,90,25);
	    present.setEnabled(false);
	    present.addActionListener(new ActionListener() {
	    	public void actionPerformed (ActionEvent e){
	    		
	    		AccountProcess aP = new AccountProcess();
	    		char state = 'P';
	    		
	    		Object readData[][] = setdashField(aP.readRecord(UserAccount.userName, list.getSelectedValue().toString()));
	    		
	    		Date dates = new Date();
	    		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
	    		Object disp[][] = {{null}};
	    		
	    		try {
					aP.recordAttendance(index, state, UserAccount.userName,list.getSelectedValue().toString());
		    		disp = aP.toDisplay(UserAccount.userName, list.getSelectedValue().toString() ,index);
	    		}catch (IOException e1) {
	    			System.out.println("Here2!");
					e1.printStackTrace();
				}
	    		openRec.setEnabled(true);
	    		
	    		DefaultTableModel model1 = (DefaultTableModel) myTable1.getModel();
	    		
	    		if(!colCreated) {
	    			model1.addColumn(sdf.format(dates));    
	    			colCreated = true;
	    		}
	    		
	    		TableColumnModel tcm = myTable1.getColumnModel();
	    		tcm.getColumn(0).setPreferredWidth(40);    
	    	    tcm.getColumn(1).setPreferredWidth(80);    
	    	    tcm.getColumn(2).setPreferredWidth(80);   
	    	    tcm.getColumn(3).setPreferredWidth(80);    
	    	    tcm.getColumn(4).setPreferredWidth(40);
	    		tcm.getColumn(5).setPreferredWidth(40);    
	    		
	    		for (int x = model1.getRowCount() - 1; x >= 0; x--) {
    			    model1.removeRow(x);
    			}
	    		
	    		for(int a = 0; a <= index; a++) {
	    			model1.addRow(new Object[]{disp[a][0],disp[a][1],disp[a][2],disp[a][3],disp[a][4],disp[a][5]});
	    		}
	    		
	    		int count = aP.readRecord(UserAccount.userName,list.getSelectedValue().toString()).size();
            	if(index < count-1){
            		index++;
		    		stName.setText(" "+readData[index][2].toString().toUpperCase() + ", " + readData[index][3].toString() + " " + readData[index][4].toString());
	            	stId.setText(" " + readData[index][1].toString());
	            	grdlvl.setText(" " + readData[index][5].toString());
	            	crsSec.setText(" " + readData[index][6].toString());
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Check attendance is complete, good job!");
	    			present.setEnabled(false);
	    			absent.setEnabled(false);
	    			late.setEnabled(false);
	    		}
            	
            	aP.attendanceSet(UserAccount.userName, list.getSelectedValue().toString());
	    	}
	    });
	    checkAt.add(present);
	    
	    absent = new JButton("Absent");
	    absent.setBounds(130,250,90,25);
	    absent.addActionListener(new ActionListener() {
	    	public void actionPerformed (ActionEvent e){
	    		
	    		AccountProcess aP = new AccountProcess();
	    		char state = 'A';
	    		
	    		Object readData[][] = setdashField(aP.readRecord(UserAccount.userName, list.getSelectedValue().toString()));
	    		
	    		Date dates = new Date();
	    		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
	    		Object disp[][] = {{null}};
	    		
	    		try {
					aP.recordAttendance(index, state, UserAccount.userName,list.getSelectedValue().toString());
		    		disp = aP.toDisplay(UserAccount.userName, list.getSelectedValue().toString() ,index);
	    		}catch (IOException e1) {
	    			System.out.println("Here2!");
					e1.printStackTrace();
				}
	    		
	    		openRec.setEnabled(true);
	    		DefaultTableModel model1 = (DefaultTableModel) myTable1.getModel();
	    		
	    		if(!colCreated) {
	    			model1.addColumn(sdf.format(dates));    
	    			colCreated = true;
	    		}
	    		
	    		TableColumnModel tcm = myTable1.getColumnModel();
	    		tcm.getColumn(0).setPreferredWidth(40);    
	    	    tcm.getColumn(1).setPreferredWidth(80);    
	    	    tcm.getColumn(2).setPreferredWidth(80);   
	    	    tcm.getColumn(3).setPreferredWidth(80);    
	    	    tcm.getColumn(4).setPreferredWidth(40);
	    		tcm.getColumn(5).setPreferredWidth(40);    
	    		
	    		for (int x = model1.getRowCount() - 1; x >= 0; x--) {
    			    model1.removeRow(x);
    			}
	    		
	    		for(int a = 0; a <= index; a++) {
	    			model1.addRow(new Object[]{disp[a][0],disp[a][1],disp[a][2],disp[a][3],disp[a][4],disp[a][5]});
	    		}
	    		
	    		int count = aP.readRecord(UserAccount.userName,list.getSelectedValue().toString()).size();
            	if(index < count-1){
            		index++;
		    		stName.setText(" "+readData[index][2].toString().toUpperCase() + ", " + readData[index][3].toString() + " " + readData[index][4].toString());
	            	stId.setText(" " + readData[index][1].toString());
	            	grdlvl.setText(" " + readData[index][5].toString());
	            	crsSec.setText(" " + readData[index][6].toString());
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Check attendance is complete, good job!");
	    			present.setEnabled(false);
	    			absent.setEnabled(false);
	    			late.setEnabled(false);
	    		}
            	aP.attendanceSet(UserAccount.userName, list.getSelectedValue().toString());
	    	}
	    });
	    absent.setEnabled(false);
	    checkAt.add(absent);
	    
	    late = new JButton("Late");
	    late.setBounds(240,250,80,25);
	    late.addActionListener(new ActionListener() {
	    	public void actionPerformed (ActionEvent e){
	    		
	    		AccountProcess aP = new AccountProcess();
	    		char state = 'L';
	    		
	    		Object readData[][] = setdashField(aP.readRecord(UserAccount.userName, list.getSelectedValue().toString()));
	    		
	    		Date dates = new Date();
	    		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
	    		Object disp[][] = {{null}};
	    		
	    		try {
					aP.recordAttendance(index, state, UserAccount.userName,list.getSelectedValue().toString());
		    		disp = aP.toDisplay(UserAccount.userName, list.getSelectedValue().toString() ,index);
	    		}catch (IOException e1) {
	    			System.out.println("Here2!");
					e1.printStackTrace();
				}
	    		
	    		openRec.setEnabled(true);
	    		DefaultTableModel model1 = (DefaultTableModel) myTable1.getModel();
	    		
	    		if(!colCreated) {
	    			model1.addColumn(sdf.format(dates));    
	    			colCreated = true;
	    		}
	    		
	    		TableColumnModel tcm = myTable1.getColumnModel();
	    		tcm.getColumn(0).setPreferredWidth(40);    
	    	    tcm.getColumn(1).setPreferredWidth(80);    
	    	    tcm.getColumn(2).setPreferredWidth(80);   
	    	    tcm.getColumn(3).setPreferredWidth(80);    
	    	    tcm.getColumn(4).setPreferredWidth(40);
	    		tcm.getColumn(5).setPreferredWidth(40);    
	    		
	    		for (int x = model1.getRowCount() - 1; x >= 0; x--) {
    			    model1.removeRow(x);
    			}
	    		
	    		for(int a = 0; a <= index; a++) {
	    			model1.addRow(new Object[]{disp[a][0],disp[a][1],disp[a][2],disp[a][3],disp[a][4],disp[a][5]});
	    		}
	    		
	    		int count = aP.readRecord(UserAccount.userName,list.getSelectedValue().toString()).size();
            	if(index < count-1){
            		index++;
		    		stName.setText(" "+readData[index][2].toString().toUpperCase() + ", " + readData[index][3].toString() + " " + readData[index][4].toString());
	            	stId.setText(" " + readData[index][1].toString());
	            	grdlvl.setText(" " + readData[index][5].toString());
	            	crsSec.setText(" " + readData[index][6].toString());
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Check attendance is complete, good job!");
	    			present.setEnabled(false);
	    			absent.setEnabled(false);
	    			late.setEnabled(false);
	    		}
            	aP.attendanceSet(UserAccount.userName, list.getSelectedValue().toString());
	    	}
	    });
	    late.setEnabled(false);
	    checkAt.add(late);
	    
	    name = new JLabel("History: ");
	    name.setBounds(20,290, 120, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    checkAt.add(name);
	    
	    Object[] columnNames = {"No.","Student ID","Last Name", "First Name", "M.I."};
	    
	    myTable1 = new JTable(new DefaultTableModel(new Object[][]{{}}, columnNames));
	    DefaultTableModel model1 = (DefaultTableModel) myTable1.getModel();
	    model1.removeRow(0);
	    
	    TableColumnModel tcm = myTable1.getColumnModel();
	    tcm.getColumn(0).setPreferredWidth(40);    
	    tcm.getColumn(1).setPreferredWidth(80);    
	    tcm.getColumn(2).setPreferredWidth(80);   
	    tcm.getColumn(3).setPreferredWidth(80);    
	    tcm.getColumn(4).setPreferredWidth(40);
	    
	    myTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    myTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    myTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	    	public void valueChanged(ListSelectionEvent event) {
	        	
	        	if(once){
	        		selected = myTable2.getSelectedRow();
	        		
	        		once = false;
	        		fName.setText("");
					lName.setText("");
					mName.setText("");
					sId.setText("");
					gradeYL.setText("");
					crSec.setText("");
	        	}
	        	else {
	        		once = true;
	        	}
	        }
	    });
	    
	    JScrollPane tb1 = new JScrollPane(myTable1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    tb1.setBounds(20,310, 307, 150);
	    checkAt.add(tb1);
	    
	    
	    //Edit/Edit 
	    delEd.setBackground(cl.bgColor());
	    delEd.setLayout(null);
	    
	    h1 = new JLabel("Edit or delete a specific student:");
	    h1.setBounds(15, 15, 250, 20);
	    h1.setForeground(cl.fontColor());
	    h1.setFont (h1.getFont ().deriveFont (13f));
	    delEd.add(h1);
	    
	    name = new JLabel("Choose your record:");
	    name.setBounds(20, 50, 150, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (13f));
	    delEd.add(name);
	    
	    JComboBox<String> records = new JComboBox<String>();
	    records.setModel(new DefaultComboBoxModel<String>(listRec));
	    records.setBounds(20, 80, 307, 25);
	    
	    records.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	
            	AccountProcess aP = new AccountProcess();
            	DefaultTableModel model2 = (DefaultTableModel) myTable2.getModel();
            	
            	for (int x = model2.getRowCount() - 1; x >= 0; x--) {
    			    model2.removeRow(x);
    			}
	    		
	    	  	Object[][] rowData1 = setdashField(aP.readRecord(UserAccount.userName, records.getSelectedItem().toString()));
	    	  	
	    	  	
	    	  	for(int a = 0; a < rowData1.length; a++) {
	    	  		model2.addRow(new Object[] {rowData1[a][0],rowData1[a][1],
	    	  				rowData1[a][2],rowData1[a][3],rowData1[a][4],rowData1[a][5],
	    	  				rowData1[a][6]});
	    	  	}
	    	  	
            }
	    });
	    delEd.add(records);
	    
	    Object[] columns = {"No.","Student ID","Last Name", "First Name", "M.I.", "Grade/Year Lvl.", "Course/Sec."};
	    
	    myTable2 = new JTable(new DefaultTableModel(new Object[][]{{}}, columns));
	    DefaultTableModel model2 = (DefaultTableModel) myTable2.getModel();
	    
	    model2.removeRow(0);
	    
	    myTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    myTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	
	        	if(once){
	        		selected = myTable2.getSelectedRow();
	        		once = false;
	        		fName1.setText("");
					lName1.setText("");
					mName1.setText("");
					sId1.setText("");
					gradeYL1.setText("");
					crSec1.setText("");
	        	}
	        	else {
	        		once = true;
	        	}
	        }
	    });
	    
	    TableColumnModel tcm2 = myTable2.getColumnModel();
	    tcm2.getColumn(0).setPreferredWidth(40);    
	    tcm2.getColumn(1).setPreferredWidth(90);    
	    tcm2.getColumn(2).setPreferredWidth(90);   
	    tcm2.getColumn(3).setPreferredWidth(90);    
	    tcm2.getColumn(4).setPreferredWidth(40);
	    tcm2.getColumn(5).setPreferredWidth(90);
	    tcm2.getColumn(6).setPreferredWidth(80);
	    
	    myTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    JScrollPane tb = new JScrollPane(myTable2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    tb.setBounds(20,110, 307, 150);
	    delEd.add(tb);
	    
	    JButton edit = new JButton("Edit");
	    edit.setBounds(45, 270, 100, 25);
	    edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AccountProcess aP = new AccountProcess();
				
				Object[][] rowData1 = setdashField(aP.readRecord(UserAccount.userName, records.getSelectedItem().toString()));
				
				fName1.setText(rowData1[selected][3].toString());
				lName1.setText(rowData1[selected][2].toString());
				mName1.setText(rowData1[selected][4].toString());
				sId1.setText(rowData1[selected][1].toString());
				gradeYL1.setText(rowData1[selected][5].toString());
				crSec1.setText(rowData1[selected][6].toString());
				
			}
	    });
	    delEd.add(edit);
	    
	    JButton delete = new JButton("Delete");
	    delete.setBounds(180, 270, 120, 25);
	    delete.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		AccountProcess aP = new AccountProcess();
	    		
	    		try {
					aP.deleteRecord(selected, 1,  UserAccount.userName, records.getSelectedItem().toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    		
	    		JOptionPane.showMessageDialog(null, "Successfully deleted.");
	    		
            	DefaultTableModel model2 = (DefaultTableModel) myTable2.getModel();
            	
            	for (int x = model2.getRowCount() - 1; x >= 0; x--) {
    			    model2.removeRow(x);
    			}
	    		
	    	  	Object[][] rowData1 = setdashField(aP.readRecord(UserAccount.userName, records.getSelectedItem().toString()));
	    	  	
	    	  	
	    	  	for(int a = 0; a < rowData1.length; a++) {
	    	  		model2.addRow(new Object[] {rowData1[a][0],rowData1[a][1],
	    	  				rowData1[a][2],rowData1[a][3],rowData1[a][4],rowData1[a][5],
	    	  				rowData1[a][6]});
	    	  	}
	    	  	
	    	}
	    });
	    delEd.add(delete);
	    
	    name = new JLabel("First Name");
	    name.setBounds(20, 300, 80, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    delEd.add(name);
	    
	    fName1 = new JTextField(20);
	    fName1.setBounds(20, 325, 100, 25);
	    fName1.setText(infoS[0]);
	    delEd.add(fName1);
	    
	    name = new JLabel("Last Name");
	    name.setBounds(128, 300, 80, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    delEd.add(name);
	    
	    lName1 = new JTextField(30);
	    lName1.setBounds(128, 325, 137, 25);
	    lName1.setText(infoS[1]);
	    delEd.add(lName1);
	    
	    name = new JLabel("M.I.");
	    name.setBounds(275, 300, 80, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    delEd.add(name);
	    
	    mName1 = new JTextField(30);
	    mName1.setBounds(275, 325, 52, 25);
	    mName1.setText(infoS[2]);
	    delEd.add(mName1);
	    
	    name = new JLabel("Student ID");
	    name.setBounds(20, 355, 80, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    delEd.add(name);
	    
	    sId1 = new JTextField(20);
	    sId1.setBounds(20, 380, 307, 25);
	    delEd.add(sId1);
	        
	    name = new JLabel("Grade/Year Level");
	    name.setBounds(20, 405, 120, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    delEd.add(name);
	    
	    gradeYL1 = new JTextField(20);
	    gradeYL1.setBounds(20, 430, 148, 25);
	    delEd.add(gradeYL1);
	    
	    name = new JLabel("Course/Section");
	    name.setBounds(178, 405, 120, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    delEd.add(name);
	    
	    crSec1 = new JTextField(20);
	    crSec1.setBounds(178, 430, 148, 25);
	    delEd.add(crSec1);
	    
	    JButton save = new JButton("Save changes");
	    save.setBounds(100, 465, 120, 25);
	    save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AccountProcess aP = new AccountProcess();
				
				List<String> newList = new ArrayList<String>();
				
				newList.add(sId1.getText().toString());
				newList.add(lName1.getText().toString());
				newList.add(fName1.getText().toString());
				newList.add(mName1.getText().toString());
				newList.add(gradeYL1.getText().toString());
				newList.add(crSec1.getText().toString());
				
				String newData = (selected+1) +"," + sId1.getText().toString() + "," + 
				lName1.getText().toString() + "," + fName1.getText().toString() + ","+
				mName1.getText().toString() + "," + gradeYL1.getText().toString() + "," + 
				crSec1.getText().toString();
				
				int c = 0, ct = 1;
				boolean valid = false;
				for(String s : newList) {
	    			if(s.isEmpty()) {
	    				
	    				if(c == 0) {
	    					sId1.setBorder(BorderFactory.createLineBorder(Color.RED));
	    				}
	    				else if(c == 1) {
	    					lName1.setBorder(BorderFactory.createLineBorder(Color.RED));
	    				}
	    				else if(c == 2) {
	    					fName1.setBorder(BorderFactory.createLineBorder(Color.RED));
	    				}
	    				else if(c == 3) {
	    					mName1.setBorder(BorderFactory.createLineBorder(Color.RED));
	    				}
	    				else if(c == 4) {
	    					gradeYL1.setBorder(BorderFactory.createLineBorder(Color.RED));
	    				}
	    				else if(c == 5) {
	    					crSec1.setBorder(BorderFactory.createLineBorder(Color.RED));
	    				}
	    				
		    			valid = false;
		    			ct--;
	    				
	    			}
	    			else {
	    				if(c == 0) {
	    					sId1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	    				}
	    				else if(c == 1) {
	    					lName1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	    				}
	    				else if(c == 2) {
	    					fName1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	    				}
	    				else if(c == 3) {
	    					mName1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	    				}
	    				else if(c == 4) {
	    					gradeYL1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	    				}
	    				else if(c == 5) {
	    					crSec1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	    				}
	    				
	    				if(ct==1)valid = true;
	    			}
	    			c++;
	    		}
				
				if(valid) {
					try {
						aP.editRecord(selected, newData, UserAccount.userName, records.getSelectedItem().toString());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
	            	DefaultTableModel model2 = (DefaultTableModel) myTable2.getModel();
	            	
	            	for (int x = model2.getRowCount() - 1; x >= 0; x--) {
	    			    model2.removeRow(x);
	    			}
		    		
		    	  	Object[][] rowData1 = setdashField(aP.readRecord(UserAccount.userName, records.getSelectedItem().toString()));
		    	  	
		    	  	
		    	  	for(int a = 0; a < rowData1.length; a++) {
		    	  		model2.addRow(new Object[] {rowData1[a][0],rowData1[a][1],
		    	  				rowData1[a][2],rowData1[a][3],rowData1[a][4],rowData1[a][5],
		    	  				rowData1[a][6]});
		    	  	}
					
		    	  	fName1.setText("");
					lName1.setText("");
					mName1.setText("");
					sId1.setText("");
					gradeYL1.setText("");
					crSec1.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Missing field/s.");
				}
				//myTable2.setRowSelectionInterval(selected, 6);
			}
	    });
	    delEd.add(save);
	    
	    deleteRec.setBackground(cl.bgColor());
	    deleteRec.setLayout(null);
	    
	    h1 = new JLabel("Delete a record:");
	    h1.setBounds(15, 15, 250, 20);
	    h1.setForeground(cl.fontColor());
	    h1.setFont (h1.getFont ().deriveFont (13f));
	    deleteRec.add(h1);
	    
	    name = new JLabel("Choose record to delete:");
	    name.setBounds(20, 50, 200, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (13f));
	    deleteRec.add(name);
	    
	    JComboBox<String> records1 = new JComboBox<String>(listRec);
	    records1.setBounds(20, 80, 307, 25);
	    deleteRec.add(records1);
	    
	    JLabel name11 = new JLabel("Retype record name to delete:");
	    name11.setBounds(20, 150, 300, 25);
	    name11.setForeground(cl.fontColor());
	    name11.setFont (name11.getFont ().deriveFont (12f));
	    name11.setVisible(false);
	    deleteRec.add(name11);
	    
	    JTextField confirm1 = new JTextField(20);
	    confirm1.setBounds(20, 175, 307, 25);
	    confirm1.setVisible(false);
	    deleteRec.add(confirm1);
	    
	    JButton conDelete = new JButton("Confirm");
	    conDelete.setBounds(120, 205, 100, 25);
	    conDelete.setVisible(false);
	    conDelete.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		AccountProcess aP = new AccountProcess();
	    		UserAccount uA = new UserAccount();
	    		
	    		System.out.println(confirm1.getText());
	    		System.out.println(records1.getSelectedItem().toString());
	    		
	    		if(confirm1.getText().toString().equals(records1.getSelectedItem().toString())) {
	    			try {
						aP.deleteRecord(1, 2,UserAccount.userName , records1.getSelectedItem().toString());
						try {
							List<String> stats = uA.getStats();
							chkCount.setText(stats.get(1));
							recCount.setText(stats.get(0));
							lastChk.setText(stats.get(2));
							recNamel.setText(recName.getText());
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	    			
	    			name11.setVisible(false);
	    			confirm1.setVisible(false);
	    			conDelete.setVisible(false);
	    			tp.setSelectedComponent(checkAt);
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Failed to confirm record name.");
	    		}
	    		
	    	}
	    });
	    deleteRec.add(conDelete);
	    
	    JButton delete1 = new JButton("Delete");
	    delete1.setBounds(120, 120, 100, 25);
	    delete1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		JOptionPane.showMessageDialog(null, "Confirm to delete record.");
	    		
	    		name11.setVisible(true);
	    		confirm1.setVisible(true);
	    		conDelete.setVisible(true);	    		
	    	}
	    	
	    });
	    deleteRec.add(delete1);
	    
	    tp = new JTabbedPane();
	    tp.setBounds(10,20, 365, 535);
	    tp.setFont(tp.getFont ().deriveFont(11));
	    tp.setBackground(cl.bgColor());
	    tp.add(checkAt, "Check Now");
	    tp.add(addAtt, "Add Record");
	    tp.add(delEd, "Edit/Delete");
	    tp.add(deleteRec, "Delete Record");
	    tp.addChangeListener((ChangeListener) new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	            AccountProcess aP = new AccountProcess();
	        	
	        	list.clearSelection();
	        	records.setModel(new DefaultComboBoxModel<String>(listRec));
	        	index = 0;
	        	setList(aP.getRecordFiles(UserAccount.userName));
	    		
	    		mList.removeAllElements();
	    		
	    		for(String s : listRec) {
	    			mList.addElement(s);
	    		}
	    		
	    		
	        
	        }
	    });
	    	    
	    panel_2.add(tp);
	    
	    panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Dashboard",
                TitledBorder.LEFT,TitledBorder.TOP, panel.getFont ().deriveFont (15f)));
	    
	    panel_2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Process",
                TitledBorder.LEFT,TitledBorder.TOP, panel.getFont ().deriveFont (15f)));
	    
	    frame.add(panel, BorderLayout.WEST);
	    frame.add(panel_2, BorderLayout.CENTER);
        frame.setVisible(true);
       
				
	}
	
	public List<String> getAddField() {
		
		List<String> addRec = new ArrayList<String>();
		
		addRec.add(recName.getText());
		addRec.add(sId.getText());
		addRec.add(lName.getText());
		addRec.add(fName.getText());
		addRec.add(mName.getText());
		addRec.add(gradeYL.getText());
		addRec.add(crSec.getText());
		
		return addRec;
	}
	
	public Object[][] setdashField(List<String> list) {
		
		Object [][] rowData = new Object[list.size()][7];
		
		int i = 0;
		for(String s : list) {
			
			StringTokenizer st = new StringTokenizer(s, ",");
			
			int j = 0;
			while(st.hasMoreTokens()) {
				rowData[i][j] = st.nextToken();
				j++;
			}
			i++;
		}
		
		return rowData;
	}
	
	
	public void createAccount() {
			
		frame = new JFrame("Attendance Checker  v0.1");
		panel = new JPanel();
		
		frame.setIconImage(logo.getImage());
		frame.setSize(430, 470);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    panel.setBackground(cl.bgColor());
	    frame.add(panel);
	    panel.setLayout(null);
	    
	    JLabel h1 = new JLabel("Create your account:");
	    h1.setBounds(30, 25, 250, 20);
	    h1.setForeground(cl.fontColor());
	    h1.setFont (h1.getFont ().deriveFont (13f));
	    panel.add(h1);
	    
	    JLabel name = new JLabel("Name");
	    name.setBounds(40, 55, 80, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    panel.add(name);
	    
	    fName = new JTextField(20);
	    fName.setBounds(40, 80, 100, 25);
	    fName.setText(infoS[0]);
	    panel.add(fName);
	    
	    lFName = new JLabel("First Name");
	    lFName.setBounds(42, 100, 80, 20);
	    lFName.setForeground(cl.fontColor());
	    lFName.setFont (lFName.getFont ().deriveFont (11.0f));
	    panel.add(lFName);
	    
	    lName = new JTextField(30);
	    lName.setBounds(148, 80, 137, 25);
	    lName.setText(infoS[1]);
	    panel.add(lName);
	    
	    lLName = new JLabel("Last Name");
	    lLName.setBounds(150, 100, 80, 20);
	    lLName.setForeground(cl.fontColor());
	    lLName.setFont (lLName.getFont ().deriveFont (11.0f));
	    panel.add(lLName);
	    
	    mName = new JTextField(30);
	    mName.setBounds(295, 80, 52, 25);
	    mName.setText(infoS[2]);
	    panel.add(mName);
	    
	    mLName = new JLabel("M.I.");
	    mLName.setBounds(297, 100, 80, 20);
	    mLName.setForeground(cl.fontColor());
	    mLName.setFont (mLName.getFont ().deriveFont (11.0f));
	    panel.add(mLName);
	    
	    lAddress = new JLabel("Address");
	    lAddress.setBounds(40, 125, 80, 25);
	    lAddress.setForeground(cl.fontColor());
	    lAddress.setFont (lAddress.getFont ().deriveFont (12f));
	    panel.add(lAddress);
	    
	    fAddress = new JTextField(20);
	    fAddress.setBounds(40, 150, 307, 25);
	    fAddress.setText(infoS[3]);
	    panel.add(fAddress);
	    
	    lEmail = new JLabel("Email");
	    lEmail.setBounds(40, 180, 80, 25);
	    lEmail.setForeground(cl.fontColor());
	    lEmail.setFont (lEmail.getFont ().deriveFont (12f));
	    panel.add(lEmail);
	    
	    email = new JTextField(20);
	    email.setBounds(40, 205, 307, 25);
	    email.setText(infoS[4]);
	    panel.add(email);
	    
	    lMobile = new JLabel("Mobile No.");
	    lMobile.setBounds(40, 235, 80, 25);
	    lMobile.setForeground(cl.fontColor());
	    lMobile.setFont (lMobile.getFont ().deriveFont (12f));
	    panel.add(lMobile);
	    
	    mNumber = new JTextField(20);
	    mNumber.setBounds(40, 260, 307, 25);
	    mNumber.setText(infoS[5]);
	    panel.add(mNumber);
	    
	    name = new JLabel("Gender");
	    name.setBounds(40, 295, 120, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    panel.add(name);
	    
	    male = new JRadioButton("Male"); 
	    male.setBounds(40, 325, 60, 25);
	    male.setSelected(infoS[6] == "Male" ? true : false);
		
	    male.setBackground(cl.bgColor());
	    
	    female = new JRadioButton("Female"); 
	    female.setBounds(110, 325, 90, 25);
	    female.setSelected(infoS[6] == "Female" ? true : false);
	    female.setBackground(cl.bgColor());
	    ButtonGroup bg=new ButtonGroup(); 
	    
	    bg.add(male);
	    bg.add(female);
	    
	    panel.add(male);
	    panel.add(female);	    
	    
	    name = new JLabel("Age");
	    name.setBounds(205, 295, 120, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    panel.add(name);
	    
	    SpinnerModel ageM=  new SpinnerNumberModel(1,1,100,1);
	     
	    age = new JSpinner(ageM);
	    age.setBounds(205, 325, 140, 25);
	    age.setValue(Integer.parseInt(infoS[7]));
	    panel.add(age);
	    
	    RoundButton rb = new RoundButton(10);
	    
	    JButton next = new JButton("Next");
	    next.setBounds(70,370,80,30);
	    next.setBorder(rb);
	    next.addActionListener(new NextButton());
	    panel.add(next);
	    
	    
	    JButton cancel = new JButton("Cancel");
	    cancel.setBounds(170,370,80,30);
	    cancel.setBorder(rb);
	    cancel.addActionListener(new CancelButton());
	    panel.add(cancel);
	    
	    error = new JLabel(eks);
	    error.setBounds(235, 373,80,25);
	    error.setIcon(null);
	    panel.add(error);
	    
	    lError = new JLabel("");
	    lError.setBounds(290, 373, 120, 25);
	    lError.setForeground(cl.errorFont());
	    panel.add(lError);
	    
	    frame.setVisible(true);
	    
	}
		
	public void setData() {
		
		int i = 0;
		for(String s : userInfo) {
			infoS[i] = s;
			i++;
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public List<String> getCred(){
		userInfo.clear();
		
		userInfo.add(userName.getText());
		userInfo.add(password.getText());
		
		return userInfo;
	}
	
	public List<String> getData(){
		userInfo.clear();
		
		userInfo.add(fName.getText());
	    userInfo.add(lName.getText());
	    userInfo.add(mName.getText());
	    userInfo.add(fAddress.getText());
	    userInfo.add(email.getText());
	    userInfo.add(mNumber.getText());
	    userInfo.add(male.isSelected() ? "Male" : "Female");
	    userInfo.add(age.getValue().toString());
	    
		return userInfo;
	}
	
	@SuppressWarnings("deprecation")
	public boolean vPass() {
		
		return password.getText().equals(cPassword.getText());
				
	}
	
	@SuppressWarnings("deprecation")
	public List<String> getData1(){
		userInfo1.clear();
		
		userInfo1.add(userName.getText());
		userInfo1.add(password.getText());
		userInfo1.add(cPassword.getText());
		
		return userInfo1;
	}
	
	
	public void loginAccount() {
		
		frame = new JFrame("Attendance Checker  v0.1");
		panel = new JPanel();
		
		frame.setIconImage(logo.getImage());
		frame.setSize(430, 450);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    panel.setBackground(cl.bgColor());
	    frame.add(panel);
	    panel.setLayout(null);
	    
	    JLabel h1 = new JLabel("LOGIN", SwingConstants.CENTER);
	    h1.setBounds(75, 25, 250, 20);
	    h1.setForeground(cl.fontColor());
	    h1.setFont (h1.getFont ().deriveFont (13f));
	    panel.add(h1);
	    
	    JLabel name = new JLabel("Username");
	    name.setBounds(70, 145, 140, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    panel.add(name);
	    
	    JLabel icon = new JLabel(username);
	    icon.setBounds(40, 170, 80, 25);
	    panel.add(icon);
	    
	    userName = new JTextField(20);
	    userName.setBounds(100, 170, 235, 25);
	    panel.add(userName);
	    
	    name = new JLabel("Password");
	    name.setBounds(70, 200, 190, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    panel.add(name);
	    
	    icon = new JLabel(lock);
	    icon.setBounds(40, 225, 80, 25);
	    panel.add(icon);
		
	    password = new JPasswordField(20);
	    password.setBounds(100, 225, 235, 25);
	    panel.add(password);
	    
	    JButton agreeB = new JButton();
	    agreeB.setBounds(60, 255, 200,25);
	    agreeB.setText("Create new account?");
	    agreeB.setFont(agreeB.getFont ().deriveFont (12));
	    agreeB.setBorderPainted(false);
	    agreeB.setFocusPainted(false);
	    agreeB.setOpaque(false);
	    agreeB.setBackground(cl.bgColor());
	    agreeB.addActionListener(new CreateAccountButton());
	    panel.add(agreeB);
	    
	    /*agreeB = new JButton();
	    agreeB.setBounds(65, 275, 200,25);
	    agreeB.setText("Forgot your password?");
	    agreeB.setFont(agreeB.getFont ().deriveFont (12));
	    agreeB.setBorderPainted(false);
	    agreeB.setFocusPainted(false);
	    agreeB.setOpaque(false);
	    agreeB.setBackground(cl.bgColor());
	    agreeB.addActionListener(new ActionListener() {
	    	
	    	
	    });*/
	    
	    panel.add(agreeB);
	    
	    error = new JLabel(eks);
	    error.setBounds(70, 305, 80, 25);
	    error.setIcon(null);
	    panel.add(error);
	    
	    lError = new JLabel("");
	    lError.setBounds(125,305, 250, 25);
	    lError.setForeground(cl.errorFont());
	    panel.add(lError);	    
	    
	    JButton logIn = new JButton("Login");
	    logIn.setBounds(140,340,120,30);
	    logIn.addActionListener(new LoginButton());
	    logIn.setFont(logIn.getFont ().deriveFont (12.5f));
	    panel.getRootPane().setDefaultButton(logIn);
	    panel.add(logIn);
	    
	    
	    frame.setVisible(true);
	}
	
	
	public void createPass() {
		
		JPanel panel2 = new JPanel();
		
	    frame = new JFrame("Attendance Checker  v0.1");
	    frame.setIconImage(logo.getImage());
		frame.setSize(400, 430);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.add(panel2);
		panel2.setLayout(null);
		panel2.setBackground(cl.bgColor());
	    
		JLabel h1 = new JLabel("Create your username and password:");
		h1.setBounds(65, 30, 250, 25);
		h1.setForeground(cl.fontColor());
		h1.setFont (h1.getFont ().deriveFont (12f));
		panel2.add(h1);
			    
	    JLabel name = new JLabel("Username");
	    name.setBounds(70, 70, 140, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    panel2.add(name);
	    
	    userName = new JTextField(20);
	    userName.setBounds(70, 95, 245, 25);
	    panel2.add(userName);
	    
	    name = new JLabel("Password");
	    name.setBounds(70, 125, 190, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    panel2.add(name);
	    
	    password = new JPasswordField(20);
	    password.setBounds(70, 150, 245, 25);
	    panel2.add(password);
	    
	    name = new JLabel("Confirm Password");
	    name.setBounds(70, 180, 220, 25);
	    name.setForeground(cl.fontColor());
	    name.setFont (name.getFont ().deriveFont (12f));
	    panel2.add(name);
	    
	    cPassword = new JPasswordField(20);
	    cPassword.setBounds(70, 205, 245, 25);
	    panel2.add(cPassword);
	    
	    agree = new JCheckBox("",false);
	    agree.setBounds(70, 235, 20,25);
	    agree.setBackground(cl.bgColor());
	    agree.setForeground(cl.bgColor());
	    panel2.add(agree);
	    
	    JButton agreeB = new JButton();
	    agreeB.setBounds(80, 235, 210,25);
	    agreeB.setText("<HTML>I accept the <FONT color=\"#000099\"><U>user-agreement.</U></FONT></HTML>");
	    agreeB.setHorizontalAlignment(SwingConstants.LEFT);
	    agreeB.setBorderPainted(false);
	    agreeB.setOpaque(false);
	    agreeB.setBackground(cl.bgColor());
	    agreeB.addActionListener(new UserAgreeButton());
	    agreeB.setToolTipText("Click to read user agreements.");
	    panel2.add(agreeB);
	    RoundButton rb = new RoundButton(10);
	    
	    error = new JLabel(eks);
	    error.setBounds(40, 265, 80, 25);
	    error.setIcon(null);
	    panel2.add(error);
	    
	    lError = new JLabel("");
	    lError.setBounds(95,265, 250, 25);
	    lError.setForeground(cl.errorFont());
	    panel2.add(lError);
	    
	    JButton next = new JButton("Back");
	    next.setBounds(75,305,80,30);
	    next.setBorder(rb);
	    next.addActionListener(new BackButton());
	    panel2.add(next);
	    
	    JButton cancel = new JButton("Sign Up");
	    cancel.setBounds(190,305,90,30);
	    cancel.setBorder(rb);
	    cancel.addActionListener(new SignUpButton());
	    panel2.add(cancel);
	    
	    frame.setVisible(true);
		
	}
	
}
