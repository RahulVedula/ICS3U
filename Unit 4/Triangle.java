import java.lang.Math;
import java.util.Scanner; 
class Main {
  //Scanner Method
  public static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
  //Establishes Variables to start the loop (random numbers)
    int side1 = 1;
    int side2 = 1;
    int side3 = 1;
    
  //Main loop, keeps running program with 0,0,0 as a termination condition
  do
  { 
    promptQuestion();
    //Enter Digits
    side1 = getInput();
    side2 = getInput2();
    side3 = getInput3();
    announceInput(side1, side2, side3);
    //Get Digits and Output the given digits
    if (checkInput (side1,side2,side3)){
    //Requirements for project—angle/side classification
    System.out.print(sideClassification(side1,side2,side3));
    System.out.println(angleClassification(side1,side2,side3));
    //Provides basic info on the triangle (area, angles..)
    promptQuestionBasic();
    if (checkBasic ()){
    basicInformation(side1,side2,side3);
    //Gives additional information (coordinates, height...)
    promptQuestionAdditional();
    if (checkAdvanced()){
      additionalInformation (side1,side2,side3);
    }
    }
    }
    //Checks the incorrect input (values that are too big, non-positive...)
    else if (incorrectBreak(side1,side2,side3) && checkInputNegative (side1,side2,side3)){
      incorrectInput();
    }
    else {
    }
  } while (checkInput1 (side1,side2,side3));

    System.out.println("Program was terminated by user."); 
  }

//Integer method that gets and returns the input
public static int getInput ()
     {
      int getInput = input.nextInt();
      return getInput;  
     }
    
public static int getInput2 ()
     {
      int getInput = input.nextInt();
      return getInput;     
     }

public static int getInput3 ()
     {
      int getInput = input.nextInt();
      return getInput;   
     }

  // Void method that asks the question
public static void promptQuestion ()
  {
   System.out.println("Provide three side lengths – 0 0 0 to terminate.");
  }
public static void promptQuestionBasic ()
  {
   System.out.println("Would you like Basic Information on the triangle? (y/n)");
  }
public static void promptQuestionAdditional ()
  {
   System.out.println("Would you like Additional Information on the triangle? (y/n)");
  }

  //Void methods that outputs the given Input
public static void announceInput (int side1, int side2, int side3)
  {
   System.out.print(side1+" "+side2+" "+side3+" ");
  }

  // Boolean Method that checks the input to pass it the information about the triangle
public static boolean checkInput (int side1, int side2, int side3)
     {
      boolean check = true;
      if (side1 <= 0 || side2 <= 0 || side3 <= 0){
        check = false;
      }
      else if (((side1+side2) <= side3) || ((side1+side3) <= side2) || ((side3+side2) <= side1))
      {
       check = false;
      }
      else {
        check = true;
      }
      return check;
     }
     public static boolean checkInput1 (int side1, int side2, int side3)
     {
      boolean check = true;
      if (side1 == 0 && side2 == 0 && side3 == 0){
        check = false;
      }
      else {
        check = true;
      }
      return check;
     }
  
  //Boolean method that says whether to the triangle is possible or not, differs from the above method as its boolean has different values that allow the loop to progress
public static boolean checkInputNegative (int side1, int side2, int side3)
     {
      boolean check = false;
      if (side1 <= 0 || side2 <= 0 || side3 <= 0){
        check = true;
      }
      else if (((side1+side2) <= side3) || ((side1+side3) <= side2) || ((side3+side2) <= side1))
      {
       check = true;
      }
      else {
        check = false;
      }
      return check;
     }

  //Void Method that prints when its incorrect input
public static void incorrectInput ()
  {
   System.out.println("Triangle cannot be formed.");
  }

  //Boolean method that stops the program from accepting 0 values/or denying all 0 values
public static boolean incorrectBreak (int side1, int side2, int side3)
  {
    boolean check = true;
     if (side1 == 0 && side2 == 0 && side3 == 0){
        check = false;
      }
      return check;
  }

  //Boolean Method that checks if the user wants to progress or not
public static boolean checkBasic ()
  {

    char checkInput = input.next().charAt(0);
    checkInput = Character.toLowerCase(checkInput);
    boolean check = false;
    if (checkInput == 'y'){
      check = true;
    }
    return check;
  }
