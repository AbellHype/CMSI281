/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File name     :  OddEven.java
*  Purpose       :  This class uses a circular list to implement a stack.
*  Author        :  M. McPartlan & M. Abell
*  Date          :  2018-09-19
*  Description   :
*  Exceptions    :  None
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

class Hash {
  private String[] hashTable;
  private int tableSize;

  public Hash(int size){
    this.hashTable = new String[size];
    this.tableSize = size;
    for (int i = 0; i < tableSize; i++) {
      hashTable[i] = "";
    }
  }

  public boolean insert(String dataIn) {
    int idealIndex = getHash(dataIn);
    int index = idealIndex;
    System.out.println(index);
    while (hashTable[index] != "") {
      index += 1;
      if (index > hashTable.length - 1) {
        index = 0;
      } else if (index == idealIndex) {
        return false;
      }
    }
    hashTable[index] = dataIn;
    return true;
  }

  public String delete(String dataIn) {
    int idealIndex = getHash(dataIn);
    System.out.println("Index: " + idealIndex);
    int index = idealIndex;
    while (hashTable[index] != dataIn) {
      index += 1;
      if (index > hashTable.length - 1) {
        index = 0;
      } else if (index == idealIndex) {
        return "";
      }
    }
    String data = hashTable[index];
    hashTable[index] = "";
    return data;
  }

  public void display() {
    System.out.print("Hash table: ");
    for (int i = 0; i < hashTable.length; i++) {
      System.out.print(hashTable[i] + ", ");
    }
    System.out.println();
  }

  private int getHash(String newData) {
    int sum = 0;
    for (int i = 0; i < newData.length(); i++) {
      sum = (sum * 27 + (newData.charAt(i) - 96)) % this.tableSize;
      System.out.println("Sum: " + sum);
    }
    return sum;
  }


  //-----------------------------------------------------------
  /**
  * Tests for OddEven class
  * @param  None
  * @return void
  */
  public static void main(String[] args) {
    Hash hash = new Hash(10);
    hash.insert("hello");
    hash.insert("yoyo");
    hash.insert("this bette go somewhere different");
    hash.insert("one");
    hash.insert("two");
    hash.insert("three");
    hash.insert("four");
    hash.insert("five");
    hash.insert("six");
    hash.insert("seven");
    hash.insert("nine");
    hash.display();
    hash.delete("yoyo");
    hash.delete("hello");
    hash.delete("yoyo");
    hash.delete("this bette go somewhere different");
    hash.delete("one");
    hash.delete("two");
    hash.delete("three");
    hash.delete("four");
    hash.delete("five");
    hash.delete("six");
    hash.delete("seven");
    hash.delete("nine");
    hash.display();
  }
}
