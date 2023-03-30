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
		int A[] = new int[N];
		int B[] = new int[N];
		int C[] = new int[N];
		int D[] = new int[N];
		long AB[] = new long[N * N];
		long CD[] = new long[N * N];
		int cnt = 0;
		long result = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[cnt] = A[i] + B[j];
				CD[cnt++] = C[i] + D[j];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		for (int i = 0; i < AB.length; i++) {
			long idx1 = binarySearchLowerBound(CD, -AB[i], 0, CD.length);
			long idx2 = binarySearchUpperBound(CD, -AB[i], 0, CD.length);
			result += idx2 - idx1;
		}
		 
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
	
	public static long binarySearchLowerBound(long arr[], long t, int s, int e) {
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
	
	public static long binarySearchUpperBound(long arr[], long t, int s, int e) {
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