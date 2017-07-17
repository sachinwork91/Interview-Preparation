

 /*
 * >>> This is unsigned bit shift operator i.e it shifts the bits including the sign bits
 * >>  This is signed bit shift operator i.e it shifts the bits and the puts the sign bit in the newly shifted bits 
 *
 *  Operators : 
 * a & b = 12
 * a | b = 61
 * a ^ b = 49
 * ~a = -61
 * a << 2 = 240
 * a >> 15
 * a >>> 15

 *
 */
public class Bits {

	
	
	public int singleElement(int[] arr) {
		int a = arr[0];
		for (int i = 1; i < arr.length; i++) {
			a = a ^ arr[i];
		}
		return a;
	}
	
	
	public static void main(String[] args){
		Bits bits=new Bits();
	int a=1;
	int b=1;
//	System.out.println(a^b);
	int[] arr={1,2,2,3,3,4,5,4,5,1,10};
	System.out.println("res => "+bits.singleElement(arr));
	System.out.println(0^1);
	int[] temp={1,2,3,5,6};
	
	
	bits.retSingle(arr);
	
	//Checking the Signs of the numbers
	int num1=1;
	int num2=-2;
	bits.checkOppSign(num1, num2);

	
	num1=1;
	num2=2;
	bits.checkOppSign(num1, num2);
	
	
	//This function is used to count the set bits till a number n
	bits.countSetBits(-1);
	
	
	//THis function performs the bitwise addition of two positive numbers
	bits.add(3, 3);
	
	bits.minOfTwo(-1,-2);
	bits.minOfThree(-1,-1, -1);
	
	
	//Set the Bits at nth position
	bits.setBit(1, 2);
	
	
	//Clearing the Bit at nth Position
	bits.clearBit(3, 0);
	
	//Toggle Bit
	bits.toggleBit(5, 0);
	
	//Stripping the Lowest Set Bit
	bits.stripLowestSetBit(3);
	
	
	
	//Rotate Left
	//229 => 11100101
	bits.leftRotate(91112229, 3);
	
	bits.countSetBits_1(3);
	
	bits.bitsFromAtoB(2,3);
	
	int[] miss={1,2,5,3};
	bits.findMissingTwo(miss, 6);
	
	bits.rev(10);
	
	
	int[] findone={1,3,3,3,2,1,1};
	//Find one
	bits.findone(findone);
	}
	
	
	//This function returns the Element which is appearing only once in an array
	//The other elements should appear in multiples of 2
	//Complexity Time: O(n) Space O(1)
 	public void  retSingle(int[] arr){
		System.out.println("Finding the Single Appearing Element");
		int res=0;
		
		for(int i=0;i<arr.length;i++){
			
			res^=arr[i];
		}
		
		
		System.out.println("The Single Appearing number is => "+res);
		
	}
	
	
 	//This function checks the sign of two passed numbers
 	//The XOR operation gives 1 when the bits are same and 0 when different
 	//The negative numbers have 1 as the last bit and positive have 0
 	// If XOR on last bit gives 1 this implies numbers had same sign
 	public void checkOppSign(int num1, int num2){
 		
 		System.out.println("Checking the Sign of the pass numbers num1: "+num1 + " num2: " + num2);
 		
 		if((num1^num2)>0){
 			System.out.println("Numbers have same sign");
 		}else{
 			System.out.println("Numbers have different sign");
 		}
 		
 		
 	}
	
	
 	

 	//This function is used to find the number of set bits till a number num
 	//Complexity O(nlogn)
 	void countSetBits(int num) {
		int sum = 0;
		System.out.println("Finding the number of Set Bits till number "+ num);
		for (int i = 1; i <= num; i++) {
			sum += countBitsUtil(i);
		}
		System.out.println("Total number of set Bits : " + sum);
	}

	// Count the numbqer of Set Bits in a number
	int countBitsUtil(int num) {
		if (num <= 0)
			return 0;
		return ((num % 2 == 0) ? 0 : 1) + countBitsUtil(num / 2);
	} 	
 	
	
	
	// This function performs the addition of two numbers
	public void add(int num1, int num2) {

		System.out.println("Performing Bitwise Addition of Two Numbers");
		int count = 0;
		while (num2 != 0) {
			int carry = num1 & num2;
			num1 = num1 ^ num2;
			num2 = carry << 1;
		}
		System.out.println("Result of Bitwise Addition of Two NUmbers: " + num1);
	}
	
	
	
	
	
