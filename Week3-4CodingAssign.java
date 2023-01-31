package week3ArraysAndMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Week3CodingAssign {

  static Scanner scanner = new Scanner(System.in); //get response to populate values

  public static void main(String[] args) {
    //1. Create an array of int called ages containing values 3, 9, 23, 64, 2, 8, 28, 93
    int[] ages= {3, 9, 23, 64, 2, 8, 28, 93, 84};
      //a. programmatically subtract first element value, from the last, without using 'ages[7]'
    int firstMinusLast = (ages[ages.length-1]) - ages[0];
      //b. Add a new age (84) to ages and repeat previous step to ensure dynamic behavior
    System.out.println("First  minus last: " + firstMinusLast);

      //c. Use a loop to iterate through ages and calculate average, print result to console
    int ageSum = 0;
    for (int i=0; i<ages.length; i++) {
      ageSum += ages[i];
    } System.out.println("Avg age: " + ageSum / ages.length); //avg age
    
        
    //2. Create an array of String with names Sam, Tommy, Sally, Buck, Bob
    String[] names = {"Sam", "Tommy", "Sally", "Buck", "Bob"};
      //a. Use a loop to iterate through array and calculate avg number of letters per name, print result
    int totalLetters = 0;
    for (String name: names) {
      totalLetters += name.length();
    } int avgLetters = totalLetters / names.length;
    System.out.println("Avg letters: " + avgLetters); //avg letters
    
      //b. Use a loop to iterate names again, concat. all names together seperate by spaces, print result
    int i = 0;
    String listedNames = "";
    while (i<names.length) {
      listedNames += names[i];
      i++; if (i == names.length) {
        break;
      } listedNames += ", ";     
    } System.out.println("Names w/ spaces: " + listedNames); //names with  spaces
      
    //3. How to access last element of any array? 'array.length - 1'
    //4. Access first element? array[0]
    //5. Create new array of nameLengths, write loop to iterate previous names array, add length of each name to nameLengths
    int[] nameLengths = new int [names.length];
    int l = 0;
    for (String name: names) {     
      nameLengths[l] = names[l].length();
      l++;
      } System.out.println("Name lengths: " + Arrays.toString(nameLengths));

    //6. Write loop to iterate nameLengths, calculate sum of all elements, print to console
    int nameLenSum = 0;
    for (int t = 0; t < nameLengths.length; t++) {
      nameLenSum += nameLengths[t];
      } System.out.println("Name lenth sum: " + nameLenSum);
      
    //7. Result- concattedWord
      //String word = "Hello";
      //int times = 3;
      String concatWord = concatStringMultInt("Hello", 3);
      System.out.println("Concatted word: " + concatWord);
      
    //8. Result- fullName
      String firstName = "Ada";
      String lastName = "Lovelace";
      String fullName = makeFullName(firstName, lastName);
      System.out.println("Full name: " + fullName);
      
    //9. Result- is array of int > 100
      System.out.println("Is greater than 100: " + arrGreaterThanHundred(ages));
      
    //10. Result- average of all elements in array
      double[] myArr = {23.8, 22.1, 10, 19.1, 20.8, 29.5};
      System.out.println("Arr avg: " + avgDoubleArray(myArr));
      
    //11. Result- arrA average > arrB average
      double[] myArrB = {82.1, 21.9, 32.8, 18.1, 9, 8};
      System.out.println("arrA > arrB: " + isArrAvgGreater(myArr, myArrB));
      
    //12. Result- will we buy a drink?
      boolean isHotOutside = true;
      double moneyInPocket = 10.55;
      System.out.println("Will buy drink: " + willBuyDrink(isHotOutside, moneyInPocket));
      
    //13. Result- have you finished all of your weekly assignments? Run through a list of assignments to visually see completion
    // See "13. Method" for more detail
      List<String> weeklyAssignments = new ArrayList<String>(); // create ArrayList for Assignments
      createWeeklyAssignmentList(weeklyAssignments); //create list and receive prompts
        
      }   
  
  //7. Method. Write method that takes a String- word, and int- n. Method returns word*int, eg 'hi', 3="hihihi"
  public static String concatStringMultInt(String word, int times) {
    String concattedWord = "";
    int numOfTimes = 0;
    do {
      concattedWord += word;
      numOfTimes++;
    } while (numOfTimes < times);
    return concattedWord;
  }
  
  //8. Method. Write a method that takes two Strings, firstName, lastName, then returns fullName String, with space.
  private static String makeFullName(String firstName, String lastName) {
    
    String fullName = firstName + " " + lastName;    
    return fullName;
  }
  
  //9. Method. Write a method that takes an array of int and returns true if the sum of all ints are > 100
  public static boolean arrGreaterThanHundred(int[] myArr) {
    int arrSum = 0;
    for (int num: myArr) {
      arrSum += num;
    }
    if (arrSum > 100) {
      return true;
    } return false;
  }
  
  //10. Method. Write a method that takes an array of double and returns the average of all elements in the array.
  public static double avgDoubleArray(double[] arr) {
    double arrSum = 0;
    
    for (double num: arr) {
      arrSum += num;
    } 
    double arrayAvg = arrSum / arr.length ;
    return arrayAvg;
  }
  
  //11. Method. Write a method that takes two arrays of double and returns true if the average of first array > average of second
  public static boolean isArrAvgGreater(double[] arrA, double[] arrB) {
    double arrASum = 0; //calculate sums
    double arrBSum = 0; //calculate sums
    int j = 0;
      
    while (j<arrA.length && j<arrB.length) { //loop while j<arrA && j<arrB
      arrASum += arrA[j];
      arrBSum += arrB[j];
      j++;     
    } if (arrA.length > arrB.length) { //if arrA.length > arrB.length, continue until arrASum complete
      while (j<arrA.length) {
        arrASum += arrA[j];
        j++;
      }
    } else { //else arrB.length > arrA.length, complete arrBSum
      while (j<arrB.length) { 
        arrBSum += arrB[j];
        j++;
      }
    }

    double arrAAvg = arrASum / arrA.length; //arr avgs
    double arrBAvg = arrBSum / arrB.length; //arr avgs
    return arrAAvg > arrBAvg;
    }
  
  //12. Method. Write a method called willBuyDrink that takes boolean isHotOutside and double moneyInPocket. Return true if it is hot outside and moneyInPocket > 10.50
  public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
    if (isHotOutside == true) {
      if (moneyInPocket > 10.50) {
        return true;
      }
    } return false;
  }
  //13. Method. Create a method of your own that solves a problem
  // create a list of the assignments for the week. create a loop that asks if you've completed them and only takes y/n answers.
  // at the end print an update on complete and incomplete assignments with a message for each.
  // this is to help repeatedly and visually see and remind myself of the assignments due/done
  public static List createWeeklyAssignmentList(List<String> weeklyAssignments) {
    weeklyAssignments.add("Watched Videos"); //list of assignments
    weeklyAssignments.add("Attended Class");
    weeklyAssignments.add("OpenClass Mastery");
    weeklyAssignments.add("Research Assignment");
    weeklyAssignments.add("LinkedIn Post");
    weeklyAssignments.add("Coding Assignment");
    
    List<String> isComplete = new ArrayList<String>(); // assign complete/incomplete lists
    List<String> isNotComplete = new ArrayList<String>();
    
    System.out.println("Have you completed the following? y/n"); //prompt user for input
    
    for (int i = 0; i < weeklyAssignments.size(); i++) { //start loop
      System.out.print(weeklyAssignments.get(i) + ": "); //display assignment
      String isCompleteResponse = scanner.nextLine(); // user input
      
      if (isCompleteResponse.equals("y")) { //if "y" add to isComplete
        isComplete.add(weeklyAssignments.get(i));    
      } 
      else if (isCompleteResponse.equals("n")) { // "n" isNotComplete check
        isNotComplete.add(weeklyAssignments.get(i));
      }
      else { // if input != "y" or "n"
        System.out.println("Please enter a valid answer."); // else proper input please
        i--; //ask same index
        }        
    }
    System.out.println("So far you have completed- " + isComplete + "\n"); // "You've completed.."
    
    if (isNotComplete.size() > 0) { //if isNotComplete > 0
      System.out.println("You are not done for the week,");
      System.out.println("The following assignments still need to be done- " + isNotComplete); //"you are not done, you need to.."
    } else if (isNotComplete.size() == 0) { // isNotComplete is empty 
      System.out.println("YOU'VE FINISHED! Time to start next week's :)"); // you're done!
    }
    return weeklyAssignments;
    }
    
  
  }  

