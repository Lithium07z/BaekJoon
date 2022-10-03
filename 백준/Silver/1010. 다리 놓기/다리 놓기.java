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
		StringTokenizer st;
		
		int num = Integer.parseInt(bfr.readLine());
		int numN = 0;
		int numK = 0 ;
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(bfr.readLine());
			numN = Integer.parseInt(st.nextToken());
			numK = Integer.parseInt(st.nextToken());
			arr = new int[numK + 1][numN + 1];
			
			for (int j = 0; j <= numK; j++) {
				arr[j][0] = 1;
			}
			
			for (int j = 1; j <= numK; j++) {
				for (int k = 1; k <= numN; k++) {
					arr[j][k] = ((arr[j - 1][k - 1] + arr[j - 1][k]));
				}
			}
			bfw.write(String.valueOf(arr[numK][numN]) + "\n");
		}
		
		bfw.flush();
		bfw.close();
	}
}