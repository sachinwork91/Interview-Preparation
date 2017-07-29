import java.util.LinkedList;



/** 
 * This class helps in generating the sequence which is possible on pressing the keys on the Phone pad
 * The problem can be solved using both BFS and DFS techniques
 *    
 * 
 * 
 * */
public class PhoneProblem {

	String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	
//Using BFS Technique
	public void gen(String digits){
		
		LinkedList<String> list=new LinkedList();
		list.add("");
		for(int i=0;i<digits.length();i++){
			int index=Character.getNumericValue(digits.charAt(i));
			while(list.peek().length()==i){
				String t=list.remove();
				for(int j=0;j<mapping[index].length();j++){
					String s=t+mapping[index].charAt(j);
					list.add(s);
				}
			}
		}
		
		for(String str: list){
			System.out.print(str+" ");
		}
	}
	
	
//DFS Technique	
	void genRes(String digits){
		LinkedList<String> res=new LinkedList<String>();
		gen(res,"",mapping, digits );
		
		System.out.println(" ");
		for(String s: res){
			System.out.print(s+" ");
		}
	}
	
	void gen(LinkedList<String> res, String s, String[] mapping,String digits){
		
		if(digits.length()==0){
			res.add(s);
			return;
		}
		
		
		for(int i=0;i<mapping[digits.charAt(0)-'0'].length();i++){
			s=s+mapping[digits.charAt(0)-'0'].charAt(i);
			gen(res, s,mapping, digits.substring(1));
			s=s.substring(0,s.length()-1);
		}
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args){
		
		PhoneProblem pp=new PhoneProblem();
		pp.gen("23");  //Using BFS
		pp.genRes("23");  //Using DFS
		
	}
	
	
}
