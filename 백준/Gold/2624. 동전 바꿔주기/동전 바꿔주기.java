
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] coins = new int[m][2];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 0; i < m; i++){
            int coin = coins[i][0];
            int q = coins[i][1];
            int[] next = new int[n + 1];

            for (int money = 0; money <= n; money++) {
                if (dp[money] == 0) continue;
                for (int cnt = 0; cnt <= q; cnt++) {
                    int nextMoney = money + coin * cnt;
                    if (nextMoney > n) break;
                    next[nextMoney] += dp[money];
                }
            }
            dp = next;
        }

        System.out.println(dp[n]);
    }
}