import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

		int N = Integer.parseInt(bfr.readLine());
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < N; i++) {
			map.put(st.nextToken(), 0);
		}
		int M = Integer.parseInt(bfr.readLine());
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < M; i++) {
			String temp = st.nextToken();
			if (map.containsKey(temp)) {
				map.put(temp, (int) map.get(temp) + 1);
				bfw.write(map.get(temp) + " ");
			} else {
				bfw.write("0 ");
				continue;
			}
		}
		bfw.flush();
		bfw.close();
	}
}