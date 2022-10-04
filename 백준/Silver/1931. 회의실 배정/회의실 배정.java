import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int total = Integer.parseInt(bfr.readLine());
		int arr[][] = new int[total][2];
		int count = 0;

		for (int i = 0; i < total; i++) {
			st = new StringTokenizer(bfr.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			} else {
				return o1[1] - o2[1];
			}
		});

		int compare = -1;
		for (int i = 0; i < total; i++) {
			if (compare <= arr[i][0]) {
				compare = arr[i][1];
				count++;
			}
		}

		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}