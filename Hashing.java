import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.lang.Object.*;

class HashTable{

  private String[] hashTable;
  private int total = 0;

  // arg constructor
  public HashTable(String[] input){
    hashTable = input;
  }

  public boolean check(int slot, String check){
    // check for collision
    if (hashTable[ slot ].equals(check)){
      return true;
    } else {
      total++; // increment for collisions
      return false;
    }
  }

}


class Hashing{

  public static void main(String[] args) {
    // System.out.println(Long.MAX_VALUE); // 9.223.372.036.854.775.807
    // BigInteger phase3 = phase2.mod(p);

    String[] a = {"cat", "hello"};

    String[] ourHashArray = Solution.fill(100_000, a);

    HashTable HT = new HashTable(ourHashArray);

    boolean bool = HT.check( 14610, "cat" );
    
    System.out.println(bool);
  } // end main

  public int find(int size, HashTable mytable, String word){
    return 1;
  }

  static String [] fill(int size, String[] array){

    String[] hashTable = new String[size]; // create the table

    for (int j=0; j<array.length ; j++ ) {

      String input = array[j]; //cat

      int total = 0;
      int moddy = size; // hashTable size

      for (int i=0; i<input.length(); i++){
        char letter = input.charAt(i);
        // letter value as big int
        BigInteger letter1 =
        new BigInteger(String.valueOf(getLetterValue(letter)));
        // power product as big int
        BigInteger powerProduct =
        new BigInteger(String.valueOf( (long) Math.pow( 27, i ) ));

        // multiply letter value by power product
        BigInteger a = letter1.multiply(powerProduct); // (value, power)
        // int letterHash =

        total += a.intValue();
      } // end inner loop

      int hashIndex = (int) (total % moddy);

      System.out.println(hashIndex);
      // if ( hashTable[hashIndex] != null {} )
      hashTable[hashIndex] = input;
    } // end outer loop
    return hashTable;
  }

  static int getLetterValue(char toFind){
    String alpha = "abcdefghijklmonpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int pointer = 0;
    while (true){
      if ( alpha.charAt(pointer ) == toFind ) {
        return pointer + 1; // plus one to match letter to number as normal
      } else {
        pointer++;
      }
    }
  } // end letter value

}
