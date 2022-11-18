import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bfr.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < size; i++) {
			String temp = bfr.readLine();
			if (map.containsKey(temp)) {
				map.put(temp, (int)map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
		
		for (int i = 0; i < size - 1; i++) {
			String temp = bfr.readLine();
			map.put(temp, (int)map.get(temp) + 1);
		}
		
		for (HashMap.Entry<String, Integer> result : map.entrySet()) {
			if (result.getValue() % 2 != 0) {
				bfw.write(result.getKey());
			}
		}
		bfw.flush();
		bfw.close();
	}
}