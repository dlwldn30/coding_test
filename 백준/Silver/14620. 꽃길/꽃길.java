
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] ground;
    static boolean[][] visited;
    static int min = 10000;

    public static void dfs(int depth, int price){
        if(depth == 3) {
            min = Math.min(min, price);
            return;
        }

        int num = 0;
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {

                if(visited[i][j] || visited[i+1][j] || visited[i-1][j] ||  visited[i][j-1] || visited[i][j+1]) {
                    continue;
                }

                visited[i][j] = true;
                visited[i][j-1] = true;
                visited[i][j+1] = true;
                visited[i+1][j] = true;
                visited[i-1][j] = true;
                 num = ground[i][j] + ground[i+1][j] + ground[i-1][j] + ground[i][j-1] + ground[i][j+1];

                dfs(depth+1, price + num);
                visited[i][j] = false;
                visited[i][j-1] = false;
                visited[i][j+1] = false;
                visited[i+1][j] = false;
                visited[i-1][j] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ground = new int[N][N];
        visited = new boolean[N][N];

        // 먼저 숫자 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);

    }
}
