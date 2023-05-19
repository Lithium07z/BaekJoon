import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) + 1;
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				idx++;
				if (idx == K) {
					bw.write(i + " " +j);
					bw.flush();
					bw.close();
					return;
				}
			}
		}
	}
}