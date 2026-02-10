
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i<N; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                if(heap.isEmpty()) {
                    System.out.println("0");
                    continue;
                }

                System.out.println(heap.poll());
            }else{
                heap.add(n);
            }
        }


    }
}
