import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = new int[Integer.parseInt(bfr.readLine())];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int i = 0;
        
        while(st.hasMoreTokens()) {
            a[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(a);
        System.out.print(a[0] + " " + a[a.length-1]);
    }
}