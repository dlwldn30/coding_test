

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[][] dp = new long[n+1][m+1];

            for(int j = 1; j <= m; j++) dp[1][j] = 1;

            for(int j = 2; j <= n; j++){
                for(int k = 1; k <= m; k++){
                    for(int c = 1; c <= k/2; c++){
                        dp[j][k] += dp[j-1][c];
                    }
                }
            }

            long answer = 0;
            for(int j = 1; j <= m; j++){
                answer += dp[n][j];
            }

            System.out.println(answer);
        }
    }
}
