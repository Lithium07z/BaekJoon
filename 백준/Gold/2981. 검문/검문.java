import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(bfr.readLine());
		int arr[] = new int[loop];
		
		for (int i = 0; i < loop; i++) {
			arr[i] = Integer.parseInt(bfr.readLine());
		}
		Arrays.sort(arr); 
		
		int gcdVal = arr[1] - arr[0];
		
		for (int i = 2; i < loop; i++) {
			gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);
		}

		for (int i = 2; i <= gcdVal; i++) {
			if (gcdVal % i == 0) {
				bfw.write(String.valueOf(i) + " ");
			}
		}
		bfw.flush();
		bfw.close();
	}
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;		
		}
		return a;
	}
}