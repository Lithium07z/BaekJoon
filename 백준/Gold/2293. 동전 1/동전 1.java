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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N + 1];
		int dp[] = new int[K + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				if (arr[i] <= j) {
					dp[j] += dp[j - arr[i]]; 
				}
			}
		}
		
		bw.write(dp[K] + "\n");
		bw.flush();
		bw.close();
	}
}