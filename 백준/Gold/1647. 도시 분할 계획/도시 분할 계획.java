
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge>{
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return w - o.w;
        }
    }

    static int[] parent;

    static int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;
        parent[b] = a;
        return true;
    }

    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {parent[i] = i;}

        Collections.sort(edges);

        int cnt = 0;
        long cost = 0;

        for (Edge edge: edges) {
            if(union(edge.u, edge.v)) {
                max = Math.max(max, edge.w);
                cost += edge.w;
                if(++cnt == n-1) break;
            }
        }

        System.out.println(cost-max);



    }
}
