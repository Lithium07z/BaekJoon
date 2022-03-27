import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[9];
        int max = 0;
        int maxIdx = 0;
        
        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(bfr.readLine());
            if (max < a[i]) {
                max = a[i];
                maxIdx = i + 1;
            }
        }
        System.out.print(max + "\n" + maxIdx);
    }
}