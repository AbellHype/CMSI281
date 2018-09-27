//IntQueue.java
//Written by Matthew Abell and B.J. Johnson
//9/27/18
//This program creates a class for a queue

public class IntQueue {

   IntLinkedList myStack;

   IntQueue() {
      myStack = new IntLinkedList();         // constructor
   }

   //This method adds an int to the back of the queue
   //@param integer value to be added
   public void push( int itemToPush ) {
      myStack.prepend( itemToPush );
   }

   //This method returns the int at the front of the queue
   //@return integer containing value at front of the queue
   public int peek() {
      return myStack.getIteratorAt(myStack.getSize() - 1).getCurrentInt();     // we use the iterator
   }

   //This method returns and removes the int at the front of the queue
   //@return integer containing value at front of the queue
   public int remove() {
      int toRemove = myStack.getIteratorAt(myStack.getSize() - 1).getCurrentInt();
      myStack.removeAt(myStack.getSize() - 1);
      return toRemove;
   }
}   
