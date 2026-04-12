

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] drinks = new int[n+1];
        int[][] dp = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1] = dp[i-1][0] + drinks[i];
            dp[i][2] = dp[i-1][1] + drinks[i];
        }

        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));








    }
}
