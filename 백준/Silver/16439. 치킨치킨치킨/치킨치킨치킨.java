
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static int max = 0;



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


        for (int i = 0; i < M-2; i++) {
            for (int j = i+1; j < M-1; j++) {
                for (int k = j+1; k < M; k++) {
                    int sum = 0;
                    for (int p = 0; p < N; p++) {
                        int best = Math.max(arr[p][i], Math.max(arr[p][j], arr[p][k]));
                        sum += best;
                    }
                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}
