import java.util.*;

/**
 *  Implementation of lists, using singly linked elements.
 *
 * @author     G. Peck
 * @created    April 27, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9,2006
 */
public class SinglyLinkedList
{
  private ListNode first;  // first element
  private ListNode last;
  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public SinglyLinkedList()
  {
    first = null;
    last = null;

  }

  /**
   *  Returns the first element in this list.
   *
   * @return  the first element in the linked list.
   */
  public Object getFirst()
  {
    return first;
  }

  public Object getLast()
  {
    return last;
  }


  /**
   *  Inserts the given element at the beginning of this list.
   *
   * @param  value  the element to be inserted at the beginning of this list.
   */
  public void addFirst(Object value)
  {
    // note the order that things happen:
    // head is parameter, then assigned

    // code this
    first = new ListNode(value, first);
  }

  public void addLast(Object value)
  {
    if (first == null)
    {
      first = new ListNode(value);
      last = first;
    }
    else
    {
      last.setNext(new ListNode(value));
      last = last.getNext();
    }

  }

  public ListNode find(Object value)
  {
    ListNode node = first;
    while(!node.getValue().equals(value))
    {
      if (node==null)
        return null;
      node = node.getNext();
    }
    return node;
  }

  public boolean remove(Object value)
  {
    ListNode prev = null;
    ListNode node = first;
    while(!node.getValue().equals(value))
    {
      if (node==null)
        return false;
      prev = node;
      node = node.getNext();
    }
    prev.setNext(node.getNext());
    return true;
  }

  /**
   *  Print the contents of the entire linked list
   */
//  public void printList()
//  {
//    // code this
//    ListNode current = first;
//    int num = 1;
//    while (current != null)
//    {
//      System.out.println(num +": " + current.getValue());
//      current = current.getNext();
//    }
//  }

  public int size()
  {
    int count = 0;
    ListNode current = first;
    while (current != null)
    {
      count++;
      current = current.getNext();
    }
    return count;
  }

  /**
   *  Returns a string representation of this list. The string
   *  representation consists of the list's elements in order,
   *  enclosed in square brackets ("[]"). Adjacent elements are
   *  separated by the characters ", " (comma and space).
   *
   * @return    string representation of this list
   */
  public void printList()
  {
    String list = "[";

    ListNode temp = first;  // start from the first node
    while (temp != null)
    {
      list += temp.getValue(); // append the data
      temp = temp.getNext();      // go to next node
      if (temp != null)
        list += ", ";
    }
    list += "]";
    System.out.print(list);
  }

}
