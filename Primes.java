/* The task is to take two integers that specify a range and output the quantity
of prime numbers that exist in that range, inclusive of the specified boundaries.
For example, the quantity of prime numbers that exist between 7 and 19 is 5
(namely 7, 11, 13, 17 and 19)*/
import java.util.Scanner;
public class Primes {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        final long startTime = System.currentTimeMillis();
        Scanner scan = new Scanner(System.in);
        int lower = scan.nextInt();
        int upper = scan.nextInt();
        // swap the values if upper bound is entered first
        if (lower > upper){
            int temp;
            temp = lower;
            lower = upper;
            upper = temp;
        }
        // declare array with the boundaries
        int[] array = new int[upper-lower+1];
        int pos = 0;
        // fill array with values between the bounsaries skipping even numbers
        for (int i=lower; i<=upper; i++){
            if (i > 3 && i % 2 == 0){
                continue;
            }
            else{
                array[pos] = i;
                pos++;
            }
        }
        numPrimes(array);
        final long endTime = System.currentTimeMillis();
        System.out.println("Execution time: "+(endTime - startTime));
    }
    public static void numPrimes(int[] array){
        int count=0;
        for (int i=0;i<=array.length-1;i++){
            if (array[i]>1 && array[i]<=3){
                count++;
            }
            else if(array[i]>3){
                int limiter=array[i]/2;
                boolean flag=true;
                for (int j=2;j<=limiter;j++){
                    if (array[i]%j==0){
                        flag=false;
                    }
                }
                if (flag){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
