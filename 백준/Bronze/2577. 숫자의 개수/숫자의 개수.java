import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bfr.readLine());
        int b = Integer.parseInt(bfr.readLine());
        int c = Integer.parseInt(bfr.readLine());
        int[] d = new int[10];
        
        for (int i = 0; i < String.valueOf(a*b*c).length(); i++) {
            int g = Character.getNumericValue(String.valueOf(a*b*c).charAt(i));
            d[g] = d[g] + 1;
        }
        for (int value : d) {
        	System.out.println(value);
        }
    }
}