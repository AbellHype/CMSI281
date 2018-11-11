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
  public List<HuffmanNode> characters = Collections.synchronizedList(new ArrayList<HuffmanNode>(0));
  public ListIterator<HuffmanNode> iterator;
  public HuffmanNode root = new HuffmanNode('~');

  public void encode(String inputStr) {
    char[] input = inputStr.toCharArray();
    for (int i = 0; i < input.length; i++) {
      HuffmanNode toAdd = new HuffmanNode(input[i]);
      toAdd.isLeaf = true;
      toAdd.count = 1;
      characters.add(toAdd);
    }
    iterator = characters.listIterator();

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
          if (tempFirst.count > tempSecond.count) {
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
    }

    while (iterator.hasPrevious()) {
      iterator.previous();
    }
    System.out.print("Sorted: ");
    while (iterator.hasNext()) {
      System.out.print(iterator.next().print() + ", ");
    }
    System.out.println();

    while (iterator.hasPrevious()) {
      iterator.previous();
    }

    // Grow the huffman tree

    while (characters.size() > 2) {
      HuffmanNode babyTree = new HuffmanNode('ñ');
      babyTree.children[0] = iterator.next();
      if (iterator.hasNext()) {
        iterator.remove();
        babyTree.children[1] = iterator.next();
        iterator.remove();
        babyTree.count = babyTree.children[0].count + babyTree.children[1].count;
        iterator.add(babyTree);
      } else {
        break;
      }

      // Sort again
      while (iterator.hasPrevious()) {
        iterator.previous();
      }
      boolean sortedSecond = false;
      while (!sortedSecond) {
        sortedSecond = true;
        while (iterator.hasNext()) {
          HuffmanNode tempFirst = iterator.next();
          if (iterator.hasNext()) {
            HuffmanNode tempSecond = iterator.next();
            if (tempFirst.count > tempSecond.count) {
              // Relys on Java passing by reference (hopefully)
              char tfr = tempFirst.value;
              int tfrI = tempFirst.count;
              tempFirst.value = tempSecond.value;
              tempFirst.count = tempSecond.count;
              tempSecond.value = tfr;
              tempSecond.count = tfrI;
              sortedSecond = false;
            }
            iterator.previous();
          }
        }
      }

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

    }
    while (iterator.hasPrevious()) {
      iterator.previous();
    }

    root.children[0] = iterator.next();
    root.children[1] = iterator.next();
    root.count = root.children[0].count + root.children[1].count;
    System.out.println(root.print());

    byte[] binaryNumber = new byte[root.count];
    
    HuffmanNode traverser = root.children[0];
    for (int i = 0; i < root.children[0].count; i++) {

    }

  }

  public String decode() {
    System.out.println(iterator.next().value);
    iterator.previous();
    return "no";
  }

  class HuffmanNode {
    public char value;
    public int count = 0;
    public HuffmanNode[] children;
    public boolean isLeaf = false;

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
    System.out.println("DECODE ===================================");
    //huff.decode();
  }
}
