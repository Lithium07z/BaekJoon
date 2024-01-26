import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int graph[][] = new int[P + 1][P + 1];
		int position[] = new int[N];
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= P; i++) {
			for (int j = 1; j <= P; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			position[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A][B] = graph[B][A] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= P; i++) {
			for (int j = 1; j <= P; j++) {
				for (int k = 1; k <= P; k++) {
					if (i != j && j != k && i != k) {
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
					}
				}
			}
		}
		
		for (int i = 1; i <= P; i++) {
			int temp = 0;
			
			for (int j = 0; j < N; j++) {
				temp += graph[position[j]][i];
			}
			min = Math.min(min, temp);
		}
		
		bw.write(min + "\n");
		bw.flush();
		bw.close();
	}
}