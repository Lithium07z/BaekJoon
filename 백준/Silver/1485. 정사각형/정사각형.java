import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int total = Integer.parseInt(bfr.readLine());
		int arr[][] = new int[4][2];

		for (int i = 0; i < total * 4; i++) {

			st = new StringTokenizer(bfr.readLine());
			arr[i % 4][0] = Integer.parseInt(st.nextToken());
			arr[i % 4][1] = Integer.parseInt(st.nextToken());

			if (i % 4 == 3) {
				Arrays.sort(arr, (o1, o2) -> {
					if (o1[0] == o2[0]) {
						return o1[1] - o2[1];
					} else {
						return o1[0] - o2[0];
					}
				});
				
				int diagonal1 = (int)Math.sqrt(Math.pow(arr[0][0] - arr[3][0], 2) + Math.pow(arr[0][1] - arr[3][1], 2));
				int diagonal2 = (int)Math.sqrt(Math.pow(arr[1][0] - arr[2][0], 2) + Math.pow(arr[1][1] - arr[2][1], 2));
				int line1 = (int)Math.sqrt(Math.pow(arr[0][0] - arr[1][0], 2) + Math.pow(arr[0][1] - arr[1][1], 2));
				int line2 = (int)Math.sqrt(Math.pow(arr[0][0] - arr[2][0], 2) + Math.pow(arr[0][1] - arr[2][1], 2));
				
				if (diagonal1 == diagonal2 && line1 == line2) {
					bfw.write("1\n");
				} else {
					bfw.write("0\n");
				}
			}
		}
		bfw.flush();
		bfw.close();
	}
}