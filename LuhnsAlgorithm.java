/*
Luhn's algorithm to validate credit card numbers
*/
import java.util.Scanner;

public class LuhnsAlgorithm{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Please enter the card number: ");
    long userInput = scan.nextLong();scan.close();
    System.out.println(luhnCheck(userInput));
  }
  public static String luhnCheck(long number){
    int sum = 0;
    int count = 0;
    long digit;
    // assume that the card number is invalid to begin
    String message = new String("The card number is INVALID");
    // iterate through the number when you run out of number than number<0
    while (number>0){
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
    if (sum%10==0){
      message = "The card number is VALID";
    }
    return message;
  }
}
