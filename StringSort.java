/* input is two integers,
the first integer represents the length of the array,
the second integer represents a position in the array.
This input is followed by a series of strings.
The output is the string at position of second integer
Sort words in ascending order according to their length
and if words are the same length, sort in reverse alphabetical order*/

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class StringSort{
  public static void main(String[] args){
    // gather the data from user
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a length for the list of the words: ");
    int param1 = scan.nextInt();
    System.out.print("Enter a position in the list: ");
    int param2 = scan.nextInt();
    // use data to create array with a series of strings also from user input
    String[] array = new String[param1];
    scan.nextLine();
    System.out.println("Enter the words seperated by enter: ");
    for (int i=0; i<array.length; i++){
      String input = scan.nextLine();
      array[i] = input;
    }
    scan.close();
    // end of user input
    for (String w : array){
      System.out.print(w+" ");
    }
    // start of sorting
    final long startTime = System.currentTimeMillis();
    String[] newArray = bubbleSort(array);
    System.out.println();
    for (String n : array){
      System.out.print(n+" ");
    }
    System.out.println();
    System.out.println(newArray[param2-1]); // param2 here
    System.out.println
    ("Execution time: "+((System.currentTimeMillis() - startTime) * 0.001));
  }

  public static String[] bubbleSort(String[] array){
    for (int j=0; j<array.length; j++){
      int i = 0;
      while (i < array.length-1){
        if (array[i].length() > array[i+1].length()){
          String temp = array[i+1];
          array[i+1] = array[i];
          array[i] = temp;
        }
        /* condition to test for two words being equal, rearranging in reverse
        alphabetical order if true*/
        else if (array[i].length() == array[i+1].length()){
          int l = 0;
          while (l<array[i].length()){
            if (array[i].charAt(l) == array[i+1].charAt(l)){
              l++;
            }
            else if (array[i].charAt(l) < array[i+1].charAt(l)){
              String temp = array[i+1];
              array[i+1] = array[i];
              array[i] = temp;
              break;
            }
            else{
              break;
            }
          }
        }
        i++;
      }
    }
    return array;
  }

  public static String[] selectionSort(String[] array){
    int pointer = 0;
    int indexLowestValue = 0;
      while (pointer < array.length){
        int lowestValue = array[pointer].length();
        for (int i=pointer; i<array.length; i++){
          if (array[i].length() <= lowestValue){
            lowestValue = array[i].length();
            indexLowestValue = i;
        }
      }
      String temp = array[pointer];
      array[pointer] = array[indexLowestValue];
      array[indexLowestValue] = temp;
      pointer++;
      }
      return array;
  }

  public static void insertionSort(String[] array){
    // pass
  }

  public static String[] randomStringArray(int length){
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String[] outArray = new String[length];
    Random r = new Random();
    int e = 0;
    while (e < length){
      int wordLength = ThreadLocalRandom.current().nextInt(2, 11);
      String word = "";
      for (int i=0; i<wordLength; i++){
        int index = r.nextInt(alphabet.length());
        word += alphabet.charAt(index);
      }
      outArray[e] = word;
      word = "";
      e++;
    }
    return outArray;
  }
}
