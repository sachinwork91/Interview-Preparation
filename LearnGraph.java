import java.util.Iterator;
import java.util.LinkedList;

/*This is an example of DFS and BFS in an  Graph Connected Graph 
 * 
 * 1. Refers to Undirected Graph
 * 2. Refers to Directed Graph
 * 
 * */
public class LearnGraph {

	
	int V = 0;
	LinkedList<Integer> adj[];

	public LearnGraph(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list.
		adj[w].add(v);   //2.  Comment this to make a directed Graph
	}

	
	
/*Graph Structure
 * 
 * 					0
 *                    \
 * 						2
 * 					   / \	
 * 					  1   3		
 * 					/
 * 				   4
 * */			

	
	public static void main(String[] args){
		
		LearnGraph g= new LearnGraph(5);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(1, 4);
		//g.addEdge(4, 1);       //1. Remove this comment to make a cycle in an undirected graph
		//g.addEdge(1,1);      //2. Remove this comment to make an directed graph
		System.out.println("Printing BFS");
		g.BFS(0);
		System.out.println("\nPrinting DFS");
		g.DFS(0);
		System.out.println(" is the Undirected graph cyclic ? => "+g.isCyclicUndirected());  
		
	//	System.out.println(" is the directed graph cyclic ? => "+g.isCyclicDirectedGraph());
		
		
	}
	
	
	void BFS(int s) {
	boolean[] visited = new boolean[V];
		if (s > V) {
			System.out.println("Index does not exists.Not possible");
		} else {
			// visited[s]=true;
			LinkedList<Integer> queue = new LinkedList<Integer>();
			visited[s] = true;
			
			queue.add(s);

			while (!queue.isEmpty()) {
				int temp = queue.poll();
				System.out.print(temp + " =>");
				LinkedList adjlist = adj[temp];
				Iterator<Integer> iter = adjlist.iterator();
				while (iter.hasNext()) {
					int data = iter.next();
					if (!visited[data]) {
						visited[data]=true;
						queue.add(data);
					}
				}
			}
		}

	}
	
	
  void DFS(int s){
		boolean[] visited=new boolean[V];
		
	DFSUtil(s, visited);	
		
	}
	
  
  void DFSUtil(int data, boolean[] visited){
	  
	  visited[data]=true;
	  System.out.print(data+"=>");
	  
	  LinkedList<Integer> adjList=adj[data];
	  for(Integer i:adjList){
		  if(!visited[i]){
			  DFSUtil(i,visited);
		  }
	 }
	  
  }

  
	boolean isCyclicUndirected() {
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (cycleDetectionUndirectedGraph(i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}
  
  
  boolean cycleDetectionUndirectedGraph(int v, boolean[] visited, int parent){
	
	  visited[v]=true;
	  int i;
	  
	  LinkedList<Integer> adjList=adj[v];
	  
	  for(Integer data: adjList){
		  if(!visited[data]){
			  if(cycleDetectionUndirectedGraph(data,visited,v)){
				  return true;
			  }
			  
		  }
		  else if(data!=parent){
			  return true;
		  }
		  
	  }
	  
	  
	  
	  return false;
  }
  
  
  
  
  boolean isCyclicDirectedGraph(){
	  
	  boolean[] visited=new boolean[V];
	  boolean[] recursionStack=new boolean[V];
	  
	  for(int i=0;i<V;i++){
		  if(cycleDetectionDirectedGraph(i, visited, recursionStack))
		  {return true;}
		  
	  }
	  return false;
  }
  
  boolean cycleDetectionDirectedGraph(int v, boolean[] visited, boolean[] recursionStack){
	  
	  if(!visited[v]){
	  visited[v]=true;
	  recursionStack[v]=true;
	  
	  LinkedList<Integer> adjList=adj[v];
	  for(Integer i: adjList){
		  
		  if(!visited[i] && cycleDetectionDirectedGraph(i,visited, recursionStack)){
			  return true;
		  }
		  else if(recursionStack[i]){return true;}
		  
	  }
	  }
	//Removing the element from the recursion stack  
     recursionStack[v]=false;
	 return false;
  }
  

}
	
	
	

