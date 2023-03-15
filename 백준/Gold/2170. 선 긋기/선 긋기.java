import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		
		int min = 0;
		int max = 0;
		int start = min = arr[0][0];
		int next = max = arr[0][1];
		for (int i = 1; i < N; i++) {
			if (next >= arr[i][0] && next <= arr[i][1]) {
				max = next = arr[i][1];
			} else {
				if (arr[i][0] < min || arr[i][1] > max) {
					sum += (next - start);
					start = arr[i][0];
					next = arr[i][1];
				}
			}
		}
		
		bw.write(sum + next - start + "\n");
		bw.flush();
		bw.close();
	}
}