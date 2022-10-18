import java.util.NoSuchElementException;

/**
 *  Implementation of lists, using singly linked elements.
 *
 * @author     G. Peck
 * @created    April 27, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9,2006
 */
public class CircularlyLinkedList
{
  private DListNode first;  // first element
  private DListNode last;
  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public CircularlyLinkedList()
  {
    first = null;
    last = null;
  }

  /**
   *  Returns the first element in this list.
   *
   * @return  the first element in the linked list.
   */

  public DListNode getFirstNode()
  {
    return first;
  }

  public DListNode getLastNode()
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
    if (first == null)
    {
      first = new DListNode(value, null, null);
      first.setNext(first);
      first.setPrevious(first);
      last = first;
    }
    else
    {
      first.setPrevious(new DListNode(value, first, first.getPrevious()));
      if (first.getNext() == first)
      {
        first.setNext(first.getPrevious());
      }
      first = first.getPrevious();
      last.setNext(first);
    }
  }

  public void addLast(Object value)
  {
    if (first == null)
    {
      addFirst(value);
    }
    else
    {
      last.setNext(new DListNode(value, first, last));
      last = last.getNext();
      first.setPrevious(last);
    }

  }
  public DListNode find(Object value)
  {
    if (first==null)
      return null;
    DListNode node = first;
    if (last.getValue().equals(value))
      return node;
    while(node != last && !(node.getValue().equals(value)))
    {
      node = node.getNext();
    }
    if (node==last)
      return null;
    return node;
  }
  public void insert(Object value)
  {
    Comparable compareVal = (Comparable)value;
    if (first == null || compareVal.compareTo(first.getValue()) <= 0)
    {
      addFirst(value);
    }
    else if (compareVal.compareTo(last.getValue()) >= 0)
    {
      addLast(value);
    }
    else
    {
      DListNode front = first;
      DListNode back = first.getPrevious();
      while (front != last && compareVal.compareTo(front.getValue()) >= 0)
      {
        back = front;
        front = front.getNext();
      }
      back.setNext(new DListNode(value, front, back));
      front.setPrevious(back.getNext());
    }
  }
  public boolean remove(Object value)
  {
    if (first == null)
    {
      return false;
    }
    if (first.getValue().equals(value)) {
      last.setNext(first.getNext());
      first = first.getNext();
      last.setPrevious(first);
      return true;
    }
    if (last.getValue().equals(value)) {
      last = last.getPrevious();
      first.setPrevious(last);
      return true;
    }
    DListNode front = first;
    DListNode back = first.getPrevious();
    while(front != last.getNext() && !front.getValue().equals(value))
    {
      back = front;
      front = front.getNext();
    }
    if (front == last.getNext())
    {
      return false;
    }
    else
    {
      back.setNext(front.getNext());
      back.getNext().setPrevious(back);
    }
    return true;
  }

  public int size()
  {
    int count = 0;
    if (first != null)
    {
      DListNode node = first;
      while (node != last)
      {
        count++;
        node = node.getNext();
      }
      count++;
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
    if (first!=null)
    {
      DListNode node = first;
      int count = 1;
      do {
        System.out.println(count + ": " + node.getValue());
        node = node.getNext();
        count++;
      }
      while (node != last.getNext());
    }
    System.out.print("\n");
  }

  public void clear()
  {
    first = null;
    last = null;
  }

  public void printBackwards()
  {
    if (last!=null) {
      int count = 1;
      DListNode node = last;
      do {
        System.out.println(count + ": " + node.getValue());
        node = node.getPrevious();
        count++;
      }
      while (node != first.getPrevious());
      System.out.print("\n");
    }
  }
}
