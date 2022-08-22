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
		LinkedHashMap<String, Integer> strMap = new LinkedHashMap<>();
		LinkedHashMap<Integer, String> intMap = new LinkedHashMap<>();
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			String temp = bfr.readLine();
			strMap.put(temp, i);
			intMap.put(i, temp);
		}
		for (int i = 0;i < M; i++) {
			String temp = bfr.readLine();
			if (temp.charAt(0) > 48 && temp.charAt(0) < 58) {
				bfw.write(intMap.get(Integer.parseInt(temp)) + "\n");
			} else {
				bfw.write(strMap.get(temp) + "\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}