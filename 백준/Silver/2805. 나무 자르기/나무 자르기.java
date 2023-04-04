import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long M;
	static long height[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		height = new long[N];
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(height);
		
		bw.write(binarySearch(height, M, 0, height[N - 1]) + "\n");
		bw.flush();
		bw.close();
	}

	public static long binarySearch(long height[], long t, long s, long e) {
		while (s < e) {
			long mid = s + (e - s) / 2;

			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (height[i] > mid) {
					sum += height[i] - mid;
				}
			}

			if (sum < t) {
				e = mid;
			} else if (sum > t) {
				s = mid + 1;
			} else {
				return mid;
			}
		}

		return e - 1;
	}
}