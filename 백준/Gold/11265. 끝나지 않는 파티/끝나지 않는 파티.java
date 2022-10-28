import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int arr[][] = new int[node + 1][node + 1];

		for (int i = 1; i <= node; i++) {
			st = new StringTokenizer(bfr.readLine());
			for (int j = 1; j <= node; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				for (int k = 1; k <= node; k++) {
					if (arr[j][k] > arr[j][i] + arr[i][k]) {
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}
			}
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(bfr.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if (arr[A][B] <= C) {
				bfw.write("Enjoy other party\n");
			} else {
				bfw.write("Stay here\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}