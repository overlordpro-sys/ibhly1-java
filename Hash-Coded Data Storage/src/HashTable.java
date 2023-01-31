/**
 *  Description of the Class
 *
 * @author     G. Peck
 * @created    July 18, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006 
 */
import java.util.*;

public class HashTable
{
    private int size;
    private int capacity;
    private ListNode[] myHashTable;

    public HashTable()
    {
        size = 0;
        capacity = 600;
        myHashTable = new ListNode[capacity];
    }

    public HashTable(int numSlots)
    {
        size = 0;
        capacity = numSlots;
        myHashTable = new ListNode[capacity];
    }


    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void add(Object obj)
    {
        // add to array in location determined by call to hashCode()
        ListNode cur = myHashTable[obj.hashCode()];
        if (cur==null)
            myHashTable[obj.hashCode()] = new ListNode(obj,null);
        else {
            while (cur.getNext() != null)
            {
                cur = cur.getNext();
            }
            cur.setNext(new ListNode(obj, null));
        }
        size++;
    }

    public Object find(Comparable target)
    {
        // will attempt to find idToFind in table, if found return inv amount,
        // else return null  (use hashCode to find location, if it's in there)
        return myHashTable[target.hashCode()];
    }

    public int getNumberOfNulls()
    {
        int nulls = 0;
        for (ListNode node : myHashTable)
        {
            if (node == null)
            {
                nulls++;
            }
        }
        return nulls;
    }

    public int getLongestList ()
    {
        int max;
        for (ListNode current : myHashTable)
        {
            int length = 0;
            // left off here
        }
        return 0;
    }

    public void printTable()
    {
        for (int i = 0; i<capacity; i++)
        {
            System.out.print(i + ": ");

            while(myHashTable[i].getNext()!=null)
        }
    }
}