import java.util.Arrays;
import java.util.Scanner;

public class RPNCalcMenu
{
    private Scanner console;
    private RPNCalc calc;

    public RPNCalcMenu()
    {
        console = new Scanner(System.in);
        calc = new RPNCalc();
    }
    public void mainMenu()
    {
        String equation = "";
        String input;
        do
        {
            System.out.print("\n Press enter to get the solution or input your number / operation: ");
            input = console.nextLine();
            if (input.equals(""))
            {
                System.out.print(equation + calc.getResult());
                System.out.println();
                continue;
            }
            char character = input.charAt(0);
            try {
                int num = Integer.parseInt(String.valueOf(character));
                equation += num + "  ";
                calc.push(num);
            }
            catch (Exception e)
            {
                if (Arrays.asList('+', '-', '*', '/').contains(character)) {
                    if (calc.operation(character))
                    {
                        equation += character + "  ";
                    }
                }
            }
            System.out.print(equation);
            System.out.println();
        }
        while(!input.equals("Q"));
    }
}
