

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[][] line = new int[p][2];

        int[] dp = new int[d+1];



        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        dp[0] = Integer.MAX_VALUE;

        for(int i = 0; i < p; i++) {
            int length = line[i][0];
            int capacity = line[i][1];

            for(int j = d; j >= length; j--) {
                if(dp[j-length] != 0   )
                    dp[j] = Math.max(dp[j], Math.min(capacity, dp[j-length]));
            }
        }


        System.out.println(dp[d]);



    }


}
