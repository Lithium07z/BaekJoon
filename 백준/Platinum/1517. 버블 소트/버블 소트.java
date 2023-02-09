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

	private static void theMergeSort(long[] a, long[] temp, int left,	int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			theMergeSort(a, temp, left, middle);
			theMergeSort(a, temp, middle + 1, right);
			merge(a, temp, left, middle, middle + 1, right);
		}
	}

	private static void merge(long[] a, long[] temp, int m, long p, int q, int n) {
		int t = m;
		long num = n - m + 1;
		long cnt = 0;

		while (m <= p && q <= n) {
			if (a[m] <= a[q]) {
				temp[t++] = a[m++];
				result += cnt;
			} else {
				temp[t++] = a[q++];
				cnt++;
			}
		}
		
		while (m <= p) {
			temp[t++] = a[m++];
			result += cnt;	
		}
		
		while (q <= n) {
			temp[t++] = a[q++];
			cnt++;
		}
		
		for (int i = 0; i < num; i++, n--) {
			a[n] = temp[n];
		}
	}
}