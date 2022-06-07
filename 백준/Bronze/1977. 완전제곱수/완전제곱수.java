import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int start = Integer.parseInt(bfr.readLine());
		int end = Integer.parseInt(bfr.readLine());
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		
		for (int i = start; i <= end; i++) { // 완전제곱수는 1의 자리 수가 0, 1, 4, 5, 6, 9로 끝남
			String str = String.valueOf(i); // 위의 숫자로 끝난다고 완전제곱수는 아님!
			if (str.charAt(str.length() - 1) == '0' ||
					str.charAt(str.length() - 1) == '1' ||
						str.charAt(str.length() - 1) == '4' ||
							str.charAt(str.length() - 1) == '5' ||
								str.charAt(str.length() - 1) == '6' ||
									str.charAt(str.length() - 1) == '9') { 
				int value = Integer.parseInt(str);
				int sqrt = (int) Math.sqrt(value);
				if (Math.sqrt(value) % 1 == 0) { // Math.pow(sqrt, 2) == value
					list.add(i);
					sum += i;
				}
			}
		}
		if (list.size() == 0) {
			bfw.write("-1");
			bfw.flush();
			bfw.close();
		} else {
			bfw.write(String.valueOf(sum) + "\n");
			bfw.write(String.valueOf(list.get(0)));
			bfw.flush();
			bfw.close();
		}
	}
}