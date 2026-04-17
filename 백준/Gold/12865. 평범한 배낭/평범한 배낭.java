

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] bags = new int[n][2];
        int[] dp = new int[m+1];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i][0] = Integer.parseInt(st.nextToken());
            bags[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            int v = bags[i][0];
            int w = bags[i][1];

            for(int j = m; j >= v; j--){
                dp[j] = Math.max(dp[j], dp[j-v] + w);
            }
        }

        int answer = 0;

        for(int i = 1; i <= m; i++){
            if(dp[i] > answer)
                answer = dp[i];
        }

        System.out.println(answer);
    }
}
