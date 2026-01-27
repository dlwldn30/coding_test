import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int size = 4 * N - 3;
        char[][] map = new char[size][size];

        // 공백으로 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = ' ';
            }
        }

        // 겹(layer)별로 테두리 그리기
        for (int layer = 0; layer < N; layer++) {
            int start = layer * 2;
            int end = size - 1 - layer * 2;

            // 위, 아래
            for (int j = start; j <= end; j++) {
                map[start][j] = '*';
                map[end][j] = '*';
            }

            // 왼, 오른
            for (int i = start; i <= end; i++) {
                map[i][start] = '*';
                map[i][end] = '*';
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}