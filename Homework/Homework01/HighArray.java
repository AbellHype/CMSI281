/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File name     :  HighArray.java
*  Purpose       :  This class automates indexing for advanced array operations.
*  Author        :  M. Abell & M. McPartlan
*  Date          :  2018-09-19
*  Description   :  This class automates indexing for advanced array operations. Includes the following fuctions:
*                   public HighARray( int max );                  // Constructor for array of length max
*                   public boolean find(long searchKey);          // Checks for elements in the array with value searchkey
*                   public void insert(long value);               // Inserts value into array
*                   public boolean delete(long value);            // Removes value from array
*                   public void display();                        // Displays the array
*                   public long getMax();                         // Returns maximum value in array
*                   public void noDups();                         // Removes duplicate entries
*
*  Exceptions    :  None
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

class HighArray {
  private long[] a; // ref to array a
  private int nElems; // number of data items
  //-----------------------------------------------------------

  /**
  * constructor
  * @param  max the length of the array.
  */
  public HighArray(int max){ // constructor
    a = new long[max]; // create the array
    nElems = 0; // no items yet
  }
  //-----------------------------------------------------------
  /**
  * @param  searchKey the value to be found in the array
  * @return Boolean result of array search
  */
  public boolean find(long searchKey){ // find specified value
    int j;
    for (j=0; j<nElems; j++) // for each element,
    if(a[j] == searchKey) // found item?
    break;          //exit loop before end
    if(j == nElems) // gone to end?
    return false; // yes, can’t find it
    else
    return true; // no, found it
  } // end find()
  //-----------------------------------------------------------
  /**
  * @param  value long value to be inserted into array
  * @return none
  */
  public void insert(long value){ // put element into array
    a[nElems] = value; // insert it
    nElems++; // increment size
  }
  //-----------------------------------------------------------
  /**
  * @param  value long value to be deleted from array
  * @return boolean result of delete operation
  */
  public boolean delete(long value){
    int j;
    for(j=0; j<nElems; j++) // look for it
    if( value == a[j] )
    break;
    if(j==nElems) // can’t find it
    return false;
    else{ // found it
      for(int k=j; k<nElems; k++) // move higher ones down
      a[k] = a[k+1];
      nElems--; // decrement size
      return true;
    }
  } // end delete()
  //-----------------------------------------------------------
  /**
  * @return none
  */
  public void display(){ // displays array contents
    for(int j=0; j<nElems; j++) // for each element,
    System.out.print(a[j] + " "); // display it
    System.out.println("");
  }
  //-----------------------------------------------------------
  /**
  * @return Long value in index
  * @throws  IllegalArgumentException if something is hinky
  */
  public long returnVal(int index){ // displays array contents
    if (index >= a.length) {
      throw new IllegalArgumentException("Index is too large");
    }
    return a[index];
  }
  //-----------------------------------------------------------
  /**
  * @return maximum value
  */
  public long getMax(){
    long highValue;
    if(nElems == 0)
    return -1;
    else{
      highValue = a[0];
      for(int j=1; j<nElems; j++){
        if(a[j] > highValue)
        highValue = a[j];
      }
      return highValue;
    }
  }
  //-----------------------------------------------------------
  /**
  * @return none
  */
  public void noDups(){
    for(int j=1; j<nElems; j++){
      for(int i=0; i<j; i++){
        if(a[i] == a[j]){
          for(int k=i; k<nElems; k++) // move higher ones down
          a[k] = a[k+1];
          nElems--; // decrement size
          j--;
          i--;
        }
      }
    }
  }
} // end class HighArray
