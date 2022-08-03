import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(bfr.readLine());
		String arr[] = new String[num];

		for (int i = 0; i < num; i++) {
			arr[i] = bfr.readLine();
		}

		Arrays.sort(arr, new Comparator<String>() {	
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		

		for (int i = 0; i < num; i++) {
			if (i < num - 1 && arr[i].equals(arr[i + 1])) {
				continue;
			} else {
				bfw.write(arr[i] + "\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}