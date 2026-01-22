
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static int[] pick = new int[3];
    static int max = 0;

    public static void dfs(int depth, int start){
        if(depth == 3){
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int best = Math.max(arr[i][pick[0]], Math.max(arr[i][pick[1]], arr[i][pick[2]]));
                sum += best;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = start; i < M; i++) {
            pick[depth] = i;
            dfs(depth+1, start+1);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        
        System.out.println(max);
    }
}
