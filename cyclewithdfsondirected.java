import java.util.*;

class Graph<T>{
	Map<T,List<T>> map = new HashMap<>();
	
	boolean dfs(T node,Map<T,Boolean> visited,Map<T,Boolean>inStack){
		visited.put(node,true);
		inStack.put(node,true);
		if(map.containsKey(node)){
			for(T child:map.get(node)){
				if(visited.containsKey(child) && inStack.get(child) == true){
					return true;
				}
				if(!visited.containsKey(child)){
					if(dfs(child,visited,inStack)==true)return true;
				}
			}
		}
		inStack.put(node,false);
		return false;
	}
	boolean is_cycle(){
		Map<T,Boolean> visited = new HashMap<>();
		Map<T,Boolean> inStack = new HashMap<>();
		for(T node:map.keySet()){
			inStack.put(node,false);
			for(T child:map.get(node))inStack.put(child,false);
		}
		for(T node:map.keySet()){
			if(!visited.containsKey(node)){
				if(dfs(node,visited,inStack)== true)return true;
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
		System.out.println(graph.is_cycle());	
	}
}