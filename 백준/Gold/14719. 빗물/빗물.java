
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] blocks = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) blocks[i] = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int i = 0; i < m; i++){
            int leftMax = blocks[i];
            int rightMax = blocks[i];

            for(int j = i+1; j < m; j++){
                if(blocks[j] > rightMax){
                    rightMax = blocks[j];
                }
            }

            for(int j = 0; j < i; j++){
                if(blocks[j] > leftMax){
                    leftMax = blocks[j];
                }
            }

            int min = Math.min(leftMax, rightMax);
            int result = Math.abs(min - blocks[i]);
            count+= result;
        }

        System.out.println(count);
    }
}