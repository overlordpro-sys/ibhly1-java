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
    int idToFind;
    Item location;

    System.out.println("Testing search algorithm\n");
    System.out.print("Enter Id value to search for (-1 to quit) --> ");
    idToFind = console.nextInt();

    while (idToFind >= 0){
      location = (Item)temp.find(new Item(idToFind, 0));
      if (location == null)
        System.out.println("Id = " + idToFind + "  No such part in stock");
      else
        System.out.println("Id = " + location.getId() +
                           "  Inv = " + location.getInv());
      System.out.println();
      System.out.print("Enter Id value to search for (-1 to quit) --> ");
      idToFind = console.nextInt();
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

    String fileName = "test.txt";
	try{
    	inFile = new Scanner(new File(fileName));
		while(inFile.hasNext()){

      		temp.insert(inFile.nextInt());
    	}
    }catch(IOException i){
    	System.out.println("Error: "+ i.getMessage());
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
            break;
          case 10 :
            System.out.println("Tree interchanged");
            root.interchange();
            break;
          case 11 :
            System.out.println("printLevel");
            break;
          case 12 :
            System.out.println("isAncestor");
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