/**
 *  Binary tree lab
 *
 * @author     G. Peck
 * @created    July 2, 2003
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;


public class PriorityQueueMenu{
  private Scanner console;
  private PriorityQueueScratch queue;

  public PriorityQueueMenu(){
    console = new Scanner(System.in);
    queue = new PriorityQueueScratch<>();
  }

  public void remove(){
    try
    {
      System.out.println("Item at top removed: " + queue.remove());
    }
    catch (NoSuchElementException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public void peek(){
    if (queue.isEmpty())
      System.out.println("Priority Queue is empty\n");
    else
      System.out.println("Item at top peeked: " + queue.peek());
  }

  public void readData (){
    Scanner inFile;

    String fileName = "file20.txt";
    int id, inv;
    try{
      inFile = new Scanner(new File(fileName));
      while(inFile.hasNext()){
        id = inFile.nextInt();
        inv = inFile.nextInt();
        queue.add(new Item(id, inv));
      }
    }catch(IOException i){
      System.out.println("Error: "+ i.getMessage());
    }
  }

  public void addItem()
  {
    boolean run = true;

    Scanner keyboard = new Scanner(System.in);

    while (run)
    {
      System.out.print("\nId of item to add: ");
      int id = keyboard.nextInt();
      System.out.print("Inventory of item to add: ");
      int inv = keyboard.nextInt();
      Item it = new Item(id, inv);
      keyboard.nextLine(); //flush newline
      queue.add(it);
      System.out.println("Item added\n");
      System.out.print("Continue (Y/N): ");
      String answer = keyboard.nextLine();
      run = answer.equalsIgnoreCase("Y");
    }
  }

  public void mainMenu (){
    String choice;
    do{
      System.out.println("Priority Queue Menu\n");
      System.out.println("(1) Read data from disk");
      System.out.println("(2) Add to heap");
      System.out.println("(3) isEmpty");
      System.out.println("(4) Peek");
      System.out.println("(5) Remove");
      System.out.println("(Q) Quit\n");
      System.out.print("Choice ---> ");
      choice = console.nextLine() + " ";
      System.out.println();

      if ('1' <= choice.charAt(0) && choice.charAt(0) <= '5'){
        switch (choice.charAt(0)){
          case '1' :
            readData();
            break;
          case '2' :
            addItem();
            break;
          case '3' :
            System.out.println(queue.isEmpty()
                    ? "Queue is empty\n"
                    : "Queue is not empty\n");
            break;
          case '4' :
            peek();
            break;
          case '5' :
            remove();
            break;
          case '6' :
            queue.printInRows();
            break;
        }
      }
    }
    while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
  }

}