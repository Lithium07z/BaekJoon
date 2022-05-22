import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr1 = new int[n][m];

		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bfr.readLine());
				for (int j = 0; j < m; j++) {
					if (k == 0) {
						arr1[i][j] = 0;
					}
					arr1[i][j] += Integer.parseInt(st.nextToken());
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bfw.write(String.valueOf(arr1[i][j] + " "));
			}
			bfw.write("\n");
		}
		bfw.flush();
		bfw.close();
	}
}