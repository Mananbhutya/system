import java.util.*;
class q6{
	int n,graph[][],visited[],ans[];
	public int findMin(){
		int idx=0,lo=Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			if(ans[i]<lo && visited[i]==0){
				lo = ans[i];
				idx = i;
			}
		}
		return idx;
	}
	public void dijkstra(int src){
		for(int i=0;i<n;i++){
			visited[i]=0;
			ans[i]=Integer.MAX_VALUE;
		}
		ans[src]=0;
		visited[src]=1;
		int count = 0;
		while(count<n-1){
			int u = findMin();
			visited[u]=1;
			for(int i=0;i<n;i++){
				if(visited[i]==0 && graph[u][i]!=0 && ans[u]+graph[u][i]<ans[i])ans[i]=(ans[u]+graph[u][i]);
			}
			count++;
		}
	}
	q6(){
		n = 9;
		graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		visited = new int[n];
		ans = new int[n];
		dijkstra(0);
		for (int i = 0; i < n; i++) {
            		System.out.println(i + " " + ans[i]);
        	}	
	}
	public static void main(String[] args){
		new q6();
	}
}