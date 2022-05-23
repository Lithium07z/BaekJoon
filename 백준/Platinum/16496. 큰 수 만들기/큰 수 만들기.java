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
		int caseNum = Integer.parseInt(bfr.readLine());
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		String[] arr = new String[caseNum];
		String[] result = new String[caseNum];
		String sum = "";
		
		for (int i = 0; i < caseNum; i++) {
			String str = st.nextToken();
			result[i] = str;
			while (str.length() < 10) {
				str += str;
			}
			arr[i] = str.substring(0, 10);
		}
		for (int i = 0; i < caseNum - 1; i++) {
			for (int j = i + 1; j < caseNum; j++) {
				if (Long.parseLong(arr[j]) > Long.parseLong(arr[i])) {
					String temp1 = arr[j];
					arr[j] = arr[i];
					arr[i] = temp1;
					String temp2 = result[j];
					result[j] = result[i];
					result[i] = temp2;
				}
			}
		}
		
		for (String a : result) {
			sum += a;
		}
		if (sum.charAt(0) == '0') {
			bfw.write("0");
			bfw.flush();
			bfw.close();
		} else {
			bfw.write(sum);
			bfw.flush();
			bfw.close();
		}
	}
}