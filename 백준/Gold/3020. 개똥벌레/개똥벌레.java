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
		int H = Integer.parseInt(st.nextToken());
		int top[] = new int[H + 1];
		int bottom[] = new int[H + 1];
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N / 2; i++) {
			bottom[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}
		
		for (int i = 1; i < H + 1; i++) {
			bottom[i] = bottom[i - 1] + bottom[i];
			top[i] = top[i - 1] + top[i];
		}

		for (int i = 1; i < H + 1; i++) {
			int sum = 0;
			
			sum += bottom[H] - bottom[i - 1] + top[H] - top[H - i];
			
			if (sum < min) {
				min = sum;
				cnt = 1;
			} else if (sum == min) {
				cnt++;
			}
		}
		
		bw.write(min + " " + cnt + "\n");
		bw.flush();
		bw.close();
	}
}