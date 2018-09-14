public class IntList implements IntListInterface {
      private int[] theList;
      private int   size;

      private static final int STARTING_SIZE = 19;    // defines starting size; don't worry, we'll deal

      public IntList() {                        // doesn't HAVE to be declared public, but doesn't hurt
         theList = new int[STARTING_SIZE];
         size = 0;
      }

      public int getValueAtIndex( int index ) {
      if(checkIndex(index)){
         return theList[index];
      }
      return -1; //Just to code to compile, improper index should be handled by checkIndex
      }

      public boolean append( int valueToAdd ) {
         if( size < theList.length ) {
            theList[size] = valueToAdd;
            size++;
            return true;
         } else {
            makeBigger();
            theList[size] = valueToAdd;
            size++;
            return true;
         }
      }

      public boolean prepend(int valuetoAdd) {
         insertValueAtIndex(valuetoAdd, 0);
         return true;
      }

      public boolean insertValueAtIndex( int value, int index ) {
         if (index < theList.length){
            holeMaker(index);
            theList[index] = value;
            return true;
         }
         else{
            while (index >= theList.length){
               makeBigger();
            }
            holeMaker(index);
            theList[index] = value;
            return true;            
         }  
      }

      public int removeValueAtIndex( int index ) {
         if (checkIndex(index)){
            int value = theList[index];
            holeFiller( index );
            return value;
         }
         return -1; //Just to code to compile, improper index should be handled by checkIndex
      }

      private boolean checkIndex(int index) throws ArrayIndexOutOfBoundsException{
         if( size == 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The list is empty!" );   // maybe not the best...
         } else if( index > size ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is too large" );
         } else if( index < 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is too small");
         } else {
            return true;
         }
      }

      private void holeMaker( int index ) {
         for( int i = size - 1; i >= index; i-- ) {
            theList[i+1] = theList[i];
         }
         size++;
      }

      private void holeFiller( int index ) {
         for( int i = index; i < size - 1; i++ ) {
            theList[i] = theList[i+1];
         }
         size--;
      }

      private void makeBigger() {
         int[] newList = new int[theList.length + STARTING_SIZE];
         System.arraycopy(theList, 0, newList, 0, theList.length);
         theList = newList;
      }

      public static void main( String[] args ) {
         IntList list = new IntList();
         list.append( 1 );
         list.append( 2 );
         list.append( 3 );
         list.append( 4 );
         list.insertValueAtIndex(5,25);
      }
   }
