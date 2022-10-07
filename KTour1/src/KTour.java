import java.util.ArrayList;
import java.util.Arrays;
public class KTour {
	private ArrayList<Integer> horizontal = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 1, -1, -2, -2, -1));
    private ArrayList<Integer> vertical   = new ArrayList<Integer>(Arrays.asList(-2, -1, 1, 2, 2, 1, -1, -2));
    private int[][] board;
    private int myX;
    private int myY;
    private int visited;
    
    public KTour()
    {
        board = new int[9][9];
        board[1][1] = 1;
        myX = 1;
        myY = 1;
        visited = 1;
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
        @SuppressWarnings("unchecked")
		ArrayList<Integer> hor = (ArrayList<Integer>) horizontal.clone();
        @SuppressWarnings("unchecked")
		ArrayList<Integer> ver = (ArrayList<Integer>) vertical.clone();
        while (hor.size() != 0)
        {
            int moveNum = (int) (Math.random()*hor.size());
            int newX = myX + hor.get(moveNum);
            int newY = myY + ver.get(moveNum);
            if (newX > 0 && newX <9 && newY > 0 && newY <9 && board[newX][newY] == 0)
            {
                myX = newX;
                myY = newY;
                return true;
            }
            hor.remove(moveNum);
            ver.remove(moveNum);
        }
        return false;
    }

    public int output()
    {
        System.out.print("  ");
        for (int i = 1; i < 9; i++)
        {
            System.out.printf("%5d", i);
        }
        System.out.println("\n");
        for (int r = 1; r < 9; r++)
        {
            System.out.print(r+" ");
            for (int c = 1; c < 9; c++)
            {
                System.out.printf("%5d", board[r][c]);
            }
            System.out.println();
        }
        System.out.print("\n"+visited+" Squares were visited");
        return visited;
    }
}
