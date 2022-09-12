import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] prime = new boolean[N + 1];
		int count = 0;

		for (int i = 2; i <= N; i++) {
			prime[i] = true;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				if (!prime[j]) {
					continue;
				}
				
				prime[j] = false;
				count++;
				
				if (count == K) {
					bfw.write(String.valueOf(j));
					bfw.flush();
					bfw.close();
				}
			}
		}
	}
}