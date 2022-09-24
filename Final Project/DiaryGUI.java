package layout;

//Rahul Vedula
//ICS3U
//June 10, 2022
//Mr.Hudson

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.border.Border;

import javax.swing.*;

//Diary Class—holds all functions, variables and info related to the diary object
class Diary {
  String diaryOwner;
  String ownerAge;
  String ownerAddress;
  String ownerPhone;
  String ownerEmail;  
  String password; 
  ArrayList<String> entries = new ArrayList<String>();
  
 public static Scanner input = new Scanner(System.in);
  public Diary(){
    this.diaryOwner = "Not entered";
    this.ownerAge = "Not entered";
    this.ownerAddress = "Not entered";
    this.ownerPhone = "Not entered";
    this.ownerEmail = "Not entered";
      }
  public void addEntry(String newEntry) {
    entries.add(newEntry);

    if (entries.size() == 4){
      Stack<String> stack = new Stack<String>();
      stack.push(entries.get(3));
      stack.push(entries.get(2));
      stack.push(entries.get(1));
      stack.push(entries.get(0));
      stack.pop();

      entries.clear();
      while(!stack.isEmpty()) { 
      entries.add(stack.pop()); 
	}
}
}

public void deleteEntry(int a){
  if (a == 1){
    entries.remove(entries.size()-1);
  }
  else if (a == 0){
    entries.remove(0);
  }
  else {
	  System.out.println("No entries");
  }
  }
public void setPassword(){
    System.out.println("Please enter a viable password!");
    String newPassword = input.nextLine();
    this.password = newPassword; 
}
public static boolean checkPassword (String newPassword, Diary[] a, int key){
  boolean check = false;
  if (a[key].password.equals(newPassword)){
    check = true;
  }
  return check;
}
public void setDiaryOwner(){
    System.out.println("Please enter your name");
    diaryOwner = input.nextLine(); 
      System.out.println("Please enter your age");
    ownerAge = input.nextLine(); 
      System.out.println("Please enter your phone number");
    ownerPhone = input.nextLine(); 
      System.out.println("Please enter your email (diary address or recovery mail)");
    ownerEmail = input.nextLine(); 
      System.out.println("Please enter your address");
    ownerAddress = input.nextLine(); 
}
public void printInformation(){
    System.out.println("-------------------------------------------------");
    System.out.println("STUDENT INFO |             ");
    System.out.println("Name         | " + diaryOwner);
    System.out.println("Age          | " + ownerAge);
    System.out.println("---------------------------");
    System.out.println("CONTACT INFO |             ");
    System.out.println("Address      | " + ownerAddress);
    System.out.println("Phone        | " + ownerPhone);
    System.out.println("Email        | " + ownerEmail);
    System.out.println("-------------------------------------------------");
}
}

public class BoxLayoutDemo {
   private JFrame frame;
   private JPanel controlPanel;
   private JPanel controlPanel2;
   private JLabel entry1 = new JLabel("Entry 1:");
   private JLabel entry2 = new JLabel("Entry 2:");
   private JLabel entry3 = new JLabel("Entry 3:");
   
   private JLabel nameText = new JLabel();
   private JLabel ageText = new JLabel();
   private JLabel addressText = new JLabel();
   private JLabel phoneText = new JLabel();
   private JLabel emailText = new JLabel();
   
   static String email=JOptionPane.showInputDialog(null, "Welcome to the Virutal Diary","Email?");
   static int key = convertKey(email);
   static Diary[] diaryHashmap = new Diary[250];
   
   public BoxLayoutDemo(){
	   //Class Constructor, specifies it rather than having the default
      prepareGUI(diaryHashmap,key);
   }
   
   public static void main(String[] args){
	   diaryHashmap[key] = new Diary ();
	   System.out.println(key);

	   BoxLayoutDemo makeGUI = new BoxLayoutDemo();
	   makeGUI.showButtonDemo(key, diaryHashmap);
   }
 
