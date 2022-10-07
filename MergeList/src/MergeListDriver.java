import java.util.LinkedList;

public class MergeListDriver {
	public static void main(String[] args)
	{
		LinkedList<Item> list = new LinkedList<Item>();
		MergeList merger = new MergeList("file20.txt");
		
		merger.readData(list);
		System.out.println("Before Sort:");
		merger.printList(list);
		
		list = merger.mergeSort(list);
		System.out.println("After Sort:");
		merger.printList(list);		
		
		list = merger.reverseList(list);
		System.out.println("After Reversal:");
		merger.printList(list);	
		
	}
}
