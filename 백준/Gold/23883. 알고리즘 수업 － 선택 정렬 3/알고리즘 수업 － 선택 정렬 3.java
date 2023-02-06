import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int a[] = new int[N];
		int c = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			map.put(a[i], i);
		}
		
		for (int i = N - 1; i >= 0; i--) {
			int m = map.pollLastEntry().getValue();
			if (i != m) {
				c++;
				int t = a[i];
				a[i] = a[m];
				a[m] = t;
				map.replace(a[m], m);
				if (c == K) {
					bw.write(a[m] + " " + a[i]);
					bw.flush();
					bw.close();
					return;
				}
			}
		}
		bw.write("-1");
		bw.flush();
		bw.close();
	}
}