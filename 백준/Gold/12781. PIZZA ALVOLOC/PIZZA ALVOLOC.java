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
		long arr[][] = new long[2][4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 8; i++) {
			if (i < 4) {
				arr[0][i] = Integer.parseInt(st.nextToken());
			} else {
				arr[1][i - 4] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(((arr[0][0] - arr[0][2]) * (arr[0][3] - arr[1][1]) - (arr[0][1] - arr[0][3]) * (arr[0][2] - arr[1][0])) *
				((arr[0][0] - arr[0][2]) * (arr[0][3] - arr[1][3]) - (arr[0][1] - arr[0][3]) * (arr[0][2] - arr[1][2])) < 0 &&
					((arr[1][0] - arr[0][2]) * (arr[0][3] - arr[1][3]) - (arr[1][1] - arr[0][3]) * (arr[0][2] - arr[1][2])) *
							((arr[1][0] - arr[0][0]) * (arr[0][1] - arr[1][3]) - (arr[1][1] - arr[0][1]) * (arr[0][0] - arr[1][2])) < 0)  {
			bw.write("1");
		} else {
			bw.write("0");
		}
		
		bw.flush();
		bw.close();
	}	
}