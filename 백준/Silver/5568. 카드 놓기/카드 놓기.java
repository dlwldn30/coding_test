import java.io.*;
import java.util.*;

public class Main {

    static String[] arr;
    static boolean[] visited;   // boolean
    static int N, K;
    static HashSet<String> set; // list 대신 set

    static void dfs(int depth, String num) {
        if (depth == K) {
            set.add(num);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, num + arr[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new String[N];
        visited = new boolean[N];
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        dfs(0, "");

        System.out.println(set.size());
    }
}