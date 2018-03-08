package BST_A2;

public class BST_Node {
  String data;
  String temp;
  BST_Node left;
  BST_Node right;
  
  
  

  BST_Node(String data){ this.data=data; }

  BST_Node current;
  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------


  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations


  public boolean containsNode(String s){

          if (this.data.compareTo(s) == 0) {
              return true;
        }

          if(this.data.compareTo(s) > 0) {
              if(this.left == null) {
                  return false;
              }
            return this.left.containsNode(s);
        }else if(this.data.compareTo(s) < 0) {
            if(this.right == null) {
                return false;
            }
            return this.right.containsNode(s);
        }
      return false;
      }

  public boolean insertNode(String s){

          if(this.data.compareTo(s) > 0) {
        	  if (this.left == null){
              this.left = new BST_Node(s);
              return true;
        	  }
          }
          if (this.data.compareTo(s) < 0) {
        	  if (this.right == null){
              this.right = new BST_Node(s);
              return true;
        	  }
          }

          if(this.data.compareTo(s) > 0) {
              
                  return this.left.insertNode(s);
              
          } else if (this.data.compareTo(s) < 0) {
              
                 return this.right.insertNode(s);
          
          }


  return false;
  }


  public boolean removeNode(String s, BST_Node parent){
     BST_Node remove = null;
   //   BST_Node remove = this.getNode(s, parent);
     
     
	  if (this.data.compareTo(s) == 0) {
		  remove = this;
		  
    }
      if(this.data.compareTo(s) > 0) { 
    	  if(this.left == null){
    		//  return null;
    	  }
    	  parent = this;
        return this.left.removeNode(s, parent);
        
    }else if(this.data.compareTo(s) < 0) {
    	if(this.left == null){
    	//	return null;
    	}
    	parent = this;
        return this.right.removeNode(s, parent);
        
    }
       System.out.println("The parent is:" + parent.getData());
	  
      
       
    
      
    	  if (remove.left == null && remove.right == null){
    		  System.out.println("You are here");
    		  if (remove.data.compareTo(parent.data) < 0){
    			
    			   parent.left = null;
    		  } else if (remove.data.compareTo(parent.data) > 0){
    			  
    			   parent.right = null;
    		  }
    		  return true;
    	  }
    	  if (remove.left == null && remove.right != null){
    		  if (parent.data.compareTo(remove.data) > 0){
    			  parent.left = remove.right.findMin();
    			  removeNode(remove.right.findMin().getData(), remove.right);
    			  return true;
    		  }
    		  if (parent.data.compareTo(remove.data) < 0){
    			  parent.right = remove.right.findMin();
    			  removeNode(remove.right.findMin().getData(), remove.right);    			  
    			  return true;
    		  }
    	  }
    	  if (remove.left != null && remove.right == null){
    		  if (parent.data.compareTo(remove.data) > 0){
    			  parent.left = remove.left.findMax();
    			  removeNode(remove.left.findMax().getData(), remove.left);
    			  return true;
    		  }
    		  if (parent.data.compareTo(remove.data) < 0){
    			  parent.left = remove.left.findMax();
    			  removeNode(remove.left.findMax().getData(), remove.left);
    			  return true;
    		  }
    	  }
    	  if (remove.left != null && remove.right != null){
    		  String toRemove = remove.right.findMin().getData();
    		  remove.data = toRemove;
    		  return remove.right.removeNode(toRemove, remove);
    	  }
      return false;
      }

  public BST_Node findMin(){

      if (this.left != null) {
    	  return this.left.findMin();
      } else {
          return this;
      }

  }
  public BST_Node findMax(){
      if (this.right != null) {
          return this.right.findMax();
      } else {
          return this;
      }
  }
  public int getHeight(){
	  if (this.left == null && this.right == null){
		  return 0;
	  }
	  if (this.left != null && this.right == null){
		  
		  return this.left.getHeight()+1;
	  }
	  if (this.left == null && this.right != null){
		  return this.right.getHeight()+1;
	  }
	  if (this.left != null && this.right != null){
		  int leftHeight = this.left.getHeight();
		  int rightHeight = this.right.getHeight();
		  if(leftHeight > rightHeight){
			  return leftHeight+1;
		  } else {
			  return rightHeight+1;
		  }
		}
      return 0; }


  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------

  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
  public BST_Node getNode(String s, BST_Node parent){
	 
	  if (this.data.compareTo(s) == 0) {
          return this;
    }
      if(this.data.compareTo(s) > 0) { 
    	  if(this.left == null){
    		  return null;
    	  }
    	  parent = this;
        return this.left.getNode(s, parent);
        
    }else if(this.data.compareTo(s) < 0) {
    	if(this.left == null){
    		return null;
    	}
    	parent = this;
        return this.right.getNode(s, parent);
        
    }
      return null;
  }
}