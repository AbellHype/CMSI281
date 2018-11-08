/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File name     :  OddEven.java
*  Purpose       :  This class uses a circular list to implement a stack.
*  Author        :  M. McPartlan & M. Abell
*  Date          :  2018-09-19
*  Description   :
*  Exceptions    :  None
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Arrays;

class OddEven {
  public static int[] sortOddEven(int[] input) {
    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < input.length - 1; i += 2) {
        // Even cases
        if (input[i] > input[i + 1]) {
          int temp = input[i];
          input[i] = input[i + 1];
          input[i + 1] = temp;
          sorted = false;
        }
      }

      for (int i = 1; i < input.length - 1; i += 2) {
        // Odd cases
        if (input[i] > input[i + 1]) {
          int temp = input[i];
          input[i] = input[i + 1];
          input[i + 1] = temp;
          sorted = false;
        }
      }
    }
    return input;
  }

  //-----------------------------------------------------------
  /**
  * Tests for OddEven class
  * @param  None
  * @return void
  */
  public static void main(String[] args) {
    int[] testArray = {1, 33, 2, 6, 1, 2, 35, 68, 14, 23, -1, -2, 45, -45};
    System.out.println(Arrays.toString(OddEven.sortOddEven(testArray)));

    int[] testArray1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(Arrays.toString(OddEven.sortOddEven(testArray1)));

    int[] testArray2 = {1-1, -2, -3, -4, -5, -6, -7};
    System.out.println(Arrays.toString(OddEven.sortOddEven(testArray2)));

    int[] testArray3 = {2};
    System.out.println(Arrays.toString(OddEven.sortOddEven(testArray3)));

    int[] testArray4 = {1, 2};
    System.out.println(Arrays.toString(OddEven.sortOddEven(testArray4)));

    int[] testArray5 = {4, 2, 2, 1, 0, -1, -2, -3};
    System.out.println(Arrays.toString(OddEven.sortOddEven(testArray5)));

    int[] testArray6 = {1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    System.out.println(Arrays.toString(OddEven.sortOddEven(testArray6)));

    int[] testArray7 = {-45, 1};
    System.out.println(Arrays.toString(OddEven.sortOddEven(testArray7)));

    int[] testArray8 = {19, 2, 3, 4, 5, 6, 1, };
    System.out.println(Arrays.toString(OddEven.sortOddEven(testArray8)));

    int[] testArray9 = {0, 0, 1};
    System.out.println(Arrays.toString(OddEven.sortOddEven(testArray9)));
  }
}
