import java.util.Scanner;

public class LeaningTowerOfCoins{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    double radius = scan.nextDouble();
    double thickness = scan.nextDouble();
    double targetDistance = scan.nextDouble();
    System.out.println(coinCalculation(radius, thickness, targetDistance));
  }
  public static long coinCalculation(double radius, double thickness, double targetDistance){
    // 1 / 2n
    int coins = 0;
    int n = 1;
    double limit = 0;
    while (limit < targetDistance){
      limit += (radius*2) * 1 / (2*n);
      n++;
      coins++;
    }
    return (long)(coins * thickness);
  }
}
