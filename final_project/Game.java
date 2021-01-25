import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;

class Game {
  public static void main(String[] args){
    userInterface();
  }

  public static void userInterface(){
    Scanner user = new Scanner(System.in);
    String response;
    Queue results = new Queue(100); // high number to ensure max not reached

    // opening messages to the user
    System.out.println("Welcome to the game!");
    System.out.println("Your choices are rock, paper or scissors....");

    /* play the game while the value stored in response is "y", but play
    at least once */
    do{
    // gather user choice
    System.out.print("Please make your choice: ");
    String userChoice = user.next().toLowerCase();

    // verify the users input
    while (!verifyInput(userChoice)){
      System.out.print("Invalid! Try again: ");
      userChoice = user.next().toLowerCase();
    }

    // gather system choice
    String systemChoice = systemChoice();
    delay(1);
    System.out.println("I chose"+" "+systemChoice);

    // compare userChoice and systemChoice and print the result
    String result = resultHandler(userChoice, systemChoice);
    delay(1);
    System.out.println("Result: "+result);

    // create a result object and add to queue for safe keeping
    Result r = new Result(userChoice, systemChoice, result);
    results.insert(r);

    // ask user for another game
    System.out.println("Do you want to play again? (Y/N): ");
    response = user.next().toLowerCase();
    }
    while (response.compareTo("y") == 0);

    user.close();

    // print the results for the user
    showResults(results);
  }

  public static String systemChoice(){
    // generate a random number to choose from array
    Random r = new Random();
    String[] choices = Data.choices;
    // choose a random number between 0 and the array length (3)
    int n = r.nextInt(choices.length);
    // use random number as index for choices and return the value
    return choices[n];
  }

  public static String resultHandler(String userChoice, String systemChoice){
    /* 3 states that userChoice can be in, depending on state result is
    determined */
    String outcome = "";
    if (userChoice.compareTo("rock") == 0){
      if (systemChoice.compareTo("rock") == 0) outcome = "It's a tie";
      if (systemChoice.compareTo("paper") == 0) outcome = "You lose";
      if (systemChoice.compareTo("scissors") == 0) outcome = "You win";
    }
    if (userChoice.compareTo("paper") == 0){
      if (systemChoice.compareTo("rock") == 0) outcome = "You win";
      if (systemChoice.compareTo("paper") == 0) outcome = "It's a tie";
      if (systemChoice.compareTo("scissors") == 0) outcome = "You lose";
    }
    if (userChoice.compareTo("scissors") == 0){
      if (systemChoice.compareTo("rock") == 0) outcome = "You lose";
      if (systemChoice.compareTo("paper") == 0) outcome = "You win";
      if (systemChoice.compareTo("scissors") == 0) outcome = "It's a tie";
    }
    return outcome;
  }

  public static boolean verifyInput(String input){
    String[] validInputs = Data.choices;
    // assuming input is incorrect until verified
    // verfication is matching the input with any value in validInputs
    boolean flag = false;
    for (int i=0; i<validInputs.length; i++){
      if (input.compareTo(validInputs[i]) == 0) flag = true;
    }
    return flag;
  }

  public static void delay(int t){
    // method to delay the program so that it plays more like a game
    try {
			TimeUnit.SECONDS.sleep(t);
		} catch (Exception e){
			e.printStackTrace();
		}
  }

  public static void showResults(Queue results){
    System.out.println();
    System.out.println("Results");
    System.out.println("-----------------------------------------------");
    System.out.println("You\t|\tOpponent\t|\tResult");
    System.out.println("-----------------------------------------------");
    // using the queue passed as a parameter
    // print all results to screen until the queue is not empty
    while (!results.isEmpty()) System.out.println(results.remove());
    System.out.println();
  }
}

class Data{
  public static String[] choices = {"rock", "paper", "scissors"};
}

class Result{
  String user;
  String opponent;
  String result;

  // general constructor
  public Result(String user, String opponent, String result){
    // declare the attributes that form the result information
    this.user = user;
    this.opponent = opponent;
    this.result = result;
  }
  // display a result object in human readable form
  public String displayResult(){
    return this.user+"\t|\t"+this.opponent+"\t|\t"+this.result;
  }
}

class Queue{
  // Queue class to create a queue of Results
  // initialize the variables for the queue creation
  private int maxSize;
  private Result[] qArray;
  private int front;
  private int back;
  private int nItems;

  //general constructor
  public Queue(int s){
    maxSize = s;
    qArray = new Result[maxSize];
    front = 0;
    back = -1;
    nItems = 0;
  }
  public boolean insert(Result s){
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
    Result removed = qArray[front];
    if (front == maxSize-1){
      front = 0;
    }
    front++;
    nItems--;
    return removed.displayResult();
  }
  public boolean isFull(){
    return nItems == maxSize;
  }
  public boolean isEmpty(){
    return nItems == 0;
  }
}
