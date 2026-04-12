

    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());



            int[][] dp = new int[n+1][10];
            for (int j = 1; j <= 9; j++) dp[1][j] = 1;

            if(n == 1){
                System.out.println(9);
                return;
            }



            for(int i = 2; i <= n; i++) {
                for(int j = 0; j <= 9; j++) {
                    if(j == 0){
                        dp[i][0] = dp[i-1][1]%1000000000;
                    }
                    else if(j == 9){
                        dp[i][9] = dp[i-1][8]% 1000000000;
                    }else{
                        dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                    }

                }
            }

            int result = 0;

            for(int i = 0; i <= 9; i++) {
                result = (result + dp[n][i])%1000000000;
            }



            System.out.println(result);

        }
    }