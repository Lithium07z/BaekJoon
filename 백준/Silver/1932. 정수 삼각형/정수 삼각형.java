import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = 0; j < i + 2 && j < i + 1; j++) {
				if (flag && i + 1 < N) {
					arr[i + 1][j] += arr[i][j];
				} else {
					flag = true;
				}
				
				if (j + 1 < i + 1 && arr[i][j] < arr[i][j + 1]) {
					continue;
				} else {
					if (i + 1 < N && j + 1 < arr[i + 1].length) {
						arr[i + 1][j + 1] += arr[i][j];
						flag = false;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			max = Math.max(arr[N - 1][i], max);
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
}
