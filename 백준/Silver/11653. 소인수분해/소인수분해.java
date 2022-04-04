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
		List<Integer> lt = new ArrayList<Integer>();
		int value = Integer.parseInt(bfr.readLine());

		for (int i = 1; i <= value; i++) {
			if (value % i == 0 && i > 1) { // i가 1 이상이어야 작동하게 아니면 리스트에 1 들어감 
				lt.add(i);
				value = value / i;
				i = 1;
			}
		}
		if (value == 2) { // 2면 2의 제곱근 때문에 반복문 실행X
			lt.add(2);
		} else if (value == 3) { // 2면 2의 제곱근 때문에 반복문 실행X
			lt.add(3);
		}
		for (int a : lt) {
			bfw.write(String.valueOf(a) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}