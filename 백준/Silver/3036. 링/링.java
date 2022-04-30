import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(bfr.readLine());
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int arr[] = new int[loop];
		
		for (int i = 0; i < loop; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < loop; i++) {
			if (arr[0] % arr[i] == 0) {
				bfw.write(String.valueOf(arr[0] / arr[i]) + "/1\n");
			} else {
				bfw.write(String.valueOf(arr[0] / gcd(arr[0], arr[i])) + "/" + String.valueOf(arr[i] / gcd(arr[0], arr[i])) + "\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}