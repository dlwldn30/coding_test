
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n%4 == 1 || n%4 == 3) {
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
