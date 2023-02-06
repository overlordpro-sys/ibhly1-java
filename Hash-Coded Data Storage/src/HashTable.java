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
        if (myHashTable[obj.hashCode()] == null)
         size++;
        myHashTable[obj.hashCode()] = new ListNode(obj, myHashTable[obj.hashCode()]);

    }

    public Object find(Comparable target)
    {
        // will attempt to find idToFind in table, if found return inv amount,
        // else return null  (use hashCode to find location, if it's in there)
        ListNode temp = myHashTable[target.hashCode()];
        while (temp!=null)
        {
            if (temp.getValue().equals(target))
                return temp.getValue();
            else
                temp=temp.getNext();
        }
        return null;
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
        int max = 0;
        for (ListNode current : myHashTable)
        {
            int length = 0;
            while(current != null)
            {
                current=current.getNext();
                length++;
            }
            if (length > max)
                max=length;
        }
        return max;
    }

    public double getAverageLength ()
    {
        double total = 0;
        for (int i = 0; i < capacity; i++)
        {
            int nodeTotal = 0;
            ListNode temp = myHashTable[i];
            while(temp != null)
            {
                temp=temp.getNext();
                nodeTotal++;
            }
            total+=nodeTotal;
        }
        return total/size;
    }

    public void printTable()
    {
        for (int i = 0; i<capacity; i++)
        {
            System.out.print(i + ": ");
            ListNode temp = myHashTable[i];
            while(temp != null)
            {
                System.out.print(temp.getValue() + " | ");
                temp=temp.getNext();
            }
            System.out.println();
        }
    }
}