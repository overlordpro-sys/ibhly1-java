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
        if (stack.size() <=1)
        {
            System.out.println("Not enough numbers in the stack");
            return;
        }
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

    public void printResult()
    {
        if (stack.isEmpty())
            System.out.println("Stack is empty");
        if (stack.size() != 1)
            System.out.println("Stack has more than one item");
        System.out.print(stack.peek());
    }
}
