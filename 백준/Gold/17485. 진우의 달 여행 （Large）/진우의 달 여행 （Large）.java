

import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][m][3];

        for(int j = 0; j < m; j++){
            for(int d = 0; d < 3; d++){
                dp[0][j][d] = arr[0][j];
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                Arrays.fill(dp[i][j], INF);
                if(j+1 < m){
                    dp[i][j][0] = arr[i][j] + Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]);
                }
                dp[i][j][1] = arr[i][j] + Math.min(dp[i-1][j][0], dp[i-1][j][2]);
                if(j-1 >= 0){
                    dp[i][j][2] = arr[i][j] + Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]);
                }
            }
        }



        int answer = INF;

        for(int j = 0; j < m; j++){
            for(int d = 0; d < 3; d++){
                answer = Math.min(answer, dp[n-1][j][d]);
            }
        }
        System.out.println(answer);


    }
}
