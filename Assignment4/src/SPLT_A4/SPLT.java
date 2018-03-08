package SPLT_A4;

public class SPLT implements SPLT_Interface {
	public BST_Node root;
	int size;
	  
	public SPLT(){
		size = 0;
		root = null;
	}
	  
	@Override
	//used for testing, please leave as is
	public BST_Node getRoot(){
		return root;
	}

	@Override
	public void insert(String s) { //It was me
		// TODO Auto-generated method stub
		if (empty()) {
			root = new BST_Node(s);
//			size += 1;
			//success, insert as root
		} else {
			root = root.insertNode(s); // insert
		}
		if (root.justMade){
			size += 1;
			root.justMade = false;
		}
			
			//success, insert node
		
	}

	@Override
	public void remove(String s) {  //DIO
		// TODO Auto-generated method stub
		if (root == null){
			
		}
		if (!contains(s));{
			
		}
		
		if (root.left == null){
			root = root.right;
		} else {
			BST_Node right = this.root.right;
			if (right == null){
				root = root.left;
			} else {
				root = root.left.findMax();
			}
			if (right != null) {
				root.right = right;
			}
			if (root.right != null){
				root.right.par = root;
			}
		}
		if (root != null) {
			root.par = null;
		}
		size -= 1;
	}
	
	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if (empty()) {
			return null;
		} else {
			root = root.findMin();
			return root.data;
			
		}
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (empty()) {
			return null;
		} else {
			root = root.findMax();
			return root.data;
		}
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
		if (empty()) {
			return false;
		}
		root = root.containsNode(s);
		return root.data.equals(s);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		if (empty()) {
			return -1;
		} else {
			return root.getHeight();
		}
	}

	
}
