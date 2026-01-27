
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] sw = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sw[i] = (Integer.parseInt(st.nextToken()) == 1);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int card = Integer.parseInt(st.nextToken());

            // 남학생
            if (student == 1) {
                for (int k = card; k <= N; k += card) {
                    sw[k] = !sw[k];
                }
            }
            // 여학생
            else {
                int d = 0;
                while (card - d >= 1 && card + d <= N
                        && sw[card - d] == sw[card + d]) {
                    d++;
                }

                for (int k = card - (d - 1); k <= card + (d - 1); k++) {
                    sw[k] = !sw[k];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(sw[i] ? 1 : 0).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }

        System.out.println(sb);
    }
}