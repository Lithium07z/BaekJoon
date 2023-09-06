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
	static int[] path;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		path = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph[A].add(new Node(B, C));
			graph[B].add(new Node(A, C));
		}

		Dijkstra(1);

		bw.write(N - 1 + "\n");

		for (int i = 2; i <= N; i++) {
			bw.write(path[i] + " " + i + "\n");
		}
		
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
					path[next.idx] = crt;
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