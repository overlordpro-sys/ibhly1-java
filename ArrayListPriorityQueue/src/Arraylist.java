public class Arraylist<E>
{
    private E[] myArray;
    private int mySize;
    
    public Arraylist()
    {
        myArray = (E[])new Object[10];
        mySize = 0;
    }

    public Arraylist(E object)
    {
        this();
        add(object);
    }

    public Arraylist(E[] array)
    {
        this();
        for (E object : array)
            add(object);
    }
    
    public void add(E obj)
    {
        if (mySize==myArray.length)
            doubleSize();
        myArray[mySize] = obj;
        mySize++;
    }

    private void doubleSize()
    {
        E[] temp = (E[]) new Object[myArray.length * 2];
        for (int i = 0; i < myArray.length; i++)
            temp[i] = myArray[i];
        myArray = temp;
    }

    public void add(int index, E obj)
    {
        if (index < 0 || index > mySize)
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Index: " + index + ", Size: " + mySize);
        if (mySize==myArray.length)
        {
            doubleSize();
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
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Index " + index + " out of bounds for length " + mySize);
        E temp = myArray[index];
        myArray[index] = obj;
        return temp;
    }

    public E remove(int index)
    {
        if (index < 0 || index >= mySize)
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Index " + index + " out of bounds for length " + mySize);
        E temp = myArray[index];
        for (; index < mySize; index++)
        {
            myArray[index] = myArray[index+1];
        }
        if (index < myArray.length)
            myArray[index] = null;
        mySize--;
        return temp;
    }

    public int size()
    {
        return mySize;
    }

    public E get(int index)
    {
        if (index < 0 || index >= mySize)
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Index " + index + " out of bounds for length " + mySize);
        return myArray[index];
    }
}