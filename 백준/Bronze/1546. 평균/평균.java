import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        Double[] a = new Double[Integer.parseInt(bfr.readLine())];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(a);
        double total = 0;
        for (int j = 0; j < a.length; j++) {
            total += a[j] / a[a.length-1] * 100;
        }
        bfw.write(String.valueOf(total/a.length));
        bfw.flush();
        bfw.close();
    }
}