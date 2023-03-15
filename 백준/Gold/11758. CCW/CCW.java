import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int	arr[][] = new int[3][2];
				
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
				
		if ((arr[1][0] - arr[0][0]) * (arr[2][1] - arr[1][1]) - (arr[1][1] - arr[0][1]) * (arr[2][0] - arr[1][0]) > 0) {
			bw.write("1");
		} else if ((arr[1][0] - arr[0][0]) * (arr[2][1] - arr[1][1]) - (arr[1][1] - arr[0][1]) * (arr[2][0] - arr[1][0]) < 0) {
			bw.write("-1");
		} else {
			bw.write("0");
		}
		bw.flush();
		bw.close();
	}
}