import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;  
        int l = Integer.parseInt(bfr.readLine());
        
        for (int i = 1; i <= l; i++) {
            st = new StringTokenizer(bfr.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfw.write("Case #" + i + ": " + a + " + " + b + " = " + (a+b) + "\n");      
        }
        bfw.close();
    }
}