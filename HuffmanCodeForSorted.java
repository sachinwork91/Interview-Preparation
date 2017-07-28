import java.util.LinkedList;

public class HuffmanCodeForSorted {

	 LinkedList<HuffmanNode> list1=new LinkedList<HuffmanNode>();
	 LinkedList<HuffmanNode> list2=new LinkedList<HuffmanNode>();
	
	
	
	class HuffmanNode{
		char c;
		int data;
		HuffmanNode left, right;
		
		HuffmanNode(char c, int data){
		 this.c=c;
		 this.data=data;
		 left=null;
		 right=null;
		}
		
		HuffmanNode(){
			left=null;
			right=null;
		}
	}
	
	
	public void initializeQueue(HuffmanCodeForSorted.HuffmanNode huffmanNode){
		list1.add(huffmanNode);
	}
	
	
	
	public HuffmanCodeForSorted.HuffmanNode findMin(){
		HuffmanCodeForSorted.HuffmanNode node1= list1.peek();
		HuffmanCodeForSorted.HuffmanNode node2= list1.peek();
		
		if(node1==null){
			return list2.poll();
		}
		if(node2==null){
			return list1.poll();
		}
		if(node1.data>node2.data){
			return list2.poll();
		}else{ return list1.poll();}
		
	
	}
	
	public HuffmanCodeForSorted.HuffmanNode getNewElement(){
		HuffmanCodeForSorted huffman=new HuffmanCodeForSorted();
		
		HuffmanNode node=huffman.new HuffmanNode();
		return node;
	}
	
	public void process(){
		
		while(!list1.isEmpty()){
			System.out.println("Cobvet"+list1.size());
			HuffmanCodeForSorted.HuffmanNode nodeToInsertIn2_1=findMin();
			;
			HuffmanCodeForSorted.HuffmanNode nodeToInsertIn2_2=findMin();
			
			HuffmanCodeForSorted.HuffmanNode huffcode=getNewElement();
			huffcode.data=nodeToInsertIn2_1.data+nodeToInsertIn2_2.data;
			
			System.out.println("Adding to list 2 : "+list2.size());
			System.out.println("Adding to list 2 :data "+nodeToInsertIn2_2.data);
			list2.add(huffcode);
		}
	}
	
	public void print(){
		
		printdata(list2.getLast(),"");	
				
				
	}
	
	public void printdata(HuffmanCodeForSorted.HuffmanNode node, String c){
		
		
		if(node.left==null && node.right==null){
			System.out.println(node.c+ " : "+ c);
		}
		else{
			printdata(node.left,"0");
			printdata(node.right,"1");
		}
		
	}	
	
	
	
	
	public static void main(String[] args){
		
	char[] arr={'a','b','d'};
	int[] freq={1,2,3};

	HuffmanCodeForSorted huffman=new HuffmanCodeForSorted();
	
	for(int i=0;i<arr.length;i++){
		HuffmanNode huffmannode= huffman.new HuffmanNode(arr[i],freq[i]);
		huffman.initializeQueue(huffmannode);
	}
	 	
	huffman.process();
	huffman.print();
	
	}
	

	
}
