public class Lab3
{
  public static void testLightCandles1()
  {
    Robot.load("candles1.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  
  public static void testLightCandles2()
  {
    Robot.load("candles2.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
    
  public static void lightCandles()
  {
    checkCandle();
    checkCandle();
    checkCandle();
    checkCandle();
    checkCandle();
    checkCandle();
    checkCandle();
    checkCandle();
    checkCandle();
    checkCandle();
  }
  
  //Run this method to test completeRoom on map room1.txt
  public static void testCompleteRoom1()
  {
     Robot.load("room1.txt");
     Robot.setDelay(0.05);
     completeRoom();
  }
  
  //Run this method to test completeRoom on map room2.txt
  public static void testCompleteRoom2()
  {
    Robot.load("room2.txt");
    Robot.setDelay(0.05);
    completeRoom();
  }
  
  //Complete this method.  You will need to write additional helper methods.
  public static void completeRoom()
  {
    checkSide();
    checkSide();
    checkSide();
    checkSide();
  }
  
  //Run this method to test swapAll on map swap1.txt
  public static void testSwapAll1()
  {
    Robot.load("swap1.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll2()
  {
    Robot.load("swap2.txt");
    Robot.setDelay(0.05);
    swapAll();
  }

  //Complete this method.  You will need to write additional helper methods.
  public static void swapAll()
  {
    swapRow();
    swapRow();
    swapRow();
    swapRow();
    swapRow();
    swapRow();
    swapRow();
    swapRow();
    swapRow();
    swapSquares();
  }
  
  //Don't run these. I will!
  public static void testLightCandles3()
  {
    Robot.load("candles3.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  
  public static void testLightCandles4()
  {
    Robot.load("candles4.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  public static void testCompleteRoom3()
  {
     Robot.load("room3.txt");
     Robot.setDelay(0.05);
     completeRoom();
  }
  
  public static void testCompleteRoom4()
  {
    Robot.load("room4.txt");
    Robot.setDelay(0.05);
    completeRoom();
  }
  
  public static void testSwapAll3()
  {
    Robot.load("swap3.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll4()
  {
    Robot.load("swap4.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  //precondition: the candle is unlit and the robot is to the left of it
  //postcondition: the candle is lit and the robot is to the right of it.
  public static void lightCandle()
  {
    Robot.move();
    Robot.makeDark();
    Robot.move();
    }
  //precondition: the robot is facing a certain direction
  //postcondition: the robot is facing 90 degrees right relative to that direction
  public static void turnRight()
  {
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();
    }
  //precondition: the robot is likely looking ahead at nothing
  //postcondition: the robot has moved down one space, facing the same way
  public static void moveDown()
  {
    turnRight();
    Robot.move();
    Robot.turnLeft();
    }
  //precondition: the robot is likely staring at a wall
  //postcondition: the robot has moved up one space, facing the same way
  public static void moveUp()
  {
    Robot.turnLeft();
    Robot.move();
    turnRight();
    }
  public static void checkCandle()
  {
    if (Robot.frontIsClear())
      {
        moveDown();
        if (Robot.frontIsClear())
        {
        lightCandle();
        }
        else
        {
        moveUp();
        lightCandle();
        }
        }
      else
      {
        moveUp();
        if(Robot.frontIsClear())
        {
        lightCandle();
        }
        else
        {
        moveUp();
        lightCandle();
        }
    }
  }
  public static void checkSquare()
  {
    Robot.turnLeft();
    if (Robot.frontIsClear())
    {
    Robot.move();
    if (Robot.onDark())
    {
    goBack();
    }
    else
    {
    Robot.makeDark();
    goBack();
    }
    }
    else
    {
    turnRight();
    }
    }
  //precondition: facing a wall on the outside
  //postcondition: facing 90 degrees right, one space back
  public static void goBack()
  {
    turnRight();
    turnRight();
    Robot.move();
    Robot.turnLeft();
    }
  //precondition: side is not necessarily "clean"
  //postcondition: side is "clean"
  public static void checkSide()
  {
    checkSquare();
    Robot.move();
    checkSquare();
    Robot.move();
    checkSquare();
    Robot.move();
    checkSquare();
    Robot.move();
    checkSquare();
    turnRight();
    }
  //precondition: the robot is facing a certain direction
  //postcondition: the robot is facing 180 degrees relative to that direction
  public static void turnAround()
  {
    turnRight();
    turnRight();
    }
  //precondition: squares are positioned a certain way
  //postcondition: positions of the squares have been switched
  public static void swapSquares()
  {
    Robot.turnLeft();
    Robot.move();
    if (Robot.onDark())
    {
    otherSide();
    if (Robot.onDark())
    {
    nextRow();
    }
    else
    {
    swapDarkThenLight();
    }
    }
    else
    {
    otherSide();
    if (Robot.onDark())
    {
    swapLightThenDark();
    }
    else
    {
    nextRow();
    }
    }
    }
  //precondition: facing a wall on the outside
  //postcondition: facing 90 degrees right, one space back
  public static void nextRow()
  {
    turnAround();
    Robot.move();
    turnRight();
    }
  //precondition: robot is on one side of the room, facing a wall
  //psotcondition: robot is on the other side of the room, facing the wall
  public static void otherSide()
  {
    turnAround();
    Robot.move();
    Robot.move();
    }
  //precondition: squares are positioned a certain way
  //postcondition: positions of the squares have been switched
  public static void swapRow()
  {
    swapSquares();
    Robot.move();
    }
  //precondition: two squares are light and dark
  //postcondition: two squares are now dark and light
  public static void swapDarkThenLight()
  {
    Robot.makeDark();
    otherSide();
    Robot.makeLight();
    goBack();
    }
  //precondition: two squares are dark and light
  //postcondition: two squares are now light and dark
  public static void swapLightThenDark()
  {
    Robot.makeLight();
    otherSide();
    Robot.makeDark();
    goBack();
    }
}
