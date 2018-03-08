package MinBinHeap_A3;

public class MinBinHeap_Playground {
  public static void main(String[] args){   
    //Add more tests as methods and call them here!!
    TestBuild();
  }
  
  public static void TestBuild(){ 
    // constructs a new minbinheap, constructs an array of EntryPair, 
    // passes it into build function. Then print collection and heap.
    MinBinHeap mbh= new MinBinHeap();
    EntryPair[] collection= new EntryPair[5];
    collection[0]=new EntryPair("a",5);
    collection[1]=new EntryPair("b",4);
    collection[2]=new EntryPair("c",3);
    collection[3]=new EntryPair("d",2);
    collection[4]=new EntryPair("e",1);
   
//    collection[5]=new EntryPair("f",5);
//    collection[6]=new EntryPair("g",6);
//    collection[7]=new EntryPair("h",17);
//   mbh.insert( new EntryPair("a", 3));
//   mbh.insert( new EntryPair("b", 4));
//   mbh.insert( new EntryPair("c", 3));
//   mbh.insert( new EntryPair("d", 2));
//   mbh.insert( new EntryPair("e", 1));
//   mbh.delMin();
 //  mbh.delMin();
//   mbh.insert( new EntryPair("a", 5));
    mbh.build(collection);
    printHeap(mbh.getHeap(), mbh.size());
    mbh.getMin();

   
    //System.out.println(mbh.getHeap()[1].value);
    //System.out.println(mbh.getHeap()(2));
    //System.out.println(mbh.getHeap()(3));
    //System.out.println(mbh.getHeap()(4));
//    printHeapCollection(collection);
   printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void printHeapCollection(EntryPair[] e) { 
    //this will print the entirety of an array of entry pairs you will pass 
    //to your build function.
    System.out.println("Printing Collection to pass in to build function:");
    for(int i=0;i < e.length;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void printHeap(EntryPair[] e,int len) { 
    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1;i < len+1;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
}
