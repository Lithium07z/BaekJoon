import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<String> list = new LinkedList<String>();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			int fNum = Integer.parseInt(st.nextToken());
			int sNum = Integer.parseInt(st.nextToken());
			if (fNum == 0 && sNum == 0) {
				break;
			} else if (sNum % fNum == 0) {
				list.add("factor");
			} else if (fNum % sNum == 0) {
				list.add("multiple");
			} else {
				list.add("neither");
			}
		}
		
		for (String value : list) {
			bfw.write(value + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}