/**
 *  Description of the Class
 *
 * @author     G. Peck
 * @created    July 18, 2002
 */

public class Item implements Comparable
{
  private int myId;
  private int myInv;

  /**
   *  Constructor for the Item object
   *
   * @param  id   id value
   * @param  inv  inventory value
   */
  public Item(int id, int inv)
  {
    myId = id;
    myInv = inv;
  }

  /**
   *  Gets the id attribute of the Item object
   *
   * @return    The id value
   */
  public int getId()
  {
    return myId;
  }

  /**
   *  Gets the inv attribute of the Item object
   *
   * @return    The inv value
   */
  public int getInv()
  {
    return myInv;
  }

  public int hashCode()
  {
//    600 is good for myId*600
    String num = String.format("%05d", myId*600);
//    int temp = 486181;
    int one = Integer.valueOf(num.substring(0,3));
    int two = Integer.valueOf(num.substring(3));
    double temp = Math.hypot(one,two) * 13.3;
    double temp2 = Math.pow(temp, 7.77);
    return (int)(temp2 % 599);





	// code this method
}



  /**
   *  Compares two Item objects by their Id (myId) fields
   *
   * @param  otherObject  Item object to compare to
   * @return              positive int if myId > otherObject.myId
   *                      0 if myId == otherObject.myId
   *                      negative int if myId < otherObject.myId
   */
  public int compareTo(Object otherObject)
  {
    Item other = (Item) otherObject;

    return myId - other.myId;
  }

  /**
   *  Compares the Item to the specified object
   *
   * @param  otherObject  Item object to compare to
   * @return              true if equal, false otherwise
   */
  public boolean equals(Object otherObject)
  {
    return this.compareTo(otherObject) == 0;
    //Item other = (Item)otherObject;
    //return myId == other.myId;
  }

  public String toString()
  {
    return "Id= " + myId + ",Inv= " + myInv;
  }
}

