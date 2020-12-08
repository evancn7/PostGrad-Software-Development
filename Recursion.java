class Recursion{
  public static void main(String[] args){
    System.out.println(tribonacci(30));
    System.out.println(recursiveDivision(1000, 17, 4));
  }
  public static int tribonacci(int n){
    if (n < 2) return 0;
    if (n == 2) return 1;
    else return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
  }
  public static int recursiveDivision(int number, int divisor, int nth){
    if (nth == 0) return number / divisor;
    else {
      return recursiveDivision(number%divisor*10, divisor, --nth);
    }
  }
}

/*
1000 % 13 = 12
12 * 10 = 120 number = 120
120 / 13 = 9 <

120 % 13 = 3
3 * 10 = 30
30 / 13 = 2 <

30 % 13 = 4
4 * 10 = 40
40 / 13 = 3 <

base case
if nth == 0 return number / divisor
*/
