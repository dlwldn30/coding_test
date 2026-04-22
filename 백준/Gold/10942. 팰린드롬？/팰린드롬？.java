

import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        int[] nums = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) nums[i] = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[n+1][n+1];

        // 길이가 1인 경우
        for(int i = 1; i <= n; i++) dp[i][i] = true;

        //길이가 2인 경우
        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i+1]) {
                dp[i][i+1] = true;
            }
        }

        // 그 이상
        for(int length = 3; length <= n; length++){
            for(int i = 1; i <= n-length + 1; i++){
                int j = i+length-1;

                if(nums[i] == nums[j] && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
            }
        }







        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[a][b] ? "1" : "0").append("\n");

        }

        System.out.println(sb);
    }


}
