
import java.io.*;
import java.util.*;


public class Main {

    static char[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String s = bufferedReader.readLine();

        map = s.toCharArray();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;




        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++){
                if (dp[j] == Integer.MAX_VALUE) continue;
                if(ok(i, j)){
                    dp[i] = Math.min(dp[i], dp[j] + (i-j) * (i-j));
                }
            }
        }

        System.out.println(dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1]);

    }

    static boolean ok(int i, int j){
        return (map[j] == 'B' && map[i] == 'O') ||
                (map[j] == 'O' && map[i] == 'J') ||
                (map[j] == 'J' && map[i] == 'B');
    }
}