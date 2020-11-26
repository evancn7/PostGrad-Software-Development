class Queue{
  // Queue class to create a queue of Strings
  // initialize the variables for the queue creation
  private int maxSize;
  private String[] qArray;
  private int front;
  private int back;
  private int nItems;

  //general constructor
  public Queue(int s){
    maxSize = s;
    qArray = new String[maxSize];
    front = 0;
    back = -1;
    nItems = 0;
  }
  public boolean insert(String s){
    if (isFull()){
      return false;
    }
    if (back == maxSize-1){
      back = -1;
    }
    back++;
    nItems++;
    qArray[back] = s;
    return true;
  }
  public String remove(){
    if (isEmpty()){
      return "empty";
    }
    String removed = qArray[front];
    if (front == maxSize-1){
      front = 0;
    }
    front++;
    nItems--;
    return removed;
  }
  public String peekFront(){
    if (isEmpty()){
      return "Empty";
    }
    return qArray[front];
  }
  public boolean isFull(){
    return nItems == maxSize;
  }
  public boolean isEmpty(){
    return nItems == 0;
  }
  public int size(){
    return nItems;
  }
}
