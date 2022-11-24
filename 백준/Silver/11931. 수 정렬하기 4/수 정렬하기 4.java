import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bfr.readLine());
		List<Integer> list = new LinkedList<Integer>();
		
		for (int i = 0; i < size; i++) {
			list.add(Integer.parseInt(bfr.readLine()));
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		for (int result : list) {
			bfw.write(String.valueOf(result) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}