
/** This Class is used to Find One Missing Number and  Two Missing Numbers from an Array Using XOR operations
 * 
 * Steps For Finding Two Missing Numbers:
 * Step 1: Find the XOR of all the Elements in the array and the elements from 1 to array length plus 2
 * Step 2: The output from step 1 gives you all XOR of the missing elements in this case the XOR of two missing numbers
 * Step 3: Now Find the set bit the result from step 2 by using Result & ~ ( Result - 1 )
 * Step 4: Now Separate the elements whose last bit is set and not set 
 * Step 5: XOR the separated elements, two different sets will contain the result
 * 
 * 
*/
public class MissingNumber {

	public void findOne(int[] arr){
		if(arr.length==0 || arr==null){
			System.out.println("Array is Empty");
		}else{
			int missingNum=arr[0];
			//Getting the XOR of all the elements of the array 
			for(int i=1;i<arr.length;i++){
				missingNum=missingNum^arr[i];
			}
			//Getting the XOR of the elements from 1 to n and Xoring with the Previous Results
			for(int i=1;i<=arr.length+1;i++){
				missingNum=missingNum^i;
			}
			//After XOR the result will have the missing element
			System.out.println("Missing Number is : " + missingNum);
		}
	}
	

	//This method is used to find the two missing elements
	public void findTwoMissing(int[] arrTwo){
		
		int x=0, y=0;
		int XORresult=arrTwo[0];
		
		//Xoring the elements of the Input Array
		for(int i=1;i<arrTwo.length;i++){
			XORresult^=arrTwo[i];
		}
		
		//XOring the elements till the array
		for(int i=1;i<=arrTwo.length+2;i++){
			XORresult^=i;
		}
		
		//Now XOR contains the XOR of Two Missing Elements
		System.out.println("XORResult => "+XORresult);
		//Dividing the array into two part on the basis of the first set bit
		int set_bit = XORresult & ~(XORresult-1);
		
		
		
		//Separating the elements on in the array on the basis of set bits
		for(int i=0;i<arrTwo.length;i++){
			if((set_bit & arrTwo[i])!=0){
				x^=arrTwo[i];
			}else{
				y^=arrTwo[i];
			}
		}
		
		//Separating the elements from 1 to N on the basis of Set Bit
		for(int i=1;i<=arrTwo.length+2;i++){
			if((set_bit & i)!=0){
				x^=i;
			}else{
				y^=i;
			}
		}
		
		System.out.println("First Missing Number is : " + x);
		System.out.println("Seconde Missing Number is : "+ y);
	}
	
	
	
	
public static void main(String[] args){
		int[] arr={1,2,3,4,5,6,8};
		MissingNumber missingNumber=new MissingNumber();
		missingNumber.findOne(arr);
		
		int[] arrTwo={1,3,4,5,6,8};
		missingNumber.findTwoMissing(arrTwo);
	}
}
