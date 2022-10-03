import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner user_input = new Scanner(System.in);
 
  //Variables
  int option;
  int bear;
  int bear1;
  String compass;
  String compass1; 
  String comp; 
  char dir1;
  char dir2;
  int angle;

    System.out.println("Compass direction:");
    compass = user_input.next();
    compass1 = compass.replaceAll("[^a-zA-Z]", "");
    comp = compass.replaceAll("[^0-9.]", "");
     //Removes all non-letter characters
if (compass.length()>2 && comp.isEmpty())
{
  System.out.println("Invalid");
}

else if (compass1 == null || compass1.isEmpty())
{
  System.out.println("Invalid");
}

else {

    dir1 = compass1.charAt(0);
    dir1 = Character.toUpperCase(dir1);

    dir2 = compass1.charAt(compass1.length() -1);
    dir2 = Character.toUpperCase(dir2);
  


if (compass.length()== 1)
{
  if(dir1 == 'S')
  {
    System.out.println("Compass S is a bearing of 180");
  }

  else if(dir1 == 'E')
  {
    System.out.println("Compass E is a bearing of 90");
  }
  else if(dir1 == 'W')
  {
    System.out.println("Compass W is a bearing of 270");
  }
  else if(dir1 == 'N')
  {
    System.out.println("Compass N is a bearing of 0");
  }
  else
  {
    System.out.println("Invalid");
  }
}

else if (compass.length() == 2)
{
  if (dir1 == 'N' && dir2 == 'W')
  {
    System.out.println("Compass NW is a bearing of 315");
  }

  else if (dir1 == 'W' && dir2 == 'N')
  {
    System.out.println("Compass WN is a bearing of 315");
  }

  else if (dir1 == 'E' && dir2 == 'N')
  {
    System.out.println("Compass NE is a bearing of 45");
  }

  else if (dir1 == 'N' && dir2 == 'E')
  {
    System.out.println("Compass NE is a bearing of 45");
  }

  else if (dir1 == 'E' && dir2 == 'S')
  {
    System.out.println("Compass ES is a bearing of 135");
  }

  else if (dir1 == 'S' && dir2 == 'E')
  {
    System.out.println("Compass SE is a bearing of 135");
  }

  else if (dir1 == 'W' && dir2 == 'S')
  {
    System.out.println("Compass WS is a bearing of 225");
  }

  else if (dir1 == 'S' && dir2 == 'W')
  {
    System.out.println("Compass SW is a bearing of 225");
  }

  else
  {
    System.out.println("Invalid");
  }

}

    
else if (compass.length() == 3 || compass.length() == 4)  
{ 
    comp = compass.replaceAll("[^0-9.]", ""); //Removes all non-integer characters
    bear = Integer.parseInt(comp); // Converts String to Integer


    if (bear<0 || bear>360)
     {
      System.out.println("Invalid");
    }

    if ((dir1 == 'N' || dir1 == 'n' || dir1 == 'S' || dir1 == 's' || dir1 == 'W' || dir1 == 'w' || dir1 == 'E' || dir1 == 'e') && (dir2 == 'N' || dir2 == 'n' || dir2 == 'S' || dir2 == 's' || dir2 == 'W' || dir2 == 'w' || dir2 == 'E' || dir2 == 'e' )){

      if (dir1 == dir2)
      {
        System.out.println("Invalid");
      }

      else if ((dir1 == 'E' && dir2 == 'W') || (dir1 == 'W' && dir2 == 'E') || (dir1 == 'S' && dir2 == 'N') || (dir1 == 'N' && dir2 == 'S'))
      {
        System.out.println("Invalid");
      }
      else {
    //N or E or W or S

    if (bear==0 && dir1=='N' && dir2=='E')
    {
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of 0");
    }

    if (bear==0 && dir1=='N' && dir2=='W')
    {
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of 0");
    }

    if (bear==0 && dir1=='E' && dir2=='N')
    {
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of 90");
    }

    if (bear==0 && dir1=='E' && dir2=='S')
    {
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of 90");
    }

    if (bear==0 && dir1=='S' && dir2=='E')
    {
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of 180");
    }

    if (bear==0 && dir1=='S' && dir2=='W')
    {
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of 180");
    }

    if (bear==0 && dir1=='W' && dir2=='S')
    {
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of 270");
    }

    if (bear==0 && dir1=='W' && dir2=='N')
    {
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of 270");
    }

    //Quadrant NE

    if (dir1=='N' && dir2=='E' && bear>0 && bear<=45)
    {
      angle = bear;
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of "+angle);
    }
    else if (dir1=='N' && dir2=='E' && bear>45)
    {
      System.out.println("Invalid");
    }

    else if (dir1=='E' && dir2=='N' && bear>0 && bear<=45)
    {
      angle = 90-bear;
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of "+angle);
    }

    else if (dir1=='E' && dir2=='N' && bear>45)
    {
      System.out.println("Invalid");
    }

    // Quadrant E,S

    if (dir1=='E' && dir2=='S' && bear>0 && bear<=45)
    {
      angle = bear+90;
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of "+angle);
    }
    else if (dir1=='E' && dir2=='S' && bear>45)
    {
      System.out.println("Invalid");
    }

    else if (dir1=='S' && dir2=='E' && bear>0 && bear<=45)
    {
      angle = 180-bear;
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of "+angle);
    }

    else if (dir1=='S' && dir2=='E' && bear>45)
    {
      System.out.println("Invalid");
    }

    //Quadrant SW

        // Quadrant E,S

    if (dir1=='S' && dir2=='W' && bear>0 && bear<=45)
    {
      angle = bear+180;
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of "+angle);
    }
    else if (dir1=='S' && dir2=='W' && bear>45)
    {
      System.out.println("Invalid");
    }

    else if (dir1=='W' && dir2=='S' && bear>0 && bear<=45)
    {
      angle = 270-bear;
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of "+angle);
    }

    else if (dir1=='W' && dir2=='S' && bear>45)
    {
      System.out.println("Invalid");
    }

    //Quadrant W,N

    if (dir1=='W' && dir2=='N' && bear>0 && bear<=45)
    {
      angle = bear+270;
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of "+angle);
    }
    else if (dir1=='W' && dir2=='N' && bear>45)
    {
      System.out.println("Invalid");
    }

    else if (dir1=='N' && dir2=='W' && bear>0 && bear<=45)
    {
      angle = 360-bear;
      System.out.println("Compass "+dir1+bear+dir2+" is a bearing of "+angle);
    }

    else if (dir1=='N' && dir2=='W' && bear>45)
    {
      System.out.println("Invalid");
    }

      }
  }
  else
  {
    System.out.println("Invalid");
  }
}
else
{
  System.out.println("Invalid");
}
}
}
}




   
