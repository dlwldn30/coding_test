

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int n1 = n;
            int n5 = n/5;



            for(int i = n5; i >= 0; i--){
                int n2 = n - 5*i;
                if(n2%3 == 0){
                    int n3 = n2/3;
                    System.out.println(i + n3);
                    return;
                }
            }

            if(n1%3 == 0){
                System.out.println(n1/3);
                return;
            }

            System.out.println(-1);
    }
}