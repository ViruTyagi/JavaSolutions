import java.util.*;

class Graph<T>{
	Map<T,List<T>> map = new HashMap<>();
	

	void dfs_helper(T node,Map<T,Boolean> visited,List<T> order){
		visited.put(node,true);
		if(map.containsKey(node)){
			for(T child:map.get(node)){
				if(!visited.containsKey(child)){
					dfs_helper(child,visited,order);
				}
			}

			order.add(node);

		}
	}
	void tps_dfs(){
		Map<T,Boolean> visited = new HashMap<>();
		List<T> order = new LinkedList<>();
		for(T node : map.keySet()){
			if(!visited.containsKey(node)){
				dfs_helper(node,visited,order);
			}
		}

		Collections.reverse(order);
		for(T node : order){
			System.out.print(node +",");
		}
		System.out.println();


	}


	void addVertex(T src){
		map.put(src,new LinkedList<>());
	}

	void addEdge(T src,T dest,boolean bidir){
		if(!map.containsKey(src))addVertex(src);
		map.get(src).add(dest);
		if(bidir == true){
			if(!map.containsKey(dest))addVertex(dest);
			map.get(dest).add(src);
		}
	}
	void printList(){
		for(T node:map.keySet()){
			System.out.print(node + "->");
			for(T e:map.get(node)){
				System.out.print(e + ",");
			}
			System.out.println();
		}
	}
}

class tswithdfs{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Graph<String> graph = new Graph<>();
		/*int n = scan.nextInt();
		//String s = scan.next();
		System.out.println(n);
		for(int i=0;i<n;i++){
			String src = scan.next();
			String dest = scan.next();
			System.out.println("output" +src + " " + dest);
			graph.addEdge(src,dest,false);
		}*/
		graph.addEdge("English","PL",false);
		graph.addEdge("Maths","PL",false);
		graph.addEdge("English","HTML",false);
		graph.addEdge("HTML","CSS",false);
		graph.addEdge("PL","HTML",false);
		graph.addEdge("PL","Python",false);
		graph.addEdge("PL","Java",false);
		graph.addEdge("Python","JS",false);
		graph.addEdge("CSS","JS",false);
		graph.addEdge("JS","WebDev",false);
		graph.addEdge("Java","WebDev",false);
		graph.tps_dfs();
	}
}