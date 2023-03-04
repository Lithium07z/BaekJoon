import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Integer> list = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N + 1];
		int size = 0;
		int cnt = 0;
		int s = 0;
		int e = 1;
		
		for (int i = 2; i <= N; i++) {
			arr[i] = i;
		}
		
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (arr[i] != 0) {
				for (int j = i * i; j <= N; j += i) {
					if (arr[j] != 0) {
						arr[j] = 0;
						size++;
					}
				}
			}
		}
		
		int[] dp = new int[N - size];
		int j = 1;
		for (int temp : arr) {
			if (temp != 0) {
				dp[j++] = temp;
			}
		}
				
		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i] + dp[i - 1];
		}
		
		while (e < dp.length && s < dp.length) {
			if (dp[e] - dp[s] < N) {
				e++;
			} else if (dp[e] - dp[s] > N) {
				s++;
			} else {
				cnt++;
				e++;
			}
		}
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
}