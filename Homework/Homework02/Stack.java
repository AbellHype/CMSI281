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
  private String topOfStack;

  //-----------------------------------------------------------
  /**
  * Constructor for Stack class.
  * @param  None
  * @return void
  */
  public Stack() {
    String[] init = {""};
    this.internalStack = new CircularList(init);
  }

  //-----------------------------------------------------------
  /**
  * Pushes the string parameter given as the next element of internalStack.
  * @param  newVal string element to be pushed onto stack.
  * @return void
  */
  public void push(String newVal){
    this.internalStack.insert(newVal);
  }

  //-----------------------------------------------------------
  /**
  * Pulls and deletes the top of the stack. Returns value pulled.
  * @param  None
  * @return String value of pulled node.
  */
  public String pull(){
    if (this.internalStack.getSize() > 1) {
      String currValue = internalStack.current.value;
      String retValue = internalStack.delete();
      internalStack.find(currValue);
      return retValue;
    } else if (this.internalStack.getSize() == 1){
        String retValue = this.internalStack.current.value;
        this.internalStack.current.value = "";
        return retValue;
    } else {
      throw new ArrayIndexOutOfBoundsException("Stack underflow");
    }
  }

  //-----------------------------------------------------------
  /**
  * Prints the current value of the stack to the terminal.
  * @param  None
  * @return void
  */
  public void printStack(){
    this.internalStack.printList();
  }

  //-----------------------------------------------------------
  /**
  * Tests for Stack class
  * @param  None
  * @return void
  */
  public static void main(String[] args) {
    Stack stack = new Stack();
    String[] testArray = {"this", "is", "a", "test", "array", "of", "strings"};
    System.out.println("Pushing memory to stack...");
    stack.internalStack.printList();
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
