

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());



        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            int result = 0;
            int n3 = num/3;
            for(int j = 1; j <= n3; j++){
                int num3 = num - j*3;
                result += num3/2+1;
            }
            result += num/2;
            System.out.println(result+1);
        }



    }
}