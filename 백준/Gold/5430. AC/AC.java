import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		boolean chk = true;
		
		Loop1 : for (int i = 0; i < T; i++) {
			chk = true;
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			LinkedList<String> list = new LinkedList<String>();
			
			for (int j = 0; j < n; j++) {
				list.add(st.nextToken());
			}
			
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == 'D' && list.size() == 0) {
					sb.append("error\n");
					continue Loop1;
				} else if (p.charAt(j) == 'R') {
					chk = !chk;
				} else if (p.charAt(j) == 'D' && chk) {
					list.removeFirst();
				} else if (p.charAt(j) == 'D' && !chk) {
					list.removeLast();
				}
			}
			sb.append("[");
			if (chk && list.size() != 0) {
				Iterator<String> iter = list.iterator();
				while (true) {
					sb.append(iter.next());
					if (iter.hasNext()) {
						sb.append(",");
					} else {
						break;
					}
				}
			} else if (!chk && list.size() != 0) {
				ListIterator<String> iter = list.listIterator(list.size());
				while (true) {
					sb.append(iter.previous());
					if (iter.hasPrevious()) {
						sb.append(",");
					} else {
						break;
					}
				}
			}
			sb.append("]\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}