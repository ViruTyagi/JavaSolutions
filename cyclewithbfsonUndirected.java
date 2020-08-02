import java.util.*;

class Graph<T>{
	Map<T,List<T>> map = new HashMap<>();
	
	boolean isTree(T d){
		Map<T,Boolean>visited = new HashMap<>();
		Map<T,T> parent = new HashMap<>();
		for(T node:map.keySet()){
			parent.put(node,node);
			for(T child:map.get(node)){
				parent.put(child,child);
			}
		}
		System.out.print(map);
		visited.put(d,true);
		Queue<T> queue= new LinkedList<>();
		queue.offer(d);
			while(!queue.isEmpty()){
			T node = queue.poll();
			//System.out.print(node + " ,");
			for(T nbr:map.get(node)){
				if(visited.containsKey(nbr) && !parent.get(node).equals(nbr)){
					//System.out.print(nbr);
					return true;
				}
				if(!visited.containsKey(nbr)){
					visited.put(nbr,true);
					parent.put(nbr,node);
					queue.add(nbr);
				}
			}
		}
		return false;
	}

	void addVertex(T src){
		map.put(src,new LinkedList<>());
	}

	void addEdge(T src,T dest,boolean bidir){
		if(!map.containsKey(src))addVertex(src);
		map.get(src).add(dest);
		if(bidir == false){
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
		Scanner scan = new Scanner(System.in);
		Graph<String> graph = new Graph<>();
		int n = scan.nextInt();
		//String s = scan.next();
		
		for(int i=0;i<n;i++){
			String src = scan.next();
			String dest = scan.next();
			//System.out.println("output" +src + " " + dest);
			graph.addEdge(src,dest,false);
		}
		System.out.println(graph.isTree("d"));	
	}
}