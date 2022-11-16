import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		int size = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			int temp = Integer.parseInt(st.nextToken());
			if (temp == 0) {
				if (pQueue.size() == 0) {
					bfw.write("-1\n");
				} else {
					bfw.write(String.valueOf(pQueue.poll()) + "\n");
				}
			} else {
				for (int j = 0; j < temp; j++) {
					pQueue.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		bfw.flush();
		bfw.close();
	}
}