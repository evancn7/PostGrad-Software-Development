import java.util.*;
public class Sorting{
  public static void main(String[] args){
    Random r = new Random();
    int[] array = new int[10];
    for (int i=0; i<array.length; i++){
      array[i] = r.nextInt(100);
    }

    for (int i: array){
      System.out.print(i+", ");
    }
    System.out.println();
    int[] newArray = selectionSort(array);

    for (int i: newArray){
      System.out.print(i+", ");
    }
  }

  // implementation of the bubble sort algorithm
  public static int[] bubbleSort(int[] array){
    for (int j=0; j<array.length; j++){
      int i = 0;
      while (i < array.length-1){
        if (array[i] > array[i+1]){
          int temp = array[i+1];
          array[i+1] = array[i];
          array[i] = temp;
        }
        i++;
      }
    }
    return array;
  }

  // implementation of the selectionSort algorithm
  public static int[] selectionSort(int[] array){
    for (int j=1; j<array.length; j++){
      int lowestValue = array[j-1];
      int position = 0;
      for (int i=j; i<array.length; i++){
        if (array[i] < lowestValue){
          lowestValue = array[i];
          position = i;
          }
        }
        System.out.println("lowest value = "+lowestValue);
        System.out.println("@ position: "+position);
        // swap values
        int temp = array[position];
        array[position] = array[j-1];
        array[j-1] = temp;
      }
      return array;
    }
}
