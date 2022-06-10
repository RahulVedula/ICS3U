//Rahul Vedula
//Diary Database
//June 6, 2022
//ICS3U
import java.util.Scanner; 
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.*; 

class Diary {
  private String diaryOwner;
  private String ownerAge;
  private String ownerAddress;
  private String ownerPhone;
  private String ownerEmail;  
  String password; 
  private ArrayList<String> entries = new ArrayList<String>();
  
 public static Scanner input = new Scanner(System.in);
  public Diary(){
    this.diaryOwner = "Not entered";
    this.ownerAge = "Not entered";
    this.ownerAddress = "Not entered";
    this.ownerPhone = "Not entered";
    this.ownerEmail = "Not entered";
      }
  public void addEntry() {
    if (entries.size() == 3){
      System.out.println("Please enter a diary entry (entry number: "+entries.size()+"):");
    }
    else{
    System.out.println("Please enter a diary entry (entry number: "+(entries.size()+1)+"):");
    }
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
    entries.add(input.nextLine()+" (Written on "+formatter.format(date)+")");

    if (entries.size() == 4){
    System.out.println("System Maximum Reached! Deleting oldest diary entry");
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
public void accessEntry (){
  if (entries.size()==1){
    System.out.println("These are the diaries written:");
    System.out.println("\n\nEntry 1\n\n");
    System.out.println(entries.get(0));
  }
  else if (entries.size()==2){
    System.out.println("These are the diaries written:");
    for (int i = 0; i < 2;i++){
    System.out.println("\n\nEntry "+(i+1)+":\n\n");
    System.out.println(entries.get(i));
  }
}
  else if (entries.size()==3){
    System.out.println("These are the diaries written:");
    for (int i = 0; i < 3;i++){
    System.out.println("\n\nEntry "+(i+1)+":\n\n");
    System.out.println(entries.get(i));
  }
  }
  else{
    System.out.println("No entries!");
  }
  }
public void deleteEntry(){
  System.out.println("Which entry would you like to delete (For the most recent, enter 1, for the oldest enter 2)");
  int getInput = input.nextInt();
  input.nextLine();
  if (getInput == 1){
    entries.remove(entries.size()-1);
  }
  else if (getInput == 2){
    entries.remove(0);
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
//Main Class
public class Main {
  public static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    int selection = 0;
    Diary[] diaryHashmap = new Diary[250];
    introduction();
    String email = getEmail();
    int key = convertKey(email);
    diaryHashmap[key] = new Diary ();
    System.out.println("Diary Created!\n");

    while (selection != 6){
      selectionInstructions();
      selection = input.nextInt();
      input.nextLine();
      System.out.println("-------------------------------------------------");
      selectionCycle(diaryHashmap, selection, key);
    }
    
//Starts the data base as the up initalizes a mandatory diary
    System.out.println("Would you like to continue (accessing existing acount or creating a new account)(y/n)");
    char userResponse = input.next().charAt(0);
    userResponse = Character.toLowerCase(userResponse);

    while (userResponse == 'y'){
      System.out.println("Please select the option below which interests you.");
      System.out.println("1 ———> Create New Account");
      System.out.println("2 ———> Access existing account");
      int newSelection = input.nextInt();
            System.out.println("-------------------------------------------------");
      while (newSelection > 2 || newSelection < 1){
      System.out.println("Invalid Input, please try again.");
        newSelection = input.nextInt();
              System.out.println("-------------------------------------------------");
      }
      //Create Acount
      if (newSelection == 1){
        createAccount(diaryHashmap);
      }
        //Access Acount
      else if (newSelection == 2){
        accessAccount(diaryHashmap);
      }
      //Sets condition for while loop
      System.out.println("Would you like to continue (accessing existing acount or creating a new account)(y/n)");
    userResponse = input.next().charAt(0);
    userResponse = Character.toLowerCase(userResponse);
    }
    System.out.println("-------------------------------------------------");
    System.out.println("Thanks for using the diary system!");
  }
//String to get introductory text
  public static void introduction (){
        String[] printStagger = new String[]{"Welcome", "to", "the", "Diary", "Maker"};
          try {
          for (int i = 0; i < 5;i++){
            System.out.print(printStagger[i]+" ");
            Thread.sleep(200);
          }
        } catch (Exception expn) {
        // catching the exception
        System.out.println(expn);
      }
  }
  public static String getEmail (){
    String emailInput= "";
    System.out.println("\nPlease enter an email to create a new account");
    emailInput = input.nextLine();
    return emailInput;
  }
  public static int convertKey (String email){
    int key = 0; 
    for (int i = 0; i < email.length();i++){
      key = (int) email.charAt(i)+key;
    }
    return key%250; 
  }
  public static void selectionCycle (Diary[] diaryHashmap, int selection, int key){
    if (selection == 1){
      diaryHashmap[key].setPassword();
    }
    else if (selection == 2){
      diaryHashmap[key].setDiaryOwner();
    }
    else if (selection == 3){
      diaryHashmap[key].addEntry();
    }
    else if (selection == 4){
      diaryHashmap[key].deleteEntry();
    }
        else if (selection == 5){
      diaryHashmap[key].accessEntry();
    }
  }
    public static void selectionInstructions (){
          System.out.println("-------------------------------------------------");
    System.out.println("Please choose the option you would like to do");
    System.out.println("1 ———> Set Password");
    System.out.println("2 ———> Set diary info");
    System.out.println("3 ———> Add new diary entry");
    System.out.println("4 ———> Delete existing entry");
    System.out.println("5 ———> Access previous entries");
    System.out.println("6 ———> Exit program");

  }
      public static void selectionInstructions2 (){
          System.out.println("-------------------------------------------------");
    System.out.println("Please choose the option you would like to do");
    System.out.println("1 ———> Reset Password");
    System.out.println("2 ———> Change diary info");
    System.out.println("3 ———> Add new diary entry");
    System.out.println("4 ———> Delete existing entry");
    System.out.println("5 ———> Access previous entries");
    System.out.println("6 ———> Exit program");

  }
  public static void createAccount (Diary[] diaryHashmap){
    String emailInput= "";
    input.nextLine();
    System.out.println("\nPlease enter an email to create a new account");
    emailInput = input.nextLine();
    int key1 = 0; 
    for (int i = 0; i < emailInput.length();i++){
      key1 = (int) emailInput.charAt(i)+key1;
    }
    key1 = key1%250;
    while (diaryHashmap[key1] != null){
      System.out.println("Already existing account. Please enter a different one.");
      System.out.println("\nPlease enter an email to create a new account");
      emailInput = input.nextLine();
       key1 = 0; 
      for (int j = 0; j < emailInput.length();j++){
        key1 = (int) emailInput.charAt(j)+key1;
    }
    key1 = key1%250;
  }
    diaryHashmap[key1] = new Diary ();
    System.out.println("Diary Created!\n");
    int selection1 = 0; 
    while (selection1 != 6){
      selectionInstructions();
      selection1 = input.nextInt();
      input.nextLine();
      System.out.println("-------------------------------------------------");
          if (selection1 == 1){
      diaryHashmap[key1].setPassword();
    }
    else if (selection1 == 2){
      diaryHashmap[key1].setDiaryOwner();
    }
    else if (selection1 == 3){
      diaryHashmap[key1].addEntry();
    }
    else if (selection1 == 4){
      diaryHashmap[key1].deleteEntry();
    }
        else if (selection1 == 5){
      diaryHashmap[key1].accessEntry();
    }
    }
  }
 public static void accessAccount (Diary[] diaryHashmap){
    String emailInput= "";
    String findPassword= "";
    boolean check = true;
    boolean check1 = true;
    int counter = 0;
    int counter2 = 0;
    input.nextLine();
          System.out.println("-------------------------------------------------");
    System.out.println("Please enter an email to access an existing account");
    emailInput = input.nextLine();
          System.out.println("-------------------------------------------------");
    int key1 = 0; 
    for (int i = 0; i < emailInput.length();i++){
      key1 = (int) emailInput.charAt(i)+key1;
    }
    key1 = key1%250;
    while (diaryHashmap[key1] == null){
      System.out.println("No existing account. Please enter an existing one.");
      System.out.println("Please enter an email");
            System.out.println("-------------------------------------------------");
      emailInput = input.nextLine();
       key1 = 0; 
      for (int j = 0; j < emailInput.length();j++){
        key1 = (int) emailInput.charAt(j)+key1;
    }
    key1 = key1%250;
    counter++;
    if (counter>3){
      check = false;
    }
  }
  if (check = false){
    System.out.println("You have entered no existing email, exiting option");
          System.out.println("-------------------------------------------------");
  }
  else{
    if (diaryHashmap[key1].password != null){
    System.out.println("Please enter password:");
    findPassword = input.nextLine();
    if (!Diary.checkPassword(findPassword,diaryHashmap, key1)){
      while (!Diary.checkPassword(findPassword,diaryHashmap, key1)){
      if (counter2 >= 3){
        check1 = false;
        findPassword = diaryHashmap[key1].password;
      }
      else{
      System.out.println("Incorrect Password");
      System.out.println("Please enter password:");
      findPassword = input.nextLine();
      counter2++;
      }
      }
      }
      }
    if (check1 == false){
      System.out.println("Incorrect Passwords, leaving option");
      System.out.println("-------------------------------------------------");
    }
    else{
        System.out.println("-------------------------------------------------");
      System.out.println("Access Granted!");
      diaryHashmap[key1].printInformation();
    int selection1 = 0; 
    while (selection1 != 6){
      selectionInstructions2();
      selection1 = input.nextInt();
      input.nextLine();
              System.out.println("-------------------------------------------------");
    if (selection1 == 1){
      diaryHashmap[key1].setPassword();
    }
    else if (selection1 == 2){
      diaryHashmap[key1].setDiaryOwner();
    }
    else if (selection1 == 3){
      diaryHashmap[key1].addEntry();
    }
    else if (selection1 == 4){
      diaryHashmap[key1].deleteEntry();
    }
        else if (selection1 == 5){
      diaryHashmap[key1].accessEntry();
    }
    }
    }
  }
  
  }
}
