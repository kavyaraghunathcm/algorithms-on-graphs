import java.util.*;

public class Acyclicity {
    static boolean cyclic =false;
    private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
        boolean[] visited= new boolean[adj.length];
        Set<Integer> path=new HashSet<>();
        for (int i = 0; i < adj.length; i++) {
            if(!visited[i]){
                explore(i, adj, visited,path);
            }
        }
        if(cyclic){return 1;}
        return 0;
    }

    private static Set<Integer> explore(int i, ArrayList<Integer>[] adj, boolean[] visited, Set<Integer> path) {
        visited[i]=true;
        if(cyclic){
            return path;
        }
        for (int v:adj[i]) {
            if(path.contains(v)){
                cyclic=true;
                return path;
            }
            if(!visited[v]){
                path.add(i);
                path=explore(v,adj,visited, path);
                path.remove(i);
            }
        }
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
        System.out.println(acyclic(adj));
    }
}

