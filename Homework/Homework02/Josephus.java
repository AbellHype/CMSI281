/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File name     :  Josephus.java
*  Purpose       :  This class simulates the josephus problem.
*  Author        :  M. McPartlan & M. Abell
*  Date          :  2018-09-19
*  Description   :
*  Exceptions    :  None
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Arrays;

class Josephus {

  public static int josephus(String[] jArray) {
    for (int jump = 2; jump < jArray.length; jump++) {
      CircularList josephus = new CircularList(jArray);
      // josephus.printList();
      String[] deletionOrder = new String[jArray.length - 1];
      int deleted = 0;
      int count = 1;
      while (deleted < jArray.length - 1) {
        count += 1;
        josephus.step();
        if (count == jump) {
          count = 1;
          String prevLoc = josephus.current.value;
          deletionOrder[deleted] = josephus.delete();
          // josephus.printList();
          josephus.find(prevLoc);
          deleted += 1;
        }
      }
      if (josephus.current.value == "Josephus") {
        System.out.println("Deletion Order: " + Arrays.toString(deletionOrder));
        return jump;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int jArrayL = Integer.parseInt(args[0]);
    int jPosition = Integer.parseInt(args[1]);

    String[] jArrayG = new String[jArrayL];
    for (int iJ = 0; iJ < jArrayL; iJ++) {
      jArrayG[iJ] = String.valueOf(iJ + 1);
      if (iJ == jPosition - 1) {
        jArrayG[iJ] = "Josephus";
      }
    }

    System.out.println("Count by: " + josephus(jArrayG));
  }
}
