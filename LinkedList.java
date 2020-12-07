class LinkedList{
  public Node head;
  public Node tail;

  public LinkedList(){
    head = null;
    tail = null;
  }
  public boolean isEmpty(){
    return (head == null);
  }
  public void insertHead(int data){
    Node newNode = new Node(data);
    if (isEmpty()){
      tail = newNode;
    }
    else{
      head.previous = newNode;
    }
    newNode.next = head;
    head = newNode;
  }
  public Node find(int key){
    Node current = head;
    while (key != current.data) {
      current = current.next;
    }
    return current;
  }
}
