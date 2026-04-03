
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bufferedReader.readLine());
        int num[] = new int[n];

        st = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());


        long[][] dp = new long[n-1][21];
        dp[0][num[0]] = 1;

        for(int i = 1; i < n-1; i++) {
            for(int j = 0; j <= 20; j++) {
                if(dp[i-1][j] == 0) continue;
                if(j + num[i] <= 20) dp[i][j+num[i]] += dp[i-1][j];
                if(j - num[i] >= 0) dp[i][j-num[i]] += dp[i-1][j];
            }
        }

        System.out.println(dp[n-2][num[n-1]]);

    }
}