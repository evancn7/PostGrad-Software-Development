import java.util.Scanner;
public class StackMain {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    // take user input for the length of the stack
    int stackLength = scan.nextInt();

    // create userStack from user parameter stackLength
    Stack userStack = new Stack(stackLength);

    // clear buffer
    scan.nextLine();

    // create loop for taking in commands from user
    for (int i=0; i<stackLength; i++){
      String command = scan.nextLine();
      String[] commandParts = command.split(" ");
      String method = commandParts[0].toLowerCase();

      // once command is entered then execute the command on the stack
      if (method.compareTo("push") == 0){
        userStack.push(Integer.parseInt(commandParts[1]));
      }
      else if (method.compareTo("pop") == 0 && !userStack.isEmpty()){
        userStack.pop();
      }
    }
  }
}
