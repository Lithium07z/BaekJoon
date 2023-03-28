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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int min = Integer.MAX_VALUE;
		int s = 0;
		int e = 1;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		while (s < N && e < N) {
			if (arr[e] - arr[s] < M) {
				e++;
			} else if (arr[e] - arr[s] > M) {
				if (min > arr[e] - arr[s]) {
					min = arr[e] - arr[s];
				}
				s++;
			} else {
				bw.write(M + "\n");
				bw.flush();
				bw.close();
				return;
			}
		}
		
		bw.write(min + "\n");
		bw.flush();
		bw.close();
	}
}