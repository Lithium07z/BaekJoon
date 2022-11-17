import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = 0;
		
		int arrA[] = new int[A];
		
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < A; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < B; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < A; i++) {
			if (!set.contains(arrA[i])) {
				list.add(arrA[i]);
				count++;
			}
		}
		bfw.write(String.valueOf(count) + "\n");
		Collections.sort(list);
		for (int result : list) {
			bfw.write(String.valueOf(result) + " ");
		}
		bfw.flush();
		bfw.close();
	}
}