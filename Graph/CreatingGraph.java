import java.util.*;
public class CreatingGraph {
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
    //vertex == index
    public static void main(String[] args) {

        //     (5)
        // 0 ------ 1
        //         / \
        //  (1)   /   \ (3)
        //       /     \
        //      2 ----- 3
        //      |   (1)
        //  (2) |
        //      |
        //      4




        int V =5;
        //int[] arr = new arr[V];
        ArrayList<Edge>[]  graph = new ArrayList[V];//arraylist of edge type array named graph
        //initially the array will be null so we need to make new empty arraylist
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();//at every ith index of graph new arraylist is created
            //ith vertex -> create new arraylist to store edges
        }

        //0-vertex
        graph[0].add(new Edge(0, 1, 5));
        //1-vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 1, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));

        //2's neighbors
        for(int i=0;i<graph[2].size();i++){//traversing arraylist of 2nd index/vertex
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }

        
    }
}
