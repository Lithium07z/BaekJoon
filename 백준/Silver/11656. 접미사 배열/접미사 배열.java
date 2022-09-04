import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String N = bfr.readLine();
		String arr[] = new String[N.length()];
		
		for (int i = 0; i < N.length(); i++) {
			String temp = "";
			for (int j = i; j < N.length(); j++) {
				temp += N.charAt(j);
			}
			arr[i] = temp;
		}
		Arrays.sort(arr);
		for (String result : arr) {
			bfw.write(result + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}