package MinBinHeap_A3;

import java.util.NoSuchElementException;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size = 0;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }

@Override
public void insert(EntryPair entry) {
	// TODO Auto-generated method stub
	if(this.isFull()){
		throw new NoSuchElementException("This has overflowed");
	}
	if(size == 0){
		array[1] = entry;
	}
	array[++size] = entry;

	bubbleUp(size);
}

@Override
public void delMin() {
	// TODO Auto-generated method stub
	if( isEmpty() == true){
		return;//void
	}
	swap(size, 1);
	array[size] = null;
	size--;
	
	bubbleDown(1);
			
}

@Override
public EntryPair getMin() {
	// TODO Auto-generated method stub
	if (isEmpty() == true){
		return null;
	}
	return array[1];
}

@Override
public int size() {
	// TODO Auto-generated method stub
	if (size < 0){
		size = 0;
	}
	return size;
}

@Override
public void build(EntryPair[] entries) {
	// TODO Auto-generated method stub
	size = entries.length;
	
	for(int n = 0; n < entries.length; n++){
		array[n+1] = entries[n];
	}
	for(int t = size/2; t > 0; t--){
	bubbleDown(t);
	}
	}
//Helper method to determine if the heap is empty
public boolean isEmpty(){
	if (size == 0){
		return true;
	}
	return false;
}
//Helper method to determine if the heap is full
public boolean isFull(){
	if (array.length == size){
		return true;
	}
	return false;
}

private int parentOf(int index){
	return (index)/2;
}
private boolean hasParent(int index){
	if (index > 1){
		return true;
	}
	return false;
}

private int parentIndex(int index){
	return index / 2;
}


private void bubbleUp(int index) {

		
	while (hasParent(index) && compareTo(array[parentOf(index)].getPriority(), array[index].getPriority()) > 0){
		System.out.println("entered");
		              swap(index, parentIndex(index));
		              
		              index = parentIndex(index);
		              bubbleUp(index);
	}
}

private void bubbleDown(int index){
	
	
	while (hasLeftChild(index)){
		int smaller = leftIndex(index);
		if (hasRightChild(index) && compareTo(array[leftIndex(index)].getPriority(), array[rightIndex(index)].getPriority())> 0){
			smaller = rightIndex(index);
		}
		if (compareTo(array[index].getPriority(), array[smaller].getPriority()) > 0){
			swap(index, smaller);
			bubbleDown(smaller);
		} else{
			break;
		}
		
	}
}

private int compareTo(int x, int y){
	if(x < y){
		return -1;
	}
	if(x > y){
		return 1;
	}
	if(x == y){
		return 0;
	}
	return 0;
}

private boolean hasLeftChild(int index){
	return leftIndex(index) <= size;
}

private boolean hasRightChild(int index){
	return rightIndex(index) <= size;
}

private int leftIndex(int index){
	return index * 2;
}

private int rightIndex(int index){
	return index * 2 + 1;
}


private void swap (int index1, int index2){
	EntryPair temp = array[index1];
	array[index1] = array[index2];
	array[index2] = temp;
}

}