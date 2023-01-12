import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {

    private static int bipartite(ArrayList<Integer>[] adj) {
        //write your code here
        int[] colour = new int[adj.length];
        for (int i = 0; i < colour.length; i++) {
            colour[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < adj.length; i++) {
            if (colour[i]==-1) {
                colour[i]=0;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v : adj[u]) {
                        if ( colour[v] == -1) {
                            queue.add(v);
                            colour[v] = 1-colour[u];
                        } else if (colour[v]==colour[u]) {
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
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
        System.out.println(bipartite(adj));
    }
}

