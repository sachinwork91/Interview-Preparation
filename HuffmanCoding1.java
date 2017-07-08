import java.util.*;
import java.io.*;

/** Huffman coding is a compression technique. 
 *  We build a min heap depending upon the frequency of the characters.
 *  at the end we starting extracting two smallest elements present in the minheap. 
 *  combine them and make a new element. 
 *  this new element is the inner element holds the sum of frequency of the two characters
 *  we keep repeating the process untill the we are left with only a single element in the heap.
 *  
 *  Here in this code to represent the min heap we are using Priority queues, 
 *  our class implements Comparable interface which helps in compartinog the two elements (used internally by 
 *  priority queue to act as min heap)
 * 
 * 
 * 
 * 
 * */
public class HuffmanCoding1{
	
	public class HeapNode implements Comparable<HeapNode>{
		//frequency
		int freq;
		//character incase of leaf node
		char data;
		//left and right heap nodes
		HeapNode left,right;
		public HeapNode(char c,int f){
			data=c;
			freq=f;
			left=null;
			right=null;
		}
		public HeapNode() {
			left=null;
			right=null;
		} 
		public int compareTo(HeapNode n1){
			return this.freq-n1.freq;
		}
	}
	
	//print the huffman codes of the characters by taking root of heap as parameter
	public void printCodes(HeapNode n1,String code){
		//if current node is leaf,prints the code
		if(n1.left==null && n1.right==null){
			System.out.println(n1.data+" "+code);
		}
		//else calls the method recursively for left and right nodes
		else{
			printCodes(n1.left,code+"0");
			printCodes(n1.right,code+"1");
		}
	}
	
	public static void main(String[] args) throws IOException{
		HuffmanCoding1 test = new HuffmanCoding1();
		PriorityQueue<HuffmanCoding1.HeapNode> pq1 = new PriorityQueue<HuffmanCoding1.HeapNode>();
		char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int freq[] = { 5, 9, 12, 13, 16, 45 };
			
		for(int i=0;i<freq.length;i++){
			HuffmanCoding1.HeapNode n1 = test.new HeapNode(arr[i],freq[i]);
			pq1.add(n1);
		}
		
		
		while(pq1.size()!=1){
			//getting two nodes with least frequencies
			HuffmanCoding1.HeapNode n1=pq1.poll(),n2=pq1.poll(),root=test.new HeapNode();
			//making a new node with the above got node and
			//adding it to priority queue
			root.freq=n1.freq+n2.freq;
			root.left=n1;
			root.right=n2;
			pq1.add(root);
		}
		//calling printCodes method to print huffman codes of individual character
		//by passing root of heap as parameter
		HuffmanCoding1.HeapNode root=pq1.peek();
		test.printCodes(root, "");
	}
}