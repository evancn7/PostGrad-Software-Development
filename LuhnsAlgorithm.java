/*
Luhn's algorithm to validate credit card numbers
*/
import java.util.Scanner;

public class LuhnsAlgorithm
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    long userInput = scan.nextLong();
    System.out.println(luhnCheck(userInput));
  }
  public static boolean luhnCheck(long number)
  {
    long checkSum = number % 10;
    long numberToValidate = number / 10;
    int sum = 0;
    int count = 1;
    long digit;
    while (numberToValidate>0)
    {
      if (count%2==0){
        digit = numberToValidate % 10;
      }
      else{
        digit = (numberToValidate % 10) * 2;
      }
      if (digit > 9){
        digit = digit - 9;
      }
      sum += digit;
      count++;
      numberToValidate = numberToValidate / 10;
    }
    return (sum*9)%10==checkSum;
  }
}
