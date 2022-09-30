import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(bfr.readLine());
		Long arr[] = new Long[N + 1];
		arr[0] = (long) 1;
		arr[1] = (long) 1;
		
		for (int i = 1; i < N; i++) {
			arr[i + 1] = (arr[i] + arr[i - 1]) % 15746; 
		}
		
		bfw.write(String.valueOf(arr[N]));
		bfw.flush();
		bfw.close();
	}
}