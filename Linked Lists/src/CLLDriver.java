public class CLLDriver
{
    /* add this code to your CircularlyLinkedList class
     *
     *
     * public DListNode getFirstNode()
      {
        return first;
      }

       public DListNode getLastNode()
       {
        return last;
       }

     */


    public static void main(String[] args)
    {
        CircularlyLinkedList cList = new CircularlyLinkedList();
        cList.addFirst(new Item(40, 60));
        DListNode node = cList.getFirstNode();
        System.out.println(node.getValue());
        System.out.println(node.getPrevious().getValue());
        System.out.println(node.getNext().getValue());

        cList = new CircularlyLinkedList();
        cList.addLast(new Item(40, 60));
        node = cList.getLastNode();
        System.out.println(node.getValue());
        System.out.println(node.getPrevious().getValue());
        System.out.println(node.getNext().getValue());


        CircularlyLinkedList list = new CircularlyLinkedList();
        CLLMenu menu = new CLLMenu();
        menu.mainMenu(list);
    }
}