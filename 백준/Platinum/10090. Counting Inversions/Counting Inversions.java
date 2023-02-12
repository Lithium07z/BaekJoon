import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		mergeSort(arr);
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}

	public static void mergeSort(long[] a) {
		long temp[] = new long[a.length];
		theMergeSort(a, temp, 0, a.length - 1);
	}

	private static void theMergeSort(long[] a, long[] temp, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			theMergeSort(a, temp, left, middle);
			theMergeSort(a, temp, middle + 1, right);
			merge(a, temp, left, middle, middle + 1, right);
		}
	}

	private static void merge(long[] a, long[] temp, int m, int p, int q, int n) {
		int i = m;
		int t = m;
		
		while (i <= p && q <= n) {	
			if (a[i] < a[q]) {
				temp[t++] = a[i++];
			} else if (a[i] > a[q]) {
				temp[t++] = a[q++];
				result += q - t;
			} else {
				temp[t++] = a[q++];
			}
		}
		
		while (i <= p) {	
			temp[t++] = a[i++];
		}
		
		while (q <= n) {	
			temp[t++] = a[q++];
		}
		i = m;
		
		while (i <= n) {
			a[i] = temp[i++];
		}
	}
}