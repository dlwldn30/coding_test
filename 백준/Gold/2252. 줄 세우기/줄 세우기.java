
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] stu = new int[n+1];
        List<Integer>[] list = new List[n+1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            stu[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) if(stu[i] == 0) q.add(i);

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            int cur = q.poll();

            sb.append(cur).append(" ");

            for(int i : list[cur]) {
                if(--stu[i] == 0) q.add(i);
            }
        }

        System.out.println(sb);
    }



}
