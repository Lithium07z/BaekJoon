import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int a[] = new int[N];
		int b[] = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			map.put(a[i], i);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		if (Arrays.equals(a, b)) {
			bw.write("1");
			bw.flush();
			bw.close();
			return;
		}
		
		for (int i = N - 1; i >= 0; i--) {
			int m = map.pollLastEntry().getValue();
			if (i != m) {
				int t = a[i];
				a[i] = a[m];
				a[m] = t;
				map.replace(a[m], m);
				if (a[i] == b[i]) {
					if (Arrays.equals(a, b)) {
						bw.write("1");
						bw.flush();
						bw.close();
						return;
					}
				}
			}
		}
		bw.write("0");
		bw.flush();
		bw.close();
	}
}