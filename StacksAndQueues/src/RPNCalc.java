import java.util.Stack;

public class RPNCalc
{
    private Stack<Integer> stack;

    public RPNCalc()
    {
        stack = new Stack<Integer>();
    }

    public void push(int val)
    {
        stack.push(val);
    }

    public boolean operation(char op)
    {
        if (stack.size() <=1)
        {
            System.out.println("Not enough numbers in the stack");
            return false;
        }
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch (op)
        {
            case '+':
                stack.push(num1+num2);
                return true;
            case '-':
                stack.push(num1-num2);
                return true;
            case '*':
                stack.push(num1*num2);
                return true;
            case '/':
                stack.push(num1/num2);
                return true;
        }
        return false;
    }

    public String getResult()
    {
        if (stack.isEmpty())
            return "\nStack is empty";
        if (stack.size() != 1)
            return "\nStack has more than one item (not enough operations)";
        return "= " + stack.peek();
    }
}
