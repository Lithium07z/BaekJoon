import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//HashSet<HashSet<Integer>> unKnown = new HashSet<HashSet<Integer>>();
		HashMap<HashSet<Integer>, Integer> unKnown = new HashMap<HashSet<Integer>, Integer>();
		HashSet<Integer> wellKnown = new HashSet<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;

		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			wellKnown.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			HashSet<Integer> tempSet = new HashSet<Integer>();
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			boolean flag = false;

			for (int j = 0; j < size; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (wellKnown.contains(temp)) {
					flag = true;
				}
				tempSet.add(temp);
			}

			if (flag) {
				for (int t : tempSet) {
					wellKnown.add(t);
				}
			} else {
				unKnown.put(tempSet, unKnown.getOrDefault(tempSet, 0) + 1);
			}
		}
		
		while (true) {
			HashSet<Integer> temp = new HashSet<Integer>();
			boolean flag = true;
			for (int t1 : wellKnown) {
				for (HashSet<Integer> uk : unKnown.keySet()) {
					if (uk.contains(t1)) {
						for (int t2 : uk) {
							temp.add(t2);
						}
						//result += unKnown.get(uk);
						uk.clear();
						flag = false;
					}
				}
			}
			if (flag) {
				break;
			}
			wellKnown = temp;
		}

		for (HashSet<Integer> t : unKnown.keySet()) {
			if (t.size() != 0) {
				result += unKnown.get(t);
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}