 //This method basically prepares the GUI, all of this could be written in the main function but instead better to seperate into methods for editing purposes 
   private void prepareGUI(Diary[] diaryHashmap, int key){
	   frame = new JFrame("Virtual Diary");
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.getContentPane().setBackground(new java.awt.Color(211,211,211));
		   frame.setLayout(null); 
		   
		   JPanel header=new JPanel();  
		   header.setBounds(0,0,1000,50);    
		   header.setBackground(Color.black);
		  
		   JPanel bodyComponent=new JPanel();   
		   bodyComponent.setBackground(new java.awt.Color(211,211,211));
		   bodyComponent.setBounds(0,50,1000,825);
		   bodyComponent.setLayout(null);
		   
		   frame.setSize(1000,825);
		   frame.setResizable(false);
		   

      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
      
	   JLabel titleText = new JLabel("Virtual Diary",SwingConstants.CENTER);
	   titleText.setFont(new Font("Serif", Font.PLAIN, 40));
	   titleText.setLocation(200, 50);
	   titleText.setSize(600, 100);
       Border border = BorderFactory.createLineBorder(Color.black, 3);
       titleText.setBorder(border);
       
	   entry1 = new JLabel("Entry 1",SwingConstants.CENTER);
	   entry1.setLocation(25, 175);
	   entry1.setSize(250, 400);
    Border entry1Border = BorderFactory.createLineBorder(Color.black, 2);
    entry1.setBorder(entry1Border);
    
	   entry2 = new JLabel("Entry 2",SwingConstants.CENTER); 
	   entry2.setLocation(375, 175);
	   entry2.setSize(250, 400);
    Border entry2Border = BorderFactory.createLineBorder(Color.black, 2);
    entry2.setBorder(entry2Border);
    
	   entry3 = new JLabel("Entry 3",SwingConstants.CENTER); 
	   entry3.setLocation(725, 175);
	   entry3.setSize(250, 400);
    Border entry3Border = BorderFactory.createLineBorder(Color.black, 2);
    entry3.setBorder(entry3Border);
      

	    nameText = new JLabel("Name: ", SwingConstants.CENTER); 
	    nameText.setLocation(25, 600);
	    nameText.setSize(250, 50);
Border contact = BorderFactory.createLineBorder(Color.black, 1);
nameText.setBorder(contact);

ageText = new JLabel("Age: ", SwingConstants.CENTER); 
ageText.setLocation(375, 600);
ageText.setSize(250, 50);
ageText.setBorder(contact);

addressText = new JLabel("Address: ",SwingConstants.CENTER); 
addressText.setLocation(725, 600);
addressText.setSize(250, 50);
addressText.setBorder(contact);

phoneText = new JLabel("Phone: ", SwingConstants.CENTER); 
phoneText.setLocation(150, 675);
phoneText.setSize(250, 50);
phoneText.setBorder(contact);

emailText = new JLabel("Email: ", SwingConstants.CENTER); 
emailText.setLocation(575, 675);
emailText.setSize(250, 50);
emailText.setBorder(contact);
    

     
	bodyComponent.add(nameText);
     bodyComponent.add(ageText);
     bodyComponent.add(addressText);
     bodyComponent.add(phoneText);
     bodyComponent.add(emailText);


    bodyComponent.add(titleText);
   	bodyComponent.add(entry1);
   	bodyComponent.add(entry2);
   	bodyComponent.add(entry3);
	   
      controlPanel = new JPanel();
      controlPanel.setBackground(Color.black);
      controlPanel.setLayout(new FlowLayout());
      controlPanel2 = new JPanel();
      controlPanel2.setBackground(Color.black);
      controlPanel2.setLayout(new FlowLayout());
      
      header.add(controlPanel);
      bodyComponent.revalidate();
	   frame.getContentPane().add(header,BorderLayout.NORTH);
	   frame.getContentPane().add(bodyComponent,BorderLayout.CENTER);


	   header.setVisible(true);
	   bodyComponent.repaint();
      frame.setVisible(true);
      
   }

