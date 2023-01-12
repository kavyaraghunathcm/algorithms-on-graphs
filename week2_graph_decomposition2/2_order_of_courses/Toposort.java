import java.util.*;

public class Toposort {
    private static List<Integer> toposort(ArrayList<Integer>[] adj) {
        //int used[] = new int[adj.length];
       // ArrayList<Integer> order = new ArrayList<Integer>();
        boolean[] visited= new boolean[adj.length];
        //write your code here
        LinkedList<Integer> path =new LinkedList<>();
        for (int i = 0; i < adj.length; i++) {
            if(!visited[i]){
                path=explore(i, adj, visited,path);
            }
        }
        return path;
    }

    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
      //write your code here
    }

    private static LinkedList<Integer> explore(int i, ArrayList<Integer>[] adj, boolean[] visited, LinkedList<Integer> path) {
        visited[i]=true;
        for (int v:adj[i]) {
            if(!visited[v]){
                path=explore(v,adj,visited, path);
            }
        }
        path.addFirst(i);
        return path;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        List<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

