import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

		int loop = Integer.parseInt(bfr.readLine());
		String[] arr = new String[loop];
		int value1 = 0;
		int value2 = 0;
		for (int i = 0; i < loop; i++) {
			int num = Integer.parseInt(bfr.readLine());
			LinkedHashSet<Integer> remover = new LinkedHashSet<>();
			LinkedHashSet<Integer> prime = new LinkedHashSet<>();

			for (int j = 2; j < num; j++) { // 소수는 2부터 시작하니까 2부터 num까지 다 넣기
				prime.add(j);
			}
			for (int j = 2; j <= Math.sqrt(num); j++) { // 모든 합설수는 자신의 제곱근보다 작거나 같은 약수를 가지니까
				for (int k = 2; k * j <= num; k++) {
					remover.add(j * k); // 2부터 자신을 제외한 배수를 추가
				}
			}
			prime.removeAll(remover); // 에라토스테네스의 체의 원리로 remover를 prime에서 뺴버림
			for (int value : prime) {
				if (prime.contains(num - value) && value <= num - value) {
					value1 = num - value;
					value2 = num - value;
 				}
			}
			bfw.write(num - value1 + " " + value2 + "\n");
		}	
		bfw.flush();
		bfw.close();
	}
}