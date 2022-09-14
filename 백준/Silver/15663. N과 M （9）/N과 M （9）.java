import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<String> set = new LinkedHashSet<String>();
	static String temp = "";

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bfr.readLine());
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(N, M, arr);
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public static void dfs(int N, int M, int[] arr) {
		String temp = "";
		if (list.size() == M) {
			for (int i = 0; i < list.size(); i++) {
				temp += list.get(i) + " ";
			}
			set.add(temp);
			temp = "";
			return;
		} else {
			for (int i = 1; i < N + 1; i++) {
				int check = 0;
				for (int j = 0; j < arr.length; j++) {
					if (arr[j] == arr[i - 1]) {
						check++;
					}
				}
				if (check > Collections.frequency(list, arr[i - 1])) {
					list.add(arr[i - 1]);
					dfs(N, M, arr);
					list.removeLast();
				}
			}
		}
	}
}