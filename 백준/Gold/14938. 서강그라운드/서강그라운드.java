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
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int graph[][] = new int[n + 1][n + 1];
		int arr[] = new int[n];
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (graph[a][b] != 0 && c < graph[a][b]) {
				graph[a][b] = graph[b][a] = c;
			} else if (graph[a][b] == 0) {
				graph[a][b] = graph[b][a] = c;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j && graph[i][j] == 0) {
					graph[i][j] = 100000000;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (graph[j][k] > graph[j][i] + graph[i][k]) {
						graph[j][k] = graph[j][i] + graph[i][k];
					}
				}
			}
		}

		for (int i = 1; i < graph.length; i++) {
			int temp = 0;
			for (int j = 1; j < graph.length; j++) {
				if (graph[i][j] <= m) {
					temp += arr[j - 1];
				}
			}			
			sum = Math.max(sum, temp);
		}
		
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}
}