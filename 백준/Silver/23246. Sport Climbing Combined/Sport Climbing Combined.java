import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bfr.readLine());
		int arr[][] = new int[n][4];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] * o1[2] * o1[3] == o2[1] * o2[2] * o2[3] && o1[1] + o1[2] + o1[3] == o2[1] + o2[2] + o2[3]) {
					return o1[0] - o2[0];
				} else if (o1[1] * o1[2] * o1[3] == o2[1] * o2[2] * o2[3]) {
					return (o1[1] + o1[2] + o1[3]) - (o2[1] + o2[2] + o2[3]);
				} else {
					return (o1[1] * o1[2] * o1[3]) - (o2[1] * o2[2] * o2[3]);
				}
			}
		});

		for (int i = 0; i < 3; i++) {
			bfw.write(String.valueOf(arr[i][0]) + " ");
		}
		bfw.flush();
		bfw.close();
	}
}