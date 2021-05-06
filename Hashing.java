// import java.util.*;
// import java.math.*;
import java.math.BigInteger;
// import java.lang.Object.*;

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
    }
    else {
      total++; // increment for collisions
      return false;
    }
  }

  public int getTotal(){
    return total;
  }

}


class Hashing{ // Solution
  public static void main(String[] args) {

    String[] a = {"hello", "hello", "hello"};
    String[] hArray = fill(100_000, a);

    HashTable HT = new HashTable( hArray );

    int s = 100_000;
    find( s, HT, "cheese" );
  } // end main

  public static void find(int size, HashTable mytable, String word){


      int total = 0;
      int moddy = size; // same as hashTable size

      for (int i=0; i<word.length(); i++){
        char letter = word.charAt(i);
        // letter value as big int
        BigInteger letter1 =
        new BigInteger(String.valueOf(getLetterValue(letter)));
        // power product as big int
        BigInteger powerProduct =
        new BigInteger(String.valueOf( (long) Math.pow( 27, i ) ));

        // multiply letter value by power product
        BigInteger a = letter1.multiply(powerProduct); // (value, power)

        total += a.intValue();
      } // end inner loop

      int hashIndex = (int) (total % moddy);

      

      }



  public static String[] fill(int size, String[] array){

    String[] hashTable = new String[size]; // create the table

    // HashTable HT = new HashTable(ourHashArray);
    // String[] ht = HT.hashTable

    for (int j=0; j<array.length ; j++ ) {

      String input = array[j];

      int total = 0;
      int moddy = size; // same as hashTable size

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
      } // end inner loop

      int hashIndex = (int) (total % moddy);

      // linear probe
      if ( hashTable[hashIndex] != null ){
        while ( hashTable[hashIndex] != null ){
          ++hashIndex;
        } // exits when index matches slot that is null
        hashTable[hashIndex] = input;
      }
      else{
        hashTable[hashIndex] = input;
      }
      int c = 0;
      while ( c<hashTable.length ) {
        if ( hashTable[c] == null ){
          hashTable[c] = "";
          c++;
        } else c++;
      }



  }
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
// for(int i=0; i<size; i++){
//
//   if(mytable.check(i, word)){
