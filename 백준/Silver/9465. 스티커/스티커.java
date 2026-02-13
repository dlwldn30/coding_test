
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[2][n];
            int[][] dp = new int[2][n];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = matrix[0][0];
            dp[1][0] = matrix[1][0];

            if (n > 1) {
                dp[0][1] = matrix[0][1] + dp[1][0];
                dp[1][1] = matrix[1][1] + dp[0][0];
            }


            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + matrix[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + matrix[1][j];
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }



    }

}
