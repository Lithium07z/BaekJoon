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
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n + 1][m + 1];
		int len = Integer.MIN_VALUE;
		
		for (int i = 1; i <= n; i++) {
			String temp = br.readLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = temp.charAt(j - 1) - '0';
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] == 1) {
					arr[i][j] = Math.min(Math.min(arr[i - 1][j - 1], arr[i - 1][j]), arr[i][j - 1]) + 1;
					len = Math.max(len, arr[i][j]);
				}
			}
		}
		
		bw.write(len * len + "\n");
		bw.flush();
		bw.close();
	}
}