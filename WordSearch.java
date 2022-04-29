// programmer:  Jonathan Hill
// 3/11/22
// Purpose:  The purpose of this program is to create a crossword puzzle.
// The program will ask you to create a "word generator" by selecting g
// If you try to produce a word generator without entering in strings then
// the program will ask you to do that first

// Note:  Sometimes the program gets hung up after entering the 5th string
// I believe this is because in the generate method at the four while loop,
// which deals with the fifth string, the program can't exit the while loop.  
// I haven't had time to debug this. If this happens start the program

// Import scanner class
import java.util.*;

// Start of WordSeach Class
public class WordSearch {
  
// Start of generate method
// returns the grid array to the LetterGenrator Class
// runs the bulk of the program
  public char [][] generate() {            
      int height = 30;
      int length = 30;
      int range = 20;
      char [][] grid = new char[length][height];
      Random rand = new Random();
      Scanner input = new Scanner(System.in);
      // generate random numbers that can be used
      // to place the users strings into the grid array
      int randomNumber = rand.nextInt(range);
      int randomNumber2 = rand.nextInt(range);
      int randomNumber3 = rand.nextInt(range);
      int randomNumber4 = rand.nextInt(range);
      int randomNumber5 = rand.nextInt(range);
      // ask user to enter strings
      System.out.println("Please enter 5 words");
      System.out.println("Enter 1st word, 8 characters or less: ");
      String wordOne = input.next();
      System.out.println("Enter 2nd word, 8 characters or less: ");
      String wordTwo = input.next();
      System.out.println("Enter 3rd word, 8 characters or less: ");
      String wordThree = input.next();
      System.out.println("Enter 4th word, 8 characters or less: ");
      String wordFour= input.next();
      System.out.println("Enter 5th word, 8 characters or less: ");
      String wordFive= input.next();
      // covert strings to uppercase
      String s = wordOne.toUpperCase();
      String t = wordTwo.toUpperCase();
      String q = wordThree.toUpperCase();
      String u = wordFour.toUpperCase();
      String v = wordFive.toUpperCase();
     // for loops to place the strings as individual characters in arrays
     // the while loops make the computer pick a differnent random number for 
     // each string to keep the strings from over writing each other
     for(int i = 0; i < s.length(); i++) {
         grid [randomNumber + i][randomNumber] = s.charAt(i);
      }
      for(int i = 0; i < t.length(); i++) {
         while(randomNumber2 == randomNumber  || randomNumber2 == randomNumber + 1  
               || randomNumber2 == randomNumber -1) {
            randomNumber2 = rand.nextInt(range);
         }
         grid [randomNumber + 2][randomNumber2 + i] = t.charAt(i);
      }
      for(int i = 0; i < q.length(); i++) {
         while(randomNumber3 == randomNumber || randomNumber3 == randomNumber2 
               || randomNumber3 == randomNumber + 1 || randomNumber3 == randomNumber2 + 1 
               || randomNumber3 == randomNumber - 1 || randomNumber3 == randomNumber2 - 1) {
            randomNumber3 = rand.nextInt(range);
         }
         grid [randomNumber + 4 + i][randomNumber + 4 + i] = q.charAt(i);
      }
      for(int i = 0; i < u.length(); i++) {
         while(randomNumber4 == randomNumber || randomNumber4 == randomNumber2 
               || randomNumber4 == randomNumber3|| randomNumber4 == randomNumber + 1 
               || randomNumber4 == randomNumber2 + 1 || randomNumber4 == randomNumber3 + 1
               || randomNumber4 == randomNumber -1 || randomNumber4 == randomNumber2 -1 
               || randomNumber4 == randomNumber3 - 1) {
                   
            randomNumber4 = rand.nextInt(range);
         }
         grid [randomNumber4][randomNumber4 + i] = u.charAt(i);
      }
      for(int i = 0; i < v.length(); i++) {
         // I believe I have a bug in this while loop that
         // keeps the program occasionally from exiting this loop
         while(randomNumber5 == randomNumber || randomNumber5 == randomNumber2 
               || randomNumber5 == randomNumber3 || randomNumber5 == randomNumber4 
               || randomNumber5 == randomNumber + 1 || randomNumber5 == randomNumber2 + 1 
               || randomNumber5 == randomNumber3 + 1 || randomNumber2 == randomNumber4 + 1 
               || randomNumber5 == randomNumber -1 || randomNumber5 == randomNumber2 -1 || 
               randomNumber5 == randomNumber3 -1 || randomNumber5 == randomNumber4 - 1) {
                 
            randomNumber5 = rand.nextInt(range);
         }
         grid [randomNumber5 + i][randomNumber5] = v.charAt(i);
      }
      return grid;
      
   } // end of generate method
    
     // Start of print method
     // prints out cross word puzzle
     public void print(char [][] c) {
      int height = 30;
      int length = 30;
      // String to fill in blank spots in c array
      String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      Random rand = new Random();
      for(int i = 0; i < height; i++) {
         for(int j = 0; j < length; j++) {
            // compares ascii values to zero to
            // determine if char element is blank
            if (c[i][j] == 0) {
               c[i][j] = characters.charAt(rand.nextInt(25));
            
            } else {
               continue;
            }    
         }
      }
      for(int i = 0; i<height; i++) {
         for(int j = 0; j<length; j++) {
          // Prints out individaul characters
          // places a space between characters
            System.out.print(c[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println("\n");
   } // end of print method
   
   // Start of the printSolution method
   public void printSolution(char [][] b) {
      int height = 30;
      int length = 30;
      for(int i = 0; i < height; i++) {
         for(int j = 0; j < length; j++) {
            // compares ascii values to zero to
            // determine if char element is blank
            if (b[i][j] == 0) {
               b [i][j] = '*';
            } else {
               continue;
            }    
         }
      }
      for(int i = 0; i<height; i++) {
         for(int j = 0; j<length; j++) {
           // Prints out individaul characters
          // places a space between characters
             System.out.print(b[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println("\n");
   } // end of printSolution method
} // end of WordSearch Class
   
   
   
   


 





