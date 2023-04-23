import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	static BigInteger arr[] = new BigInteger[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N + 1];
		int dp[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (N == 1) {
			dp[1] = arr[1];
		} else if (N == 2) {
			dp[2] = arr[1] + arr[2];
		} else if (N > 2) {
			dp[1] = arr[1];
			dp[2] = arr[1] + arr[2];
			dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
			for (int i = 4; i <= N; i++) {
				dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i] + arr[i - 1]);
			}
		}

		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
	}
}