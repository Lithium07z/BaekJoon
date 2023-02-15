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
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N + 1];
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		A[0] = -1000000001;
		for (int i = 1; i < N + 1; i++) {
			int t = Integer.parseInt(st.nextToken());
			if (A[i - 1] < t) {
				A[i] = t;
				cnt++;
			} else {
				int s = 1;
				int e = i - 1;
				while (s <= e) {
					int m = (s + e) / 2;
					if (t <= A[m]) {
						e = m - 1;
					} else {
						s = m + 1;
					}
				}
				A[s] = t;
				i--;
				N--;
			}
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
}