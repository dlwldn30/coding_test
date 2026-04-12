

    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n+1][2];
            for(int i = 1; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            int k = Integer.parseInt(br.readLine());

            int[][] dp = new int[n+1][2];
            for(int i = 0; i <= n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

            dp[1][0] = 0;
            dp[1][1] = 0;

            for(int i = 2; i <= n; i++) {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][0] + arr[i-1][0]);
                if(i >= 3) dp[i][0] = Math.min(dp[i][0], dp[i-2][0] + arr[i-2][1]);

                dp[i][1] = Math.min(dp[i][1], dp[i-1][1] + arr[i-1][0]);
                if(i >= 3) dp[i][1] = Math.min(dp[i][1], dp[i-2][1] + arr[i-2][1]);
                if(i >= 4) dp[i][1] = Math.min(dp[i][1], dp[i-3][0] + k);
            }

            System.out.println(Math.min(dp[n][0], dp[n][1]));
        }
    }   