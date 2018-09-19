/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File name     :  HighArrayApp.java
*  Purpose       :  This class tests the HighArray class.
*  Author        :  M. Abell & M. McPartlan
*  Date          :  2018-09-19
*  Description   :  This class tests the indexing for advanced array operations.
*                   Functions to test:
*                   public HighArray( int max );                  // Constructor for array of length max
*                   public boolean find(long searchKey);          // Checks for elements in the array with value searchkey
*                   public void insert(long value);               // Inserts value into array
*                   public boolean delete(long value);            // Removes value from array
*                   public void display();                        // Displays the array
*                   public long getMax();                         // Returns maximum value in array
*                   public void noDups();                         // Removes duplicate entries
*
*  Exceptions    :  None
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

class HighArrayApp{
  public static void main(String[] args){
    int maxSize = 100; // array size
    HighArray arr; // reference to array
    arr = new HighArray(maxSize); // create the array
    arr.insert(77); // insert 10 items
    arr.insert(99);
    arr.insert(44);
    arr.insert(55);
    arr.insert(22);
    arr.insert(88);
    arr.insert(11);
    arr.insert(00);
    arr.insert(66);
    arr.insert(33);
    arr.display(); // display items
    int searchKey = 35; // search for item
    System.out.print("Max in array: " + arr.getMax() + "\n");
    if( arr.find(searchKey) ) {
      System.out.println("Found " + searchKey);
    } else {
      System.out.println("Can not find " + searchKey);
    }
    arr.delete(00); // delete 3 items
    arr.delete(55);
    arr.delete(99);
    arr.insert(77);
    arr.insert(22);
    arr.display(); // display items again
    System.out.println("Max in array: " + arr.getMax());
    System.out.println("Removing Duplicates.");
    arr.noDups();
    arr.display();

    System.out.println("--------------------------------------");

    maxSize = 100; // array size
    HighArray arr1; // reference to array
    arr1 = new HighArray(maxSize); // create the array
    arr1.insert(243); // insert 10 items
    arr1.insert(423);
    arr1.insert(42454);
    arr1.insert(5875);
    arr1.insert(2572);
    arr1.insert(8548);
    arr1.insert(181);
    arr1.insert(03460);
    arr1.insert(63456);
    arr1.insert(3343433);
    arr1.display(); // display items
    searchKey = 3343433; // search for item
    System.out.print("Max in array: " + arr1.getMax() + "\n");
    if( arr1.find(searchKey) ) {
      System.out.println("Found " + searchKey);
    } else {
      System.out.println("Can not find " + searchKey);
    }
    arr1.delete(243); // delete 3 items
    arr1.delete(42454);
    arr1.delete(181);
    arr1.insert(3343433);
    arr1.insert(63456);
    arr1.display(); // display items again
    System.out.println("Max in array: " + arr1.getMax());
    System.out.println("Removing Duplicates.");
    arr1.noDups();
    arr1.display();

    System.out.println("--------------------------------------");

    maxSize = 100; // array size
    HighArray arr2; // reference to array
    arr2 = new HighArray(maxSize); // create the array
    arr2.insert(-12); // insert 10 items
    arr2.insert(0);
    arr2.insert(3455);
    arr2.insert(734565);
    arr2.insert(1234);
    arr2.insert(-12435463);
    arr2.insert(12);
    arr2.insert(35);
    arr2.insert(23);
    arr2.insert(234);
    arr2.display(); // display items
    searchKey = -12435463; // search for item
    System.out.print("Max in array: " + arr2.getMax() + "\n");
    if( arr2.find(searchKey) ) {
      System.out.println("Found " + searchKey);
    } else {
      System.out.println("Can not find " + searchKey);
    }
    arr2.delete(-12435463); // delete 3 items
    arr2.delete(234);
    arr2.delete(23);
    arr2.insert(1234);
    arr2.insert(35);
    arr2.display(); // display items again
    System.out.println("Max in array: " + arr2.getMax());
    System.out.println("Removing Duplicates.");
    arr2.noDups();
    arr2.display();

    System.out.println("--------------------------------------");

    maxSize = 100; // array size
    HighArray arr3; // reference to array
    arr3 = new HighArray(maxSize); // create the array
    arr3.insert(-12); // insert 10 items
    arr3.insert(-0);
    arr3.insert(-3455);
    arr3.insert(-734565);
    arr3.insert(-1234);
    arr3.insert(-12435463);
    arr3.display(); // display items
    searchKey = -12435463; // search for item
    System.out.print("Max in array: " + arr3.getMax() + "\n");
    if( arr3.find(searchKey) ) {
      System.out.println("Found " + searchKey);
    } else {
      System.out.println("Can not find " + searchKey);
    }
    arr3.delete(-12435463); // delete 3 items
    arr3.delete(-234);
    arr3.delete(-23);
    arr3.insert(-1234);
    arr3.insert(-35);
    arr3.display(); // display items again
    System.out.println("Max in array: " + arr3.getMax());
    System.out.println("Removing Duplicates.");
    arr3.noDups();
    arr3.display();

    System.out.println("--------------------------------------");

    maxSize = 100; // array size
    HighArray arr4; // reference to array
    arr4 = new HighArray(maxSize); // create the array
    arr4.insert(1); // insert 10 items
    arr4.insert(2);
    arr4.insert(2);
    arr4.insert(3);
    arr4.insert(4);
    arr4.insert(5);
    arr4.display(); // display items
    searchKey = -5; // search for item
    System.out.print("Max in array: " + arr4.getMax() + "\n");
    if( arr4.find(searchKey) ) {
      System.out.println("Found " + searchKey);
    } else {
      System.out.println("Can not find " + searchKey);
    }
    arr4.delete(5); // delete 3 items
    arr4.delete(4);
    arr4.delete(2);
    arr4.insert(1);
    arr4.insert(0);
    arr4.display(); // display items again
    System.out.println("Max in array: " + arr4.getMax());
    System.out.println("Removing Duplicates.");
    arr4.noDups();
    arr4.display();

  } // end main()
} // end class HighArrayApp
