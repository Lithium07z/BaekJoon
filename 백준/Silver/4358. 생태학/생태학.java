import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		int sum = 0;
		
		while (true) {
			String temp = bfr.readLine();
			if (temp == null || temp.length() == 0) {
				break;
			}
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}	
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			sum += entry.getValue();
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			bfw.write(entry.getKey() + " " + String.format("%.4f", entry.getValue() / (double)sum * 100) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}