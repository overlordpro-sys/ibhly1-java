/**
 *  Binary tree lab
 *
 * @author     G. Peck
 * @created    July 2, 2003
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class TreeStats {
  private Scanner console;

  public TreeStats(){
    console = new Scanner(System.in);
  }

  void testFind(BinarySearchTree temp){
    String toFind;

    System.out.println("Testing search algorithm\n");
    System.out.print("Enter value to search for (-1 to quit) --> ");
    toFind = console.nextLine();

    while (!toFind.equals("-1"))
    {
      Object location = temp.find(toFind);
      if (location != null)
        System.out.println(toFind + " found");
      else
        System.out.println(toFind + " not found");
      System.out.println();
      System.out.print("Enter value to search for (-1 to quit) --> ");
      toFind = console.nextLine();
    }
  }


  public void testDelete(BinarySearchTree temp){
    String toDelete;
    boolean success;

    System.out.println("Testing delete algorithm\n");
    System.out.print("Enter value to delete (-1 to quit) --> ");
    toDelete = console.nextLine();

    while (!toDelete.equals("-1"))
    {
      if (temp.find(toDelete) == null)
        System.out.println(toDelete + " not in tree");
      else{
        temp.delete(toDelete);
        System.out.println(toDelete + " was deleted");
      }
      System.out.println();
      System.out.print("Enter value to delete (-1 to quit) --> ");

      toDelete = console.nextLine();
    }
  }

  public void readData (BinarySearchTree temp){
    Scanner inFile;

    String fileName = "fileC.txt";
    try{
      inFile = new Scanner(new File(fileName));
      while(inFile.hasNext()){

        temp.insert(inFile.nextLine());
      }
    }catch(IOException i){
      System.out.println("Error: "+ i.getMessage());
    }
  }

  public void testLevel (BinarySearchTree temp)
  {
    System.out.println("Testing level algorithm\n");
    System.out.print("Enter level to search for (-1 to quit) --> ");
    int level = console.nextInt();
    while (level >= 0)
    {
      System.out.println("Level " + level + " has: ");
      temp.printLevel(level);
      System.out.println();
      System.out.print("Enter level to search for (-1 to quit) --> ");
      level = console.nextInt();
    }
  }

  public void testAncestor (BinarySearchTree temp)
  {
    boolean run = true;

    Scanner keyboard = new Scanner(System.in);

    while (run)
    {
      System.out.print("\nAncestor: ");
      String ancestor = keyboard.nextLine();

      System.out.print("\nDescendant to look for: ");
      String descendant = keyboard.nextLine();

      if (temp.isAncestor(ancestor, descendant))
      {
        System.out.println(descendant + " is a descendant of " + ancestor);
      }
      else
      {
        System.out.println(descendant + " is NOT a descendant of " + ancestor);
      }

      System.out.print("Continue (Y/N): ");
      String answer = keyboard.nextLine();
      run = answer.equalsIgnoreCase("Y");
    }
  }

  public void mainMenu (BinarySearchTree root){
    String choice;
    int choiceNum;
    do{
      System.out.println("Queue Stack Binary tree menu\n");
      System.out.println("(1) Fill the tree from a file");
      System.out.println("(2) Inorder output");
      System.out.println("(3) PrintByLevel");
      System.out.println("(Q) Quit\n");
      System.out.print("Choice ---> ");
      choice = console.nextLine();
      choiceNum = validMenuInput(choice);
      System.out.println();

      if (choiceNum != -1)
      {
        switch (choiceNum){
          case 1 :
            readData(root);
            break;
          case 2:
            System.out.println();
            System.out.println("Tree in order\n");
            System.out.println();
            root.printInorderNonrecursive();
            System.out.println("\n");
            break;
          case 3:
            System.out.println();
            root.printLevelNonrecursive();
            System.out.println("\n");
        }
      }
    }
    while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
  }

  public int validMenuInput(String input)
  {

    try
    {
      int choice = Integer.parseInt(input);
      if (choice >= 1 && choice <= 15)
        return choice;
    }
    catch(Exception e)
    {
    }
    return -1;
  }
}