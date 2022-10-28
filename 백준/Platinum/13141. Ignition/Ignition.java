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
		int maxArr[][] = new int[node + 1][node + 1];
		int minArr[][] = new int[node + 1][node + 1];
		double result = Integer.MAX_VALUE;

		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				if (i != j) {
					minArr[i][j] = 1000000000;
				}
			}
		}

		for (int i = 1; i <= edge; i++) {
			st = new StringTokenizer(bfr.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			maxArr[S][E] = Math.max(L, maxArr[S][E]);
			maxArr[E][S] = maxArr[S][E];
			minArr[S][E] = Math.min(L, minArr[S][E]);
			minArr[E][S] = minArr[S][E];
		}

		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				for (int k = 1; k <= node; k++) {
					minArr[j][k] = Math.min(minArr[j][k], minArr[j][i] + minArr[i][k]);
				}
			}
		}

		for (int i = 1; i <= node; i++) {
			double shortestTime = 0;
			for (int j = 1; j <= node; j++) {
				for (int k = 1; k <= node; k++) {
					if (minArr[j][k] != 1000000000) {
						double remainEdge = maxArr[j][k] - (minArr[i][k] - minArr[i][j]);
						if (remainEdge > 0) {
							shortestTime = Math.max(shortestTime, minArr[i][k] + remainEdge / 2);
						}
					}
				}
			}
			result = Math.min(result, shortestTime);
		}
		bfw.write(String.valueOf(result));
		bfw.flush();
		bfw.close();
	}
}