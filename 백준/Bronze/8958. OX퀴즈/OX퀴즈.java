import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(bfr.readLine());
        int[]  b = new int[a];
        
        for (int i = 0; i < a; i++) {
            int count = 0;
            int total = 0;
            String s = bfr.readLine();
            char[] c = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                c[j] = s.charAt(j);
            }
            for (int k = 0; k < s.length(); k++) {
                if (c[k] == 'O') {
                    count = count + 1;
                    total += count;
                } else {
                    count = 0;
                }
            }
            b[i] = total;
        }
        for (int value : b) {
            bfw.write(String.valueOf(value) + "\n");
        } 
        bfw.flush();
        bfw.close();
    }
}