import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> graph[];
	static boolean visited[];
	static long depth = 0;
	static long count = 1;
	static long sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		graph = new ArrayList[node + 1];
		visited = new boolean[node + 1];

		for (int i = 1; i <= node; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= edge; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[v].add(u);
			graph[u].add(v);
		}

		for (int i = 1; i <= node; i++) {
			Collections.sort(graph[i]);
		}

		dfs(start, 0);	

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}

	static void dfs(int v, long d) {
		visited[v] = true;
		sum += d * count++;
		for (int i = 0; i < graph[v].size(); i++) {
			int x = graph[v].get(i);
			if (!visited[x]) {
				dfs(x, ++d);
				d--;
			}
		}
	}
}