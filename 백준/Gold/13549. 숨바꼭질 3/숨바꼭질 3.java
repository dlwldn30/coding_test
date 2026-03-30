
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        boolean[] visited = new boolean[100001];

        Arrays.fill(dist, Integer.MAX_VALUE);

       Queue<Integer> q = new LinkedList<>();
       q.add(a);
       dist[a] = 0;
       visited[a] = true;


       while (!q.isEmpty()) {
           int cur = q.poll();
           visited[cur] = true;

           int[] next = {cur*2, cur+1, cur-1};

           for(int nx : next) {
               if(nx < 0 || nx >= 100001) continue;
               if(visited[nx]) continue;
               int plus = nx == cur*2 ? 0 : 1;
               if(dist[nx] < dist[cur]+plus) continue;
               dist[nx] = dist[cur]+plus;
               q.add(nx);
           }

       }

        System.out.println(dist[b]);
    }


}