import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class MaxCoins {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] curr = { 3, 10, 20, 50, 100 };
		Set<Integer> set = new LinkedHashSet();
		for (int i = curr.length - 1; i >= 0; i--) {
			while (num >= curr[i]) {
				num = num - curr[i];
				set.add(curr[i]);
			}
		}

		if (num != 0) {
			System.out.println("Not possible to give denominations");
		} else {
			System.out.println("Deonominations");
			for (Integer i : set) {
				System.out.print(i + ", ");

			}

		}

		/*
		 * 
		 * while (num != 0) { if(max>num){ if(rem_len>0){ rem_len--;
		 * max=availableCoins[rem_len]; }else{
		 * System.out.println("I aint giving you no money"); break; }
		 * 
		 * }else{ System.out.println("sa"); num=num-max; result[j++]=max; }
		 * 
		 * } System.out.println("You Will Receive "+num +
		 * " In denominations => "); j--; for(int k=0;k<=j;k++) {
		 * System.out.print(result[k]+", "); }
		 */
	}

}
