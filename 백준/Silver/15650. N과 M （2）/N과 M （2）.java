import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dfs(N, M);
		System.out.println(sb);
	}
	
	public static void dfs(int N, int M) {
		int check = -1;
		if (list.size() == M) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i) > list.get(j)) {
						check++;
						break;
					}
				}
			}
			if (check == -1) {
				for (int i = 0; i < list.size(); i++) {
					sb.append(list.get(i)).append(" ");
				}
				sb.append("\n");
			}
			return;
		} else {
			for (int i = 1; i < N + 1; i++) {
				if (!list.contains(i)) {
					list.add(i);
					dfs(N, M);
					list.removeLast();
				}
			}
		}
	}
}