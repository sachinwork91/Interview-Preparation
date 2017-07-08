import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ActivitySelectionUnsorted {

	
	public static void main(String[] args)
	{
		
		
		System.out.println("How many Activities you want to enter ? ");
		Scanner sc=new Scanner(System.in);
		int list_size=sc.nextInt();
		
		Map<Integer, Integer> map=new HashMap();
		int key=0;
		int value=0;
		for(int i=0;i<list_size;i++)
		{
			System.out.println("Enter Start Time : ");
			value=sc.nextInt();
			System.out.println("Enter End Time : ");
			key=sc.nextInt();
			map.put(key, value);
		}
		
		Map<Integer, Integer> sorted_map=new TreeMap(map);
		List list=(List) sorted_map.keySet();
		List values= (List) sorted_map.values();
		result(values, list);
		
	}
	
	
	static	void  result(List start, List fin)
	{

     Iterator iter_start=start.iterator();
     Iterator iter_fin= fin.iterator();
     
     int start_time=0;
     int fin_time=0;
     
      int count=0;
      start_time=(int) iter_start.next();
      fin_time=(int) iter_fin.next();
      count=1;
      int start_time_2=0;
      int fin_time_2=0 ;
     while(iter_fin.hasNext() )
     {
    	 start_time_2=(int)iter_start.next();
    	 if(start_time_2>=fin_time){
    		 
    		 count++;
    		fin_time=(int)iter_fin.next(); 
    	 }
    	 
    	 
    	 
    	 
    	 
    	 
     }
	 
		
		
	}
	
	
}
