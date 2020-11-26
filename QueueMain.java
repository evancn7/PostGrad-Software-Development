// Manipulate a queue according to the given insert and remove commands and
// then output the string that is in the middle of the queue. If there is an even
// number of strings in the queue, thus two middle strings, output the one which
// is nearest the front. If a remove command is issued for an empty queue then
// nothing should happen.
import java.util.Scanner;

public class QueueMain{
  public static void main(String[] args){
    // set up for input, scanner and queue
    String s = "INSERT this\nINSERT is\nINSERT how\nINSERT to\nREMOVE\nINSERT do\nREMOVE\nINSERT it";
    Scanner scan = new Scanner(s);
    Queue myQ = new Queue(20);

    // while the queue has next line, as amount of commands is not defined
    while (scan.hasNextLine()){
      String command = scan.nextLine();
      String[] commandSplit = command.split(" ");
      // convert command to lower case for comparison
      String method = commandSplit[0].toLowerCase();
      // once command is entered then execute the command on the queue
      // once determined that command is insert then take 2nd part of command
      if (method.compareTo("insert") == 0) myQ.insert(commandSplit[1]);
      else myQ.remove();
    }

    // close resource
    scan.close();

    // find the middle value, if even then find value nearest the front
    int middleItem;
    if (myQ.size() % 2 == 0) middleItem = myQ.size() / 2 - 1;
    else middleItem = myQ.size() / 2;

    // adjust middle item for current position
    middleItem = middleItem + myQ.frontPosition();
    while (myQ.frontPosition() != middleItem) myQ.remove();

    // print middle item to screen
    System.out.println(myQ.remove());
  }
}
