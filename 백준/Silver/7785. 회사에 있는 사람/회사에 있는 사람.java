import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeMap<String, Integer> map = new TreeMap<String, Integer>(Collections.reverseOrder());
		StringTokenizer st;
		
		int size = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bfr.readLine());
			String name = st.nextToken();
			if (map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
			} else {
				map.put(name, 1);
			}
		}
		
		for (Entry<String, Integer> temp : map.entrySet()) {
			if (temp.getValue() % 2 != 0) {
				bfw.write(temp.getKey() + "\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}