
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();

    static void quad(int x, int y, int size) {
        if (size == 1) {
            sb.append(tree[x][y]);
            return;
        }

        int first = tree[x][y];
        boolean same = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (tree[i][j] != first) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            sb.append(first);
            return;
        }

        int half = size / 2;
        sb.append("(");
        quad(x, y, half);
        quad(x, y + half, half);
        quad(x + half, y, half);
        quad(x + half, y + half, half);
        sb.append(")");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                tree[i][j] = line.charAt(j) - '0';
            }
        }

        quad(0, 0, N);
        System.out.println(sb);
    }
}