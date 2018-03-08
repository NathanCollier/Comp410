/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  Node temp;
  Node current;
  int size = 0;
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
    sentinel.next = sentinel;
    sentinel.prev = sentinel;
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }

@Override
public boolean insert(double elt, int index) {
	Node current = new Node(elt);
	// TODO Auto-generated method stub
	//Tests if the desired index is in the list
	if (index > size() || index < 0) {
		return false;
	}else if (isEmpty() == true && index != 0){//Tests if the list is empty
		return false;
	} else if (isEmpty() == true){
		current.next = sentinel;
		current.prev = sentinel;
		sentinel.next = current;
		sentinel.prev = current;
		return true;
	} else if (index >= size()){ //Tests to see if the insert is at the end of the list
		current = sentinel.prev;
		size++;
		return true;
	} else {
		//Iterates through the list
		 	current=sentinel.next; // the first data node in the list is the one after sentinel. 
		    System.out.print("sentinel");
		    for(int i=0; i<size; i++) { 
		    	if (i == index){
		    		temp.next = current;
		    		temp.prev = current.prev;
		    		temp.prev.next = temp;
		    		current.prev = temp;
		    	}
		      System.out.print(" --> " + current.data);
		      current=current.next;
		    }
		    size++;
		    return true;
	}

}

@Override
public boolean remove(int index) {
	// TODO Auto-generated method stub
	//Tests if the desired index is in the list
	if (index > size() || index < 0) {
		return false;
	}
	//Tests if the list is empty
	if (this.isEmpty() == true){
		return false;
	} else if (index >= size()){ //Tests to see if the insert is at the end of the list
		current = sentinel.prev;
		size--;
		return true;
	} else {
		//Iterates through the list
		 	current=sentinel.next; // the first data node in the list is the one after sentinel. 
		    System.out.print("sentinel");
		    for(int i=0; i<size; i++) { 
		    	if (i == index){
		    		current.prev.next = current.next;
		    		current.next.prev = current.prev;
		    	}
		      System.out.print(" --> " + current.data);
		      current=current.next;
		    }
		    size--;
		    return true;
	}

}

@Override
public double get(int index) {
	current=sentinel.next; // the first data node in the list is the one after sentinel. 
   	if(index > size-1 || size==0 ){
		return Double.NaN;
	}else{
    for(int i = 0; i < index; i++) { 
    		current=current.next;
    	}
    	
    
    return current.data;
	}
}

@Override
public int size() {
	return size;
	
}

@Override
public boolean isEmpty() {
	if (size() == 0){
	return true;
	} else {
		return false;
	}
}

@Override
public void clear() {
	sentinel.next = null;
	sentinel.prev = null;
    	size = 0;
	
}
}