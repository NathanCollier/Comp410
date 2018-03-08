package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  public BST_Node current;
  int size;

  public BST(){ size=0; root=null; }

  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

@Override
public boolean insert(String s) {
    // TODO Auto-generated method stub
    if(size == 0) {
        root = new BST_Node(s);
        size++;
        return true;
    } else if(this.contains(s) == true){
        return false;
    } else if(root.insertNode(s) == true) {
            size++;
            return true;
    }
    return false;
}

@Override
public boolean remove(String s) {
    // TODO Auto-generated method stub
	if(size == 0){
		return false;
	} else if (size == 1){
		
		root = null;
		size--;
		return true;
	}else if (this.contains(s) != true){
		return false;
	} else if (s.compareTo(root.getData()) == 0){
	
   	  if (root.left == null && root.right != null){
   	 		 root = root.right.findMin();
   			// removeNode(root.right.findMin().getData(), root.right);
   			  return true;
   		  }
   	
   	  
   	  if (root.left != null && root.right == null){
 
   			  root = root.left.findMax();
   			//  removeNode(remove.left.findMax().getData(), remove.left);
   			  return true;
   		  }

   	  if (root.left != null && root.right != null){
   		  String toRemove = root.right.findMin().getData();
   		  root.data = toRemove;
   		  return root.right.removeNode(toRemove, root);
   	  }

	} else if(root.removeNode(s,null)){
		size--;
		return true;
	}
    return false;
}

@Override
public String findMin() {
    // TODO Auto-generated method stub
	if(size == 0){
		return null;
	}
    return root.findMin().getData();
}

@Override
public String findMax() {
    // TODO Auto-generated method stub
	if(size == 0){
		return null;
	}
    return root.findMax().getData();
}

@Override
public boolean empty() {
    // TODO Auto-generated method stub
    if (size == 0) {
        return true;
    } else {
        return false;
    }
}

@Override
public boolean contains(String s) {
    // TODO Auto-generated method stub
    if (size !=0) {
        if (root.containsNode(s)) {
            return true;
        }
    }
    return false;
}

@Override
public int size() {
    // TODO Auto-generated method stub
    return size;
}

@Override
public int height() {
    // TODO Auto-generated method stub
	if (size == 0){
		return -1;
	}
    return root.getHeight();
}


}
