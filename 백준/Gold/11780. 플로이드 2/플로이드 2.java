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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int node = Integer.parseInt(bfr.readLine());
		int edge = Integer.parseInt(bfr.readLine());
		int arr[][] = new int[node + 1][node + 1];
		String city[][] = new String[node + 1][node + 1];

		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				if (i != j && arr[i][j] == 0) {
					arr[i][j] = 1000000;
				}
			}
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(bfr.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (arr[a][b] == 0 || arr[a][b] > c) {
				arr[a][b] = c;
			}
			if (city[a][b] == null) {
				sb.setLength(0);
				city[a][b] = sb.append(a).append(" ").append(b).toString();
			}
		}

		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				for (int k = 1; k <= node; k++) {
					if (arr[j][k] > arr[j][i] + arr[i][k]) {
						arr[j][k] = arr[j][i] + arr[i][k];
						sb.setLength(0);
						city[j][k] = sb.append(city[j][i]).append(city[i][k].substring((int)(Math.log10(i) + 1))).toString();
					}
				}
			}
		}
		sb.setLength(0);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[i][j] == 1000000) {
					sb.append("0 ");
				} else {
					sb.append(arr[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}

		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				if (city[i][j] == null) {
					sb.append("0 \n");
				} else {
					sb.append(city[i][j].split(" ").length).append(" ").append(city[i][j]).append("\n");
				}
			}
		}
		bfw.write(sb.toString());
		bfw.flush();
		bfw.close();
	}
}