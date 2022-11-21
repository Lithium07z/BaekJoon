import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		LinkedHashMap<Integer, Integer> lMap = new LinkedHashMap<Integer, Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (lMap.containsKey(temp)) {
				lMap.put(temp, lMap.get(temp) + 1);
			} else {
				lMap.put(temp, 1);
			}
		}
		
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(lMap.entrySet());
		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
		    @Override
		    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
			return o2.getValue() - o1.getValue();
		    }
		});
		for(Map.Entry<Integer, Integer> entry : entryList){
			for (int i = 0; i < entry.getValue(); i++) {
				bfw.write(String.valueOf(entry.getKey()) + " ");
			}
		}
		bfw.flush();
		bfw.close();
	}
}