import java.util.*;

public class Graphs {
    static class Edge {
        int src;
        int dest;
        //int wt;

        public Edge(int s, int d /*int w*/) {
            this.src = s;
            this.dest = d;
            //this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i]=new ArrayList<Edge>();
        }

        /*
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
        */

        /*
        graph[0].add(new Edge(0, 1));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));

        */

        /*graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    public static void bfs(ArrayList<Edge> graph[], int V, boolean vis[], int start) {
        Queue<Integer> q=new LinkedList<>();
        //boolean vis[]=new boolean[V];
        q.add(0); //add the starting point of the graph - say 0
        while(!q.isEmpty()) {
            int curr=q.remove();
            if(vis[curr]==false) {
                System.out.print(curr+" ");
                vis[curr]=true; //mark as visited

                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e=graph[curr].get(i);
                    q.add(e.dest); //add all neighbours of curr node to the queue
                }
            }
        }

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr+" ");
        vis[curr]=true; //mark as visited
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false)
            dfs(graph, e.dest, vis);
        }
    }

    public static void printAllPaths(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int tar) {
        if(curr==tar) {
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]) {
                vis[curr]=true;
                printAllPaths(graph, vis, e.dest, path+e.dest, tar);
                vis[curr]=false;
            }
        }
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]) {
        vis[curr]=true;
        rec[curr]=true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if(rec[e.dest])
            return true;
            else if(!vis[e.dest]){
                if(isCycleDirected(graph, vis, e.dest, rec))
                return true;
            }
        }

        rec[curr]=false;
        return false;
    }

    public static void topoSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topoSortUtil(graph, e.dest, vis, s);
            }
        }
        
        s.push(curr);
    }
    
    //O(V+E)
    public static void topoSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topoSortUtil(graph, i, vis, s);
            }
        }
        
        while(!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // If the adjacent vertex is not visited, recur for that vertex
            if (!vis[e.dest]) {
                if (isCyclicUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            // If an adjacent vertex is visited and is not the parent of the current vertex, then there is a cycle.
            else if (e.dest != par) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCyclicUndirected(ArrayList<Edge>[] graph, boolean vis[]) {
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCyclicUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);

        //print 2's neighbours
        //for(int i=0; i<graph[2].size(); i++)
        //{
            //Edge e = graph[2].get(i);
            //System.out.println(e.dest+" ");
        //}

        //bfs(graph, V); //bfs for connected graph

        //disconnected graph bfs
        /*boolean vis[]=new boolean[V];
        for(int i=0; i<V; i++) {
            if (vis[i]==false)
            bfs(graph, V, vis, i);
        }*/

        //System.out.println();

        //disconnected graph dfs
        /*boolean vis2[]=new boolean[V];
        for(int i=0; i<V; i++) {
            if (vis2[i]==false)
            dfs(graph, i, vis2);
        }*/

        //dfs(graph, 0, vis2); //dfs for connected graph 

        //int src=0, tar=5;
        //printAllPaths(graph, new boolean[V], src, "0", tar);

        /*boolean vis[]=new boolean[V];
        boolean rec[]=new boolean[V];
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                boolean isCycle= isCycleDirected(graph, vis, i, rec);
                if(isCycle) {
                    System.out.println(isCycle);
                    break;
                }
            }
        }
        */

        //topoSort(graph);

        System.out.println(isCyclicUndirected(graph, new boolean[V]));

        //System.out.println();
    }
}
