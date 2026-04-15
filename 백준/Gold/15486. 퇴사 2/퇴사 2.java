import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] meet;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        meet = new int[N + 1][2];
        dp = new int[N + 2]; // dp[N+1] 접근을 위해 +2

        // 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meet[i][0] = Integer.parseInt(st.nextToken()); // 상담 기간
            meet[i][1] = Integer.parseInt(st.nextToken()); // 수익
        }

        // DP
        for (int i = N; i >= 1; i--) {
            // 오늘 상담 안 하는 경우
            dp[i] = dp[i + 1];

            // 오늘 상담 하는 경우
            int next = i + meet[i][0];
            if (next <= N + 1) {
                dp[i] = Math.max(dp[i], meet[i][1] + dp[next]);
            }
        }

        // 정답
        System.out.println(dp[1]);
    }
}