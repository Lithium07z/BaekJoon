import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		long arr[][] = new long[N][N];
		int INF = 987654321;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					arr[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
		
			arr[a][b] = arr[b][a] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()) - 1;
		int v2 = Integer.parseInt(st.nextToken()) - 1;
		long min = Math.min(arr[0][v1] + arr[v1][v2] + arr[v2][N - 1], arr[0][v2] + arr[v2][v1] + arr[v1][N - 1]);
		
		bw.write((min >= INF)? "-1" : min + "\n");
		bw.flush();
		bw.close();
	}
}