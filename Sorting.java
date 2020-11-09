import java.util.Random;
public class Sorting{
  public static void main(String[] args){
    Random r = new Random();
    int[] array = new int[100];
    for (int i=0; i<array.length; i++){
      array[i] = r.nextInt(1000);
    }
    bubbleSort(array);
    for (int i: array){
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
}
