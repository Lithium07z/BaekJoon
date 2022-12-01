import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeMap<String, String> map = new TreeMap<String, String>();
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int loop = Integer.parseInt(st.nextToken());
		int quiz = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < loop; i++) {
			String team = bfr.readLine();
			int member = Integer.parseInt(bfr.readLine());
			
			for (int j = 0; j < member; j++) {
				map.put(bfr.readLine(), team);
			}
		}
		
		for (int i = 0; i < quiz; i++) {
			String temp = bfr.readLine();
			int num = Integer.parseInt(bfr.readLine());
			
			if (num == 0) {
				for (HashMap.Entry<String, String> result : map.entrySet()) {
					if (result.getValue().equals(temp)) {
						bfw.write(result.getKey() + "\n");
					}
				}
			} else {
				bfw.write(map.get(temp) + "\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}