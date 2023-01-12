import java.util.*;

public class StronglyConnected {
    static Vertex[] adj;
    static int clock=1;

     public static class Vertex{
        int key;
        int PostOrder;
        boolean used;
        boolean visited;
        List<Vertex> neighbours;
        List<Vertex> reverseNeighbours;

         public Vertex(int key) {
             this.key = key;
             neighbours=new ArrayList<>();
             reverseNeighbours= new ArrayList<>();
         }

         public int getPostOrder() {
             return PostOrder;
         }
     }
    private static int numberOfStronglyConnectedComponents(){
        //write your code here
        //DFS
        for (Vertex v : adj) {
            if(!v.visited){
                explore(v);
            }
        }

        Arrays.sort(adj, Comparator.comparingInt(Vertex::getPostOrder).reversed());
        int res=0;
        for (Vertex v: adj) {
            if(!v.used){
                res++;
                explore2(v);

            }
        }
        return res;
    }

    private static void explore(Vertex i) {
         clock++;
        i.visited=true;
        for (Vertex v:i.reverseNeighbours) {
            if(!v.visited){
                explore(v);
            }
        }
        i.PostOrder= clock;
        clock++;

    }
    private static void explore2(Vertex i) {
        i.used=true;
        for (Vertex v:i.neighbours) {
            if(!v.used){
                explore2(v);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        adj = new Vertex[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new Vertex(i);
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            //reversed
            adj[x - 1].neighbours.add(adj[y-1]);
            adj[y - 1].reverseNeighbours.add(adj[x-1]);
        }
        System.out.println(numberOfStronglyConnectedComponents());
    }
}

