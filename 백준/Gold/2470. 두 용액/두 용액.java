import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int rs = 0;
		int re = 0;
		int s = 0;
		int e = N - 1;
		int arr[] = new int[N];
		int min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		while (true) {
			if (arr[s] + arr[e] > 0) {
				if (Math.abs(arr[s] + arr[e]) < min) {
					min = Math.abs(arr[s] + arr[e]);
					rs = s;
					re = e;
				}
				e--;
				if (s >= e) {
					bw.write(arr[rs] + " " + arr[re]);
					bw.flush();
					bw.close();
					return;
				}
			} else if (arr[s] + arr[e] < 0) {
				if (Math.abs(arr[s] + arr[e]) < min) {
					min = Math.abs(arr[s] + arr[e]);
					rs = s;
					re = e;
				}
				s++;
				if (s >= e) {
					bw.write(arr[rs] + " " + arr[re]);
					bw.flush();
					bw.close();
					return;
				}
			} else {
				bw.write(arr[s] + " " + arr[e]);
				bw.flush();
				bw.close();
				return;
			}
		}
	}
}