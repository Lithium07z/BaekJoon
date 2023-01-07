import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int max = Integer.MIN_VALUE;
		int s = 0;
		int e = K;
		
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		do {
			int sum = 0;
			for (int i = s; i < e; i++) {
				sum += arr[i];
			}
			max = (sum > max)? sum : max;
			s++;
			e++;
		} while (e <= N);
		bfw.write(String.valueOf(max));
		bfw.flush();
		bfw.close();
	}
}