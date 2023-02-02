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


public class HashTableMenu {
  private Scanner console;

  public HashTableMenu(){
    console = new Scanner(System.in);
  }

  void testFind(HashTable temp){
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

  public void testDelete(HashTable temp){
//    int idToDelete;
//    boolean success;
//
//    System.out.println("Testing delete algorithm\n");
//    System.out.print("Enter Id value to delete (-1 to quit) --> ");
//    idToDelete = console.nextInt();
//
//    while (idToDelete >= 0){
//      Item dNode = new Item(idToDelete, 0);
//
//      if (temp.find(dNode) == null)
//        System.out.println("Id# " + idToDelete + "  No such part in stock");
//      else{
//        temp.delete(dNode);
//        System.out.println("     Id #" + idToDelete + " was deleted");
//      }
//      System.out.println();
//      System.out.print("Enter Id value to delete (-1 to quit) --> ");
//
//      idToDelete = console.nextInt();
//    }
  }

  public void readData (HashTable temp){
    Scanner inFile;

    String fileName = "file400.txt";
    int id, inv;
	try{
    	inFile = new Scanner(new File(fileName));
		while(inFile.hasNext()){
      		id = inFile.nextInt();
     		inv = inFile.nextInt();
//      		temp.insert(new Item(id, inv));
    	}
    }catch(IOException i){
    	System.out.println("Error: "+ i.getMessage());
    }
  }

  public void mainMenu (HashTable temp){
    String choice;
    do{
      System.out.println("HashTable menu\n");
      System.out.println("(1) Read data from disk");
      System.out.println("(2) Print table");
      System.out.println("(3) Search table");
      System.out.println("(4) Print statistics");
      System.out.println("(Q) Quit\n");
      System.out.print("Choice ---> ");
      choice = console.nextLine() + " ";
      System.out.println();

      if ('1' <= choice.charAt(0) && choice.charAt(0) <= '5'){
        switch (choice.charAt(0)){
          case '1' :
            readData(temp);
            break;
          case '2' :
            System.out.println();
            temp.printTable();
            System.out.println();
            break;
          case '3' :
            testFind(temp);
            break;
          case '4' :
            temp.getLongestList();
            temp.getNumberOfNulls();
            break;
        }
      }
    }
    while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
  }

}