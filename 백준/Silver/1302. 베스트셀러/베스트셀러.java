import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeMap tmap = new TreeMap();
		int size = Integer.parseInt(bfr.readLine());

		for (int i = 0; i < size; i++) {
			String temp = bfr.readLine();
			if (tmap.containsKey(temp)) {
				tmap.put(temp, (int) tmap.get(temp) + 1);
			} else {
				tmap.put(temp, 1);
			}
		}

		List<String> keySet = new ArrayList<>(tmap.keySet());
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(tmap.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o2.getValue().equals(o1.getValue())) {
					Collections.sort(keySet);
				}
				return o2.getValue() - o1.getValue();
			}
		});

		bfw.write(entryList.get(0).getKey());
		bfw.flush();
		bfw.close();
	}
}