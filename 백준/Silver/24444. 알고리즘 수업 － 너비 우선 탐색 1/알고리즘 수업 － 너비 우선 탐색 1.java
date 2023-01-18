import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int count = 1;

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		boolean visited[] = new boolean[node + 1];
		int result[] = new int[node + 1];

		for (int i = 0; i <= node; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(v).add(u);
			graph.get(u).add(v);
		}
		
		for (ArrayList<Integer> sort : graph) {
			Collections.sort(sort);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = true;
		result[start] = count++;
		q.add(start);

		while (!q.isEmpty()) {
			int j = q.poll();
			for (int i = 0; i < graph.get(j).size(); i++) {
				int temp = graph.get(j).get(i);
				if (!visited[temp]) {
					visited[temp] = true;
					result[temp] = count++;
					q.add(temp);
				}
			}
		}
		
		for (int i = 1; i <= node; i++) {
			bw.write(result[i] + "\n");
		}

		bw.flush();
		bw.close();
	}
}