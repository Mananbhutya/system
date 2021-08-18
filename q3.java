import java.util.*;
class q3 {
    int max=1000;
    Map<Integer,ArrayList<Integer>> graph = new  HashMap<>();
    public void dfs(char source){
        int src = source-'A';
        Stack<Integer> s = new Stack<Integer>();
        boolean[] visited = new boolean[max];
        s.add(src);
        for(int i=0;i<max;i++){
            visited[i]=false;
        }
        System.out.println("DFS Traversal from "+source+"is :");
        while(s.size()!=0){
            int node = s.peek();
            s.pop();
            if(visited[node]==true){
                continue;
            }
            visited[node]=true;
            System.out.print((char)(node+'A')+" ");
            for(int child: graph.get(node)){
                s.add(child);
            }
        }
    }
    q3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int v = sc.nextInt();
        System.out.println("Enter number of edges");
        int e = sc.nextInt();
        for(int i=0;i<max;i++){
            graph.put(i,new ArrayList<Integer>());
        }
        System.out.println("Enter edges in v1 v2 format");
        for(int i=0;i<e;i++){
            char a = sc.next().charAt(0);
            char b = sc.next().charAt(0);
            int m = a-'A';
            int n = b-'A';
            ArrayList<Integer>  x = graph.get(m);
            ArrayList<Integer>  y = graph.get(n);
            x.add(n);
            y.add(m);
            graph.put(m,x);
            graph.put(n,y);
        }
        dfs('A');
        sc.close();
    }
    public static void main(String[] args) {
        new q3();
    }
}
