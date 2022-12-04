import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		StringTokenizer st;
		
		int size = Integer.parseInt(bfr.readLine());
		int count = 0;
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bfr.readLine());
			String c = st.nextToken().substring(0, 2);
			String s = st.nextToken();
			if (c.equals(s)) {
				continue;
			}
			if (map.get(s + c) != null) {
				map.put(s + c, map.get(s + c) + 1);
			} else {
				map.put(s + c, 1);
			}
			if (map.get(c + s) != null) {
				count += map.get(c + s);
			}
		}
		
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}