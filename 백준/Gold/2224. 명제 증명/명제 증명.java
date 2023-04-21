import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int graph[][] = new int[52][52];
		int cnt = 0;
		
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {
				if (i != j) {
					graph[i][j] = INF; 
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			String t = br.readLine();
			int p = t.charAt(0);
			int q = t.charAt(5);
	
			if (p < 91) {
				p -= 65;
			} else {
				p -= 71;
			}
			if (q < 91) {
				q -= 65;
			} else {
				q -= 71;
			}
			graph[p][q] = 1;
		}
		
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {
				for (int k = 0; k < 52; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {
				if (i != j && graph[i][j] != INF) {
					cnt++;
					if (i < 26) {
						sb.append((char)(i + 65)).append(" => ");
					} else {
						sb.append((char)(i + 71)).append(" => ");
					}
					if (j < 26) {
						sb.append((char)(j + 65)).append("\n");
					} else {
						sb.append((char)(j + 71)).append("\n");
					}
				}
			}
		}
		
		bw.write(cnt + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}