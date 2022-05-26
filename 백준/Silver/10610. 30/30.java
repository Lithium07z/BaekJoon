import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String ipNum = bfr.readLine();
		String arr[] = new String[ipNum.length()];
		int sum = 0;
		
		for (int i = 0; i < ipNum.length(); i++) {
			sum += ipNum.charAt(i) - '0';
			arr[i] = String.valueOf(ipNum.charAt(i));
		}
		
		if (ipNum.contains("0") && sum % 3 == 0) {
			Arrays.sort(arr,Collections.reverseOrder());
			String result = "";
			for (String value : arr) {
				result += value;
			}
			bfw.write(result);
			bfw.flush();
			bfw.close();
		} else {
			bfw.write("-1");
			bfw.flush();
			bfw.close();
		}
	}
}