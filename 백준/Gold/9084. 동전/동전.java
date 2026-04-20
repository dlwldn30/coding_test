

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());

            int[] num = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) num[j] = Integer.parseInt(st.nextToken());

            int c = Integer.parseInt(br.readLine());
            int[] dp = new int[c+1];
            dp[0] = 1;

            for(int k= 0; k < m; k++){
                for(int j = num[k]; j <= c; j++){
                    dp[j] += dp[j - num[k]];
                }
            }

            System.out.println(dp[c]);


        }
    }
}
