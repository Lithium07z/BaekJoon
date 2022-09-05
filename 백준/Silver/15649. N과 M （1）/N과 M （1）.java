import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer> list = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dfs(N, M);
		
	}
	
	public static void dfs(int N, int M) {
		if (list.size() == M) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
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