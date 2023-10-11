vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            //case-1
            if(!vis[e.dest]){
                if(detectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }
            //case-2
            if(vis[e.dest] && e.dest!=par){
                return true;
            }
        }
        return false;