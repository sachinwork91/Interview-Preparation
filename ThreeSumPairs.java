import java.util.HashMap;

public class ThreeSumPairs {

	
	
	public void findSum(int[] arr){
		int n=arr.length;
		
		HashMap<Integer,String> map=new HashMap<Integer, String>();
	
		for (int i = 0; i < n - 1; i++) {
			map.clear();
			for (int j = i + 1; j < n; j++) {
				if (map.containsKey(-(arr[i] + arr[j]))) {
				 System.out.println(arr[i]+", "+arr[j]+", "+ -(arr[i] + arr[j]));		
				}else{
					map.put(arr[j], "");
				}
			}
		}
	}
		
		
		
		
		/*	for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				map.put(-(arr[i]+arr[j]),arr[i]+" "+arr[j]  );	
			}
		}
		
		
		for(int i=0; i<n ;i++){
			System.out.println();
			if(map.containsKey(arr[i])){
				System.out.println(map.get(i)+" "+arr[i]);
			}
		}
	*/	
		
	
	
	
	
	
	
	public static void main(String[] args){
		
		ThreeSumPairs pair=new ThreeSumPairs();
		int[] arr={0, -1, 2, -3, 1};
		pair.findSum(arr);
		
		
	}
	
}
