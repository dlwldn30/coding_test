
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger total = BigInteger.ONE;

        for (int i = n; i > n-m; i--){
            total = total.multiply(BigInteger.valueOf(i));
        }
        for (int i = 1; i <= m; i++){
            total = total.divide(BigInteger.valueOf(i));
        }

        System.out.println(total);
    }
}
