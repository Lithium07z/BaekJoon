import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static String result[];
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		StringTokenizer st;
		int max = 0;
		
		int N = Integer.parseInt(bfr.readLine());
		String nodeArr[] = new String[N];

		for (int i = 0; i < N; i++) {
			nodeArr[i] = bfr.readLine();
		}
		Arrays.sort(nodeArr);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(nodeArr[i]);
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();

			map.put(root, map.getOrDefault(root, 1));
			map.put(left, map.get(root) * 2);
			map.put(right, map.get(root) * 2 + 1);
			
			max = Math.max(max, map.get(right));
		}
		map.remove(".");
		result = new String[max + 1];
		
		for (String temp : map.keySet()) {
			result[map.get(temp)] = temp;
		}
		
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
		
	}

	public static void preorder(int n) {
		if (result[n] != null) {
			System.out.print(result[n]);
			preorder(n * 2);
			preorder(n * 2 + 1);
		}
	}

	public static void inorder(int n) {
		if (result[n] != null) {
			inorder(n * 2);
			System.out.print(result[n]);
			inorder(n * 2 + 1);
		}
	}

	public static void postorder(int n) {
		if (result[n] != null) {
			postorder(n * 2);
			postorder(n * 2 + 1);
			System.out.print(result[n]);
		}
	}
}