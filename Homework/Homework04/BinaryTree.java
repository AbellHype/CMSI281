public class BinaryTree {
   public static void main( String[] args ) {
      BinaryTreeNode root = new BinaryTreeNode( 0 );
      root.add( 1, "L" );
      root.add( 2, "R" );
      BinaryTreeNode one = root.getChild( "L" );
      BinaryTreeNode two = root.getChild( "R" );
      one.add( 3, "L" );
      one.add( 4, "R" );
      two.add( 5, "L" );
      two.add( 6, "R" );
      BinaryTreeNode six = two.getChild( "R" );
      six.add( 7, "L" );
      six.add( 8, "R" );
      root.inOrderTraversal();
   }
}
