// Math Training Game
// v1.0
// Created By: John Derick Amalraj
// Date Started: April 13 2017
// Date Playabe: April 18 2017
// Date Completed: April 23 2017
import hsa.*;
import java.awt.*;



public class Math_Training_Game {
  public static void main(String[] args) {
    Console con = new Console(90,360,33,"Math Training Game");
    
    // Title Screen/Intro Animation
    // Variables below are used to in the Title Screen/Intro Animation
    String strGameName;
    String strGameVersion;
    String strCreator;
    String strDate;
    
    //The variables below are used to determine the coordinates of the fonts, for the animation to work
    //Please Note: That the variables listed below will be defined/used mutiple times throughout the game
    int intX = 700;
    int intY = 900;
    int intCount;
    char chrKey;
    
    //Giving the strings values
    strGameName = "Math Training Game";
    strGameVersion = "Version 1.0";
    strCreator = "Created by: John Derick Amalraj";
    strDate = "Date Completed: 23 April 2017";
    
    //This command was a bit hard to figure out.
    con.setFont(new Font("Serif", 1, 50));
    
    //Animation loop for the documentation strings
    for(intCount = 0;intCount < 200;intCount++){
      con.setColor(Color.BLACK);
      con.drawString(strGameName, intX,intY);
      if (intCount > 20){
        con.drawString(strGameVersion, intX, intY+100);
      }
      if (intCount > 40){
        con.drawString(strCreator, intX, intY+200);
      }
      if (intCount > 60) {
        con.drawString(strDate, intX, intY+300);
      }
      con.setColor(Color.WHITE);
      pause(100/3);
      con.drawString(strGameName, intX,intY);
      if(intCount > 20){
        con.drawString(strGameVersion, intX, intY+100);
      }
      if (intCount > 40){
        con.drawString(strCreator, intX, intY+200);
      }
      if (intCount > 60) {
        con.drawString(strDate, intX, intY+300);
      }
      intY=intY-6;
    }
    // Variables that make the game function
    int intQuestionType;
    int intNumber1;
    int intNumber2;
    int intAns;
    int intEnter;
    intEnter =0;
    String strEqu;
    
    ///Variables to determine lives in game, and percentage of questions correct
    double dblTries;
    dblTries = 3;
    double dblAmount;
    double dblCorrect;
    double dblPercentage;
    
    ///Variables for the Difficulty
    int intDiff;
    intDiff = 10;
    int intMultiDiff;
    intMultiDiff = 6;
    char chrLeave;
    
    //Variables that are used in game over screen
    ///Note that diffculty ie reset after losing
    ////Also note other variables used are intY, to make the entire black, to surprise them
    String strGameOver;
    String strYouQuit;
    strGameOver="Game Over!";
    strYouQuit="You Quit!";
    int intLength;
    String strFinalPercent;
    String strReturn;
    String strCorrect;
    ////Beta-testers complained of lives being a double number, so I made it a string.
    String strTries;
    
    //Variables that are used in success screen
    ///Note that diffculty ie reset after losing
    String strSuccess;
    strSuccess="Success";
    
    //Variables that for the Error Animation
    int intAnimation;
    intAnimation=1;
    String strAnimation;
    strAnimation="N";
    double dblcross;
    String strIncorrect;
    strIncorrect = "Incorrect";
    //note the variables, intX, intY, and dblTries are used in the creation of the error animation
    
    // Variables that are adjusted/used in the Config Screen
    String strConfig;
    strConfig = "Configurations";
    int intNum;
    
    ///Addition
    int intAdd;
    String strAdd;
    intAdd = 1;
    strAdd = "Y";
    
    ///Subtraction
    int intSub;
    intSub = 1;
    String strSub;
    strSub = "Y";
    
    ///Multiplication
    int intMulti;
    intMulti = 0;
    String strMulti;
    strMulti ="N";
    
    ///Division
    int intDiv;
    intDiv = 0;
    String strDiv;
    strDiv = "N";
    
    ///Number of Lives
    int intLives;
    intLives = 3;
    ///Number of Questions
    int intAmount;
    intAmount = 100;
    
    ///Option of Negative Answers *for Subtraction only
    int intNegAns;
    intNegAns=0;
    String strNegAns;
    strNegAns="N";
    char chrChange;
    
    while (0==0){
      
      //Main Menu Screen
      con.setCursorVisible(false);
      con.clear();
      con.setColor(Color.BLACK);
      con.setFont(new Font("Arial", Font.BOLD, 120));
      con.drawString(strGameName, 400,250);
      con.setCursor(10,35);
      con.println("1: Play");
      con.setCursor(11,35);
      con.println("2: Instructions");
      con.setCursor(12,35);
      con.println("3. Config");
      con.setCursor(13,35);
      con.println("4: Credits");
      con.setCursor(14,35);
      con.println("5: Quit");
      chrKey =' ';
      while(chrKey !='1' && chrKey !='2' && chrKey !='3' && chrKey !='4' && chrKey !='5'){
        
        //Entering the corresponding char will send user to desired Screen
        con.setCursor(15,35);
        con.println("Please select a number");
        con.setCursor(16,35);
        chrKey = con.getChar();
      }
      con.setCursor(17,35);
      if(chrKey == '1'){
        //GAME SCREEN
        con.clear();
        //Lives & Number of Questions determined
        dblAmount = intAmount;
        dblTries = intLives;
        //The Level is determined
        int intLevel;
        intLevel = 1;
        //Value needed to start error animation is determined
        dblcross = intLives-1;
        dblCorrect=0.0;
        for(intCount=0;dblTries>0 &&dblCorrect<intAmount;intCount++){
          if(intAnimation==1){
            intX = 200;
            intY = 1000;
            //Check if player has made a mistake
            while(dblcross==dblTries){
              con.setCursorVisible(false);
              con.drawLine (0, intX, 1900, intY);
              con.drawLine (0, intY, 1900, intX);
              con.drawString(strIncorrect,700,250);
              pause(5);
              intX=intX-1;
              intY=intY-1;
              if(intX==0){
                pause(1000);
                dblcross=dblcross-1;
                con.clear();
                con.setCursorVisible(true);
              }
            }
          }
          //Calculation for stuff the player should know
          strTries=(""+dblTries+"");
          intLength=strTries.length();
          strTries=strTries.substring(0,intLength-2);
          dblCorrect = intCount - (intLives-dblTries);
          if(dblCorrect==dblAmount){
            break;
          }
          //Increase in difficulty
          while((dblCorrect/10)==intLevel){
            intLevel=intLevel+1;
            intDiff=intDiff*2;
            intMultiDiff=intMultiDiff+(intMultiDiff/2);
            break;
          }
          //displaying stuff the player should know
          con.setCursor(13,24);
          con.println("You have "+strTries+" lives");
          con.setCursor(14,24);
          con.println("You have done "+intCount+" questions");
          con.setCursor(15,24);
          con.println("You have correctly answered "+dblCorrect+" questions");
          con.setCursor(16,24);
          con.println("You are on Level: "+intLevel);
          con.setCursor(18,24);
          con.println("To Exit, enter 0");
          //Getting the Percentage
          con.setCursor(15,70);
          dblPercentage = Math.round(((intCount-(intLives-dblTries))/intCount)*10000)/100.0;
          con.println(dblPercentage+"%");
          
          //The number generator determines the type of question
          intQuestionType = (int)(Math.random()*4);
          
          //What to do if the question type is addition
          ///Generate two random numbers, add them, get answer
          ////input equation into a string
          /////Print the string, and await the player's answer
          if (intQuestionType == 0&&intAdd==1){
            intNumber1 = (int)Math.ceil((Math.random()*intDiff));
            intNumber2 = (int)Math.ceil((Math.random()*intDiff));
            intAns = intNumber1 + intNumber2;
            strEqu = intNumber1+" + "+intNumber2;
            con.drawString(strEqu,825,250);
            con.setCursor(19,24);
            intEnter = con.readInt();
            if (intEnter == intAns){
              con.clear();
            }
            else if (intEnter ==0){
              break;
            }
            else if (intEnter != intAns) {
              dblTries=dblTries-1;
              con.clear();
            }
          }
          //What to do if the question type is subtraction && player has enabled negative number
          ///Generate two random numbers, subtract them, get answer
          ////input equation into a string
          /////Print the string, and await the player's answer
          else if(intQuestionType == 1&&intNegAns==1&&intSub==1){
            intNumber1=0;
            intNumber2=0;
            while(intNumber1==intNumber2){
              intNumber1 = (int)Math.ceil((Math.random()*intDiff));
              intNumber2 = (int)Math.ceil((Math.random()*intDiff));
            }
            intAns = intNumber1 - intNumber2;
            strEqu = intNumber1+" - "+intNumber2;
            con.drawString(strEqu,825,250);
            con.setCursor(19,24);
            intEnter = con.readInt();
            if (intEnter == intAns){
              con.clear();
            }
            else if (intEnter ==0){
              break;
            }
            else if (intEnter != intAns) {
              dblTries=dblTries-1;
              con.clear();
            }
          }
          //What to do if the question type is subtraction
          ///Generate two random numbers, find the bigger one, subtract them, get answer
          ////input equation into a string
          /////Print the string, and await the player's answer
          else if(intQuestionType == 1&&intSub==1){
            intNumber1=0;
            intNumber2=0;
            while(intNumber1==intNumber2){
              intNumber1 = (int)Math.ceil((Math.random()*intDiff));
              intNumber2 = (int)Math.ceil((Math.random()*intDiff));
            }
            if(intNumber1>=intNumber2){
              intAns = intNumber1 - intNumber2;
              strEqu = intNumber1+" - "+intNumber2;
              con.drawString(strEqu,825,250);
              con.setCursor(19,24);
              intEnter = con.readInt();
              if (intEnter == intAns){
                con.clear();
              }
              else if (intEnter ==0){
                break;
              }
              else if (intEnter != intAns) {
                dblTries=dblTries-1;
                con.clear();
              }
            }
            else if(intNumber2>=intNumber1){
              intAns = intNumber2 - intNumber1;
              strEqu = intNumber2+" - "+intNumber1;
              con.drawString(strEqu,825,250);
              con.setCursor(19,24);
              intEnter = con.readInt();
              if (intEnter == intAns){
                con.clear();
              }
              else if (intEnter ==0){
                break;
              }
              else if (intEnter != intAns) {
                dblTries=dblTries-1;
                con.clear();
              }
            }
          }
          //What to do if the question type is Multiplication
          ///Generate two random numbers, multiply them, get answer
          ////input equation into a string
          /////Print the string, and await the player's answer
          else if(intQuestionType == 2&&intMulti==1){
            intNumber1=0;
            intNumber2=0;
            while(intNumber1==intNumber2){
              intNumber1 = (int)Math.ceil((Math.random()*intMultiDiff));
              intNumber2 = (int)Math.ceil((Math.random()*intMultiDiff));
            }
            intAns = intNumber1*intNumber2;
            strEqu = intNumber1+" x "+intNumber2;
            con.drawString(strEqu,825,250);
            con.setCursor(19,24);
            intEnter = con.readInt();
            if (intEnter == intAns){
              con.clear();
            }
            else if (intEnter ==0){
              break;
            }
            else if (intEnter != intAns) {
              dblTries=dblTries-1;
              con.clear();
            }
          }
          //Division
          ///Get two random numbers
          ////check which one is less than the other and count down till disvisor is found
          else if(intQuestionType == 3&&intDiv==1){
            intNumber1 = (int)Math.ceil((Math.random()*intDiff));
            intNumber2 = (int)Math.ceil((Math.random()*intMultiDiff));
            if(intNumber2>intNumber1){
              while(intNumber1%intNumber2!=0)
              {intNumber2--;
                if(intNumber1%intNumber2==0){
                  break;
                }
              }
            }
            if(intNumber1>intNumber2){
              while(intNumber1%intNumber2!=0)
              {intNumber2++;
                if(intNumber1%intNumber2==0){
                  break;
                }
              }
            }
            intAns = intNumber1/intNumber2;
            strEqu = intNumber1+" ÷ "+intNumber2;
            con.drawString(strEqu,825,250);
            con.setCursor(19,24);
            intEnter = con.readInt();
            if (intEnter == intAns){
              con.clear();
            }
            else if (intEnter ==0){
              break;
            }
            else if (intEnter != intAns) {
              dblTries=dblTries-1;
              con.clear();
            }
          }
          else{
            intCount--;
          }
        }
        
        //This calculation is here to check if player has answer enough questions
        con.clear();
        chrLeave=' ';
        
        //This will print the Success screen if the player has answered the specificed number of questions, without losing all lives
        while(dblAmount == dblCorrect){
          strCorrect=(""+dblCorrect+"");
          intLength=strCorrect.length();
          strCorrect=strCorrect.substring(0,intLength-2);
          con.setFont(new Font("Arial", Font.BOLD, 200));
          con.drawString(strSuccess, 500,250);
          intDiff=10;
          intMultiDiff = 6;
          dblPercentage = Math.round(((intCount-(intLives-dblTries))/intCount)*10000)/100.0;
          con.setCursor(13,24);
          con.println("You have done "+strCorrect+" of "+intCount+" questions  "+dblPercentage+"%");
          con.setCursor(14,24);
          con.println("You have completed the goal of doing "+strCorrect+" questions");
          con.setCursor(17,30);
          con.println("Press 0 to return to the main menu");
          con.setFont(new Font("Arial", Font.BOLD, 120));
          con.setCursor(19,34);
          chrLeave = con.getChar();
          if(chrLeave=='0');{
            break;
          }
        }
        //This will print the You Quit Screen, it will happen when the player quits.
        while(intEnter==0){
          intY=1900;
          while(intY>=0){
            //This animation makes the entire screen black, adds to the effect of lossss
            con.drawLine (0, intY, 1900, intY);
            intY=intY-1;
          }
          con.setFont(new Font("Arial", Font.BOLD, 200));
          strCorrect=(""+dblCorrect+"");
          intLength=strCorrect.length();
          strCorrect=strCorrect.substring(0,intLength-2);
          con.setColor (Color.WHITE);
          con.drawString(strYouQuit, 400,250);
          dblPercentage = Math.round(((intCount-(intLives-dblTries))/intCount)*10000)/100.0;
          strFinalPercent=("You have done "+strCorrect+" of "+intCount+" questions   "+dblPercentage+"% Correct");
          con.setFont(new Font("Arial", 0, 40));
          con.drawString(strFinalPercent,600,400);
          strReturn= ("Press 0 to return to the main menu");
          con.drawString(strReturn,600,600);
          con.setCursor(14,24);
          intDiff=10;
          intMultiDiff = 6;
          con.setColor (Color.BLACK);
          con.setCursor(17,30);
          con.setFont(new Font("Arial", Font.BOLD, 120));
          con.setCursor(19,34);
          chrLeave = con.getChar();
          if(chrLeave=='0');{
            break;
          }
        }
        while (dblAmount!= dblCorrect&&intEnter!=0){
          intY=1900;
          while(intY>=0){
            //This animation makes the entire screen black, adds to the effect of lossss
            con.drawLine (0, intY, 1900, intY);
            intY=intY-1;
          }
          ///Since the screen is black, con.drawString must be used to preserve the black screen
          con.setFont(new Font("Arial", Font.BOLD, 200));
          strCorrect=(""+dblCorrect+"");
          intLength=strCorrect.length();
          strCorrect=strCorrect.substring(0,intLength-2);
          con.setColor (Color.WHITE);
          //In white the mistakes, number of questions done, and the percentage shall be written
          con.drawString(strGameOver, 400,250);
          dblPercentage = Math.round(((intCount-(intLives-dblTries))/intCount)*10000)/100.0;
          strFinalPercent=("You have done "+strCorrect+" of "+intCount+" questions   "+dblPercentage+"% Correct");
          con.setFont(new Font("Arial", 0, 40));
          con.drawString(strFinalPercent,600,400);
          strReturn= ("Press 0 to return to the main menu");
          con.drawString(strReturn,600,600);
          con.setCursor(14,24);
          intDiff=10;
          intMultiDiff = 6;
          con.setColor (Color.BLACK);
          con.setCursor(17,30);
          //Resetting the font back to the regular one used.
          con.setFont(new Font("Arial", Font.BOLD, 120));
          con.setCursor(19,34);
          chrLeave = con.getChar();
          if(chrLeave=='0');{
            break;
          }
        }
        dblPercentage = 0.0;
        dblCorrect=0.0;
      }
      
      //Instructions Screen
      else if(chrKey == '2'){
        con.clear();
        String strInstruct;
        strInstruct = "Instructions";
        con.drawString(strInstruct, 600,150);
        con.setCursor(8,12);
        con.println("This is a unique game");
        con.setCursor(9,12);
        con.println("In this game, mathmatical questions will appear on the screen.");
        con.setCursor(10,12);
        con.println("The job of the player is to correctly input the answers to the questions.");
        con.setCursor(11,12);
        con.println("The only way to lose the game is to make three mistakes.");
        con.setCursor(12,12);
        con.println("Be warned that the questions will get harder over time.");        
        con.setCursor(13,12);
        con.println("It is not recommended to use a calculator.");
        con.setCursor(14,12);
        con.println("As the purpose of this game is to build your mental math skills");
        con.setCursor(15,12);
        con.println("Although this game is intended for elementary students, there are options");
        con.setCursor(16,12);
        con.println("in the config to make the game harder.");
        con.setCursor(17,12);
        con.println("It is also possible to change the number of questions, and lives.");
        con.setCursor(18,12);
        con.println("Have fun, and good luck building those math skills!!!");
        con.setCursor(20,24);
        con.println("To return to the main menu press 0");
        int intTest;
        intTest =0;
        //Way to return to main menu
        while (intTest == 0){
          con.setCursor(17,24);
          chrChange=con.getChar();
          if(chrChange == '0'){
            break;}
        }
      }
      
      //Configuration Screen
      else if(chrKey == '3'){
        while(0==0){
          con.setCursorVisible(true);
          con.clear();
          con.drawString(strConfig, 600,150);
          con.setCursor(8,8);
          con.println("For any option you would like to change please enter the option # and then press enter");
          con.setCursor(9,8);
          con.println("After that enter the corresponding number or letter. (N = no, Y = yes)");
          con.setCursor(10,8);
          con.println("If you cannot see the Cursor enter 9 and press enter.");
          con.setCursor(11,8);
          con.println("Type 0 to return to the main menu");
          con.setCursor(13,24);
          con.println("1. Addition                        {"+strAdd+"}");
          con.setCursor(14,24);
          con.println("2. Subtraction                     {"+strSub+"}");
          con.setCursor(15,24);
          con.println("3. Multiplication                  {"+strMulti+"}");
          con.setCursor(16,24);
          con.println("4. Division                        {"+strDiv+"}");
          con.setCursor(17,24);
          con.println("5. Lives                           {"+intLives+"}");
          con.setCursor(18,24);
          con.println("6. Number of Questions             {"+intAmount+"}");
          con.setCursor(19,24);
          con.println("7. Enable Negative Answers         {"+strNegAns+"}");
          con.setCursor(20,24);
          con.println("8. Disable Error Animation         {"+strAnimation+"}");          
          con.setCursor(22,30);
          //Number inputted will determine what value to change/ or send player back to main menu
          
          intNum=con.readInt();
          while (intNum!=1&&intNum!=2&&intNum!=3&&intNum!=4&&intNum!=5&&intNum!=6&&intNum!=7&&intNum!=8&&intNum!=9&&intNum!=0){
            con.setCursor(22,30);
            intNum=con.readInt();
          }
          //Controls for Addition
          if(intNum==1){
            con.setCursorVisible(true);
            con.setCursor(13,60);
            chrChange=con.getChar();
            if(chrChange =='Y'||chrChange =='y'){
              strAdd = "Y";
              intAdd = 1;
            }else if (chrChange =='N'||chrChange =='n'){
              strAdd = "N";
              intAdd = 0;
            }
          }
          
          //Controls for Subtraction
          if(intNum == 2){
            con.setCursorVisible(true);
            con.setCursor(14,60);
            chrChange=con.getChar();
            if(chrChange =='Y'||chrChange =='y'){
              strSub = "Y";
              intSub = 1;
            }else if (chrChange =='N'||chrChange =='n'){
              strSub = "N";
              intSub = 0;
            }
          }
          
          //Controls for Multiplication
          if(intNum==3){
            con.setCursorVisible(true);
            con.setCursor(15,60);
            chrChange=con.getChar();
            if(chrChange =='Y'||chrChange =='y'){
              strMulti = "Y";
              intMulti = 1;
            }else if (chrChange =='N'||chrChange =='n'){
              strMulti = "N";
              intMulti = 0;
            }
          }
          //Controls for Division
          if(intNum==4){
            con.setCursorVisible(true);
            con.setCursor(16,60);
            chrChange=con.getChar();
            if(chrChange =='Y'||chrChange =='y'){
              strDiv = "Y";
              intDiv = 1;
            }else if (chrChange =='N'||chrChange =='n'){
              strDiv = "N";
              intDiv = 0;
            }
          }
          //Controls for Number of Lives
          if(intNum==5){
            con.setCursorVisible(true);
            con.setCursor(17,60);
            intCount=con.readInt();
            if( intCount>0){
              intLives=intCount;
            }
          }
          
          //Controls for Number of Questions
          if(intNum==6){
            con.setCursorVisible(true);
            con.setCursor(18,60);
            intCount=con.readInt();
            if( intCount>0){
              intAmount=intCount;
            }
          }
          
          //Controls to enable negative answers *for subtraction only
          if(intNum == 7){
            con.setCursorVisible(true);
            con.setCursor(19,60);
            chrChange=con.getChar();
            if(chrChange =='Y'||chrChange =='y'){
              strNegAns = "Y";
              intNegAns = 1;
            }else if (chrChange =='N'||chrChange =='n'){
              strNegAns = "N";
              intNegAns = 0;
            }
          }
          //Controls to disable the error animation
          if(intNum == 8){
            con.setCursorVisible(true);
            con.setCursor(20,60);
            chrChange=con.getChar();
            if(chrChange =='Y'||chrChange =='y'){
              strAnimation = "Y";
              intAnimation = 0;
            }else if (chrChange =='N'||chrChange =='n'){
              strAnimation = "N";
              intAnimation = 1;
            }
          }
          if(intNum == 9){
            con.setCursorVisible(true);
            con.setCursor(22,30);
          }
          //Way to reurn to main menu
          if(intNum==0){
            con.setCursorVisible(false);
            break;
          }
        }
      }else if(chrKey == '4'){
        //Credit Screen
        
        con.setFont(new Font("Serif", 1, 50));
        con.clear();
        intX = 600;
        intY = 1000;
        //I dedicate a string to everyone who have helped me
        String strCadawas;
        String strTesters;
        String strWilliam;
        String strThomas;
        String strJakob;
        String strFelicia;
        String strBryan;
        String strBenedict;
        String strInspired;
        strCadawas="Special Thanks to Mr. Cadawas";
        strTesters="Beta-Testers:";
        strWilliam="              William Victor Galapon";
        strThomas= "              Thomas Aryawan";
        strJakob=  "              Jakob Bruhn";
        strFelicia="              Felicia Nip";
        strBryan=  "              Bryan Ng";
        strBenedict="            Benedict Amalraj";
        strInspired="Inspired by Lumosity";
        for(intCount = 0;intCount < 700;intCount++){
          con.setColor(Color.BLACK);
          con.drawString(strCreator, intX,intY);
          if (intCount > 20){
            con.drawString(strTesters, intX, intY+100);
            if(intCount>20){
              con.drawString(strWilliam, intX+200, intY+100);
            }
          }
          if (intCount > 40){
            con.drawString(strThomas, intX+200, intY+200);
          }
          if (intCount > 60){
            con.drawString(strJakob, intX+200, intY+300);
          }
          if (intCount > 60){
            con.drawString(strFelicia, intX+200, intY+400);
          }
          if (intCount > 80){
            con.drawString(strBryan, intX+200, intY+500);
          }
          if (intCount > 100){
            con.drawString(strBenedict, intX+200, intY+600);
          }
          if (intCount > 160){
            con.drawString(strCadawas, intX, intY+900);
          }
          if (intCount > 200) {
            con.drawString(strInspired, intX, intY+1000);
          }
          con.setColor(Color.WHITE);
          pause(100/3);
          con.drawString(strCreator, intX,intY);
          if (intCount > 20){
            con.drawString(strTesters, intX, intY+100);
            if(intCount>20){
              con.drawString(strWilliam, intX+200, intY+100);
            }
          }
          if (intCount > 40){
            con.drawString(strThomas, intX+200, intY+200);
          }
          if (intCount > 60){
            con.drawString(strJakob, intX+200, intY+300);
          }
          if (intCount > 60){
            con.drawString(strFelicia, intX+200, intY+400);
          }
          if (intCount > 80){
            con.drawString(strBryan, intX+200, intY+500);
          }
          if (intCount > 100){
            con.drawString(strBenedict, intX+200, intY+600);
          }
          if (intCount > 160){
            con.drawString(strCadawas, intX, intY+900);
          }
          if (intCount > 200) {
            con.drawString(strInspired, intX, intY+1000);
          }
          intY=intY-3;
          
        }
        
      }else if(chrKey == '5'){
        //found this online
        System.exit(0);
      }
    }
  }
  public static void pause(int intMS) {
    try{
      Thread.sleep(intMS);
    }catch(InterruptedException e){
    }
    
  }
}
