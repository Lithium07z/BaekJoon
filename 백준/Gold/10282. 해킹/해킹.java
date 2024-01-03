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
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int cnt = 0;
			int val = Integer.MIN_VALUE;
			
			dist = new int[n + 1];
			graph = new ArrayList[n + 1];

			Arrays.fill(dist, INF);

			for (int j = 1; j <= n; j++) {
				graph[j] = new ArrayList<Node>();
			}

			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				graph[b].add(new Node(a, s));
			}

			Dijkstra(c);
			
			for (int temp : dist) {
				if (temp != INF) {
					cnt++;
					val = Math.max(val, temp);
				}
			}

			bw.write(cnt + " " + val + "\n");
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