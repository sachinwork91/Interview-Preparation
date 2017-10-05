
/* * This a program which helps in counting the number of islands represented in a matrix
 *   also the size of the matrix  
 * 
 * */
public class NumberOfIslands {

	
	static int count=0;
	int getRegion(int[][] matrix, int r, int c) {

		if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[r].length) {
			return 0;
		}

		if (matrix[r][c] == 0) {
			return 0;
		}

		matrix[r][c] = 0; // This is done to keep the track of the visited

		int size = 1;
	
		
		//Here we are checking for three rows and three columns basically around the current element
		for (int row = r - 1; row <= r + 1; row++) {
			for (int col = c - 1; col <= c + 1; col++) {

				if (row != r || col != c)			// To check not repeating itself
					size += getRegion(matrix, row, col);
			}
		}
		return size;
	}

	

	int getBiggestRegion(int[][] matrix) {

		int biggestRegion = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == 1) {

					int size = getRegion(matrix, row, col);
					biggestRegion = Math.max(biggestRegion, size);
					//if(biggestRegion>0){
					//	count++;
					//}
					count++;
				}

			}

		}

		return biggestRegion;
	}

	int count_islands(int[][] islands) {

		return getBiggestRegion(islands);
	}

	public static void main(String[] args) {

		int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
						   		{   1, 1, 0, 0, 1 }, 
								{   1, 1, 0, 1, 1 },
								{   0, 0, 0, 0, 0 },
								{   1, 0, 1, 0, 1 } };
								
								
								

		NumberOfIslands islands = new NumberOfIslands();

		System.out.println("count => " + islands.count_islands(M));
		System.out.println("Total Islands => "+count);
	}

}
