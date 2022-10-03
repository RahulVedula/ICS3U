import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Main {
//Method for scanner
  public static Scanner s = new Scanner(System.in);
//Methods For Colours Of Text
  public static final String ANSI_RESET = "\u001B[0m";

  public static final String ANSI_BLACK_BACKGROUND = "\033[0;100m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\033[0;103m";

  public static final String ANSI_WHITE = "\033[1;37m";

  public static void main(String[] args) {
//Initialize variables
    String[] wordleListArray = wordleList(); //String array of every possible wordle ANSWER (~12,000 words)
    String[] allowedWords = wordTotalList(); //String array of every possible wordle GUESS (~13,000 words)
    char[] inputArr = new char[5]; //Input array containing the letters of the Input String
    String wordleGuess = ""; //String that takes in input 
    int checkStreak = 0; //Variable Checks Streak
    int overallPoints = 0; //Variable counts overall correct answers
    int overallRounds = 0; //Variable counts overall rounds
    giveAllInstructions(); // Gives Instructions
    do {
      String wordle = randomWord(wordleListArray); //Gets a random word from the possible list of answers
      if (gamePlay(wordleListArray, wordleGuess, inputArr, wordle, allowedWords)){
        checkStreak++;
        overallPoints++;
      } // Method for the game
      else {
        checkStreak = 0;
      }
      System.out.println("Your current streak is: "+checkStreak);
      overallRounds++; //Tracks overall rounds
    } while (getConfirmation()); //Condition to play again
    
    System.out.println("------------------------------------------------------");
    System.out.println("You got "+overallPoints+" guesses out of "+overallRounds+" rounds");
    System.out.println("Thanks for playing!");
  }

//--------------------------------------------------------
//The below methods are the main methods used to accomplish the functions, in order
  
  //Method that handles instructions checks and prints instructions
  public static void giveAllInstructions() {
    System.out.println("Welcome To Wordle!");
    instructionsPrint();
    if (instructionCheck()) {
      instructionGive();
      instructionsPrint2();
      while (!instructionCheck2()) {
        instructionsPrint2();
      }
      removeInputMass();
      // instructionsPrint3();
    } else {
      removeInput();
      removeInput();
      // instructionsPrint3();
    }
  }
  
  //Most important method — controls gameplay and combine many of the mentioned methods
  public static boolean gamePlay(String[] wordleListArray, String wordleGuess, char[] inputArr, String wordle, String[] allowedWords) {
    int i = 0;
    boolean winner = false;
    instructionsPrint3();
    System.out.println("");
    do {

      wordleGuess = newWordleInput();
      removeInput();

      i++;
      while (wordCheck(allowedWords, wordleGuess)) {
        wordleGuess = promptAction();
        removeInput();
        removeInput();
      }
      inputArr = powArray(wordleGuess);
      String[] beta = printValue2(inputArr, wordle);

      try {
        for (int j = 0; j < 5; j++) {
          System.out.print(beta[j]);
          System.out.print(" ");
          Thread.sleep(200);
        }
      } catch (Exception expn) {
        // catching the exception
        System.out.println(expn);
      }
      System.out.println("\n");
    } while (!wordleGuess.equals(wordle) && i < 6);

    if (wordleGuess.equals(wordle)) {
      congratMessage(wordle, i);
      winner = true;
    }

    else {
      System.out.println("You Lost!");
      System.out.println("The word was: " + wordle);
      System.out.println("------------------------------------------------------");
    }
    return winner;
  }
  
  //Method that gets confirmation to play the game or not. 
  public static boolean getConfirmation() {
    System.out.println("Would you like to continue the game? (y/n)");
    String getLine = s.nextLine();
    char getFirstLetter = 'y';
    if (getLine == "") {
      getFirstLetter = 'n';
    } else {
      getFirstLetter = getLine.charAt(0);
    }
    getFirstLetter = Character.toUpperCase(getFirstLetter);
    boolean continueStop = false;

    if (getFirstLetter == 'Y') {
      continueStop = true;
    }
    return continueStop;
  }

//The below methods are methods used in the above methods to accomplish their functions
//------------------------------------------------------
//Method that takes in a randomWord
  public static String randomWord(String[] wordleListArray) {
    int randomNumber = (int) (Math.random() * ((2316 - 1 + 1) - 1));
    String randomWord2 = wordleListArray[randomNumber];
    return randomWord2;
  }
  //Method that takes in new word when the word is not apart of the list, the difference between this method and the other, is that this method prints not a word where the other one solely takes in input. It returns a variable that is later stored in the inital gues variable. 
  public static String promptAction() {
    String wordleGuess1 = "";
    System.out.println("Not A Word");
    wordleGuess1 = s.nextLine();
    wordleGuess1 = wordleGuess1.toUpperCase();
    return wordleGuess1;
  }

  public static String newWordleInput() {
    String wordleGuess1 = "";
    wordleGuess1 = s.nextLine();
    wordleGuess1 = wordleGuess1.toUpperCase();
    return wordleGuess1;
  }
  
  //Method that organizes the wordleGuess into a character array so that it can be returned and stored into the inital inputArray
  public static char[] powArray(String wordleGuess) {
    char[] inputArr1 = new char[5];
    for (int letter = 0; letter < 5; letter++) {
      inputArr1[letter] = wordleGuess.charAt(letter);
    }
    return inputArr1;
  }

  //Checks if word is apart of the allowed word list
  public static boolean wordCheck(String[] allowedWords, String wordleGuess) {
    boolean checkWord = true;
    for (int i = 0; i < 12793; i++) {
      if (wordleGuess.equals(allowedWords[i])) {
        checkWord = false;
      }
    }
    return checkWord;
  }
  
//This method controls printing the value of the string and checking for letter placement. 
  public static String[] printValue2(char[] inputArr, String wordle) {
    String[] parseString = new String[5];
    int doubleLetter = 0; //This is a counter to check for frequencies of double letters, when double letters occur, this counter increases by one. Except for when a double letter occurs where another letter is green.
  //Greens
    for (int check = 0; check < 5; check++) {
      if (inputArr[check] == wordle.charAt(check)) {
        parseString[check] = ANSI_GREEN_BACKGROUND + ANSI_WHITE + " " + inputArr[check] + " " + ANSI_RESET;
        for (int check1 = 0; check1 < 5; check1++) {
          if (inputArr[check] == inputArr[check1] && check != check1) {
            doubleLetter++;
          }
        }
      } else if ((inputArr[check] == wordle.charAt(0)) || (inputArr[check] == wordle.charAt(1))
          || (inputArr[check] == wordle.charAt(2)) || (inputArr[check] == wordle.charAt(3))
          || (inputArr[check] == wordle.charAt(4))) {

//Yellows
        for (int check1 = 0; check1 < 5; check1++) {
          if (inputArr[check] == inputArr[check1] && check != check1) {
            if (inputArr[check1] == wordle.charAt(check1)) {
              doubleLetter = 3;
            } else {
              doubleLetter++;
            }
          }
        }
        if (doubleLetter > 1) {
          parseString[check] = (ANSI_BLACK_BACKGROUND + ANSI_WHITE + " " + inputArr[check] + " " + ANSI_RESET);
          doubleLetter = 0;
        } else {
          parseString[check] = (ANSI_YELLOW_BACKGROUND + ANSI_WHITE + " " + inputArr[check] + " " + ANSI_RESET);
        }
      }
//Grays
      else {
        parseString[check] = (ANSI_BLACK_BACKGROUND + ANSI_WHITE + " " + inputArr[check] + " " + ANSI_RESET);
      }
    }

    return parseString;
  }

// Method that just prints a congratulatory message when you finish
  public static void congratMessage(String wordle, int i) {
    if (i == 1) {
      System.out.println("----------------------Genius(1/6)----------------------");
    } else if (i == 2) {
      System.out.println("----------------------Magnificent (2/6)----------------------");
    } else if (i == 3) {
      System.out.println("----------------------Impressive (3/6)----------------------");
    } else if (i == 4) {
      System.out.println("----------------------Great (4/6)----------------------");
    } else if (i == 5) {
      System.out.println("----------------------Nice (5/6)----------------------");
    }
    if (i == 6) {
      System.out.println("----------------------Whew (6/6)----------------------");
    }

  }

//A method that removes input by moving cursors and erasing line content
  public static void removeInput() {
    int count = 1;
    System.out.print(String.format("\033[%dA", count)); // Move up
    System.out.print("\033[2K"); // Erase line content }
  }
  
  //Same Remove Input method expept this method removes the Instructions
  public static void removeInputMass() {
    for (int i = 0; i < 21; i++) {
      removeInput();
    }
    }

  //Method that asks users if they would like to get instructions on how to play wordle
  public static boolean instructionCheck() {
    boolean booleanContinue = false;
    char check1 = 'a';
    String characterContinue = "";

    characterContinue = s.nextLine();
    characterContinue = characterContinue.toUpperCase();
    if (characterContinue == "") {
      check1 = 'n';
    } else {
      check1 = characterContinue.charAt(0);
    }
    if (check1 == 'Y') {
      removeInput();

      booleanContinue = true;
    }
    return booleanContinue;
  }

    //Method that gives Instructions for wordle
  public static void instructionGive() {
    System.out.println(
        "Guess the WORDLE in six tries. \n\nEach guess must be a valid five-letter word. Hit the enter button to submit.\n\nAfter each guess, the color of the background will change to show how close your guess was to the word.");

    System.out.println("\n\033[0;1m" + "EXAMPLES:\n");
    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_WHITE + " W " + ANSI_RESET);
    System.out.print(" ");
    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " E " + ANSI_RESET);
    System.out.print(" ");
    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " A " + ANSI_RESET);
    System.out.print(" ");
    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " R " + ANSI_RESET);
    System.out.print(" ");
    System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " Y " + ANSI_RESET);

    System.out.println("The letter W is in the word and in the correct spot.\n");

    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " P " + ANSI_RESET);
    System.out.print(" ");
    System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_WHITE + " I " + ANSI_RESET);
    System.out.print(" ");
    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " L " + ANSI_RESET);
    System.out.print(" ");
    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " L " + ANSI_RESET);
    System.out.print(" ");
    System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " S " + ANSI_RESET);

    System.out.println("The letter I is in the word but in the wrong spot.\n");

    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " V " + ANSI_RESET);
    System.out.print(" ");
    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " A " + ANSI_RESET);
    System.out.print(" ");
    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " G " + ANSI_RESET);
    System.out.print(" ");
    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " U " + ANSI_RESET);
    System.out.print(" ");
    System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " E " + ANSI_RESET);

    System.out.println("The letter U is not in the word in any spot.\n");
  }
  
