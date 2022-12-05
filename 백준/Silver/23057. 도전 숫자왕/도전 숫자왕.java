import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static long[] result;
	static int size;
	static Long[] arr;
	static HashSet<Long> set = new HashSet<Long>();

	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		size = Integer.parseInt(bfr.readLine());
		visited = new boolean[size];
		result = new long[size];
		arr = new Long[size];

		long max = 0;
		st = new StringTokenizer(bfr.readLine());

		for (int i = 0; i < size; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			max += arr[i];
		}

		dfs(0);

		bfw.write(String.valueOf(max - set.size() + 1));
		bfw.flush();
		bfw.close();
	}

	public static void dfs(int n) {
		long sum = 0;
		if (n == result.length) {
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}
			set.add(sum);
		} else {
			visited[n] = true;
			result[n] = arr[n];
			dfs(n + 1);
			visited[n] = false;
			dfs(n + 1);
		}
	}
}