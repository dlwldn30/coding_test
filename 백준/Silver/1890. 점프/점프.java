
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long [][] dp = new long[n][n];
        dp[0][0] = 1;

        int a = 0;
        int b = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == n-1 && j == n-1) continue;
                
                if(dp[i][j] == 0) continue;
                int d = map[i][j];
                
                if(i + d < n){
                    dp[i+d][j] += dp[i][j];
                }
                if(j + d < n){
                    dp[i][j+d] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);

    }
}
