
import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        parent = new int[100001];


        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        boolean[] visited = new boolean[100001];

        Arrays.fill(dist, Integer.MAX_VALUE);

       Queue<Integer> q = new LinkedList<>();
       q.add(a);
       parent[a] = a;
       dist[a] = 0;
       visited[a] = true;



       while (!q.isEmpty()) {
           int cur = q.poll();

           int[] next = {cur*2, cur+1, cur-1};

           for(int nx : next) {
               if(nx < 0 || nx >= 100001) continue;
               if(visited[nx]) continue;
               dist[nx] = dist[cur]+1;
               parent[nx] = cur;
               visited[nx] = true;
               q.add(nx);
           }

       }

        System.out.println(dist[b]);

        List<Integer> path = new ArrayList<>();
        for (int i = b; i != a; i = parent[i]) {
            path.add(i);
        }
        path.add(a);
        Collections.reverse(path);

        for (int x : path) {
            System.out.print(x + " ");
        }
    }


}