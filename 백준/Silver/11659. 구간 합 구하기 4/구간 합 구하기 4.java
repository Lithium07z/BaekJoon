import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[] = new int[n + 1];
		
		st = new StringTokenizer(bfr.readLine());
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) { // i까지의 누적합 구하기
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < m; i++)  {
			st = new StringTokenizer(bfr.readLine());
			int f = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bfw.write(String.valueOf(arr[b] - arr[f - 1]) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}