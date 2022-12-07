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
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int arr[][] = new int[node + 1][node + 1];
		int point[][] = new int[node + 1][node + 1];

		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				if (i != j) {
					arr[i][j] = 100000000;
				} else {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(bfr.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = c;
			point[a][b] = b;
			point[b][a] = a;
		}

		for (int m = 1; m <= node; m++) {
			for (int s = 1; s <= node; s++) {
				for (int e = 1; e <= node; e++) {
					if (arr[s][e] > arr[s][m] + arr[m][e]) {
						arr[s][e] = arr[s][m] + arr[m][e];
						point[s][e] = point[s][m];
					}
				}
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (point[i][j] == 0) {
					bfw.write("- ");
				} else {
					bfw.write(String.valueOf(point[i][j]) + " ");
				}
			}
			bfw.write("\n");
		}
		bfw.flush();
		bfw.close();
	}
}