import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int cost[][];
	static int dp[][];
	static int r = 0;
	static int g = 1;
	static int b = 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			cost[i][r] = Integer.parseInt(st.nextToken());
			cost[i][g] = Integer.parseInt(st.nextToken());
			cost[i][b] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			cost[i][r] += Math.min(cost[i - 1][g], cost[i - 1][b]);
			cost[i][g] += Math.min(cost[i - 1][r], cost[i - 1][b]);
			cost[i][b] += Math.min(cost[i - 1][r], cost[i - 1][g]);
		}
		
		bw.write(Math.min(Math.min(cost[N - 1][r], cost[N - 1][g]), cost[N - 1][b]) + "\n");
		bw.flush();
		bw.close();
	}
}