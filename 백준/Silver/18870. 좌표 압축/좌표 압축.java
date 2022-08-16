import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeSet<Integer> set = new TreeSet<Integer>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int size = Integer.parseInt(bfr.readLine());
		int arr[] = new int[size];
		
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		
		Iterator iter = set.iterator();
		for (int i = 0; i < set.size(); i++) {
			map.put((int)iter.next(), i);
		}
		for (int i = 0; i < size; i++) {
			bfw.write(String.valueOf(map.get(arr[i])) + " ");
		}
		bfw.flush();
		bfw.close();
	}
}
