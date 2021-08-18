import java.util.*;
import java.lang.*;
import java.io.*;
class q7 {
	int V, key[], parent[],graph[][];
	Boolean mstSet[];
	int minKey()
	{
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		return min_index;
	}
	void printMST()
	{
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}
	q7()
	{	
		V=5;
		graph = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };
		parent= new int[V];
		key= new int[V];
		mstSet = new Boolean[V];
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		for (int count = 0; count < V - 1; count++) {
			int u = minKey();
			mstSet[u] = true;
			for (int v = 0; v < V; v++)
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}
		printMST();
	}

	public static void main(String[] args)
	{
		new q7();
	}
}
// This code is contributed by Aakash Hasija
