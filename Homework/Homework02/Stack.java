/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File name     :  Stack.java
*  Purpose       :  This class uses a circular list to implement a stack.
*  Author        :  M. McPartlan & M. Abell
*  Date          :  2018-09-19
*  Description   :
*  Exceptions    :  None
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Arrays;

class Stack {
  public CircularList internalStack;
  private String stackEnd;

  public Stack() {
    String[] init = {""};
    this.internalStack = new CircularList(init);
  }

  public void push(String newVal){
    if (newVal == "") {
      throw new IllegalArgumentException("Cannot push null to stack.");
    } else {
      this.internalStack.insert(newVal);
    }
  }

  public String pull(){
    if (this.internalStack.getSize() > 1) {
      String retValue = internalStack.delete();
      internalStack.find("");
      return retValue;
    } else {
      throw new ArrayIndexOutOfBoundsException("Stack underflow");
    }
  }

  public void printStack(){
    System.out.print("[");
    this.internalStack.step();
    for (int i = 1; i < this.internalStack.getSize(); i++) {
      if (i == this.internalStack.getSize() - 1) {
        System.out.print(this.internalStack.current.value);
      } else {
        System.out.print(this.internalStack.current.value + ", ");
      }
      this.internalStack.step();
    }
    System.out.println("]");
    this.internalStack.find("");
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    String[] testArray = {"this", "is", "a", "test", "array", "of", "strings"};
    System.out.println("Pushing memory to stack...");
    for (int i = testArray.length - 1; i >= 0; i--) {
      stack.push(testArray[i]);
      testArray[i] = "";
    }
    System.out.println("Memory: " + Arrays.toString(testArray));
    System.out.print("Stack: ");
    stack.printStack();
    System.out.println("Pulling memory from stack...");
    for (int i = 0; i < testArray.length; i++) {
      testArray[i] = stack.pull();
    }
    System.out.println("Memory: " + Arrays.toString(testArray));
    System.out.print("Stack: ");
    stack.printStack();
  }
}
