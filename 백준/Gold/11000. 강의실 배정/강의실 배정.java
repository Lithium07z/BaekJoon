import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>((o1, o2) -> o1[0] - o2[0]);
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq1.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		while (!pq1.isEmpty()) {
			int temp[] = pq1.poll();
			if (!pq2.isEmpty() && temp[0] >= pq2.peek()) {
				pq2.poll();
			}
			pq2.add(temp[1]);
		}

		bw.write(pq2.size() + "\n");
		bw.flush();
		bw.close();
	}
}