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
		int M = Integer.parseInt(st.nextToken());
		int check = 0;
		
		st = new StringTokenizer(bfr.readLine());
		
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(bfr.readLine());
		
		for (int i = 0; i < M; i++) {
			int gift = pq.poll();
			int child = Integer.parseInt(st.nextToken());
			if (gift - child >= 0) {
				pq.add(gift - child);
				check++;
			} else{
				break;
			}
		}
		
		if (check == M) {
			bfw.write("1");
		} else {
			bfw.write("0");
		}
		bfw.flush();
		bfw.close();
	}
}