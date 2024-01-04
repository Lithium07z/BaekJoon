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
	static final int INF = 2000000000;
	static ArrayList<Node> graph[];
	static int dist[];
	static int path[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		int min;
		
		dist = new int[N + 1];
		path = new int[N + 1];
		graph = new ArrayList[N + 1];
		
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, t));
			graph[b].add(new Node(a, t));
		}
		
		min = Dijkstra();
		
		for (int i = N; i > 0; i = path[i]) {
			max = Math.max(max, PathFinding(path[i], i));
		}

		bw.write(max == INF ? "-1" : max - min + "\n");
		bw.flush();
		bw.close();
	}

	public static int Dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean visited[] = new boolean[graph.length];

		Arrays.fill(dist, INF);

		dist[1] = 0;
		pq.offer(new Node(1, 0));

		while (!pq.isEmpty()) {
			int crt = pq.poll().x;

			if (visited[crt]) {
				continue;
			}

			visited[crt] = true;

			for (Node next : graph[crt]) {
				if (dist[next.x] > dist[crt] + next.y) {
					path[next.x] = crt;
					dist[next.x] = dist[crt] + next.y;
					pq.offer(new Node(next.x, dist[next.x]));
				}
			}
		}
		
		return dist[graph.length - 1];
	}
	
	public static int PathFinding(int s, int e) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean visited[] = new boolean[graph.length];

		Arrays.fill(dist, INF);

		dist[1] = 0;
		pq.offer(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node crt = pq.poll();

			if (visited[crt.x]) {
				continue;
			}

			visited[crt.x] = true;
			
			for (Node next : graph[crt.x]) {
				if(s == crt.x && e == next.x) {
					continue;
				}
				
				if (dist[next.x] > dist[crt.x] + next.y) {
					dist[next.x] = dist[crt.x] + next.y;
					pq.offer(new Node(next.x, dist[next.x]));
				}
			}
		}
		return dist[graph.length - 1];
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