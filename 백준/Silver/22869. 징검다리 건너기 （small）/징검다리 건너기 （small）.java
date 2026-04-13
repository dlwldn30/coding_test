

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] stones = new int[n+1];
        boolean[] dp = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) stones[i] = Integer.parseInt(st.nextToken());

        dp[1] = true;
        for(int i = 1; i <= n; i++){
            if(!dp[i]) continue;
            for(int j = i+1; j <= n; j++){
                int cost = (j-i) * (Math.abs(stones[i] - stones[j]) + 1);
                if(cost <= m)
                    dp[j] = true;
            }
        }

        System.out.println(dp[n] ? "YES" : "NO");








    }
}
