
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;
    static class Node implements Comparable<Node> {
        int s;
        int e;
        int v;

        public Node(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        public int compareTo(Node o) {
            return this.v - o.v;
        }

    }

    static int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] graph = new Node[m];

       


        parent = new int[n+1];
        for(int i = 1; i <= n; i++) parent[i] = i;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            graph[i] = new Node( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(graph);

        int result = 0;
        for(Node node : graph){
            if(find(node.s) != find(node.e)){
                union(node.s, node.e);
                result += node.v;
            }
        }

        System.out.println(result);



    }


}