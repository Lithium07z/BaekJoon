import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        int a[] = new int[42];
        Arrays.fill(a, 0);
        
        for (int i = 0; i < 10; i++) {
        	int b = Integer.parseInt(bfr.readLine());
        	a[b%42]++;
        }
        for (int value : a) {
        	if (value != 0) {
        		count += 1;
        	}
        }
        bfw.write(String.valueOf(count));
        bfw.flush();
        bfw.close();
    }
}