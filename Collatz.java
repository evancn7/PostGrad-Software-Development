import java.util.Scanner;

class Collatz{
    public static void main(String[] args){

        String sampleInput = "4\n9\n3";
        Scanner scan = new Scanner(sampleInput);

        int lefter = scan.nextInt();
        int upper = scan.nextInt();
        int index = scan.nextInt();

        int[] array = new int[upper - lefter + 1];

        int arrayPos = 0; // keep track of the array postion for inserting

        while (lefter <= upper){
            int comparable = lefter;
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
            array[arrayPos] = count; // set current position to count
            arrayPos++; // move to next postion
            lefter++;
        } // end outer while


        int left = 0;
        int right = array.length - 1;

        qSort(array, left, right);

        System.out.println(array[index - 1]);
    } // end main

    static void qSort(int a[], int left, int right){
        if (left < right){
        /* pi is parting index, arr[pi] is now at right place */
            int p = part(a, left, right);

            qSort(a, left, p - 1);
            qSort(a, p + 1, right);
        }
    }

    static int part(int a[], int left, int right){
        // pivot (Element to be placed at right position)
        int pivot = a[right];

        int i = (left - 1);  // Index of smaller element and indicates the right position of pivot found so far

        for (int j = left; j <= right- 1; j++){
            // If current element is smaller than the pivot
            if (a[j] < pivot){
                i++;    // increment index of smaller element

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i+1];
        a[i+1] = a[right];
        a[right] = temp;

        return (i + 1);
    }
}
