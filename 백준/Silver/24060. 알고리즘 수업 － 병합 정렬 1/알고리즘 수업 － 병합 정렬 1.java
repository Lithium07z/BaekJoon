import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long K = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long arr[] = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		mergeSort(arr);
		
		bw.write("-1");
		bw.flush();
		bw.close();
	}

	public static void mergeSort(long[] a) throws IOException {
		long temp[] = new long[a.length];
		theMergeSort(a, temp, 0, a.length - 1);
	}

	private static void theMergeSort(long[] a, long[] temp, int left, int right) throws IOException {
		if (left < right) {
			int middle = (left + right) / 2;
			theMergeSort(a, temp, left, middle);
			theMergeSort(a, temp, middle + 1, right);
			merge(a, temp, left, middle, middle + 1, right);
		}
	}

	private static void merge(long[] a, long[] temp, int m, int p, int q, int n) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i = m;
		int t = m;
		
		while (i <= p && q <= n) {	// 나뉘어진 두 배열의 값 중 더 작은 쪽을 임시배열에 저장
			if (a[i] <= a[q]) {
				temp[t++] = a[i++];
			} else {
				temp[t++] = a[q++];
			}
		}
		
		while (i <= p) {	// q가 범위를 벗어난 경우
			temp[t++] = a[i++];
		}
		
		while (q <= n) {	// m이 범위를 벗어난 경우
			temp[t++] = a[q++];
		}
		i = m;
		
		while (i <= n) {
			a[i] = temp[i++];
			if (--K == 0) {
				bw.write(temp[i - 1] + "\n");
				bw.flush();
				bw.close();
			}
		}
	}
}