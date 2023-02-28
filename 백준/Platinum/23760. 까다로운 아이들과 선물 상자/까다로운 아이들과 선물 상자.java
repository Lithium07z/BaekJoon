import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int i = 0;

		st1 = new StringTokenizer(br.readLine());

		for (i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st1.nextToken()));
		}

		Collections.sort(arr, Collections.reverseOrder());

		st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (i = 0; i < M; i++) {
			int gift = arr.remove(Integer.parseInt(st2.nextToken()) - 1);
			int child = Integer.parseInt(st1.nextToken());
			if (gift - child >= 0) {
				binarySearch(arr, 0, arr.size() - 1, gift - child);
			} else {
				break;
			}
		}

		if (i == M) {
			bw.write("1");
		} else {
			bw.write("0");
		}
		bw.flush();
		bw.close();
	}

	public static void binarySearch(ArrayList<Integer> arr, int low, int high, int key) {
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr.get(mid) == key) {
				arr.add(mid, key);
				return;
			} else if (arr.get(mid) < key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		arr.add(low, key);
		return;
	}
}