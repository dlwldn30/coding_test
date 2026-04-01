
import java.io.*;
import java.util.*;


public class Main {

    static int[] parent;

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];
        parent = new int[100001];

       parent[n] = n;

        q.add(n);
        visited[n] = true;
        dist[n] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            int[] cur = {x+1, x-1, 2*x};

            for(int nx : cur){
                if(nx < 0 || nx >= 100001) continue;
                if(visited[nx]) continue;

                dist[nx] = dist[x] + 1;
                visited[nx] = true;
                parent[nx] = x;
                q.add(nx);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = m; i != n; i = parent[i]) {
            list.add(i);
        }
        list.add(n);
        Collections.reverse(list);

        System.out.println(dist[m]);

        for(int x : list){
            System.out.print(x + " ");
        }


    }
}
