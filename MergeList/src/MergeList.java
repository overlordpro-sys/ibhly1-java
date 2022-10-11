import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class MergeList
{
	private String fileName;
	
	public MergeList(String file)
	{
		fileName = file;
	}

	public void readData(LinkedList<Item> list)
	{
		try 
		{
			Scanner inFile = new Scanner(new File(fileName));
			while(inFile.hasNext())
			{        	   
				String[] line = inFile.nextLine().trim().split("\\s+");
				Item pair = new Item(Integer.valueOf(line[0]), Integer.valueOf(line[1]));
				list.addLast(pair);        	   
				
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		 
	}

	//  Recursively divides a list in half, over and over. When the
	//  sublist has one or two values, stop subdividing.
	public LinkedList<Item> mergeSort(LinkedList <Item> listA)
	{
		if (listA == null)
		{
			return null;
		}
		if(listA.size() <= 1)
			return listA;
		
		LinkedList<Item> listB = new LinkedList<Item>();
		
		split(listA, listB);	    
	    return merge(mergeSort(listA), mergeSort(listB));
	}

	private void split(LinkedList<Item> listA, LinkedList<Item> listB)
	{
		ListIterator<Item> iter = listA.listIterator(listA.size() / 2);
		while (iter.hasNext())
		{
			
				listB.addLast(iter.next());
				iter.remove();			
		}
	}
	
	private LinkedList<Item> merge(LinkedList<Item> listA, LinkedList<Item> listB)
	{
		LinkedList <Item> mergedList = new LinkedList <Item>();
		ListIterator<Item> iterA = listA.listIterator(0);
		ListIterator<Item> iterB = listB.listIterator(0);
		while (iterA.hasNext() && iterB.hasNext())
		{
			Item a = iterA.next();
			Item b = iterB.next();
			if (a.compareTo(b)<=0)
			{
				mergedList.addLast(a);
				iterB.previous();
			}
			else
			{
				mergedList.addLast(b);
				iterA.previous();
			}
		}
		while(iterA.hasNext())
		{
			mergedList.addLast(iterA.next());
		}
		while(iterB.hasNext())
		{
			mergedList.addLast(iterB.next());
		}
		
		return mergedList;
	}
	
	public LinkedList<Item> reverseList(LinkedList<Item> list)
	{
		LinkedList<Item> reversed = new LinkedList<Item>();
		Iterator<Item> iter = list.iterator();
		while (iter.hasNext())
		{
			reversed.addFirst(iter.next());
		}
		return reversed;
	}

	public void printList(LinkedList<Item> list) {
		Iterator<Item> iter = list.iterator();
		while (iter.hasNext()) {
			Item obj = iter.next();
			System.out.printf("%5s%16s", "Id: " + obj.getId(), "Inventory: " + obj.getInv() + "\n");
		}
		System.out.println();
	}
}
