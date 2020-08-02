import java.util.*;

class Graph<T>{
	Map<T,List<T>> map = new HashMap<>();
	


	int shortestPath(T src,T dest){
		Map<T,Integer> dist = new HashMap<>();
		dist.put(src,0);
		Queue<T> queue = new LinkedList<>();
		queue.offer(src);
		while(!queue.isEmpty()){
			T node = queue.poll();
			for(T child:map.get(node)){
				if(!dist.containsKey(child)){
					dist.put(child,dist.get(node)+1);
					queue.offer(child);
				}
			}
		}
		return dist.get(dest);

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

class test{
	public static void main(String[] args){
		Graph<String> graph = new Graph<>();
		graph.addEdge("delhi","mumbai",true);
		graph.addEdge("mumbai","kkr",true);
		graph.addEdge("kkr","bang",true);
		graph.addEdge("bang","goa",true);
		System.out.println(graph.shortestPath("delhi","bang"));
		
	}
}