
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        List<Integer>[] blocks = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) {
            blocks[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                blocks[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] dp = new int[n+1][h+1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for(int j = 0; j <= h; j++){
                dp[i][j] = dp[i-1][j];
                for(int block : blocks[i]){
                    if(j-block >= 0){
                        dp[i][j] += dp[i-1][j-block];
                        dp[i][j] %= 10007;
                    }
                }
            }
        }

        System.out.println(dp[n][h]);

    }


}
