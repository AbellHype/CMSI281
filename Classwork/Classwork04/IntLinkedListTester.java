//IntLinkedListTester.java
//Written by Matthew Abell and B.J. Johnson
//9/20/18
//This program creates an instance of a linked list to test methods

public class IntLinkedListTester {
   
   public static void main( String[] args ) {
      IntLinkedList myList = new IntLinkedList();
      myList.prepend( 23 );
      myList.prepend( 19 );
      myList.prepend( 17 );
      myList.prepend( 13 );
      myList.prepend( 11 );
      myList.prepend(  7 );
      myList.prepend( 9 );
      myList.insertAt(0,8);
      myList.insertAt(4,43);
      myList.insertAt(9,5);
      IntLinkedList.Iterator myIt = myList.getIteratorAt( 0 );
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 0
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 1
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 2
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 3
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 4
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 5
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 6
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 7
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 8
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 9
      myList.removeAt(0);
      myList.removeAt(8);
      myList.removeAt(5);
      myIt = myList.getIteratorAt( 0 );
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 0
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 1
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 2
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 3
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 4
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 5
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 6
   }
}
