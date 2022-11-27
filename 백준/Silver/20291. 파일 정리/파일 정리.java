import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		StringTokenizer st;
		
		int size = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bfr.readLine(), ".");
			String temp = st.nextToken();
			temp = st.nextToken();
			
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			bfw.write(entry.getKey() + " " + String.valueOf(entry.getValue()) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}