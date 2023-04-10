import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int N = Integer.parseInt(br.readLine());
			int R = 1;
			
			for (int j = 0; j < N; j++) {
				String key = br.readLine().split(" ")[1];
				map.put(key, map.getOrDefault(key, 1) + 1);
			}
			
			for (int t : map.values()) {
				R *= t;
			}
			bw.write(R - 1 + "\n");
		}
		bw.flush();
		bw.close();
	}
}