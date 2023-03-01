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
	static int result[];
	static int count = 0;

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
		result = new int[node + 1];
		
		Arrays.fill(result, -1);

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

		dfs(start);	
		
		for (int i = 1; i <= node; i++) {
			sb.append(result[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	//result[v] = count++;
	static void dfs(int v) {
		visited[v] = true;
		result[v] = count++;
		for (int i = 0; i < graph[v].size(); i++) {
			int x = graph[v].get(i);
			if (!visited[x]) {
				dfs(x);
			}
		}
		count--;
	}
}