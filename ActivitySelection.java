import java.util.Arrays;



//This is an Activity Selection Problem
//In this s=> Start time of the Activity
//f=> end time of the Activity
//result prints the indexs of the activities which are selected so as to complete
//the maximum number of activities
public class ActivitySelection {

	
	
	
	public static void main(String[] args){
		 int s[] =  {1, 3, 0, 5, 8, 5};
		 int f[] =  {2, 4, 6, 7, 9, 9};
		 result(s,f);
		
		
	}
//This method assumes that the list is passed sorted based on the finish time	
	public static void result(int[] s, int[] f)
	{
		
		if(s.length>0)
		{  
			int i=0;
			System.out.println("Activity Start => ");
			//Selecting the first activity as it will always be selected
			System.out.print(" "+i);
			//Checking if the start time of the next activity is greater or equal to the previous activity
			// IF yes then we can select this activity
			for(int j=1;j<f.length;j++)
			{
				
				if(s[j]>=f[i]){

					i=j;
					System.out.print(""+i);
				}
				
				
				
			}
			
			
			
			
		}
		
	}
	
	
	
	
}
