
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
             int result = 1;
             result += a/2;
             for(int j = 1; j <= a/3; j++){
                 int a1 = a-3*j;
                 result += a1/2+1;
             }
             sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
