//IntLinkedList.java
//Written by Matthew Abell and B.J. Johnson
//9/20/18
//This program creates a class for a linked list

public class IntLinkedList {

   private Node head;
   private int  size;

   // the constructor
   IntLinkedList() {
      head = null;
      size = 0;
   }

   public int getSize() {
      return size;
   }

   public void prepend( int dataToAdd ) {
      Node currentHead = head;
      head = new Node( dataToAdd );
      head.next = currentHead;
      size++;
   }

   // @param index is the index where the node will be inserted, dataToAdd is the data that will be added
   //this method inserts a node into the linked list
   public void insertAt(int index, int dataToAdd){
      if(index == 0){
         prepend(dataToAdd);
      }
      else{
         Node ins = new Node(dataToAdd);
         Iterator count = getIteratorAt(index-1);
         ins.next = count.currentNode.next;
         count.currentNode.next = ins;
         size++;
      }
   }


   // @param index is the index where the node will be removed
   //this method removes a node from a linked list
   public void removeAt(int index){
      if(index == 0  && size != 0){
         head = head.next;
         size--;
      }
      else if(index == size){ //this deals with the fringe case when index = size, there is no node there to delete
         throw new IllegalArgumentException();
      }
      else{
         Iterator bef = getIteratorAt(index-1);
         Node newNode = bef.currentNode;
         bef.next();
         bef.next();
         newNode.next = bef.currentNode;
         size--;
      }
   }

   private class Node {

      int data;            // remember this is an IntLinkedList
      Node next;           // here's the self-referential part

      // constructor
      Node( int d ) {
         data = d;
         next = null;
      }
   }

   public Iterator getIteratorAt( int index ) {
      if( (index > size) || (index < 0) ) {
         throw new IllegalArgumentException();
      }
      Iterator it = new Iterator();
      while( index > 0 ) {
         it.next();
         index--;
      }
      return it;
   }

   public class Iterator {
      private Node currentNode;

      Iterator() {
         currentNode = head;
      }

      public void next() {
         if( currentNode == null ) {
            return;
         } else {
            currentNode = currentNode.next;
         }
      }

      public boolean hasNext() {
         return ((currentNode != null) && (currentNode.next != null));
      }

      public int getCurrentInt() {
         return currentNode.data;
      }
   }
}           
