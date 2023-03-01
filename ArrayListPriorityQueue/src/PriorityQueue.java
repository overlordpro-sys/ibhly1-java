public class PriorityQueue<E>
{
    private Arraylist<E> myList;

    public PriorityQueue()
    {
        myList = new Arraylist<>(1);
    }

    public void add(E item)
    {
        myList.add(item);
        heapUp();
    }

    private void heapUp()
    {
        int index = myList.size();
        while (index != 1 && ((Comparable)myList.get(myList.size())).compareTo(myList.get(index/2)) < 0)
        {
            swap (index, index/2);
            index/=2;
        }
    }

    public boolean isEmpty()
    {
        if (myList.size()==1)
            return true;
        if (myList.get(1) == null)
            return true;
        return false;
    }

    public E peek()
    {
        if (myList.size() != 1)
            return myList.get(1);
        return null;
    }

    public E remove()
    {
        E temp = myList.get(1);
        heapDown();
        return temp;
    }

    private void heapDown()
    {
        myList.set(1, myList.remove(myList.size()-1));
        int index = 1;
        while (index*2 <= myList.size())
        {
            Comparable object1 = (Comparable)myList.get(index*2);
            int toSwap = index*2;
            if (index*2+1<= myList.size() && object1.compareTo(myList.get(index*2+1)) > 0 )
                toSwap = index*2+1;
            if (((Comparable)myList.get(toSwap)).compareTo(myList.get(index))< 0)
                swap(index, toSwap);
        }
    }

    private void swap(int index1, int index2)
    {
        E temp = myList.get(index1);
        myList.set(index1, myList.get(index2));
        myList.set(index2, temp);
    }
}
