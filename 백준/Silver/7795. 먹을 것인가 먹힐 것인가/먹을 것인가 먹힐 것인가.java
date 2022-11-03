import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int cases = Integer.parseInt(bfr.readLine());

		for (int i = 0; i < cases; i++) {
			st = new StringTokenizer(bfr.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr1[] = new int[N];
			int arr2[] = new int[M];
			int count = 0;

			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < N; j++) {
				arr1[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr1);

			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < M; j++) {
				arr2[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr2);

			for (int j = N - 1; j >= 0; j--) {
				for (int k = 0; k < M; k++) {
					if (arr1[j] <= arr2[k]) {
						break;
					} else {
						count++;
					}
				}
			}
			bfw.write(String.valueOf(count) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}