/* Problem Statement
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime. Given an input threshold x, output how many circular primes there are below that threshold.
*/

import java.util.Scanner;
import java.util.ArrayList;

class CircularPrime {
  public static void main(String[] args) {
    Scanner scan = new Scanner("40000");
    int threshold = scan.nextInt();
    scan.close();
    int count = 0;
    long startTime = System.currentTimeMillis();
    for (int i = 0; i <= threshold; i++) {
      if (checkPrime(i)) {
        if (checkCircularPrime(getPermutations(Integer.toString(i)))) count++;
      }
    }
    System.out.println(count);
    long endTime = System.currentTimeMillis();
    double duration = ((endTime - startTime) * 0.001);
    System.out.println("Run time was " + duration);
  }
  static ArrayList<String> getPermutations(String number) {
    ArrayList<String> toReturn = new ArrayList<String>();
    String result = number;
    do {
      String a = result.substring(0, 1);
      String b = result.substring(1);
      result = b + a;
      toReturn.add(result);
    } while (number.compareTo(result) != 0);
    return toReturn;
  }
  static boolean checkPrime(int n) {
    int divisor = 3;
    boolean flag = false;
    if ( n < 2 ) return false;
    do {
      if (n % divisor == 0) flag = true;
      divisor++;
    } while (divisor <= (n / 2));
    if (flag) return false;
    else return true;
  }
  static boolean checkCircularPrime(ArrayList<String> permutations) {
    for (String permutation : permutations) {
      int arg = Integer.parseInt( permutation );
      if (checkPrime( arg ) == false) return false;
    }
    return true;
  }
}
