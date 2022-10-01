import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int numN = Integer.parseInt(st.nextToken());
		int numK = Integer.parseInt(st.nextToken());
		arr = new int[numN + 1][numK + 1];
		
		for (int i = 0; i <= numN; i++) {
			arr[i][0] = 1;
		}
		
		for (int i = 1; i <= numN; i++) {
			for (int j = 1; j <= numK; j++) {
				arr[i][j] = ((arr[i - 1][j - 1] + arr[i - 1][j])) % 10007;
			}
		}
		
		bfw.write(String.valueOf(arr[numN][numK]));
		bfw.flush();
		bfw.close();
	}
}