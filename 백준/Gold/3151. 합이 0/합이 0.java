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
		long cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int u = binarySearchUpperBound(arr, -(arr[i] + arr[j]), j + 1, N);
				int l = binarySearchLowerBound(arr, -(arr[i] + arr[j]), j + 1, N);
				cnt += u - l;
			}
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
	
	public static int binarySearchLowerBound(int arr[], int t, int s, int e) {
		while (s < e) {
			int mid = (s + e) / 2;

			if (arr[mid] >= t) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}
		return s; 
	}
	
	public static int binarySearchUpperBound(int arr[], int t, int s, int e) {
		while (s < e) {
			int mid = (s + e) / 2;

			if (arr[mid] > t) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}
		return s; 
	}
}