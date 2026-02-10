
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if(absA != absB) return absA - absB;

                    return a-b;
                }
        );


        for (int i = 0; i<N; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                sb.append(pq.isEmpty() ? "0" : pq.poll()).append("\n");
            }else{
                pq.offer(n);
            }
        }
        System.out.println(sb);
    }
}
