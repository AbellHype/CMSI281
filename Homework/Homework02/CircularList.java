/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File name     :  CircularList.java
*  Purpose       :  This class defined a circular list.
*  Author        :  M. McPartlan & M. Abell
*  Date          :  2018-09-19
*  Description   :
*  Exceptions    :  None
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Arrays;

class CircularList {
  public ListItem current;
  private int listSize;

  //-----------------------------------------------------------
  /**
  * Constructor for CircularList class
  * @param  initialValues a string array of all elements to be created in the circular list
  * @return void
  */
  public CircularList(String[] initialValues) {
    this.listSize = initialValues.length;
    this.current = new ListItem();
    current.value = initialValues[0];

    if (initialValues.length == 1) {
      this.current.nextItem = this.current;
    } else {
      ListItem prevItem = this.current;
      ListItem currentItem;
      for (int i = 1; i < initialValues.length + 1; i++) {
        if (i == 1) {
          currentItem = new ListItem();
          currentItem.value = initialValues[i];
        } else if (i < initialValues.length ) {
          currentItem = new ListItem();
          currentItem.value = initialValues[i];
        } else {
          currentItem = this.current;
        }

        prevItem.nextItem = currentItem;
        prevItem = currentItem;

      }
    }
  }

  //-----------------------------------------------------------
  /**
  * Prints the circular list. Does not affect the "current" node selected.
  * @param  None
  * @return void
  */
  public void printList() {
    System.out.print("[");
    for (int i = 0; i < this.listSize; i++) {
      if (i == this.listSize - 1) {
        System.out.println(this.current.value + "]");
      } else {
        System.out.print(this.current.value + ", ");
      }
      step();
    }
  }

  //-----------------------------------------------------------
  /**
  * Returns the size of the circular list
  * @param  None
  * @return void
  */
  public int getSize(){
    return this.listSize;
  }

  //-----------------------------------------------------------
  /**
  * Iterate the circular list. Selects the next element in the list.
  * @param  None
  * @return void
  */
  public void step() {
    this.current = this.current.nextItem;
  }

  //-----------------------------------------------------------
  /**
  * Selects node with desired string as "current"
  * @param  searchArg a string value to search for in the array.
  * @return Boolean result of list search
  */
  public boolean find(String searchArg) {
    for (int i = 0; i < this.listSize; i++) {
      if (this.current.value == searchArg) {
        return true;
      } else {
        step();
      }
    }
    return false;
  }

  //-----------------------------------------------------------
  /**
  * Inserts new ListItem ahead of "current". Does NOT affect current.
  * @param  newArg the value to be inserted into the list
  * @return void
  */
  public void insert(String newArg) {
    ListItem insertItem = new ListItem();
    insertItem.value = newArg;
    insertItem.nextItem = this.current.nextItem;
    this.current.nextItem = insertItem;
    this.listSize += 1;
  }

  //-----------------------------------------------------------
  /**
  * Deletes node ahead of "current". "Current" IS AFFECTED and becomes the node after the deleted node.
  * @param  None
  * @return String value of deleted node.
  */
  public String delete() {
    ListItem tempCurrent = this.current;

    step();
    String retValue = this.current.value;
    this.listSize -= 1;
    tempCurrent.nextItem = this.current.nextItem;
    step();
    return retValue;
  }

  //-----------------------------------------------------------
  /**
  * A class defining ListItem, the node element used in CircularList. No functions other than constructor.
  * @param  None
  * @return void
  */
  class ListItem {
    public ListItem nextItem;
    public String value;

    public ListItem() {
      this.value = "";
    }
  }

  //-----------------------------------------------------------
  /**
  * Test cases for the CircularList and ListItem classes.
  * @param  None
  * @return void
  */
  public static void main(String[] args) {
    String[] testArray = {"Hello!", "This", "is", "a", "circular", "list", "!"};
    CircularList test = new CircularList(testArray);
    test.printList();
    System.out.println();
    test.find("is");
    test.insert("NOT ");
    test.find("Hello!");
    test.printList();
    System.out.println();
    test.step();
    test.find("is");
    test.delete();
    test.find("Hello!");
    test.printList();
    System.out.println();
    System.out.println("-----------------------------");
    String[] numStr = {"1", "2", "3", "4", "5", "6", "7"};
    CircularList printTest = new CircularList(numStr);
    printTest.printList();
    System.out.println("Current: " + printTest.current.value);
    printTest.delete();
    System.out.println("Current: " + printTest.current.value);
    printTest.printList();
    System.out.println("Current: " + printTest.current.value);
    printTest.printList();
    System.out.println("Current: " + printTest.current.value);
    printTest.printList();
    System.out.println("Current: " + printTest.current.value);
    System.out.println("-----------------------------");
    String[] numStr1 = {"1", "2"};
    CircularList printTest1 = new CircularList(numStr1);
    printTest1.printList();
    printTest1.insert("3");
    printTest1.printList();
    System.out.println("-----------------------------");
    String[] numStr2 = {"1"};
    CircularList printTest2 = new CircularList(numStr2);
    printTest2.printList();
    printTest2.step();
    printTest2.printList();
    printTest2.step();
    printTest2.printList();
    printTest2.insert("2");
    printTest2.printList();
    printTest2.step();
    printTest2.printList();
    printTest2.step();
    printTest2.printList();
    printTest2.insert("3");
    printTest2.printList();
    System.out.println("Current: " + printTest2.current.value);
    printTest2.delete();
    printTest2.printList();
    printTest2.delete();
    printTest2.printList();
  }
}
