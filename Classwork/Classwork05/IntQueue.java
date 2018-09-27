public class IntQueue {

   IntLinkedList myStack;

   IntQueue() {
      myStack = new IntLinkedList();         // constructor
   }

   public void push( int itemToPush ) {
      myStack.prepend( itemToPush );
   }

   public int peek() {
      return myStack.getIeratorAt( 0 ).getCurrentInt();     // we use the iterator
   }

   public int remove() {
      return myStack.removeAt( 0 );
   }
}   
