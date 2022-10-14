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
public class DOrderedList
{
  private DListNode first;  // first element
  private DListNode last;
  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public DOrderedList()
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
    if (first == null)
    {
      first = new DListNode(value, null, null);
      last = first;
    }
    else
    {
      first.setPrevious(new DListNode(value, first, null));
      first = first.getPrevious();
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
      last.setNext(new DListNode(value, null, last));
      last = last.getNext();
    }

  }
//fix later
  public DListNode find(Object value)
  {
    if (first==null)
      return null;
    DListNode node = first;
    while(node != null && !(node.getValue().equals(value)))
    {
      node = node.getNext();
    }
    return node;
  }
  public void insert(Object value)
  {
    Comparable compareVal = (Comparable)value;
    if (first == null || compareVal.compareTo(first.getValue()) < 0)
    {
      addFirst(value);
    }
    else if (compareVal.compareTo(last.getValue()) > 0)
    {
      addLast(value);
    }
    else
    {
      DListNode front = first;
      DListNode back = null;
      while (front != null && compareVal.compareTo(front.getValue()) >= 0)
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
      first = first.getNext();
      return true;
    }
    DListNode front = first;
    DListNode back = null;
    while(front != null && !front.getValue().equals(value))
    {
      back = front;
      front = front.getNext();
    }
    if (front == null)
    {
      return false;
    }
    if (front.getNext() == null)
    {
      back.setNext(null);
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
    DListNode node = first;
    while (node != null)
    {
      count++;
      node = node.getNext();
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
    DListNode node = first;
    int count = 1;
    while (node != null)
    {
      System.out.println(count + ": " + node.getValue());
      node = node.getNext();
      count++;
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
    int count = 1;
    DListNode node = last;
    while (node != null)
    {
      System.out.println(count + ": " + node.getValue());
      node = node.getPrevious();
      count++;
    }
    System.out.print("\n");
  }

}
