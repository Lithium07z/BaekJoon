import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<Integer> list = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dfs(N, M);
		bfw.flush();
		bfw.close();
	}
	
	public static void dfs(int N, int M) throws IOException {
		if (list.size() == M) {
			for (int i = 0; i < list.size(); i++) {
				bfw.write(String.valueOf(list.get(i)) + " ");
			}
			bfw.write("\n");
			return;
		} else {
			for (int i = 1; i < N + 1; i++) {
					list.add(i);
					dfs(N, M);
					list.removeLast();
			}
		}
	}
}