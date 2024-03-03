import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int result[] = new int[node + 1];
		
		Arrays.fill(result, -1);
		result[start] = 0;
		
		for (int i = 0; i <= node; i++) {
			graph.add(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(v).add(u);
			graph.get(u).add(v);
		}

		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		
		q.add(start);

		while (!q.isEmpty()) {
			int j = q.poll();
			
			for (int i = 0; i < graph.get(j).size(); i++) {
				int temp = graph.get(j).get(i);
				
				if (result[temp] == -1) {
					result[temp] = result[j] + 1;
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