package SPLT_A4;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node par;
	boolean justMade;
	
	BST_Node(String data){
		this.data=data;
		this.justMade = true;
	}
	
	BST_Node(String data, BST_Node left,BST_Node right, BST_Node par){ //feel free to modify this constructor to suit your needs
	    this.data=data;
	    this.left=left;
	    this.right=right;
	    this.par=par;
	    this.justMade=true;
	  }
	
	
	public String getData(){
		return data;
	}
	public BST_Node getLeft(){
		return left;
	}
	public BST_Node getRight(){
		return right;
	}
	
	public BST_Node containsNode(String s){ //it was me
		if(data.equals(s)){
			splay(this);
			return this;
		}
		if(data.compareTo(s)>0){//s lexiconically less than data
			if(left!=null){
			return left.containsNode(s);
			} else {
				splay(this);
				return this;
			}
		}
		if(data.compareTo(s)<0){
			if(right!=null){
			return right.containsNode(s);
			} else {
				splay(this);
				return this;
			}
		}
		return null; //shouldn't hit  //concerned
	}
	
	
	public BST_Node insertNode(String s){
		if (s.compareTo(this.data) < 0) {
			if (this.left != null){
				return this.left.insertNode(s);
			}
			this.left = new BST_Node(s, null, null, this);
			BST_Node root = this.left;
			splay(this.left);
			return root;
		}
		if (s.compareTo(this.data) > 0) {
			if (this.right != null){
				return this.right.insertNode(s);
			}
			this.right = new BST_Node(s, null, null, this);
			BST_Node root = this.right;
			splay(this.right);
			return root;
		}
		splay(this);
		return this;
		
	
	}
	public BST_Node findMin(){
		if(left!=null){
			return left.findMin();
		}		
		splay(this);
		return this;
	}
	public BST_Node findMax(){
		if(right!=null){
			return right.findMax();
		}
		splay(this);
		return this;
	}
	public int getHeight(){
		int l=0;
		int r=0;
		if(left!=null)l+=left.getHeight()+1;
		if(right!=null)r+=right.getHeight()+1;
		return Integer.max(l, r);
	}
	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")+",Right: "+((this.right!=null)?right.data:"null");
	}
	
	private void rotateRight(BST_Node a) {
		BST_Node b = a.par;
		if (b.par != null) {
			if (b != b.par.left) {
				b.par.right = a;
			} else {
				b.par.left = a;
			}
		}
		if (a.right != null) {
			a.right.par = b;
		}
		a.par = b.par;
		b.par = a;
		b.left = a.right;
		a.right = b;
		}

	private void rotateLeft(BST_Node a) {
		BST_Node b = a.par;
		if (b.par != null) {
			if (b != b.par.left) {
				b.par.right = a;
			} else {
				b.par.left = a;
			}
		}
		if (a.left != null) {
			a.left.par = b;
		}
		a.par = b.par;
		b.par = a;
		b.right = a.left;
		a.left = b;
		}
	
	public void splay(BST_Node toSplay) {
		while (toSplay.par != null) {
			BST_Node pap = toSplay.par;
			BST_Node grandpap = pap.par;
			if (grandpap == null) { 			//right under the root
				if (toSplay == pap.left) { 		// to the left of the root
					rotateRight(toSplay);
				} else { 						// then it is to the right of root
					rotateLeft(toSplay);
				}
			} else if (toSplay == pap.left) { 	// to the left of parent
				if (pap == grandpap.left) {		// to the far left of grandparent
					rotateRight(toSplay);
					rotateRight(toSplay);
				} else { 						// zig then zag (LR) of grandparent
					rotateRight(toSplay);
					rotateLeft(toSplay);
				}
			} else if (toSplay == pap.right) {	// to the  right of parent
				if (pap == grandpap.right) { 	// to the far right of grandparent
					rotateLeft(toSplay);
					rotateLeft(toSplay);
				} else { 						// zag then zig (RL) of grandparent
					rotateLeft(toSplay);
					rotateRight(toSplay);
				}
			}
		}
	}
}
