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
        Queue<String> expression =  new LinkedList<String>();

        String equation = "";
        String input;
        do
        {
            System.out.print("\n Press enter to get the solution or input your number / operation (Enter 'Q' to exit): ");
            input = console.nextLine();
            if (input.equals(""))
            {
                System.out.print(equation + calc.getResult());
                System.out.println();
                continue;
            }
            char character = input.charAt(0);
            try
            {
                int num = Integer.parseInt(String.valueOf(character));
                equation += num + "  ";
                calc.push(num);
            } catch (NumberFormatException e)
            {
                if (Arrays.asList('+', '-', '*', '/').contains(character))
                {
                    if (calc.operation(character))
                    {
                        equation += character + "  ";
                    }
                } else
                    System.out.println("Invalid input");
            }
            System.out.print(equation);
            System.out.println();
        }
        while(!input.equals("Q"));
    }

}
