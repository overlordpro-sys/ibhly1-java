import java.util.*;
import java.io.*;

public class Life
{
    // specs say matrix to be 20 x 20.  If you'd like, you can make it 22 x 22 
    // and ignore row/col 0 and 21.  This will allow you to not have to test the 
    // condition of going out of bounds when you're counting neighbors.
    // You can make the matrix to store ints or Strings    
    private String[][] myMatrix;
    
    // initialize matrix (fill with " " if make String matrix)
    // call loadFile
    public Life(String fileName)
    {
        myMatrix = new String[22][22];
        for (int row = 0; row <= 21; row++)
        {
        	for (int col = 0; col<=21; col++)
        	{
        		myMatrix[row][col] = " ";
        	}
        }
        loadFile("life100.txt");  
    }
    
    // loads file and updates matrix so that matrix[r][c] is alive if (r,c) 
    // is present in file
    private void loadFile(String fileName)
    {
        try
        {
           Scanner read = new Scanner(new File(fileName));
           while(read.hasNextInt())
           {
        	   myMatrix[read.nextInt()][read.nextInt()] = "*";
        	   
           }
        }
        catch (IOException error)
        {
            System.out.println (error.getMessage());
        }            
    }
    
    // updates the matrix based on the number of neighbors around each cell.
    // make a copy matrix
    // count nbrs around each cell in copy (separate method)
    // 0,1, or 4+ nbrs --> death to myMatrix[r][c]
    // 3 nbrs --> life to myMatrix[r][c]   
    public void nextGeneration()
    {
        String[][] clonedMatrix = new String[22][22];
        
        for (int row = 0; row <= 21; row++)
        {
        	for (int col = 0; col<=21; col++)
        	{
        		clonedMatrix[row][col] = myMatrix[row][col];
        	}
        }
        for (int r = 1; r <= 20; r++)
        {
        	for (int c = 1; c<=20; c++)
        	{
        		int  neighbors = countNeighbors(myMatrix, r, c);
        		if (neighbors == 3)
        		{
        			clonedMatrix[r][c] = "*";
        		}
        		if (neighbors < 2 || neighbors > 3)
        		{
        			clonedMatrix[r][c] = " ";
        		}
        	}
        }
        myMatrix = clonedMatrix;
        
    }
    
    // counts and returns number of living organisms around max[r][c]   
    private int countNeighbors(String[][] max, int row, int col)
    {
        int total = 0;
    	for (int r = row-1; r <= row+1; r++)
    	{
    		for (int c = col-1; c <= col+1; c++)
        	{
        		if(!(r == row && c == col) && myMatrix[r][c].equals("*"))
        		{
        			total++;
        		}
        	}
    	}
    	return total;
    }
    
    // counts and returns total # of living organisms in myMatrix
    public int countLiving()
    {
    	int total = 0;
    	for (int row = 1; row <= 20; row++)
        {
        	for (int col = 1; col<=20; col++)
        	{
        		if (myMatrix[row][col].equals("*"))
        		{
        			total++;
        		}
        	}
        }
    	return total;
    }
    
    // counts and returns # of living organisms in row
    public int countRow(int row)
    {
    	int total = 0;
    	for (int col = 1; col<=20; col++)
    	{
    		if (myMatrix[row][col].equals("*"))
    		{
    			total++;
    		}
    	}
    	return total;
    }        
    
     // counts and returns # of living organisms in col
    public int countCol(int col)
    {
    	int total = 0;
    	for (int row = 1; row<=20; row++)
    	{
    		if (myMatrix[row][col].equals("*"))
    		{
    			total++;
    		}
    	}
    	return total;
    }
    
    // displays contents of myMatrix ( "*" if alive, " " if dead)
    // include row # and col # (make a table)
    public void output()
    {
    	System.out.printf("%25s", "12345678901234567890\n");
    	for (int row = 1; row <= 20; row++)
        {
    		System.out.printf("%2d", row);
    		System.out.print("  ");
        	for (int col = 1; col<=20; col++)
        	{
        		
        		System.out.print(myMatrix[row][col]);
        	}
        	System.out.println();
        }
    }
}