public static boolean checkAdvanced ()
  {

    char checkInput = input.next().charAt(0);
    checkInput = Character.toLowerCase(checkInput);
    boolean check = false;
    if (checkInput == 'y'){
      check = true;
    }
    return check;
  }

  // Method for Side Classification (scalene, equilateral, or isosceles)
public static String sideClassification (int side1, int side2, int side3){
    String firstOutput = "";
    if (side1 == side2 && side2 == side3){
      firstOutput = "Triangle possible: Equilateral";
    }
    else if ((side1 == side2 && side2 != side3) || (side2 == side3 && side2 != side1) || (side1 == side3 && side1 != side2) ){
      firstOutput = "Triangle possible: Isosceles";
    }
    else if (side1 != side2 && side2 != side3 && side1 != side3){
      firstOutput = "Triangle possible: Scalene";
    }
    return firstOutput;
  }

  //Method that classifies triangles by angle type
public static String angleClassification (int side1, int side2, int side3){
  String outputSecond = "";
  int [] apple = {side1,side2,side3};
  // This loop compares consecutive values in an array and swaps values. Thus, organizing it by lowest to highest
    for (int i = 0; i < apple.length; i++){   
      for (int j = i + 1; j < apple.length; j++){    
        int mediator = 0;  
        if (apple[i] > apple[j]){  
          mediator = apple[i];  
          apple[i] = apple[j];  
          apple[j] = mediator;  
        }  
      }  
    }
    int a = apple[0];
    int b = apple[1];
    int c = apple[2];

    //If statement to identify which angle type of triangle

    if (Math.pow(c,2) > (Math.pow(b,2)+(Math.pow(a,2)))){
     outputSecond = " and obtuse";
    } 
    else if (Math.pow(c,2) < (Math.pow(b,2)+(Math.pow(a,2)))){
     outputSecond = " and acute";
    } 
    else if (Math.pow(c,2) == (Math.pow(b,2)+(Math.pow(a,2)))){
     outputSecond = " and right";
    } 
    return outputSecond;
  }
//Method that gives basic information about the triangle
public static void basicInformation (int side1, int side2, int side3){
  int [] apple = {side1,side2,side3};
  // This loop compares consecutive values in an array and swaps values. Thus, organizing it by lowest to highest
    for (int i = 0; i < apple.length; i++){   
      for (int j = i + 1; j < apple.length; j++){    
        int mediator = 0;  
        if (apple[i] > apple[j]){  
          mediator = apple[i];  
          apple[i] = apple[j];  
          apple[j] = mediator;  
          }  
        }  
      }
    double a = apple[0];
    double b = apple[1];
    double c = apple[2];

      double s =(a+b+c)/2;
      double area1 = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
      double areaRound = area1*100;
      double area2 = Math.round(areaRound);
      double area = area2/100;
      System.out.println("Area: "+area);
      int perimeter = (int)(s*2);
      System.out.println("Perimeter: "+perimeter);
      double q = (Math.pow(b,2))+(Math.pow(c,2))-(Math.pow(a,2));
      double p = (Math.pow(a,2))+(Math.pow(c,2))-(Math.pow(b,2));
      double g = (Math.pow(b,2))+(Math.pow(a,2))-(Math.pow(c,2));

  double angle1 = Math.acos(q/(2*b*c));
    angle1 = Math.toDegrees(angle1);
    angle1 = angle1*100;
    angle1 = Math.round(angle1);
    angle1 = angle1/100;
  double angle2 = Math.acos(p/(2*a*c));
    angle2 = Math.toDegrees(angle2);
    angle2 = angle2*100;
    angle2 = Math.round(angle2);
    angle2 = angle2/100;
  double angle3 = Math.acos(g/(2*b*a));
    angle3 = Math.toDegrees(angle3);
    angle3 = angle3*100;
    angle3 = Math.round(angle3);
    angle3 = angle3/100;

  System.out.println("Angle 1: "+angle1+"°");
  System.out.println("Angle 2: "+angle2+"°");
  System.out.println("Angle 3: "+angle3+"°");
  }

