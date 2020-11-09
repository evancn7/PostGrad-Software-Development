import java.util.Random;
import java.lang.Math;

public class MonteCarloCoPrime{

  public static void main(String[] args){
    final long startTime = System.currentTimeMillis();
    monteCarloLoop(3, 11, 10000);
    final long endTime = System.currentTimeMillis();
    System.out.println("Execution time: "+((endTime - startTime) * 0.001));
  }

  public static boolean isCoPrime(int a, int b){
    // the greatest common divisor must be 1 to return true
    boolean flag = true; // assume true
    int limit = Math.min(a, b);
    // 1 is always a common denominator so start i=2 and stop at lower divisor
    for (int i=2; i<=limit; i++){
      // if anything above i divides in then flag is flipped to false
      if (a % i == 0 && b % i == 0){
        flag = false; // false otherwise
      }
    }
    return flag;
  }

  public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

  public static void monteCarloLoop(int divisor1, int divisor2, int numTrials){
    // set variable so a test for probability is possible
    double trueCases = 0;
    double prob = 0;
    // create a random object to be used to generate candidates in loop
    Random r = new Random();
    for (int i=0; i<numTrials; i++){
      // generate a random number using divisors
      int candidate1 = divisor1 * r.nextInt(numTrials);
      int candidate2 = divisor2 * r.nextInt(numTrials);
      if (gcd(candidate1, candidate2) == 1){
        trueCases++;
    }
    prob = (double)trueCases/numTrials;
    // return the result of true cases probability
  }
  System.out.println(Math.round(prob*100));
}
}
