public class PriorityQueue<E>
{
    private Arraylist<E> list;

    public PriorityQueue()
    {
        list = new Arraylist<>(null);
    }

    public void add(E item)
    {
        list.add(item);
        heapUp();
    }

    private void heapUp()
    {

    }

    public boolean isEmpty()
    {
        return true;
    }

    public E peek()
    {
        return list.get(1);
    }

    public E remove()
    {
        return null;
    }

    private void heapDown()
    {

    }
}
