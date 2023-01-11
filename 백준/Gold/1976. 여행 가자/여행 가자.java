import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (i == j) {
					arr[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (arr[j][i] == 1 && arr[i][k] == 1) {
						arr[j][k] = 1;
					}
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		while (st.hasMoreTokens()) {
			if (arr[start - 1][Integer.parseInt(st.nextToken()) - 1] == 0) {
				bw.write("NO");
				bw.flush();
				bw.close();
				return;
			} 
		}
		bw.write("YES");
		bw.flush();
		bw.close();
	}
}