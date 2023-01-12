import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
        int[] dist= new int[adj.length];
        for (int i = 0; i <dist.length ; i++) {
            dist[i]=-1;
        }
        dist[s]=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()){
            int u = queue.poll();
            for (int v:adj[u] ) {
                if(dist[v]==-1){
                    queue.add(v);
                    dist[v]=dist[u]+1;

                }
            }
        }


        return dist[t];
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

