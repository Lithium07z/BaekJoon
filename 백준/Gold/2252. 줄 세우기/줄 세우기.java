import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Graph g = new Graph(N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			g.insertEdge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		}
		
		g.topologicalSort();
	}
}

class Node {
	int vertex;
	Node link;
	
	public Node(int vertex, Node link) {
		this.vertex = vertex;
		this.link = link;
	}
}

class Graph {
	Node[] header;
	int n;
	int[] indegree; // 정점 i의 진입차수
	
	public Graph(int vertices) {
		n = vertices;
		header = new Node[n];
		indegree = new int[n];
	}
	
	public void topologicalSort() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i, v, successor, j = 0;
		Queue<Integer> zeroPredQ = new LinkedList<Integer>(); // 선행자가 없는 정점들을 저장하는 큐
		int[] sortedList = new int[n]; // 위상 정렬 결과를 보관하는 리스트 
		
		for (i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				zeroPredQ.add(i);
			}
		}
		if (zeroPredQ.isEmpty()) {
			return;
		}
		while (!zeroPredQ.isEmpty()) {
			// indegree가 0인 정점들을 큐에서 하나씩 삭제해 처리
			v = zeroPredQ.poll();
			// indegree가 0인 정점들을 결과 리스트에 삽입
			sortedList[j++] = v;
			if (header[v] == null) {
				continue; // 정점 v의 후속자가 없으면 밖의 while 루프로
			} else {
				successor = header[v].vertex;
				header[v] = header[v].link;
			} // 후속자가 있으면, 그 후속자를 successor로 설정
			while(true) {
				indegree[successor]--;
				if (indegree[successor] == 0) {
					zeroPredQ.add(successor);
				}
				if (header[v] != null) {
					successor = header[v].vertex;
					header[v] = header[v].link;
				} else {
					break;
				}
			}	
		}
		for (i = 0; i < sortedList.length; i++) {
			bw.write(sortedList[i] + 1 + " ");
		}
		bw.flush();
		bw.close();
	}
	
	public void insertEdge(int i, int j) {
		Node node = new Node(j, null);
		node.link = header[i];
		header[i] = node;
		
        indegree[j]++;
	}
}