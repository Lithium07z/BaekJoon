import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int size = Integer.parseInt(bfr.readLine());
		int arr[][] = new int[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < size; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 0) {
					arr[i][j] = Integer.MAX_VALUE;
				} else {
					arr[i][j] = temp;
				}
			}
		}

		for (int m = 0; m < size; m++) {
			for (int s = 0; s < size; s++) {
				for (int e = 0; e < size; e++) {
					if (arr[s][m] == 1 && arr[m][e] == 1) {
						arr[s][e] = 1;
					}
				}
			}
		}

		for (int result1[] : arr) {
			for (int result2 : result1) {
				if (result2 == Integer.MAX_VALUE) {
					bfw.write("0 ");
				} else {
					bfw.write(String.valueOf(result2) + " ");
				}
			}
			bfw.write("\n");
		}
		bfw.flush();
		bfw.close();
	}
}