import java.util.*;
public class Sorting{
  public static void main(String[] args){
    Random r = new Random();
    int[] array = new int[5];
    for (int i=0; i<array.length; i++){
      array[i] = r.nextInt(100);
    }

    for (int i: array){
      System.out.print(i+" ");
    }
    System.out.println();
    int[] newArray = selectionSort(array);

    for (int i: newArray){
      System.out.print(i+" ");
    }
    System.out.println();
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
    int pointer = 0;
    int indexLowestValue = 0;
      while (pointer < array.length){
        int lowestValue = array[pointer];
        for (int i=pointer; i<array.length; i++){
          if (array[i] <= lowestValue){
            lowestValue = array[i];
            indexLowestValue = i;
        }
      }
      int temp = array[pointer];
      array[pointer] = array[indexLowestValue];
      array[indexLowestValue] = temp;
      pointer++;
      }
      return array;
    }
}
