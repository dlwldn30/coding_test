
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

        public Edge(int u, int v, int w){
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
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;
        parent[b] = a;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map;
        int N = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();

        map = new int[N][N];
        parent = new int[N];
        for (int i=0; i<N; i++){parent[i] = i;}

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                edges.add(new Edge(i, j, map[i][j]));
            }
        }

        Collections.sort(edges);

        int count = 0;
        long sum = 0;

        for(Edge edge : edges){
            if(union(edge.u, edge.v)){
                sum += edge.w;
                if(++count == N-1) break;
            }
        }

        System.out.println(sum);
    }


}
