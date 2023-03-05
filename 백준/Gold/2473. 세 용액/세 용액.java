import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int rs = 0;
		int re = 0;
		int  rf = 0;
		int  s;
		int  e;
		int fixed = N;
		long  arr[] = new long[N];
		long min = Long.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		while (fixed > 2) {
			s = 0;
			e = fixed - 2;
			fixed--;
			while (s < e) {
				if (Math.abs(arr[s] + arr[e] + arr[fixed]) < min) {
					min = Math.abs(arr[s] + arr[e] + arr[fixed]);
					rs = s;
					re = e;
					rf = fixed;
				}
				if (arr[s] + arr[e] + arr[fixed] > 0) {
					e--;
				} else if (arr[s] + arr[e] + arr[fixed] < 0) {
					s++;
				} else {
					bw.write(arr[s] + " " + arr[e] + " " + arr[fixed]);
					bw.flush();
					bw.close();
					return;
				}
			}
		}
		
		bw.write(arr[rs] + " " + arr[re] + " " + arr[rf]);
		bw.flush();
		bw.close();
		return;
	}
}