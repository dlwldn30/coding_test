
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        int[] count = new int[100001];

        Arrays.fill(dist, -1);
        dist[a] = 0;
        count[a] = 1;



        Queue<Integer> q = new LinkedList<>();

        q.add(a);


        while(!q.isEmpty()) {

            int cur = q.poll();

            int[] next = {cur*2, cur+1, cur-1};

            for(int nx : next){
                if(nx < 0 || nx > 100000) continue;

                if(dist[nx] == -1){
                    dist[nx] = dist[cur] + 1;
                    count[nx] = count[cur];
                    q.add(nx);
                } else if(dist[nx] == dist[cur]+1){
                    count[nx] += count[cur];
                }
            }
        }


        System.out.println(dist[k]);
        System.out.println(count[k]);
    }


}