// Method that gives additional Information of the Triangle
public static void additionalInformation (int side1, int side2, int side3)
  {
  int [] apple = {side1,side2,side3};

    for (int i = 0; i < apple.length; i++){   
      for (int j = i + 1; j < apple.length; j++){    
        int mediator = 0;  
        if (apple[i] > apple[j]){  
          mediator = apple[i];  
          apple[i] = apple[j];  
          apple[j] = mediator;  
          }  
        }  
      }
  double a = apple[0];
  double b = apple[1];
  double c = apple[2];
  //Calculating Angles and Area
    double s =(a+b+c)/2;
    double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    int perimeter = (int)(s*2);
    double q = (Math.pow(b,2))+(Math.pow(c,2))-(Math.pow(a,2));
    double p = (Math.pow(a,2))+(Math.pow(c,2))-(Math.pow(b,2));
    double g = (Math.pow(b,2))+(Math.pow(a,2))-(Math.pow(c,2));
  double angle1 = Math.acos(q/(2*b*c));
    angle1 = Math.toDegrees(angle1);
  double angle2 = Math.acos(p/(2*a*c));
    angle2 = Math.toDegrees(angle2);
  double angle3 = Math.acos(g/(2*b*a));
    angle3 = Math.toDegrees(angle3);

  //Calculating Heights
  double height1 = (2.0*area)/a;
    height1 = height1*100;
    height1 = Math.round(height1);
    height1 = height1/100;
  double height2 = (2.0*area)/b;
    height2 = height2*100;
    height2 = Math.round(height2);
    height2 = height2/100;
  double height3a = (2.0*area)/c;
    double height3 = height3a*100;
    height3 = Math.round(height3);
    height3 = height3/100;
  System.out.println("This is the height from base "+a+": "+height1);
  System.out.println("This is the height from base "+b+": "+height2);
  System.out.println("This is the height from base "+c+": "+height3);
  System.out.println("");

  //Calculating Medians
  double filler = Math.acos(b);
    filler = Math.toDegrees(filler);
  double median1 = Math.sqrt((2.0*(Math.pow(b,2))+2.0*(Math.pow(c,2))-(Math.pow(a,2)))/4.0);
    median1 = median1*100;
    median1 = Math.round(median1);
    median1 = median1/100;
  double median2 = Math.sqrt((2.0*(Math.pow(a,2))+2.0*(Math.pow(c,2))-(Math.pow(b,2)))/4.0);
    median2 = median2*100;
    median2 = Math.round(median2);
    median2 = median2/100;
  double median3 = Math.sqrt((2.0*(Math.pow(b,2))+2.0*(Math.pow(a,2))-(Math.pow(c,2)))/4.0);
    median3 = median3*100;
    median3 = Math.round(median3);
    median3 = median3/100;
  System.out.println("Median 1: "+median1);
  System.out.println("Median 2: "+median2);
  System.out.println("Median 3: "+median3);
  System.out.println("");

  //Calculating In Radius
  double inRadius = area/s;
    inRadius = inRadius*100;
    inRadius = Math.round(inRadius);
    inRadius = inRadius/100;
  System.out.println("The radius of a circle in the triangle: "+inRadius);
  System.out.println("");

  //Calculating Coordinates of vertices
  int aX = 0;
  int aY = 0;
  int bY = 0;
  int bX = (int)c;
  double cX = (Math.pow(c,2)+Math.pow(b,2)-Math.pow(a,2))/(2.0 * c);
    cX = cX*100;
    cX = Math.round(cX);
    cX = cX/100;
  double cY = height3a;
    cY = cY*100;
    cY = Math.round(cY);
    cY = cY/100;
  System.out.println("The Coordinates of the 3 vertices in the triangle: ");
  System.out.println("A ("+aX+","+aY+")");
  System.out.println("B ("+bX+","+bY+")");
  System.out.println("C ("+cX+","+cY+")");
  

  //Calculating the centroid
  double centroidX = (aX+bX+cX)/3.0;
    centroidX = centroidX*100;
    centroidX = Math.round(centroidX);
    centroidX = centroidX/100;
  double centroidY = (aY+bY+cY)/3.0;
    centroidY = centroidY*100;
    centroidY = Math.round(centroidY);
    centroidY = centroidY/100;
  System.out.println("The centroid of the triangle is:("+centroidX+","+centroidY+")");
  
  }
}
