import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bfr.readLine());
		int result = 0;
		StringTokenizer st;
		List<Integer> list1 = new ArrayList();
		st = new StringTokenizer(bfr.readLine());
		
		for (int i = 0; i < size; i++) {
			list1.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> list2 = new ArrayList();
		st = new StringTokenizer(bfr.readLine());
		
		for (int i = 0; i < size; i++) {
			list2.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list1);
		Collections.sort(list2);
		Collections.reverse(list2);
		for (int i = 0; i < size; i++) {
			result += list1.get(i) * list2.get(i);
		}
		bfw.write(String.valueOf(result));
		bfw.flush();
		bfw.close();
	}
}