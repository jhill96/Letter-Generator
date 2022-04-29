// programmer:  Jonathan Hill
// 3/11/22
// Purpose:  The purpose of this program is to create a crossword puzzle.
// The program will ask you to create a "word generator" by selecting g
// If you try to produce a word generator without entering in strings then
// the program will ask you to do that first

// Note:  Sometimes the program gets hung up after entering the 5th string
// I believe this is because in the generate method at the for while loop,
// which deals with the fifth string, the program can't exit the while loop.  
// I haven't had time to debug this. If this happens start the program over.

// Import scanner class
import java.util.*;

// Start of the LetterGenerator class
public class LetterGenerator {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String userinput = "";
      WordSearch puzzle = new WordSearch();
      // create different arrays that I can use in different methods
      // so I'm not over writing arrays.
      char [][] a = new char [30][30];
      char [][] b = new char [30][30];
      char [][] c = new char [30][30];
      // start of do/while 
      do{
         input = new Scanner(System.in);
         printIntro();
         userinput = input.next();
         if (userinput.equalsIgnoreCase("g")) {
            a  =  puzzle.generate();
         } else if (userinput.equalsIgnoreCase("p")) {
            int sum = 0;
            for( int i = 0; i<30; i++) {
               for(int  j = 0; j < 30; j++) {
            //iterates though the grid array in wordsearch class
            //and copies information to c array which is passed
            //to the print() in word search class
                  c [j][i] = a[j][i];
            //checks to see if there's any character in the array
            //by adding up ascii values and comparing to zero
                  sum = sum + a[j][i];
               }
            }
            if( sum > 0) {
               puzzle.print(c);
            } else {
               System.out.println("Please create a word generator first\n");
            }
         } else if (userinput.equalsIgnoreCase("s")) {
           
            int sum = 0;
            for(int  i = 0; i<30; i++) {
               for(int j = 0; j < 30; j++) {
            //iterates though the grid array in wordsearch class
            //and copies information to b array which is passed
            //to the print() in word search class
                  b [j][i] = a[j][i];
            //checks to see if there's any character in the array
            //by adding up ascii values and comparing to zero
                  sum = sum + a[j][i];
               }
            }
            if(sum > 0) {
               puzzle.printSolution(b);
            } else {
               System.out.println("Please create a word generator first\n");
            }
         } else if (userinput.equalsIgnoreCase("q")) {
            break;
         } else {
            System.out.println("Please enter a valid command");
         }
      
      } while (userinput.equalsIgnoreCase("g") || userinput.equalsIgnoreCase("p") || userinput.equalsIgnoreCase("s")
            || !userinput.equalsIgnoreCase("g") && !userinput.equalsIgnoreCase("q")|| !userinput.equalsIgnoreCase("p") 
            && !userinput.equalsIgnoreCase("q")|| !userinput.equalsIgnoreCase("s") && !userinput.equalsIgnoreCase("q"));
   } // end of do/while 
        
   // Start of printIntro method - presents the main menu
   public static void printIntro() {
      System.out.printf("%s%n" , "Welcome to my word search generator!");
      System.out.printf("%s%n" , "Please select an option:");
      System.out.printf("%s%n" , "Generate a new word search  (enter g)");
      System.out.printf("%s%n" , "Print out your word search (enter p)");
      System.out.printf("%s%n" , "Show the solution to your word search (enter s)");
      System.out.printf("%s%n" , "Quit program (enter q)");
   } // end of the printIntro method
} // end of LetterGenerator class
