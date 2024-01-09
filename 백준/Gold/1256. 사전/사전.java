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
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int acnt = N;
		int zcnt = M;
		long dp[][] = new long[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
		}
		
		for (int j = 1; j <= M; j++) {
			dp[0][j] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] > 1000000000 ? 1000000000 : dp[i - 1][j] + dp[i][j - 1];
			}
		}
		
		if (K > dp[N][M]) {
			bw.write("-1");
			bw.flush();
			bw.close();
			return;
		}
		
		for (int i = 0; i < N + M; i++) {
			if (acnt == 0) {
				bw.write("z");
				zcnt--;
				continue;
			}
			
			if (zcnt == 0) {
				bw.write("a");
				acnt--;
				continue;
			}
			
			long temp = dp[acnt - 1][zcnt];
			if (K <= temp) {
				bw.write("a");
				acnt--;
			} else {
				K -= temp;
				bw.write("z");
				zcnt--;
			}
		}
		
		bw.flush();
		bw.close();
	}
}
