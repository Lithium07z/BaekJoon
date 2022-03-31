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
		String before = st.nextToken();
		String after = st.nextToken();
		String value = "";
		
		int count1 = 0;
		int count2 = 0;
		int max = Math.max(before.length(), after.length());
		int arr1[] = new int[max];
		int arr2[] = new int[max];
		int add = 0;
		
		for (int i = max; i > 0; i--) {
			if (max - before.length() != 0 && i > before.length()) {
				arr1[i - 1] = 0;
				continue;
			}
			arr1[i - 1] = before.charAt(count1) - '0';
			count1++;
		}
		for (int i = max; i > 0; i--) {
			if (max - after.length() != 0 && i > after.length()) {
				arr2[i - 1] = 0;
				continue;
			}
			arr2[i - 1] = after.charAt(count2) - '0';
			count2++;
		}
		for (int i = 0; i < max; i++) {
			if (arr1[i] + arr2[i] + add >= 10) {
				value += (arr1[i] + arr2[i] - 10 + add);
				add = 1;
			} else {
				value += (arr1[i] + arr2[i] + add);
				add = 0;
			}
		}
		if (add == 1) {
			value += 1;
		}
		StringBuffer sb = new StringBuffer(value);
		String reverse = sb.reverse().toString();
		bfw.write(reverse);
		bfw.flush();
		bfw.close();
	}
}