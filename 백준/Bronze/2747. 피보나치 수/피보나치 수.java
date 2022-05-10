import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(bfr.readLine());
		bfw.write(String.valueOf(fibo(loop)));
		bfw.flush();
		bfw.close();
	}
	static int arr[] = new int [100];
	public static int fibo(int loop) {
		
		if (loop <= 1) {
			return loop;
		} else if (arr[loop] != 0) {
			return arr[loop];
		} else {
			return arr[loop] = fibo(loop - 2) + fibo(loop - 1);
		}
	}
}
