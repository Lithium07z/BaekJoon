import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static HashSet<String> hset = new HashSet<String>();
	static TreeSet<Integer> tset = new TreeSet<Integer>();
	static int A;
	static int B;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		DFS(0, 0, C);

		for (int t : tset) {
			bw.write(t + " ");
		}
		
		bw.flush();
		bw.close();
	}

	public static void DFS(int a, int b, int c) {
		StringBuilder sb = new StringBuilder();
		if (a == 0) {
			tset.add(c);
		}
		String set = sb.append(a).append(b).append(c).toString();
		if (!hset.contains(set)) {
			hset.add(set);
			if (a != 0) {
				if (B - b > a) {
					DFS(0, a + b, c);
				} else if (B - b <= a) {
					DFS(a - B + b, B, c);
				}
				if (C - c > a) {
					DFS(0, b, a + c);
				} else if (C - c <= a) {
					DFS(a - C + c, b, C);
				}
			}
			if (b != 0) {
				if (A - a > b) {
					DFS(a + b, 0, c);
				} else if (A - a <= b) {
					DFS(A, b - A + a, c);
				}
				if (C - c > b) {
					DFS(a, 0, c + b);
				} else if (C - c <= b) {
					DFS(a, b - C + c, C);
				}
			}
			if (c != 0) {
				if (A - a > c) {
					DFS(a + c, b, 0);
				} else if (A - a <= c) {
					DFS(A, b, c - A + a);
				}
				if (B - b > c) {
					DFS(a, b + c, 0);
				} else if (B - b <= c) {
					DFS(a, B, c - B + b);
				}
			}
		}
	}
}