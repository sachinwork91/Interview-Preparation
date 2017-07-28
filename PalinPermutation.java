import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PalinPermutation {
	public void check(String str){
		
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=' '){
				if(map.containsKey(str.charAt(i)))
				{
					int count=map.get(str.charAt(i));
					count++;
					map.put(str.charAt(i), count);
				}else{
					map.put(str.charAt(i), 1);
				}			
			}
		}
		
		Set<Character> set=map.keySet();
		Iterator<Character> iter=set.iterator();
		int flag=0;
		while(iter.hasNext()){
			   Character ch=iter.next();
			   int count=map.get(ch);
			   if(count%2==1){
				   flag++;
			   }
			   if(flag==2){
				   System.out.println("Not a palindromic permutation"); 
				   break;
			   }
			
		}
		
		if(flag!=2)System.out.println("It is a Palindromic Permutation");
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		PalinPermutation perm=new PalinPermutation();
		perm.check("aab ");
	}

}
