import java.util.Scanner;
import java.lang.Math;

class BasePalindrome{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    long number = scan.nextLong();
    scan.close();

    int total = 0;
    for (long i = 2; i <=10; i++) {
      long conv = BPUtils.baseConvertor( number, i );
      if ( BPUtils.checkPal(conv) ) total++;
    }
    System.out.println(total);
  }
}

class BPUtils{
  static long baseConvertor(long number, long base){
    long r;
    long power = 0;
    long result = 0;
    while (number > 0) {
      r = number % base;
      number = number / base;
      // post-increment power for next loop
      long factor = (long) Math.pow(10, power++);
      result += r * factor;
    }
    return result;
  }
  static boolean checkPalString(long number){
    String strNumber = Long.toString(number);
    String revNumber = "";
    while (number > 0){
      long digit = number % 10;
      number = number / 10;
      revNumber += String.valueOf( digit );
    }
    return strNumber.equals(revNumber);
  }
  static boolean checkPal(long number){
    long numberToCheck = number;
    long revNumber = 0;
    while (number > 0){
      long digit = number % 10;
      number = number / 10;
      revNumber = revNumber * 10;
      revNumber += digit;
    }
    return numberToCheck == revNumber;
  }
}
