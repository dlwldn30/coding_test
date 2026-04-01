
import java.io.*;
import java.util.*;


public class Main {

    static class Node{
        int screen;
        int clip;
        int dist;

        public Node(int screen, int clip, int dist) {
            this.screen = screen;
            this.clip = clip;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[1001][1001]; // 현재와 클립

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0, 0));
        visited[1][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.screen == n){
                System.out.println(cur.dist);
                return;
            }

            //붙여넣기
            if(cur.clip > 0 && cur.screen + cur.clip <= 1000 && !visited[cur.screen+cur.clip][cur.clip]){
                visited[cur.screen+cur.clip][cur.clip] = true;
                q.add(new Node(cur.screen + cur.clip, cur.clip, cur.dist+1));
            }
            // clip에 복사
            if(!visited[cur.screen][cur.screen]){
                visited[cur.screen][cur.screen] = true;
                q.add(new Node(cur.screen, cur.screen, cur.dist+1));
            }
            //이모티콘 하나 지우기
            if(cur.screen > 1 && !visited[cur.screen-1][cur.clip]){
                visited[cur.screen-1][cur.clip] = true;
                q.add(new Node(cur.screen-1, cur.clip, cur.dist+1));
            }

        }


    }
}
