import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.lang.Object.*;

public class Hashing {
  public static void main(String[] args) {
    // System.out.println(Long.MAX_VALUE); // 9.223.372.036.854.775.807

    // BigInteger phase2 = phase1.multiply(c2);
    // BigInteger phase3 = phase2.mod(p);

    String input = "cats";

    int total = 0;
    int moddy = 100_000;
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

      total += a.intValue();
    }
    long res = total % moddy;
    System.out.println( res );
  }// End of void main


  static int getLetterValue(char toFind){
    String alpha = "abcdefghijklmonpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int pointer = 0;
    while (true){
      if ( alpha.charAt(pointer) == toFind ) {
        return pointer + 1;
      } else {
        pointer++;
      }
    }
  }//End of letter value


}//End of class

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


class Solution{

  public int find(int size, HashTable mytable, String word){


  }
  public String [] fill(int size, String[] array){

  String[] hashTable = new String[size];
  //loop in here
  return hashTable;
}


}
