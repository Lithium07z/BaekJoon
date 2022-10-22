import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		int arr[] = new int[1000001];
		
		if (A == B) {
			arr[1] = 0;
			bfw.write(String.valueOf(arr[count]));
		} else {
			A %= B;
			for (int i = 1; i < arr.length; i++) {
				A *= 10;
				arr[i] = A / B;
				A %= B;
			}
			bfw.write(String.valueOf(arr[count]));
		}
		bfw.flush();
		bfw.close();
	}
}