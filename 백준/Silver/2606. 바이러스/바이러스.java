
import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        visited[1] = true;
        dfs(1);

        System.out.println(count);
    }

    static void dfs(int a){
        for (int next : graph[a]) {
            if (!visited[next]) {
                visited[next] = true;
                count++;
                dfs(next);
            }
        }
    }
}