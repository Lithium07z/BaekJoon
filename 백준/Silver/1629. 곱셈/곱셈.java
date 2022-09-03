import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		long result;
		
		result = pow(A, B, C);
		
		bfw.write(String.valueOf(result));
		bfw.flush();
		bfw.close();
	}
	
	public static long pow(long A, long B, long C) {
		if (B == 0) {
			return 1 ;
		} else if (B == 1) {
			return A % C;
		}
		
		long res = pow(A, B / 2, C);
		
		if (B % 2 == 0) {
			return (res * res) % C;
		} else {
			return ((res * res % C)* A) % C;
		}
	}
}