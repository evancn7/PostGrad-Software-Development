import java.util.Scanner;

class Collatz{
    public static void main(String[] args){

        String sampleInput = "4\n9\n3";
        Scanner scan = new Scanner(sampleInput);

        int lower = scan.nextInt();
        int upper = scan.nextInt();
        int index = scan.nextInt();

        Array array = new Array(lower, upper, index);

        array.getCollatzArray();


        int left = 0;
        int right = array.array.length - 1;

        array.recQuickSort(left, right);


        for (int n : array.array) System.out.println(n);

    } // end main
}

class Array{
    int[] array;
    int lower;
    int upper;
    int index;

    Array(int lower, int upper, int index){
        this.lower = lower;
        this.upper = upper;
        this.index = index;
        array = new int[upper - lower + 1];
    }

    void getCollatzArray(){
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
            array[arrayPos] = count; // set current position to count
            arrayPos++; // move to next postion
            lower++;
        } // end outer while
    }
    int createPart(int left, int right, long pivot){
        int leftPart = left - 1;
        int rightPart = right;

        while (true){
            while (array[++leftPart] < pivot){}
            while (rightPart > 0 && array[--rightPart] > pivot){}

            if (leftPart >= rightPart){
                break;
            }
            else{
                int temp = array[leftPart];
                array[leftPart] = array[rightPart];
                array[rightPart] = temp;
            }
        }
        int temp = array[leftPart];
        array[leftPart] = array[rightPart];
        array[rightPart] = temp;
        return leftPart;
    }
    void recQuickSort(int left, int right){
        if (right - left <= 0){
            return;
        }
        else{
            long pivot = array[right];

            int part = createPart(left, right, pivot);
            recQuickSort(left, part - 1);
            recQuickSort(part + 1, right);
        }
    }
}
