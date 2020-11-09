/* input is two integers, first integer represents the length of the array, the
second integer represents a position in the array. This input is followed by a
series of strings. The output is the string at position of second integer*/

import java.util.Scanner;
public class StringSort{
  public static void main(String[] args){
    // gather the data from user
    Scanner scan = new Scanner(System.in);
    int param1 = scan.nextInt();
    int param2 = scan.nextInt();
    // use data to create array with a series of strings also from user input
    String[] array = new String[param1];
    scan.nextLine();
    for (int i=0; i<array.length; i++){
      String input = scan.nextLine();
      array[i] = input;
    }
    scan.close();
    // end of user input

    // start of bubbleSort
    final long startTime = System.currentTimeMillis();
    String[] newArray = bubbleSort(array);
    System.out.println("Execution time: "+((System.currentTimeMillis() - startTime) * 0.001));
    for (String word : newArray){
      System.out.println(word);
    }
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
        i++;
      }
    }
    return array;
  }

  public static void selectionSort(String[] array){
    // pass
  }
  public static void insertionSort(String[] array){
    // pass
  }
}
