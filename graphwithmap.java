import java.util.*;

class Pair{
	String type;
	int weight;
	Pair(String type,int weight){
		this.type = type;
		this.weight = weight;
	}
}

class Graph{
	HashMap<String,ArrayList<Pair>> map;
	void addtograph(String src,String dest,Boolean bidir,int weight){
		if(bidir){
			if(map.containsKey(src) == true){
				ArrayList current = map.get(src);
				if(map.containsKey(dest)){
					ArrayList current2 = map.get(dest);
					Pair c = new Pair(dest,weight);
			Pair c2 = new Pair(src,weight);
			current.add(c);
			current2.add(c2);
			map.put(src,current);
			map.put(dest,current2);		
				}else{
					ArrayList current2 = new ArrayList<Pair>();
					Pair c = new Pair(dest,weight);
			Pair c2 = new Pair(src,weight);
			current.add(c);
			current2.add(c2);
			map.put(src,current);
			map.put(dest,current2);
				}



			}else{
				ArrayList current = new ArrayList<Pair>();
				if(map.containsKey(dest)){
					ArrayList current2 = map.get(dest);
					Pair c = new Pair(dest,weight);
			Pair c2 = new Pair(src,weight);
			current.add(c);
			current2.add(c2);
			map.put(src,current);
			map.put(dest,current2);
				}else{
					ArrayList current2 = new ArrayList<Pair>();
					Pair c = new Pair(dest,weight);
			Pair c2 = new Pair(src,weight);
			current.add(c);
			current2.add(c2);
			map.put(src,current);
			map.put(dest,current2);
				}
			}
			
		}else{
		if(map.containsKey(src)){
			ArrayList current = map.get(src);
			Pair c = new Pair(dest,weight);
		current.add(c);
		map.put(src,current);
		}else{
			ArrayList<Pair> current = new ArrayList<>();
			Pair c = new Pair(dest,weight);
		current.add(c);
		map.put(src,current);
		}
		
		}
		
	} 
	void printlist(){
		for(String x:map.keySet()){
			System.out.print(x + " --> ");
			ArrayList list = map.get(x);
			for(int i=0;i<list.size();i++){
				Pair c = (Pair)list.get(i);
				System.out.print(c.type +"  " + c.weight + ", ");
			}
			System.out.println();
		}
	}   
	void bfs(String src){
		Queue<String> queue = new LinkedList<>();
		queue.offer(src);
		HashMap<String,Boolean> visited = new HashMap();
		visited.put(src,true);
		while(!queue.isEmpty()){
			String node = queue.poll();
			System.out.print(node + " ");
			List<Pair> l = map.get(src);
			for(int i=0;i<l.size();i++){
				Pair c = (Pair)l.get(i);
				if(!visited.containsKey(c.type)){
					queue.add(c.type);
					visited.put(c.type,true);
				}
			}
		}
	}

}
class graphwithmap {
    public static void main(String args[]) {
        //System.out.println("Hello World!");

        Graph g = new Graph();
        g.map = new HashMap();
        g.addtograph("A","B",true,20);
        g.addtograph("A","D",true,20);
        g.addtograph("A","C",false,30);
        g.addtograph("C","B",true,20);
        g.addtograph("D","B",true,20);
        g.printlist();
        g.bfs("A");
        //System.out.println(g.map);
        //g.printlist();

    }
}