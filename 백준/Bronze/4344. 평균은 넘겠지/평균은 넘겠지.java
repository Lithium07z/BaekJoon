import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int a = Integer.parseInt(bfr.readLine());
        double[] d = new double[a];
        
        for (int i = 0; i < a; i++) {
        	st = new StringTokenizer(bfr.readLine());
            Double[] b = new Double[Integer.parseInt(st.nextToken())];
            double c = 0;
            double count= 0;
            for (int j = 0; j < b.length; j++) {
            	b[j] = Double.parseDouble(st.nextToken());
            	c += b[j];
            }
            c = c / b.length;
            for (int k = 0; k < b.length; k++) {
                if (b[k] > c) {
                    count += 1;
                }
            }
            d[i] = count / b.length * 100;
        }
        for (double value : d) {
        	String result = String.format("%.3f" , value);
            bfw.write(result + "%\n");
        }
        bfw.flush();
        bfw.close();
    }
}