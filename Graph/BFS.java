import java.util.*;

public class BFS {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    } 
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
         
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph){ //O(V+E) for adjacency list || O(V^2) for matrix
        Queue<Integer> q = new LinkedList<>();
        q.add(0);//src
        boolean visited[] = new boolean[graph.length];
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.println(curr+" ");//print
                visited[curr] = true;//visit
                //find neighbors of a graph
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);//add neighbor in queue
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]){ //O(V+E)
        System.out.print(curr+" ");
        vis[curr] = true;   
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void main(String[] args) {
        
        //    1 ------ 3
        //   /         | \
        //  0          |  5 --- 6
        //  \          | /
        //   2 ------- 4
        




        int V =7;
        ArrayList<Edge>[]  graph = new ArrayList[V];
        createGraph(graph);
        // bfs(graph);
        dfs(graph, 0, new boolean[V]);

        

       
    }

}
