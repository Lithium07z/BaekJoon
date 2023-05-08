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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int graph[][] = new int[N][N];
		int road[][] = new int[M][3];
		int INF = 987654321;
		
		for (int i = 0 ; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			road[i][0] = Integer.parseInt(st.nextToken());
			road[i][1] = Integer.parseInt(st.nextToken());
			road[i][2] = Integer.parseInt(st.nextToken());
			graph[road[i][0]][road[i][1]] = graph[road[i][1]][road[i][0]] = road[i][2];
		}
				
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			int temp[][] = new int[N][N];
			int cnt = 0;
			
			for (int j = 0 ; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (j != k) {
						temp[j][k] = INF;
					}
				}
			}
			
			for (int j = 0; j < M; j++) {
				if (i != j) { 
					temp[road[j][0]][road[j][1]] = temp[road[j][1]][road[j][0]] = road[j][2];
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < N; l++) {
						temp[k][l] = Math.min(temp[k][l], temp[k][j] + temp[j][l]);
					}
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) { 
					if (temp[j][k] > graph[j][k]) {
						cnt++;
					}
				}
			}
			
			bw.write(cnt / 2 + " ");
		}
		
		bw.flush();
		bw.close();
	}
}