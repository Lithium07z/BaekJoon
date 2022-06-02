import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[][] arr = new char[8][8];
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			String value = bfr.readLine();
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = value.charAt(j);
				if (i % 2 == 0 && j % 2 == 0 && arr[i][j] == 'F') {
					cnt++;
				} else if (i % 2 == 1 && j % 2 == 1 && arr[i][j] == 'F'){
					cnt++;
				}
			}
		}
		bfw.write(String.valueOf(cnt));
		bfw.flush();
		bfw.close();
	}
}