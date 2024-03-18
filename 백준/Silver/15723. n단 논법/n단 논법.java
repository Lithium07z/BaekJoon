import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int graph[][] = new int[26][26];
		int INF = 987654321;
		
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				graph[i][j] = INF;
			}
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = st.nextToken().charAt(0) - 'a';
			st.nextToken();
			int b = st.nextToken().charAt(0) - 'a';
			
			graph[a][b] = 1;
		}
		
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				for (int k = 0; k < 26; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = st.nextToken().charAt(0) - 'a';
			st.nextToken();
			int b = st.nextToken().charAt(0) - 'a';
			
			bw.write(graph[a][b] == INF ? "F\n" : "T\n");
		}
		
		bw.flush();
		bw.close();
	}
}