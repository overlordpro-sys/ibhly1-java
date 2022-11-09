import java.util.Arrays;
import java.util.Scanner;

public class RPNCalcMenu
{
    private Scanner console;
    private RPNCalc calc;

    public RPNCalcMenu()
    {
        console = new Scanner(System.in);
        RPNCalc calc = new RPNCalc();
    }
    public void mainMenu()
    {
        String equation = "";
        char input;
        do
        {
            System.out.println("Input your number / operation");
            input = console.nextLine().charAt(0);
            try {
                int num = Integer.parseInt(String.valueOf(input));
                equation += num + "  ";
                calc.push(num);
            }
            catch (Exception e)
            {
                if (Arrays.asList('+', '-', '*', '/').contains(input))
                {
                    equation += input + "  ";
                    calc.operation(input);
                }
                else
                {
                    System.out.println("Invalid input");
                    continue;
                }
            }
            System.out.print(equation);
        }
        while(input!='Q');
    }
}
