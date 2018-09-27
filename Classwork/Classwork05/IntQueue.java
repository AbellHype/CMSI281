public class IntQueue {

   IntLinkedList myStack;

   IntQueue() {
      myStack = new IntLinkedList();         // constructor
   }

   public void push( int itemToPush ) {
      myStack.prepend( itemToPush );
   }

   public int peek() {
      return myStack.getIteratorAt(myStack.getSize() - 1).getCurrentInt();     // we use the iterator
   }

   public int remove() {
      myStack.removeAt(myStack.getSize() - 1);
   }
}   
