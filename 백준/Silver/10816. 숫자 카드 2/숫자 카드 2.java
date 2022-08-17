import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
 		LinkedHashSet<String> set = new LinkedHashSet<String>();
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
 		
 		int n = Integer.parseInt(bfr.readLine());
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		for (int i = 0; i < n; i++) {
			String num = st.nextToken();
			if (map.containsKey(num)) {
				int temp = map.get(num) + 1;
				map.put(num, temp);
			} else {
				map.put(num, 1);
			}
		}
		
		int m = Integer.parseInt(bfr.readLine());
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < m; i++) {
			String temp = st.nextToken();
			if (map.get(temp) == null) {
				bfw.write("0 ");
			} else {
				bfw.write(map.get(temp) + " ");
			}
		}
		bfw.flush();
		bfw.close();
	}
}