import java.util.*;

class Graph{
	int V;
	ArrayList<Integer>[] list;
	Graph(int V){
		this.V = V;
		list = new ArrayList[V];
		for(int i=0;i<V;i++)list[i] = new ArrayList<>();
	}
	void addtoGraph(int src,int dest){
		list[src].add(dest);
		list[dest].add(src);
	}

	void dfs_helper(int src,boolean[] visited){
		System.out.print(src + " ");
		for(int x:list[src]){
			if(!visited[x]){
				visited[x] = true;
				dfs_helper(x,visited);
			}
		}
	}
	void dfs(int src){
		System.out.println("DFS down there--- ");
		boolean[] visited = new boolean[V];
		visited[src] = true;
		dfs_helper(src,visited);
	}
	void bfs(int src){
		System.out.println("BFS down there--- ");
		if(list.length == 0)return;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		//System.out.print(src+ " ");
		boolean[] visited = new boolean[V];
		//int[] prev = new int[V];
		visited[src] = true;
		while(!queue.isEmpty()){
			int node = queue.poll();
			System.out.print(node + " ");
			for(Integer c:list[node]){
				if(!visited[c]){
					queue.add(c);
					
					visited[c] = true;
				}
			}
			//System.out.println();
		}

	}
	void printlist(){
		for(int i=0;i<V;i++){
			System.out.print("Vertex " + i + " : ");
			for(int x:list[i])System.out.print(x + ",");
			System.out.println();
		}
	}
}

class test{
	public static void main(String[] args){
		Graph g = new Graph(6);
		
		g.addtoGraph(1,2);
		g.addtoGraph(1,3);
		g.addtoGraph(3,4);
		//g.addtoGraph(1,2);
		g.addtoGraph(4,5);
		g.addtoGraph(0,1);
		g.printlist();
		g.bfs(0);
		System.out.println();
		g.dfs(0);
	}
}