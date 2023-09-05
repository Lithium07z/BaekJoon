import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[100001];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());

			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 2;

			for (int j = 4; j <= P; j++) {
				dp[j] = (dp[j - 1] + dp[j - 2] + Q) % Q;
			}

			bw.write("Case #" + i + ": " + dp[P] % Q + "\n");
		}
		bw.flush();
		bw.close();
	}
}