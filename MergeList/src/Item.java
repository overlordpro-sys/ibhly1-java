/**
 *  Description of the Class
 *
 * @author     G. Peck
 * @created    July 18, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */

public class Item implements Comparable{
  private int myId;
  private int myInv;

  /**
   *  Constructor for the Item object
   *
   * @param  id   id value
   * @param  inv  inventory value
   */
  public Item(int id, int inv){
	  myId = id;
	  myInv = inv;
  }

  /**
   *  Gets the id attribute of the Item object
   *
   * @return    The id value
   */
  public int getId(){
	  return myId;
  }

  /**
   *  Gets the inv attribute of the Item object
   *
   * @return    The inv value
   */
  public int getInv(){
    return myInv;
  }

  /**
   *  Compares two Item objects by their Id (myId) fields
   *
   * @param  otherObject  Item object to compare to
   * @return              positive int if myId > otherObject.myId
   *                      0 if myId == otherObject.myId
   *                      negative int if myId < otherObject.myId
   */
  public int compareTo(Object otherObject){
    int myId = this.getId();
    int otherId = ((Item) otherObject).getId();
    if (myId > otherId)
    {
    	return 1;
    }
    if (myId < otherId)
    {
    	return -1;
    }
    return 0;
  }

  /**
   *  Compares the Item to the specified object
   *
   * @param  otherObject  Item object to compare to
   * @return              true if equal, false otherwise
   */
  public boolean equals(Object otherObject){
	  return (this.compareTo(otherObject)==0);
  }

  public String toString(){
    return "Id=" + myId + ",Inv=" + myInv;
  }
}

