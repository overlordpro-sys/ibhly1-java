public class ArrayListDriver
{
    public static void main(String[] args)
    {
        Arraylist<Integer> list = new Arraylist<Integer>();
        list.add(1);
        list.add(3);
        list.add(2, 2);
        System.out.print(list.get(0));
        System.out.print(list.get(1));
        System.out.print(list.get(2));

    }
}
