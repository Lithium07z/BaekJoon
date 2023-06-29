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
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		graph = new ArrayList[N];
		boolean flag = true;
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			graph[Integer.parseInt(st.nextToken()) - 1].add(new Node(Integer.parseInt(st.nextToken()) - 1, 1));
		}

		int dist[] = Dijkstra(X);
		
		for (int i = 0; i < N; i++) {
			if (dist[i] == K) {
				bw.write(i + 1 + "\n");
				flag = false;
			}
		}
		
		if (flag) {
			bw.write("-1");
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