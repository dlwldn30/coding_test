
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] map;
    static int mid;

    static void rotateMap() {

        mid = Math.min(N, M) / 2;

        for (int layer = 0; layer < mid; layer++) {

            int top = layer;
            int left = layer;
            int bottom = N - 1 - layer;
            int right = M - 1 - layer;

            int temp = map[top][left]; 

            // 위쪽 (←)
            for (int j = left; j < right; j++) {
                map[top][j] = map[top][j + 1];
            }

            // 오른쪽 (↑)
            for (int i = top; i < bottom; i++) {
                map[i][right] = map[i + 1][right];
            }

            // 아래쪽 (→)
            for (int j = right; j > left; j--) {
                map[bottom][j] = map[bottom][j - 1];
            }

            // 왼쪽 (↓)
            for (int i = bottom; i > top + 1; i--) {
                map[i][left] = map[i - 1][left];
            }

            map[top + 1][left] = temp;


        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i< R; i++){
            rotateMap();
        }


        for (int i = 0; i< N; i++){
            for (int j = 0; j< M; j++){
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


}
