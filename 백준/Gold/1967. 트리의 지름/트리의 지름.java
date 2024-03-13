import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Point> graph[];
	static boolean visited[];
	static int point = -1;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Point>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			
			graph[s].add(new Point(e, v));
			graph[e].add(new Point(s, v));
		}
		
		DFS(0, 0);
		visited = new boolean[N];
		DFS(point, 0);
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int start, int weight) {
		visited[start] = true;

		if (weight > max) {
			max = weight;
			point = start;
		}
		
		for (int i = 0; i < graph[start].size(); i++) {
			if (!visited[graph[start].get(i).x]) {
				DFS(graph[start].get(i).x, weight + graph[start].get(i).y);
			}
		}
	}
}