//Void methods that handle single line print statements, just to simplif the gamePlay method more 
  public static void instructionsPrint() {
    System.out.println("Instructions? (y/n)");
  }

  public static void instructionsPrint2() {
    System.out.println("Would you like to start the game?");
  }

  public static void instructionsPrint3() {
    System.out.println("You may begin:");
  }
    
//Method that asks the users if they would like to continue. This is just a superficial method that makes the output look better, I can assume they would like to play the game as they initiated program
  public static boolean instructionCheck2() {
    boolean booleanContinue = true;
    char check1 = 'a';
    String characterContinue = "";
    characterContinue = s.nextLine();
    characterContinue = characterContinue.toUpperCase();
    if (characterContinue == "") {
      check1 = 'n';
    } else {
      check1 = characterContinue.charAt(0);
    }
    return booleanContinue;
  }

//Method that access the text file to find the possible answers for wordle
  public static String[] wordleList() {
    String[] newArr = new String[2316];
    int newLine = 0;
    try {
      File myObj = new File("wordlist.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        newLine++;
        String data = myReader.nextLine();
        newArr[newLine] = data.toUpperCase();
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return newArr;
  }
//Method that access the text file of possible wordle guesses
  public static String[] wordTotalList() {
    String[] newArr = new String[12973];
    int newLine = 0;
    try {
      File myObj = new File("allowedwords.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        newLine++;
        String data = myReader.nextLine();
        newArr[newLine] = data.toUpperCase();
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return newArr;
  }
}
