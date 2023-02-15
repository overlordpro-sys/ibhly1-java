/**
 * Description of the Class
 *
 * @author G. Peck
 * @created July 18, 2002
 * <p>
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapSort
{
    private final PriorityQueue<Item> myHeapPQ;
    private final String myFile;

    public HeapSort()
    {
        this("file20.txt");
    }

    public HeapSort(String fName)
    {
        myHeapPQ = new PriorityQueue<Item>();
        loadFile(fName);
        myFile = fName;
    }

    private void loadFile(String fileName)
    {
        int id, inv;
        Scanner inFile;
        try
        {
            inFile = new Scanner(new File(fileName));

            while (inFile.hasNext())
            {
                id = inFile.nextInt();
                inv = inFile.nextInt();
                myHeapPQ.add(new Item(id, inv));
            }
        } catch (IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        }
    }

    public void sort()
    {
        // create new text file

        try (FileWriter HeapSortOutput = new FileWriter("HeapSortOutput.txt"))
        {
            while (!myHeapPQ.isEmpty())
            {
                HeapSortOutput.write(myHeapPQ.remove() + "\n");
            }
        }
        catch (IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        }

    }

}