import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RPNCalcDriver
{
    public static void main (String[] args)
    {
        Scanner console = new Scanner(System.in);
        RPNCalc calc = new RPNCalc();
        Queue<Character> expression = new LinkedList<Character>();

        String input;
        do
        {
            calc.emptyStack();
            do
            {
                System.out.print("Input your single-digit integers / operation (Enter 'q' to exit and evaluate): ");
                input = console.nextLine();
                char character = input.charAt(0);
                if (Character.isDigit(character))
                {
                    int num = Character.getNumericValue(character);
                    calc.push(num);
                    expression.add(character);
                }
                else if (Arrays.asList('+','-','*','/').contains(character))
                {
                    calc.operation(character);
                    expression.add(character);
                }
            }
            while(!input.equals("q"));

            while (!expression.isEmpty())
            {
                System.out.print(expression.remove()+" ");
            }
            System.out.print(calc.getResult() + "\n");

            System.out.print("\n Continue? (y or n): ");
            input = console.nextLine();
        } while(input.equals("y"));
    }
}
