public class Stack {
      // initialize the variables for the stack creation
      private int maxSize;
      private int[] stackArray;
      private int top;

      // general constructor
      public Stack(int s){
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
      }
      // push method to add items to top of stackArray
      public void push(int item){
        top++;
        stackArray[top] = item;
      }
      // pop method to extract items from top of stackArray
      public int pop(){
        return stackArray[top--];
      }
      // method to peek at what is at the top of the stackArray
      public int peek(){
        return stackArray[top];
      }
      // method to check position of top
      public int getTop(){
        return this.top;
      }
      // method to check if stackArray is empty
      public boolean isEmpty(){
        return top == -1;
      }
      // method to check if stackArray is full
      public boolean isFull(){
        return top == maxSize-1;
      }
      // method to empty the stackArray
      public void makeEmpty(){
        top = -1;
      }
}
