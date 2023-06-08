import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long arr[][] = new long [2][N];
		double sum1 = 0;
		double sum2 = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			arr[0][i] = Long.parseLong(st.nextToken());
			arr[1][i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = 0; i < N - 1; i++) {
			sum1 += arr[0][i] * arr[1][i + 1];
			sum2 += arr[1][i] * arr[0][i + 1];
		}
		sum1 += arr[0][N - 1] * arr[1][0];
		sum2 += arr[1][N - 1] * arr[0][0];
		
		bw.write(String.format("%.1f", Math.abs(sum1 - sum2) / 2));
		bw.flush();
		bw.close();
	}
}
