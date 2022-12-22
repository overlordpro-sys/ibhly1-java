public class Arraylist<E>
{
    private E[] myArray;
    private int mySize;
    
    public Arraylist()
    {
        myArray = (E[])new Object[10];
        mySize = 0;
    }
    
    public void add(E obj)
    {
        if (mySize>=myArray.length)
        {
            E[] temp = (E[]) new Object[myArray.length * 2];
            for (int i = 0; i < myArray.length; i++)
                temp[i] = myArray[i];
            myArray = temp;
        }
        myArray[mySize] = obj;
        mySize++;
    }

    public void add(int index, E obj)
    {
        if (index < 0 || index > mySize)
            throw new ArrayIndexOutOfBoundsException();
        if (mySize>=myArray.length)
        {
            E[] temp = (E[]) new Object[myArray.length * 2];
            for (int i = 0; i < myArray.length; i++)
                temp[i] = myArray[i];
            myArray = temp;
        }
        for (int i = mySize; i > index; i--)
        {
            myArray[i] = myArray[i-1];
        }
        myArray[index] = obj;
        mySize++;
    }

    public E set(int index, E obj)
    {
        if (index < 0 || index >= mySize)
            throw new ArrayIndexOutOfBoundsException();
        E temp = myArray[index];
        myArray[index] = obj;
        return temp;
    }

    public E remove(int index)
    {
        if (index < 0 || index >= mySize)
            throw new ArrayIndexOutOfBoundsException();
        for (; index < mySize; index++)
        {
            myArray[index] = myArray[index+1];
        }
        E temp = myArray[index+1];
        myArray[index+1] = null;
        mySize--;
        return temp;
    }

    public int size()
    {
        return mySize;
    }

    public E get(int index)
    {
        if (index < 0 || index > mySize)
            throw new ArrayIndexOutOfBoundsException();
        return myArray[index];
    }
}