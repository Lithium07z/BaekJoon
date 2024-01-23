import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedHashMap<Integer, Point> map = new LinkedHashMap<Integer, Point>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int graph[][] = new int[N + 1][N + 1];
		boolean special[] = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int sp = Integer.parseInt(st.nextToken());
			
			if (sp == 1) {
				special[i] = true;
			}
			
			map.put(i, new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 1; i < N; i++) { 
			for (int j = i + 1; j <= N; j++) { 
				int len = Math.abs(map.get(i).x - map.get(j).x) + Math.abs(map.get(i).y - map.get(j).y);
				
				graph[i][j] = graph[j][i] = special[i] && special[j] ? Math.min(T, len) : len;
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (i != j && j != k && i != k) {
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
					}
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			bw.write(graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}