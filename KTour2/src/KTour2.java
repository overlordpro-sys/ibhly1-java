
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class KTour2 {
	private ArrayList<Integer> horizontal = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 1, -1, -2, -2, -1));
    private ArrayList<Integer> vertical   = new ArrayList<Integer>(Arrays.asList(-2, -1, 1, 2, 2, 1, -1, -2));
    private int[][] board;
    private int[][] access;
    private int myX;
    private int myY;
    private int visited;
    
    
    public KTour2()
    {
        board = new int[9][9];
        board[1][1] = 1;
        access = new int[9][9];
        myX = 1;
        myY = 1;
        visited = 1;
        loadFile("access.txt");
    }

    public void start()
    {
        int i = 2;
        while (move())
        {
            board[myX][myY] = i;
            visited++;
            i++;
        }

    }

    private boolean move()
    {
        int lowestIndex = -1;
        int lowestAccess = 9;
        for (int moveNum = 0; moveNum < horizontal.size(); moveNum++)
        {
            int newX = myX + horizontal.get(moveNum);
            int newY = myY + vertical.get(moveNum);
            if (newX > 0 && newX <9 && newY > 0 && newY <9 && board[newX][newY] == 0)
            {
                if(access[newX][newY] < lowestAccess)
                {
                	lowestIndex = moveNum;
                	lowestAccess = access[newX][newY];
                }
            }
        }
        if (lowestIndex != -1)
        {
        	myX+=horizontal.get(lowestIndex);
        	myY+=vertical.get(lowestIndex);
        	updateAccess(myX, myY);
        	return true;
        }
        return false;
    }
    
    private void updateAccess(int row, int col)
    {
    	int[] horizontal = {1, 2, 2, 1, -1, -2, -2, -1};
    	int[] vertical = {-2, -1, 1, 2, 2, 1, -1, -2};
    	for (int i = 0; i < horizontal.length; i++)
    	{
    		int newX = row + horizontal[i];
    		int newY = col + vertical[i];
    		if (newX > 0 && newX < 9 && newY > 0 && newY < 9)
    		{
    			access[newX][newY]--;
    		}
    	}
    }
    
    public void output()
    {
        System.out.print(" ");
        for (int i = 1; i < 9; i++)
        {
            System.out.printf("%5d", i);
        }
        System.out.println();
        for (int r = 1; r < 9; r++)
        {
            System.out.print(r);
            for (int c = 1; c < 9; c++)
            {
                System.out.printf("%5d", board[r][c]);
            }
            System.out.println();
        }
        System.out.print("\n"+visited+" Squares were visited");
    }
    
    private void loadFile(String fileName)
    {
    	try
        {
           Scanner read = new Scanner(new File(fileName));
           for (int r = 1; r <= 8; r++)
           {
        	   for (int c = 1; c <= 8; c++)
        	   {
        		   access[r][c] = read.nextInt();
        	   }
           }
        }
        catch (IOException error)
        {
            System.out.println (error.getMessage());
        } 
    }
}

