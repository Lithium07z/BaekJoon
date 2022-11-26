import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int save = T;
		int temp = 0;
		
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(bfr.readLine()));
		}

		while (T != 0) {
			temp = pq.poll();
			if (temp < H) {
				pq.add(temp);
				break;
			} else {
				if (temp == 1) {
					pq.add(1);
					break;
				} else {
					pq.add(temp / 2);
				}
			}
			T--;
		}
		
		if (pq.peek() < H) {
			bfw.write("YES\n");
			bfw.write(String.valueOf(save - T));
		} else {
			bfw.write("NO\n");
			bfw.write(String.valueOf(pq.peek()));
		}
		bfw.flush();
		bfw.close();
	}
}