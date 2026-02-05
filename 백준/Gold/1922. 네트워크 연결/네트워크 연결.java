
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }

    static int[] parent;

    static int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return false;
        parent[y] = x;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) {parent[i] = i;}

        Collections.sort(edges);

        int cost = 0;
        int count = 0;

        for (Edge edge : edges) {
            if(union(edge.u, edge.v)){
                cost += edge.w;
                if(++count == N) break;
            }
        }

        System.out.println(cost);
    }


}
