
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
        meet = new int[N+1][2];
        dp = new int[N+2];

        for(int i = 1; i <= N; i++) {
            dp[i] = 0;
        }



        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            meet[i][0] = t;
            meet[i][1] = p;
        }


        for (int i = N; i >= 1; i--) {
            // 상담을 안 하는 경우
            dp[i] = dp[i + 1];

            // 상담을 할 수 있는 경우
            if (i + meet[i][0] <= N + 1) {
                dp[i] = Math.max(dp[i], maxMeet(meet, dp, i));
            }

        }

        System.out.println(dp[1]);

    }

    static int maxMeet(int[][] meet, int[]dp, int i) {
        int n = i + meet[i][0];
        return meet[i][1] + dp[n]; // 그 날의 수익 + 그 다음 바로의 수익
    }

}
