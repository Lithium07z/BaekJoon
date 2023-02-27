import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cases; i++) {
			System.gc();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int max = 0;
			String key = "";
			
			for (int j = 0; j < length; j++) {
				String temp = st.nextToken();
				int value = map.getOrDefault(temp, 0) + 1;
				map.put(temp, value);
				if (value > max) {
					max = value;
					key = temp;
				}
			}
			if (max > length / 2) {
				bw.write(key + "\n");
			} else {
				bw.write("SYJKGW\n");
			}
		}
		bw.flush();
		bw.close();
	}
}