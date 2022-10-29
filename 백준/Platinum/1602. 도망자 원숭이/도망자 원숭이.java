import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int cases = Integer.parseInt(st.nextToken());
		int city[][] = new int[node + 1][node + 1];
		int value[][] = new int[node + 1][node + 1];
		Integer delaySort[] = new Integer[node + 1];
		int delay[] = new int[node + 1];

		st = new StringTokenizer(bfr.readLine());
		for (int i = 1; i <= node; i++) {
			delay[i] = Integer.parseInt(st.nextToken());
			delaySort[i] = i;
		}
		
		Arrays.sort(delaySort, 1, node + 1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return delay[o1] - delay[o2];
			}
		});

		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				if (i != j) {
					city[i][j] = 1000000000;
					value[i][j] = 1000000000;
				} else {
					value[i][j] = delay[i];
				}
			}
		}

		for (int i = 1; i <= edge; i++) {
			st = new StringTokenizer(bfr.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			city[a][b] = c;
			city[b][a] = city[a][b];
			value[a][b] = c + Math.max(delay[a], delay[b]);
			value[b][a] = value[a][b];
		}

		for (int i = 1; i <= node; i++) {
			int s = delaySort[i];
			for (int j = 1; j <= node; j++) {
				for (int k = 1; k <= node; k++) {
					city[j][k] = Math.min(city[j][k], city[j][s] + city[s][k]);
					value[j][k] = Math.min(value[j][k],
							city[j][k] + Math.max(delay[j], Math.max(delay[k], delay[s])));
				}
			}
		}

		for (int i = 0; i < cases; i++) {
			st = new StringTokenizer(bfr.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			if (value[S][T] != 1000000000) {
				bfw.write(String.valueOf(value[S][T]) + "\n");
			} else {
				bfw.write("-1\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}