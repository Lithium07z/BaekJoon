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
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sum += arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int total = Integer.parseInt(br.readLine());
		int s = 0;
		int e = arr[N - 1];
		
		if (sum <= total) {
			bw.write(arr[N - 1] + "\n");
			bw.flush();
			bw.close();
			return;
		}
		
		while (s <= e) {
			int mid = (s + e) / 2;
			int temp = 0;
			
			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					temp += mid;
				} else {
					temp += arr[i];
				}
			}
			
			if (temp > total) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		
		bw.write(e + "\n");
		bw.flush();
		bw.close();
	}
}