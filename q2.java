import java.util.*;
class q2{
	int v,e,max=1000;
	Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
	public void bfs(int src){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		boolean visited[] = new boolean[max];
		for(int i=0;i<max;i++)visited[i]=false;
		System.out.println("D1");
		while(q.size()!=0){
			int node = q.poll();
			if(visited[node]==true)continue;
			visited[node]=true;
			System.out.print((char)(node+'A')+" ");
			for(int child:graph.get(node))q.add(child);
		}
	}
	q2(){
		Scanner sc  = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		for(int i=0;i<max;i++){
			graph.put(i,new ArrayList<Integer>());
		}
		for(int i=0;i<e;i++){
			int a,b;
			a = sc.next().charAt(0)-'A';
			b = sc.next().charAt(0)-'A';
			ArrayList<Integer> x = graph.get(a);
			x.add(b);
			graph.put(a,x);
			ArrayList<Integer> y = graph.get(b);
			y.add(a);
			graph.put(b,y);
		}
		int start = sc.next().charAt(0)-'A';
		bfs(start);
	}
	public static void main(String[] args){	
		new q2();
	}
}