	 /*This function finds the minimum of two numbers
	 * >>> is unsigned bit shift operator
	 * Example x=5,y=6  x-y => x-6 =-1
	 * -1=> binary representation 1000000000000000000000000000000 
	 *                            ^ is the MSB 
	 * now when we shift this 31 times the result is 0000000.....1
	 * 
	 * 
	 * >> is the signed bitwise operator i.e it retains the sign and puts it in the new shifted bits 
	 * x=5, y=6 x-y=> 5-6 =>-1 
	 * -1=> binary representation 1000000000000000000000000000000
	 *  						  ^ is the MSB 	
	 * applying -1>>31  => 10000000.........1   which means -1   
	 *					   ^ the sign is retained and the bits are shifted	
	 */
	public int minOfTwo(int x, int y){
		
		
		System.out.println("Finding the minimum of Two Numbers using >>>: "+x+ " y:"+y);
		int min = x;
		int s = Integer.SIZE-1;
		if((y-min)>>>s==1) min=y;
		System.out.println("Min is => "+min);
		System.out.println("Finding the minimum of Two Numbers using >>: "+x+ " y:"+y);
    	min = x;
		s = Integer.SIZE-1;
		if((y-min)>>s==-1) min=y;
		System.out.println("Min is => "+min);
		return min;
	}
	
	
	
	//This function helps in finding minimum of three numbers
	public void minOfThree(int x, int y , int z){
		System.out.println("Finding the minimum of Three numbers x: "+ x+" y:"+y+" z:"+z);
		int min=minOfTwo(x,y);
		min= minOfTwo(min,z);
		System.out.println("Minimum of Three numbers x:"+ x+" y:"+y+" z:"+z+" is "+ min);
		
	}
	
	
	
	
	//Setting the bit At nth postion
	// We take a number and assign 1
	// Now left shift the number so that the asisgned 1 comes at the position to set the bit 
	// Now Perform OR as if the bit at this position is unset it will be set and remaing will remain same
	// Example Setting 2nd bit for 1 => 0001 
	//									 ^ This is the 2nd bit
	// Setting the  1<<2 => 0100   
	// 0001 | 0100 => 0101 => which results in 5
	public void setBit(int num, int pos){
		
		System.out.println("Setting the bit at "+pos+" for "+num);
		int x=1;
		x=x<<pos;
		System.out.println("Result After setting the Bit => "+(num|x));
	}
	
	
	
	

	// First assign 1 to a number x
	// Shift it till it reaches the position 
	// Now flip the bits of this number so as the current bit becomes 0 and remaining 1
	// Now Perform the And operation , the bit at current will be set to 0 as the current bit was 0
	public void clearBit(int num, int pos){
		int x=1;
		System.out.println("Clearing the Bits at the position "+ pos+ " of "+num);
		//Shifting bits in x;
		x=x<<pos;
		//Inverting the Bits
		x=~x;
		//Now perform and operation on Bits
		System.out.println("Result after Clearing the Bit "+ (num&x));
		
	}
	
	
	
   /** In this method shift 1 to the position at which the bit needs to be toggled	
	 * Perfom XOR operation
	 * 
	 *  1^1 = 0
	 *  0^0 = 0
	 *  1^0 = 1
	 *  0^1 = 1
	 * 
	 * */
	void toggleBit(int num, int pos){
		int x=1;
		
		System.out.println("Toggling a bit at pos:"+pos+" of : "+num );
		//Shifting  by pos
		x=x<<pos;
		
		//Performing XOR to toggle
	    x=x^num;
		System.out.println("Result of Toggling bit :"+x);
		
	}
	
	
	
	
    /**	
	 * This method removes the lowest set bit in a numer 
	 * when we subtract 1 from any number it flips all the bits till it encounters the first set bit
	 * also it flips that bit
	 * Example:  X=1100
	 * Y=X-1   => 1100-0001  =>   1011
	 * Now Perform and Operation on this
	 * As all the bits including the first set bit are flipped we will get number stripped of till 1st bit
	 * result= X&Y =>  1100&1011 => 1000
	 * 
	 **/
	void stripLowestSetBit(int num){
		
		System.out.println("Strippin the lowest set bit of "+num);
		int x=num;
		x=x-1;
		System.out.println("Result After Strippin the Lowest Set Bit => "+(x&num));
		
		
	}
	
	

	
	
	
	 /*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	void leftRotate(int x, int N){
		
		System.out.println("Shifting "+ x+" to Left: "+ Integer.toBinaryString(x) );
		/*int x=num<<32-shift;
		System.out.println("Binary x "+Integer.toBinaryString(x));
		int y=num>>8-shift;
		System.out.println("Binary y "+Integer.toBinaryString(y));
		int res=x|y;
		System.out.println("Result After Shifting => "+y + " Binary Form : "+Integer.toBinaryString(res));
	
	*/ 
		
