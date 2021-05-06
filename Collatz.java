import java.util.Scanner;

class Collatz{
    public static void main(String[] args){

        String sampleInput = "45\n55\n3";
        Scanner scan = new Scanner(sampleInput);

        int lower = scan.nextInt();
        int upper = scan.nextInt();
        // int index = scan.nextInt();
        scan.close();

        C[] array = new C[upper - lower + 1];
        int arrayPos = 0; // keep track of the array postion for inserting

        while (lower <= upper){
            int comparable = lower;
            int count = 0;
            // comparable is changing in this loop
            while (comparable != 1){
                if (comparable % 2 == 0){ // if it's even
                    comparable = comparable / 2; // divide by 2
                    count++; // one more step is added
                }
                else{ // if it's odd
                    comparable = comparable * 3 + 1;
                    count++; // one more step is added
                }
            } // end inner while

            C c = new C(lower, count);
            array[arrayPos] = c;
            arrayPos++; // move to next postion
            lower++;
        } // end outer while

        int left = 0;
        int right = array.length - 1;

        qSort(array, left, right);
        bubbleSort(array);

        for (C n : array) System.out.println(n);

        // System.out.println(array[index - 1]);
    } // end main

    static void qSort(C a[], int left, int right){
        if (left < right){
            int p = part(a, left, right);

            qSort(a, left, p - 1);
            qSort(a, p + 1, right);
        }
    }

    static int part(C a[], int left, int right){
        int pivot = a[right].count;
        int i = (left - 1);
        for (int j = left; j <= right - 1; j++){
            // If current element is smaller than the pivot
            if (a[j].count < pivot){
                i++;    // increment index of smaller element
                C temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        C temp = a[i+1];
        a[i+1] = a[right];
        a[right] = temp;
        return (i + 1);
    }
    public static C[] bubbleSort(C[] array){
        for (int j=0; j<array.length; j++){
            int i = 0;
            while (i < array.length-1){
                if (array[i].count  == array[i+1].count){
                    if (array[i].number > array[i+1].number){
                        C temp = array[i+1];
                        array[i+1] = array[i];
                        array[i] = temp;
                    }
                }
                i++;
            }
        }
        return array;
    }
}
class C{
    public int number;
    public int count;

    C(int n, int c){
        number = n;
        count = c;
    }
    public String toString(){
        return "n: "+number+" c: "+count;
    }
}
