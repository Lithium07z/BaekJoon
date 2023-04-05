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
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long arr[] = new long[K];
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		bw.write(binarySearch(arr, N, 1, arr[arr.length - 1]) + "\n");
		bw.flush();
		bw.close();
	}
	
	public static long binarySearch(long arr[], long t, long s, long e) {
		long mid = 0;
		while (s <= e) {
			mid = (s + e) / 2;
			
			long sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i] / mid;
			}

			if (sum >= t) {
				s = mid + 1;
			} else {
				e = mid - 1;
			} 
		}
		
		return e;
	}
}