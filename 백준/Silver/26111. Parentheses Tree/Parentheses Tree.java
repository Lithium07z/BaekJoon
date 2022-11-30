import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp = bfr.readLine();
		long sum = 0;
		int check = 0;
		
		for (int i = 0 ; i < temp.length(); i++) {
			if  (temp.charAt(i) == '(') {
				check += 1;	
			} else {
				if (temp.charAt(i - 1) == '(') {
					check -= 1;
					sum += check;
				} else {
					check -= 1;
				}
			}
		}
		bfw.write(String.valueOf(sum));
		bfw.flush();
		bfw.close();
	}
}