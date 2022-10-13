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
    if (first == null)
    {
      throw new NoSuchElementException();
    }
    else
    {
      return first.getValue();
    }
  }

  public Object getLast()
  {
    if (last == null)
    {
      throw new NoSuchElementException();
    }
    else
    {
      return last.getValue();
    }
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
//fix later
  public ListNode find(Object value)
  {
    ListNode node = first;
    if (node==null)
      return null;
    while(node != null && !(node.getValue().equals(value)))
    {
      node = node.getNext();
    }
    if (node == null)
      return null;
    return node;
  }
  public void insert(Object value)
  {
    Comparable compareVal = (Comparable)value;
    if (first == null)
    {
      first = new ListNode(value);
      last = first;
    }
    else if (compareVal.compareTo(first.getValue()) < 0)
    {
      addFirst(value);
    }
    else if (compareVal.compareTo(last.getValue()) > 0)
    {
      addLast(value);
    }
    else
    {
      ListNode front = first;
      ListNode back = null;
      while (front != null && compareVal.compareTo(front.getValue()) > 0)
      {
        back = front;
        front = front.getNext();
      }
      back.setNext(new ListNode(value, front));
    }
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
    String list = "";

    ListNode temp = first;  // start from the first node
    while (temp != null)
    {
      list += temp.getValue(); // append the data
      temp = temp.getNext();      // go to next node
      if (temp != null)
        list += " | ";
    }
    System.out.print(list);
  }

  public void clear()
  {
    first = null;
    last = null;
  }

  public void printBackwards()
  {
    backwards(first);
  }

  public void backwards(ListNode node)
  {
    if (node!= null)
    {
      backwards(node.getNext());
      System.out.print(node.getValue() + " ");
    }
  }

}
