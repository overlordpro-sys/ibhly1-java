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
  private double scalar;
  private double exponent;




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

  public Item(int id, int inv, double scale, double exp)
  {
    myId = id;
    myInv = inv;
    scalar = scale;
    exponent = exp;
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

//    int one = Integer.valueOf(num.substring(0,2));
//    int two = Integer.valueOf(num.substring(2));
//    double temp = Math.hypot(one,two) * scalar;
//    double temp2 = Math.pow(temp, exponent);
//    return (int)(temp2 % 599);

    int one = Integer.valueOf(num.substring(0,2));
    int two = Integer.valueOf(num.substring(1));
    double temp = Math.hypot(one,two) * 251.04229273894168;
    double temp2 = Math.pow(temp, 7.778787910153129);
    return (int)(temp2 % 599);
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

