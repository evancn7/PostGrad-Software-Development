import java.util.Scanner;
import java.math.BigInteger;

class ElGamal {
    public static void main(String[] args) {

        // "150001 7 66436\n90429 57422"
        // "24852977 2744 8414508\n15268076 743675"
        // Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner("24852977 2744 8414508\n15268076 743675");

        String alice = scan.nextLine();
        String bob = scan.nextLine();

        scan.close();

        String[] aliceArray = alice.split(" ");
        String[] bobArray = bob.split(" ");

        // return an int which is the key
        int key = bruteForceSearch(aliceArray[1], aliceArray[0], aliceArray[2]);

        String message = decryptMessage(bobArray[0], bobArray[1], aliceArray[0], key);

        System.out.println(message);
    }

    static String decryptMessage(String num1, String num2, String mod, int key) { // c1, c2, p, key
        // c2 / c1x => m.g^xy / g^xy

        BigInteger c1 = new BigInteger(num1);
        BigInteger c2 = new BigInteger(num2);
        BigInteger p = new BigInteger(mod);

        // c1 ^ p-x-1

        BigInteger phase1 = c1.pow((Integer.parseInt(mod)) - key - 1);
        BigInteger phase2 = phase1.multiply(c2);
        BigInteger phase3 = phase2.mod(p);

        String res = phase3.intValue() + "";
        return res;
    }

    static int bruteForceSearch(String generator, String modulus, String prod) {
        int i = 0;

        // alice = 7 ^ x % 150001 = 66436

        BigInteger g = new BigInteger(generator);
        BigInteger p = new BigInteger(modulus);
        BigInteger product = new BigInteger(prod);

        while (true) {

            BigInteger x = new BigInteger(Integer.toString(i));

            BigInteger test = (g.modPow(x, p));
            if (test.intValue() == product.intValue())
                break;
            else
                i++;
        }
        return i;
    }
}
