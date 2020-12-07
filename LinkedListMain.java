import java.util.*;

class LinkedListMain{
  public static void main(String[] args){
    String inputString = "4\n345\n836\n853\n173\n0 -1 1\n1 0 2\n2 1 3\n3 2 -1";
    Scanner scan = new Scanner(inputString);
    int num = Integer.parseInt(scan.nextLine());
    Node[] array = new Node[num];
    for (int i=0; i<num; i++) array[i] = new Node(Integer.parseInt(scan.nextLine()));
    while (scan.hasNext()){
      int select = scan.nextInt();
      int previous = scan.nextInt();
      int next = scan.nextInt();
      if (previous != -1) array[select].previous = array[previous];
      if (next != -1) array[select].next = array[next];
    }
    LinkedList myList = new LinkedList();
    if (num>0){
      myList.head = array[0];
      myList.tail = array[num-1];
    }
    System.out.println(search(myList));
  }
  static int search(LinkedList myList){
    // check if empty and if true return 0
    if (myList.isEmpty()) return 0;
    // check if defective and if true return 0
    Node select = myList.head;
    Node previous = null;
    while (select.next != null){
      if (select.previous != previous) return 0;
      else{
        previous = select;
        select = select.next;
      }
    }

    // check for highest integer
    Node current = myList.head;
    int highest = myList.head.data;
    while (current.next != null) {
      if (current.data > highest){
        highest = current.data;
      }
      current = current.next;
    }
    return highest;
  }
}
