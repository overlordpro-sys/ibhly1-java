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
    System.out.print("Enter Id value to search for (-1 to quit) --> ");
    toFind = console.nextLine();

    while (!toFind.equals("Q"))
    {
      Object location = temp.find(toFind);
      if (location == null)
        System.out.println(location + " found");
      else
        System.out.println(location + "not found");
      System.out.println();
      System.out.print("Enter Id value to search for (Q to quit) --> ");
      toFind = console.nextLine();
    }
  }

  public void testDelete(BinarySearchTree temp){
    int idToDelete;
    boolean success;

    System.out.println("Testing delete algorithm\n");
    System.out.print("Enter Id value to delete (-1 to quit) --> ");
    idToDelete = console.nextInt();

    while (idToDelete >= 0){
      Item dNode = new Item(idToDelete, 0);

      if (temp.find(dNode) == null)
        System.out.println("Id# " + idToDelete + "  No such part in stock");
      else{
        temp.delete(dNode);
        System.out.println("     Id #" + idToDelete + " was deleted");
      }
      System.out.println();
      System.out.print("Enter Id value to delete (-1 to quit) --> ");

      idToDelete = console.nextInt();
    }
  }

  public void readData (BinarySearchTree temp){
    Scanner inFile;

    String fileName = "fileB.txt";
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
      keyboard.nextLine(); //flush newline

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
      System.out.println("Binary tree menu\n");
      System.out.println(" (1) Fill the tree from a file");
      System.out.println(" (2) Preorder output");
      System.out.println(" (3) Inorder output");
      System.out.println(" (4) Postorder output");
      System.out.println(" (5) Count nodes in tree");
      System.out.println(" (6) Count leaves in tree");
      System.out.println(" (7) Find the height of the tree");
      System.out.println(" (8) Find the width of the tree");
      System.out.println(" (9) Clear the tree");
      System.out.println("(10) Interchange the tree(mirror image)");
      System.out.println("(11) Print level");
      System.out.println("(12) isAncestor");
      System.out.println("(13) Find");
      System.out.println("(14) Delete");
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
          case 2 :
            System.out.println();
            System.out.println("Tree in preorder\n");
            System.out.printf("%6s%6s","Id","Inv");
            System.out.println();
            root.printPreorder();
            System.out.println();
            break;
          case 3 :
            System.out.println();
            System.out.println("Tree in order\n");
            System.out.printf("%6s%6s","Id","Inv");
            System.out.println();
            root.printInorderHelper();
            System.out.println();
            break;
          case 4 :
            System.out.println();
            System.out.println("Tree in postorder\n");
            System.out.printf("%6s%6s","Id","Inv");
            System.out.println();
            root.printPostorder();
            System.out.println();
            break;
          case 5 :
            System.out.println("Number of nodes = " + root.countNodes());
            System.out.println();
            break;
          case 6 :
            System.out.println("Number of leaves = " + root.countLeaves ());
            System.out.println();
            break;
          case 7 :
            System.out.println("Tree Height: " + root.height());
            break;
          case 8 :
            System.out.println("width");
            break;
          case 9 :
            System.out.println("Tree cleared");
            root.clearTree();
            break;
          case 10 :
            System.out.println("Tree interchanged");
            root.interchange();
            break;
          case 11 :
            testLevel(root);
            break;
          case 12 :
            testAncestor(root);
            break;
          case 13 :
            testFind(root);
            break;
          case 14 :
            testDelete(root);
            break;
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
      if (choice >= 1 && choice <= 14)
        return choice;
    }
    catch(Exception e)
    {
    }
    return -1;
  }
}