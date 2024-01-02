import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 2000000000;
	static ArrayList<Node> graph[];
	static int dist[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			dist = new int[n + 1];
			graph = new ArrayList[n + 1];

			Arrays.fill(dist, INF);
			
			for (int j = 1; j <= n; j++) {
				graph[j] = new ArrayList<Node>();
			}

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				if ((a == g || a == h) && (b == g || b == h)) {
					graph[a].add(new Node(b, d * 2 - 1));
					graph[b].add(new Node(a, d * 2 - 1));
				} else {
					graph[a].add(new Node(b, d * 2));
					graph[b].add(new Node(a, d * 2));
				}
			}

			for (int j = 0; j < t; j++) {
				list.add(Integer.parseInt(br.readLine()));
			}
			
			Collections.sort(list);
			
			Dijkstra(s);
			
			for (int j : list) {
				if (dist[j] % 2 == 1) {
					bw.write(j + " ");
				}
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}

	public static void Dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean visited[] = new boolean[graph.length];
		
		dist[s] = 0;
		pq.offer(new Node(s, 0));

		while (!pq.isEmpty()) {
			int crt = pq.poll().x;

			if (visited[crt]) {
				continue;
			}

			visited[crt] = true;

			for (Node next : graph[crt]) {
				if (dist[next.x] > dist[crt] + next.y) {
					dist[next.x] = dist[crt] + next.y;
					pq.offer(new Node(next.x, dist[next.x]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.y, o.y);
	}
}