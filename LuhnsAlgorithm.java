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
    if (luhnCheck(userInput)){
      System.out.println("VALID");
    }
    else{
      System.out.println("INVALID");
    }

  }
  public static boolean luhnCheck(long number)
  {
    int sum = 0;
    int count = 0;
    long digit;
    while (number>0)
    {
      if (count%2==0){
        digit = number % 10;
      }
      else{
        digit = (number % 10) * 2;
      }
      if (digit > 9){
        digit = digit - 9;
      }
      sum += digit;
      count++;
      number = number / 10;
    }
    return sum%10==0;
  }
}