   private void showButtonDemo(int key, Diary[] diaryHashmap){
      JButton b1 = new JButton("Set Password");
      b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	   diaryHashmap[key].password = JOptionPane.showInputDialog(null, "Please enter your password","Password?");
        	   
         }
      });
      JButton b2 = new JButton("Set Contact");
      b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 JTextField nameText1 = new JTextField(5);
        	 JTextField ageText1 = new JTextField(5);
        	 JTextField addressText1 = new JTextField(5);
        	    
        	 JTextField phoneText1 = new JTextField(5);
        	 JTextField emailText1 = new JTextField(5);

       	  if (diaryHashmap[key].diaryOwner.equals("Not entered")) {
        	    JPanel myPanel = new JPanel();
        	    myPanel.add(new JLabel("Name"));
        	    myPanel.add(nameText1);
        	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        	    myPanel.add(new JLabel("Age"));
        	    myPanel.add(ageText1);
        	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        	    myPanel.add(new JLabel("Address"));
        	    myPanel.add(addressText1);
        	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        	    myPanel.add(new JLabel("Phone"));
        	    myPanel.add(phoneText1);
        	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        	    myPanel.add(new JLabel("Email"));
        	    myPanel.add(emailText1);
 

        	    int result = JOptionPane.showConfirmDialog(null, myPanel, 
        	             "Please Enter Contact Info", JOptionPane.OK_CANCEL_OPTION);
        	    if (result == JOptionPane.OK_OPTION) {
 
        	       diaryHashmap[key].diaryOwner = nameText1.getText();
        	       diaryHashmap[key].ownerAge = ageText1.getText();
        	       diaryHashmap[key].ownerAddress = addressText1.getText();
        	       diaryHashmap[key].ownerPhone = phoneText1.getText();
        	       diaryHashmap[key].ownerEmail = emailText1.getText();

        	       
        	}
       	  }
        	    nameText.setText("Name: "+diaryHashmap[key].diaryOwner);
        	    ageText.setText("Age: "+diaryHashmap[key].ownerAge);
        	    addressText.setText("Address: "+diaryHashmap[key].ownerAddress);
        	    phoneText.setText("Phone: "+diaryHashmap[key].ownerPhone);
        	    emailText.setText("Email: "+diaryHashmap[key].ownerEmail);
   
         }
      });
      JButton b3 = new JButton("Add Entry");
      b3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        		Date date = new Date();
      	   String newEntry = JOptionPane.showInputDialog(null, "Please enter a new entry","New Entry");
      	   newEntry = "<html>"+newEntry+"<br/><br/>"+"(Written on "+formatter.format(date)+")"+"</html>";
      	   diaryHashmap[key].addEntry(newEntry);
      	   
         }
      });
      
      JButton b4 = new JButton("Delete Entry");
      b4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 Object[] options = {"Oldest",
             "Most Recent"};
        	 int n = JOptionPane.showOptionDialog(frame,"Which entry would you like to detete?","Delete Entry",JOptionPane.WARNING_MESSAGE,JOptionPane.WARNING_MESSAGE,null,options,options[0]);
			diaryHashmap[key].deleteEntry(n);
         }
      });
      JButton b5 = new JButton("Access Entries");
      b5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 
        	 if (diaryHashmap[key].entries.size() == 0){
      		   entry1.setText("Entry 1");
      		   entry2.setText("Entry 2");
      		   entry3.setText("Entry 3");
        	 }
        	 
         else if (diaryHashmap[key].entries.size() == 1) {
        	    

        		   entry1.setText("<html><div style='text-align: center;'>"+diaryHashmap[key].entries.get(0)+"</html>");
        		   entry2.setText("Entry 2");
        		   entry3.setText("Entry 3");


        	}
        	else if (diaryHashmap[key].entries.size() == 2) {
    
        		   entry1.setText("<html><div style='text-align: center;'>"+ diaryHashmap[key].entries.get(0) +"</html>");
        		   entry2.setText("<html><div style='text-align: center;'>"+ diaryHashmap[key].entries.get(1) +"</html>"); 
        		   entry3.setText("Entry 3");
 
   
        	}
        	else if (diaryHashmap[key].entries.size() == 3) {


        	entry1.setText("<html><div style='text-align: center;'>"+ diaryHashmap[key].entries.get(0) +"</html>");
        	entry2.setText("<html><div style='text-align: center;'>"+ diaryHashmap[key].entries.get(1) +"</html>");
        	entry3.setText("<html><div style='text-align: center;'>"+ diaryHashmap[key].entries.get(2) +"</html>"); 

        	}
         }
      });
      JButton b6 = new JButton("Access/Create");
      b6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 int count = 0;
        	 email=JOptionPane.showInputDialog(null, "Welcome to the Virtual Diary","Email?");
        	 int key = convertKey(email);
        	 System.out.println(key);
        	 if (diaryHashmap[key] == null) {
        	 diaryHashmap[key] = new Diary ();
        	 }
        	 else {
        		if (diaryHashmap[key].password != null) {
        			String newPassword = JOptionPane.showInputDialog(null, "Welcome! Please enter your password","Password?");
        			while (!Diary.checkPassword(newPassword,diaryHashmap, key)) {
        				newPassword = JOptionPane.showInputDialog(null, "Welcome! Please enter your password again","Password?");
        				count++;
        				if (count >= 2) {
        					break;
        				}
        			}
        			}
        		}
       if (count >= 2) {
    	   JOptionPane.showMessageDialog(null, "To many incorrect passwords, detecting suspicious activity. Deleting diary!");
    	   frame.dispose();
       }
       else {
        	 BoxLayoutDemo swingControlDemo = new BoxLayoutDemo();
             swingControlDemo.showButtonDemo(key, diaryHashmap);

       }
         }
      });
      controlPanel.add(b1);
      controlPanel.add(b2);
      controlPanel.add(b3);
      controlPanel.add(b4);
      controlPanel.add(b5);
      controlPanel.add(b6);
      
      frame.setVisible(true);
   }
   public static int convertKey (String email){
	    int key = 0; 
	    for (int i = 0; i < email.length();i++){
	      key = (int) email.charAt(i)+key;
	    }
	    return key%250; 
	  }
}
