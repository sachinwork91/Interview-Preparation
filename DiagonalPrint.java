

/* This class is used to print the diagonal elements of a matrix
* Works for BOTH Square and Non Square Matrix
*
* 1  2  3 
* 4  5  6 
* 7  8  9
* 
* output =>  1 
* 			4 2 
* 		  7 5 3 
*          8 6 
*           9	
*
*
*/

public class DiagonalPrint {

public void diagonalPrint(int[][] arr){
		
		
		for(int i=0;i<arr.length;i++){
			
			int row=i;
			int col=0;
			
			while(row>=0 && col<arr[0].length){
				System.out.print(arr[row][col]);
				row--;col++;
			}
			System.out.println(" ");
		}
		int last_row=arr.length-1;
	
		
		//Printing the Lowe Half 
		for(int i=1;i<arr[0].length;i++){
		    int col=i;
			int l=last_row;
		    while(col<arr[0].length)
			{
				System.out.print(arr[l--][col++]);
		
			}
		System.out.println(" ");
		}
		
	}
	
	
	
	
	public static void main(String[] args){
		
		DiagonalPrint dp=new DiagonalPrint();
		int[][] arr= {{1,2,3,4 },
					   {5,6,7,8,},	
					   {9,10,11, 12 }	};
		dp.diagonalPrint(arr);
		
		
		
		
	}
	
}
