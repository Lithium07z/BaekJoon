import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		HashMap<String, String> map = new HashMap();
		
		int size = Integer.parseInt(st.nextToken());
		int search = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bfr.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		for (int i = 0; i < search; i++) {
			bfw.write(map.get(bfr.readLine()) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}