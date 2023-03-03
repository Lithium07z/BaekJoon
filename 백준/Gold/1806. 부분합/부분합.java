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
		int S = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int dp[] = new int[N + 1];
		int len = Integer.MAX_VALUE;
		int sum = 0;
		int s = 0;
		int e = 1;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (S == 0) {
			bw.write("1");
			bw.flush();
			bw.close();
			return;
		}
		
		dp[1] = arr[0];
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + arr[i - 1];
		}
		
		while (e <= N && s <= N) {
			sum = dp[e] - dp[s];	
			if (sum < S) {
				e++;
			} else if (sum >= S) {
				len = Math.min(e - s, len);
				s++;
			}
		}
		
		if (len == Integer.MAX_VALUE) {
			bw.write("0");
		} else {
			bw.write(len + "\n");
		}
		bw.flush();
		bw.close();
	}
}