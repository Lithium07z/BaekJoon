import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stk = new Stack<Integer>();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		int cnt = 0;

		Arrays.fill(dp, 1);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (N == 1) {
			bw.write(1 + "\n" + arr[0] + "\n");
		} else {

			for (int i = 1; i < N; i++) {
				int max = 0;
				for (int j = i - 1; j >= 0; j--) {
					if (arr[i] > arr[j] && max < dp[j]) {
						max = dp[j];
					}
				}
				dp[i] += max;
				cnt = Math.max(cnt, dp[i]);
			}

			bw.write(cnt + "\n");

			for (int i = dp.length - 1; i >= 0; i--) {
				if (cnt == dp[i]) {
					stk.add(arr[i]);
					cnt--;
				}
			}

			while (!stk.empty()) {
				bw.write(stk.pop() + " ");
			}
		}
		bw.flush();
		bw.close();
	}
}