import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        int number = Integer.parseInt(value);
        // int number = 1_440_085_377;
        String sequence = scan.nextLine();
        // String sequence = "4321";
        scan.close();

        int f1 = Integer.parseUnsignedInt("11111111000000000000000000000000", 2);
        int f2 = Integer.parseInt("00000000111111110000000000000000", 2);
        int f3 = Integer.parseInt("00000000000000001111111100000000", 2);
        int f4 = Integer.parseInt("00000000000000000000000011111111", 2);

        int[] byteArray = new int[] { (number & f1), (number & f2), (number & f3), (number & f4) };

        int acc = 0;
        for ( int i = 0; i < byteArray.length; i++ ){
            int ind = findIndex( sequence, i + 1 );
            if ( ind > (i) ) acc += byteArray[i] >> ( ( ind - i ) * 8 );
            if ( ind < (i) ) acc += byteArray[i] << ( ( i - ind ) * 8 );
            else acc += byteArray[i];
        }
        System.out.println( acc );
    }
    static int findIndex(String s, int toFind){
        int i = 0;
        while ( true ){
            char ch = s.charAt(i);
            if ( Character.getNumericValue(ch) == toFind ) break;
            else i++;
        }
        return i;
    }
}
