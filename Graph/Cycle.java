import java.util.ArrayList;

public class Cycle {//undirected graph
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
         //0-vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        //1-vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    //O(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length;i++){//check each component
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1)){//i'th node=current node, parent = -1 cz when we start from a node it doesn't have a parent
                    return true;//cycle exists in one of the graphs
                }
            }
        }
        return false;
    }
    //dfs
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par){
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //case-3

            /* wring code */
            // if(!vis[e.dest] && detectCycleUtil(graph, vis, e.dest, curr)){// if !vis[e.dest] is false, the detectCycleUtil function will still be called, 
            //     return true;
            // }
            if(!vis[e.dest]){// if neighbor unvisited & detectCycleUtil true then return true
                if(detectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                } 
            }
            
            //case-1
            else if(vis[e.dest] && e.dest!=par){
                return true;
            }
            //case-2 -> do nothing, continue;
        }
        return false;
    }
    public static void main(String[] args) {
    //     0 ---------- 3
    //   / |            |
    //  /  |            |
    // 1   |            4
    //  \  |
    //   \ |
    //     2

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));


    }
}
