import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Long, Integer> map = new HashMap<>();
		
		int size = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < size; i++) {
			long temp1 = Long.parseLong(bfr.readLine());
			if (map.containsKey(temp1)) {
				int temp2 = map.get(temp1) + 1;
				map.put(temp1, temp2);
			} else {
				map.put(temp1, 1);
			}
		}
		List<Map.Entry<Long, Integer>> list = new LinkedList<Map.Entry<Long,Integer>>();
		list.addAll(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>() {
			@Override
			public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
				if(o1.getValue().intValue()==o2.getValue().intValue())
					return Long.compare(o1.getKey().longValue(), o2.getKey().longValue());
				return Integer.compare(o2.getValue().intValue(), o1.getValue().intValue());
			}
		});
		bfw.write(String.valueOf(list.get(0).getKey()));
		bfw.flush();
		bfw.close();
	}
}