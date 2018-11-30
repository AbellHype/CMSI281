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
      tableSize[i] = "";
    }
  }

  public boolean insert(String dataIn) {
    int idealIndex = getHash(dataIn);
    int index = idealIndex;
    while (hashTable[index] != "") {
      index += 1;
      if (index > hashTable.length() - 1) {
        index = 0;
      } else if (index == idealIndex) {
        return false;
      }
    }
    hashTable[idealIndex] = dataIn;
    return true;
  }

  private int getHash(String new) {
    int sum = 0;
    for (int i = 0; i < new.length(); i++) {
      sum = (sum * 27 + new.charAt(i) - 96) % this.tableSize;
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
    String testCase = "Hello world.";
    Huffman huff = new Huffman();
    huff.encode(testCase);
    System.out.println("DECODE ===================================");
    //huff.decode();
  }
}
