import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;
	static ArrayList<Node>[] graph;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int PB = Integer.parseInt(st.nextToken()) - 1;
		int PA1 = Integer.parseInt(st.nextToken()) - 1;
		int PA2 = Integer.parseInt(st.nextToken()) - 1;
		graph = new ArrayList[P];

		for (int i = 0; i < P; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
	
		bw.write(Math.min(Dijkstra(PB)[PA1] + Dijkstra(PA1)[PA2], Dijkstra(PB)[PA2] + Dijkstra(PA2)[PA1]) + "\n");
		bw.flush();
		bw.close();
	}

	public static int[] Dijkstra(int X) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean visited[] = new boolean[graph.length];
		int dist[] = new int[graph.length];

		Arrays.fill(dist, INF);
		dist[X] = 0;
		pq.offer(new Node(X, 0));

		while (!pq.isEmpty()) {
			int crt = pq.poll().idx;

			if (visited[crt]) {
				continue;
			}
			visited[crt] = true;

			for (Node next : graph[crt]) {
				if (dist[next.idx] > dist[crt] + next.v) {
					dist[next.idx] = dist[crt] + next.v;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		return dist;
	}
}

class Node implements Comparable<Node> {
	int idx;
	int v;

	public Node(int idx, int v) {
		this.idx = idx;
		this.v = v;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.v, o.v);
	}
}