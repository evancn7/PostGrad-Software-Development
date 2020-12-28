/*
In this problem, you will be given a multiple lists of numbers. You must remove any
multiples of three from each list of numbers and then sort the sublists by the number
of elements remaining within them, with the sublists containing the most items
coming first
4
1 2 3 4 5 6
2 3 3 4 6 6
3 3 3 6 6 6
1 2 4 5 7 8
-----------
[1, 2, 4, 5, 7, 8]
[1, 2, 4, 5]
[2, 4]
[]
*/
import java.util.Scanner;
import java.util.Arrays;

public class Lab10{
  public static void main(String[] args){
    final long startTime = System.currentTimeMillis();
    String input = "4\n1 2 3 4 5 6\n2 3 3 4 6 6\n3 3 3 6 6 6\n1 2 4 5 7 8";
    Scanner scan = new Scanner(input);
    int n = scan.nextInt();
    scan.nextLine();
    // an array of arrays
    String[][] container = new String[n][n];
    for (int i=0; i<n; i++){
      // scan user input and split the values into an array
      String a = scan.nextLine();
      String[] array = a.split(" ");
      // choose numbers that aren't multiples of 3 and add to modArray
      String[] modArray = new String[array.length];
      int pos = 0;
      for (int j=0; j<array.length; j++){
        if (Integer.parseInt(array[j]) % 3 != 0){
          modArray[pos] = array[j];
          pos++;
        }
      }
      // remove null values created in previous code block
      int len = pos + 1;
      String[] cleanArray = new String[len-1];
      for (int k=0; k<len-1; k++){
        if (modArray[k] != null) cleanArray[k] = modArray[k];
      }
      container[i] = cleanArray;
    }
    // run sort algorithm on length
    String[][] sortedContainer = bubbleSort(container); // flag
    // for each to print container
    for (String[] S : sortedContainer){
          System.out.println(Arrays.toString(S));
    }
    final long endTime = System.currentTimeMillis();
    System.out.println("Execution time: "+((endTime - startTime) * 0.001));
  }
  // implementation of the bubble sort algorithm
  public static String[][] bubbleSort(String[][] array){
    for (int j=0; j<array.length; j++){
      int i = 0;
      while (i < array.length-1){
        if (array[i].length < array[i+1].length){
          String[] temp = array[i+1]; // flag
          array[i+1] = array[i];
          array[i] = temp;
        }
        i++;
      }
    }
    return array;
  }
}
