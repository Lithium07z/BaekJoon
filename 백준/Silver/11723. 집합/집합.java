import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int cases = Integer.parseInt(bfr.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < cases; i++) {
			st = new StringTokenizer(bfr.readLine());
			String command = st.nextToken();
			int x = 0;
			if (st.hasMoreTokens()) {
				x = Integer.parseInt(st.nextToken());		
			}
			
			if (command.equals("add")) {
				if (!list.contains(x)) {
					list.add(x);
				}
			} else if (command.equals("remove")) {
				if (list.contains(x)) {
					list.remove(list.indexOf(x));
				}
			} else if (command.equals("check")) {
				if (list.contains(x)) {
					bfw.write("1\n");
				} else {
					bfw.write("0\n");
				}
			} else if (command.equals("toggle")) {
				if (list.contains(x)) {
					list.remove(list.indexOf(x));
				} else {
					list.add(x);
				}
			} else if (command.equals("all")) {
				list.clear();
				for (int j = 1; j <= 20; j++) {
					list.add(j);
				}
			} else if (command.equals("empty")) {
				list.clear();
			}
		}
		bfw.flush();
		bfw.close();
	}
}