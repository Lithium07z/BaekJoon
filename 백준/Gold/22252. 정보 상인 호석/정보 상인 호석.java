import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, PriorityQueue> map = new HashMap<String, PriorityQueue>();
		int size = Integer.parseInt(bfr.readLine());
		StringTokenizer st;
		String name;
		int length;
		int command;
		long sum = 0;

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bfr.readLine());
			command = Integer.parseInt(st.nextToken());
			name = String.valueOf(st.nextToken());
			length = Integer.parseInt(st.nextToken());

			if (command == 1) {
				for (int j = 0; j < length; j++) {
					if (!map.containsKey(name)) {
						PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
						pQueue.add(Integer.parseInt(st.nextToken()));
						map.put(name, pQueue);
					} else {
						map.get(name).add(Integer.parseInt(st.nextToken()));
					}
				}
			} else {
				if (!map.keySet().contains(name)) {
					continue;
				}
				while (!map.get(name).isEmpty() && length > 0) {
					sum += (int) map.get(name).poll();
					length--;
				}
			}
		}
		bfw.write(String.valueOf(sum));
		bfw.flush();
		bfw.close();
	}
}