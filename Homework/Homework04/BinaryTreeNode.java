public class BinaryTreeNode {

  private int data;
  private BinaryTreeNode left;
  private BinaryTreeNode right;

  public BinaryTreeNode( int d ) {
      data = d;
      left = null;
      right = null;
  }

  public void add( int s, String child ) {
     child = child.toUpperCase();
     if( child.equals( "L" ) ) {
        left = new BinaryTreeNode( s );
     } else if( child.equals( "R" ) ) {
        right = new BinaryTreeNode( s );
     } else {
        throw new IllegalArgumentException();
     }
  }

  public BinaryTreeNode getChild( String child ) {
     child = child.toUpperCase();
     if( child.equals("L") || child.equals("R") ) {
        return (child.equals("L") ? left : right);
     } else {}
        throw new IllegalArgumentException();
  }

  public int getData() {
    return data;
  }

  public boolean hasChildren(){
    if(left == null && right == null){
      return false;
    }
    else{
      return true;
    }
  }

  public void inOrderTraversal(){
    //System.out.print("R" + data + " ");
    if(hasChildren() == false){
      System.out.print(data);
    }
    else{
      if(left != null){
        if(left.hasChildren() == false){
          System.out.print(left.data);
        }
        else{
          left.inOrderTraversal();
        }
      }
      System.out.print(data);
      if(right != null){
        if(right.hasChildren() == false){
          System.out.print(right.data);
        }
        else{
          right.inOrderTraversal();
        }
      }
    }
  }
}
