import java.util.*;


class dsu{
	int[] parent,rank;
	int total;
	dsu(int n){
		parent = new int[n];
		rank = new int[n];
		for(int i=0;i<n;i++){
			parent[i];
		}
		total = n;

	}

	int get(int a){
		if(a == parent[i])return a;
		return parent[a] =  get(parent[i]); //get parent of a

	}

	void union_set(int a,int b){
		a = get(a);
		b = get(b);
		if(a == b)return;
		if(rank[a] <rank[b]){
			int temp = a;
			a = b;
			b = temp;
		}
		if(rank[a] == rank[b])rank[a]++;
		parent[b] = a;
		total--;
	}

}

class test{
	public static void main(String[] args){
		dsu d = new dsu(10);
	}
}