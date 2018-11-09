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

class Huffman {
  List<HuffmanNode> characters = Collections.synchronizedList(new ArrayList<HuffmanNode>(0));
  public void encode(String inputStr) {
    char[] input = inputStr.toCharArray();
    for (int i = 0; i < input.length; i++) {
      characters.add(new HuffmanNode(input[i]));
    }
    ListIterator<HuffmanNode> iterator = characters.listIterator();
    while (iterator.hasPrevious()) {
      iterator.previous();
    }

    while (iterator.hasNext()) {
      System.out.print(iterator.next().print() + ", ");
    }
    System.out.println();

    while (iterator.hasPrevious()) {
      iterator.previous();
    }

    for (int i = 0; i < characters.size(); i ++) {
      HuffmanNode currentObj = iterator.next();
      while (iterator.hasNext()) {
        HuffmanNode innerWorkingObj = iterator.next();
        if (innerWorkingObj.value == currentObj.value) {
          iterator.remove();
          currentObj.count += 1;
        }
      }
      for (int r = characters.size(); r > i; r--) {
        iterator.previous();
      }
    }

    while (iterator.hasPrevious()) {
      iterator.previous();
    }

    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      while (iterator.hasNext()) {
        HuffmanNode tempFirst = iterator.next();
        if (iterator.hasNext()) {
          HuffmanNode tempSecond = iterator.next();
          if (tempFirst.count < tempSecond.count) {
            // Relys on Java passing by reference (hopefully)
            char tfr = tempFirst.value;
            int tfrI = tempFirst.count;
            tempFirst.value = tempSecond.value;
            tempFirst.count = tempSecond.count;
            tempSecond.value = tfr;
            tempSecond.count = tfrI;
            sorted = false;
          }
          iterator.previous();
        }
      }
      while (iterator.hasPrevious()) {
        iterator.previous();
      }
    }

    while (iterator.hasPrevious()) {
      iterator.previous();
    }
    while (iterator.hasNext()) {
      System.out.print(iterator.next().print() + ", ");
    }
    System.out.println();
  }

  public String decode(byte[] encoding) {
    return "fuck you";
  }

  class HuffmanNode {
    public char value;
    public int count = 1;
    public HuffmanNode[] children;
    public HuffmanNode parent;

    public HuffmanNode(char newChar) {
      this.value = newChar;
      children = new HuffmanNode[2];
    }

    public String print(){
      return value + "(" + count + ")";
    }
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
  }
}
