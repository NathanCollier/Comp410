package BST_A2;

public class BST_Playground {
/*
 * you will test your own BST implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create BST objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and height, and looking at the BST_Nodes
 * to see if they are all linked up correctly for a BST
 *
*/

  public static void main(String[]args){

      BST testList0 = new BST();
      testList0.insert("B");
    // testList0.insert("A");
      testList0.insert("D");
      testList0.insert("C");
      testList0.insert("E");
      testList0.remove("B");
	  /*
	  BST testList1 = new BST();
      testList1.insert("B");
      testList1.insert("A");
      testList1.insert("D");
      testList1.insert("C");
      
      BST testList2 = new BST();
      testList2.insert("B");
      testList2.insert("A");
      testList2.insert("D");
      testList2.insert("C");
      testList2.insert("E");
      */
//      System.out.println("Min is:");
//      System.out.println(testList0.findMin());
//      System.out.println("Max is:");
//      System.out.println(testList0.findMax());
//      
     System.out.println(testList0.height());
     printLevelOrder(testList0);
//      
   // you should test your BST implementation in here
   // it is up to you to test it thoroughly and make sure
   // the methods behave as requested above in the interface

   // do not simple depend on the oracle test we will give
   // use the oracle tests as a way of checking AFTER you have done
   // your own testing

   // one thing you might find useful for debugging is a print tree method
   // feel free to use the printLevelOrder method to verify your trees manually
   // or write one you like better
   // you may wish to print not only the node value, and indicators of what
   // nodes are the left and right subtree roots,
   // but also which node is the parent of the current node

  }

  static void printLevelOrder(BST tree){
  //will print your current tree in Level-Order...
  //https://en.wikipedia.org/wiki/Tree_traversal
    int h=tree.getRoot().getHeight();
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }

  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
  static void printInOrder(BST_Node root){
  //will print your current tree In-Order
  if(root!=null){
    printInOrder(root.getLeft());
    System.out.print(root.getData() + " ");
    printInOrder(root.getRight());
  }
  }
}