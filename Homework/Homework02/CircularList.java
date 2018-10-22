/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File name     :  CircularList.java
*  Purpose       :  This class automates indexing for advanced array operations.
*  Author        :  M. McPartlan & M. Abell
*  Date          :  2018-09-19
*  Description   :
*  Exceptions    :  None
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Arrays;

class CircularList {
  public ListItem current;
  private int listSize;

  public CircularList(String[] initialValues) {
    this.listSize = initialValues.length;
    this.current = new ListItem();
    current.value = initialValues[0];

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

  public void step() {
    this.current = this.current.nextItem;
  }

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

  // Inserts item ahead of current
  public void insert(String newArg) {
    ListItem insertItem = new ListItem();
    insertItem.value = newArg;
    insertItem.nextItem = this.current.nextItem;
    this.current.nextItem = insertItem;
  }
  // Deletes item ahead of current
  public String delete() {
    ListItem tempCurrent = this.current;

    step();
    String retValue = this.current.value;
    this.listSize -= 1;
    tempCurrent.nextItem = this.current.nextItem;
    step();
    return retValue;
  }

  class ListItem {
    public ListItem nextItem;
    public String value;

    public ListItem() {
      this.value = "";
    }
  }

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

    // Generate josephus test string
    String[] jArray = new String[20];
    for (int iJ = 0; iJ < 20; iJ++) {
      jArray[iJ] = String.valueOf(iJ + 1);
      if (iJ == 6) {
        jArray[iJ] = "Josephus";
      }
    }

    // String[] jArray = {"1", "2", "3", "4", "5", "6", "7"};
    String search = "Josephus";

    System.out.println(Arrays.toString(jArray));

    for (int jump = 2; jump < jArray.length; jump++) {
      CircularList josephus = new CircularList(jArray);
      System.out.println("--------------------------------------------");
      // josephus.printList();
      System.out.println("--------------------------------------------");
      String[] deletionOrder = new String[jArray.length - 1];
      int deleted = 0;
      int count = 1;
      while (deleted < jArray.length - 1) {
        count += 1;
        josephus.step();
        if (count == jump) {
          // System.out.println("Count: " + count);
          count = 1;
          String prevLoc = josephus.current.value;
          deletionOrder[deleted] = josephus.delete();
          josephus.find(prevLoc);
          // josephus.printList();
          // System.out.println(Arrays.toString(deletionOrder));
          deleted += 1;
        }
      }
      if (josephus.current.value == search) {
        System.out.println("SUCCESS, count by: " + jump);
        System.out.println(Arrays.toString(deletionOrder));
        break;
      }
    }
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
  }

}
