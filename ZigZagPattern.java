import java.util.Arrays;



/*
 * We need to take care of the null values which are stored in our result array when we initialize it
 * 
 * */
public class ZigZagPattern {

	public static void main(String[] args) {

		ZigZagPattern obj = new ZigZagPattern();
		System.out.println(obj.convert("GeeksforGeeks", 3));
	}

	public String convert(String str, int row) {

		if (row == 1) {
			System.out.println(str);
			return str;
		} else if (str == null || str.length() == 1) {
			System.out.println(str);
			return str;
		}

		else {

			String[] res = new String[row];

			boolean down = true;
			int row_num = 0;

			StringBuffer[] sb;

			for (int i = 0; i < str.length(); i++) {

				if (res[row_num] == null) {
					res[row_num] = "" + str.charAt(i);
				} else {
					res[row_num] = res[row_num] + str.charAt(i);

				}

				// Last Row Reached ....Move Up
				if (row_num == row - 1) {
					down = false;
				}

				if (row_num == 0) { //Reached the first row
					down = true;
				}

				if (down) {// Moving Down ..increment the row
					row_num++;
				} else {
					row_num--; // Moving Up....decrement the row
				}
			}

			StringBuilder builder = new StringBuilder();
			for (String s : res) {
				if (s != null)
					builder.append(s);
			}
			String st = builder.toString();
			return st;
		}
	}

}
