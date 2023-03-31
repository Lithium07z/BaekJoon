import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char arr[][] = new char[15][15];
		 
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				arr[i][j] = '!';
			}
		}
		
		for (int i = 0; i < 5; i++) {
			String temp = br.readLine();
			if (temp.length() == 0) {
				break;
			}
			for (int j = 0; j < temp.length(); j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] != '!') {
					bw.write(arr[j][i]);
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}