	   N = N % 32;
	   int res=(x << N | x >> (32 - N));
       System.out.println("Result => " +res+" Binary: "+Integer.toBinaryString(res) );
	
	
	
	}
	
	
	
	
   /** 
	 * This function is used to find the number of bits required to convert from a to b
	 *  A^B sets the bits to 1 where they are different and 0 to where they are same 
	 *  after that we just need to count the bits in the result which are set
	 **/	
	void bitsFromAtoB(int a, int b){
		int res=a^b;
		res=countSetBits_1(res);
		System.out.print("Bits Requeired to Flip from "+a + " to "+ b  + " are : " );
		System.out.print(res);
	}
	
	int countSetBits_1(int num){
		
		int x=num;
		int sum=0;
		while(num>0){
			sum+=num&1;
			num=num>>1;
		}
		System.out.println("Total Number of Set Bits in "+x+" are: "+sum);
		
		return sum;
	}
	
	
	//Finding the two missing elements in an array
	//Steps: XOR all the elements in the array with the expected elements
	//Example {1,3,4,6}
	//XOR all the elements of array   xor^=arr[i]
	//XOR all the elements till the number xor^=1,2..3...6
	//xor results in xor=1^3^4^6^1^2^3^4^5^6
	//which results in xor=2^4   (110)
	//Now get the set bit of the result
	//so start a loop and keep anding(&) with 1 and keeping the count
	//After 1 iteration shift the bits in the xor by 1 towards right
	//if the result is 1 we have reached the first set bit, we have the counter also
	//now separate the elements in the array and the normal loop counter by anding at the position of the set bit
	  	
	void findMissingTwo(int[] arr, int n) {

		int xor = 0;
		//Xoring the elements of array
		for (int i = 0; i < arr.length; i++) {
			xor ^= arr[i];
		}
		//Xoring the elements till the number n
		for (int i = 1; i <= n; i++) {
			xor ^= i;
		}
		// Xor has xor of two elements
		int setbit =xor & ~(xor - 1);
		int p = 0;
		while ((setbit & 1) == 0) {
			p++;
			setbit = setbit >> 1;
		}
		int x = 0;
		int y = 0;
		for (int i = 0; i < arr.length; i++) {
			int res = arr[i] >> p;
			if ((res & 1) == 1) {
				x ^= arr[i];
			} else {
				y ^= arr[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			int res = i >> p;
		if ((res & p) == 1) {
				x ^= i;
			} else {
				y ^= i;
			}
		}

	
		System.out.println("Missing no are: " + x + " other:" + y);

	}	
	
	
	
	
	//
	public void rev(int num){
		int rev=0;
		int count=32;
		System.out.println("Reversing the Bits of Number: "+num);
		System.out.println("Orginal Bits =>"+Integer.toBinaryString(num));
		while(num!=0){
			
			int temp=1;
			temp=num&temp;
			
			rev=rev|temp;
			rev=rev<<1;	
			num=num>>1;
			count--;
		}
		System.out.println("In"+Integer.toBinaryString(rev));
		rev=rev<<count-1;
		
		System.out.println("Reversed Bits =>"+Integer.toBinaryString(rev));
	}
	
	
	
	
	
	
	void findone(int[] arr) {
		System.out.println("Here");
		int[] bitarr = new int[32];

		for (int i = 0; i < arr.length; i++) {

			int num = arr[i];
			int pos = 31;
			while (num != 0) {

				if ((num & 1) == 1) {
					System.out.println("....");
					bitarr[pos]++;

				}
				pos--;
				num = num >> 1;
			}

		}
		System.out.println("next");
		for (int i = 0; i < bitarr.length; i++) {
			bitarr[i] = bitarr[i] % 3;
		}

		for (int i = 0; i < bitarr.length; i++) {
			System.out.print(bitarr[i] + " ");
		}

		int res = 0;

		System.out.println();

		for (int i = 31, j = 0; i >= 0; i--, j++) {
			res += (int) (bitarr[i] * Math.pow(2, j));
		}

		System.out.println("res => " + Integer.toBinaryString(res));
		System.out.println("Missing Number is => " + res);
	}
	
	int missing(int a[],int num){
		
		int[] arr=new int[num];
		
		for(int i=0;i<num;i++){
			arr[i]=i;
		}
		
		int r=arr[arr.length-1];
		int j=0;
		for(int i=0;i<a.length;i++){
			
			j^=a[i]^arr[i];
		}
		
		
		
		
		return r^j;
	}
	
}
