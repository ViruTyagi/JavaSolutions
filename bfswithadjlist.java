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

	void bfs(int src){
		//
		if(list.length == 0)return;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		System.out.println(src+ " ");
		boolean[] visited = new boolean[V];
		//int[] prev = new int[V];
		visited[src] = true;
		while(!queue.isEmpty()){
			int node = queue.poll();
			for(Integer c:list[node]){
				if(!visited[c]){
					queue.add(c);
					System.out.print(c + " ");
					visited[c] = true;
				}
			}
			System.out.println();
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
		g.bfs(5);
	}
}