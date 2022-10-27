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
		int node = Integer.parseInt(bfr.readLine());
		int edge = Integer.parseInt(bfr.readLine());
		int arr[][] = new int[node + 1][node + 1];
		int count = 0;
		
		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				if (i != j) {
					arr[i][j] = 1000000000;
				}
			}
		}
		
		for (int i = 1; i <= edge; i++) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A][B] = 1;
			arr[B][A] = 1;
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
		
		for (int i = 2; i <= node; i++) {
			if (arr[i][1] != 1000000000) {
				count++;
			}
		}
		
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}