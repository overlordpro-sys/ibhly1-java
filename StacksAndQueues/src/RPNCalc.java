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

    public void operation(char op)
    {
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch (op)
        {
            case '+':
                stack.push(num1+num2);
                break;
            case '-':
                stack.push(num1-num2);
                break;
            case '*':
                stack.push(num1*num2);
                break;
            case '/':
                stack.push(num1/num2);
                break;
        }
    }

    public String getResult()
    {
        if (stack.isEmpty())
            return "\nStack is empty";
        if (stack.size() != 1)
            return "\nStack has more than one item (not enough operations)";
        return "= " + stack.peek();
    }

    public void emptyStack()
    {
        stack.clear();
    }
}
