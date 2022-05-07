class MyTree
{
  BinarySearchTree t=new BinarySearchTree();
  
  public static void main(String[] args) throws NullPointerException
  {
    BinarySearchTree t = new BinarySearchTree();
    t.insert(new KeyedItem("M"));
    t.insert(new KeyedItem("J"));
    t.insert(new KeyedItem("W"));
    t.insert(new KeyedItem("D"));
    t.insert(new KeyedItem("L"));
    t.insert(new KeyedItem("S"));
    t.insert(new KeyedItem("Z"));
    t.insert(new KeyedItem("F"));
    t.insert(new KeyedItem("T"));
    
    BinarySearchTree myCopy = new BinarySearchTree();
    myCopy.insert(new KeyedItem("M"));
    myCopy.insert(new KeyedItem("J"));
    myCopy.insert(new KeyedItem("W"));
    myCopy.insert(new KeyedItem("D"));
    myCopy.insert(new KeyedItem("L"));
    myCopy.insert(new KeyedItem("S"));
    myCopy.insert(new KeyedItem("Z"));
    myCopy.insert(new KeyedItem("F"));
    myCopy.insert(new KeyedItem("T"));
    

    System.out.println("This is the inorder traversal");
    t.inorder();

    System.out.println("This is the preoder traversal");
    myCopy.preorder();

    System.out.println("This is the postorder traversal");
    t.postorder();
    
    System.out.println("These trees are the same: "+ t.duplicateCheck(myCopy));
    
    t.delete("M");
    System.out.println("This is the preorder traversal of the tree with the base 'M' deleted");
    t.preorder();
  }

}
