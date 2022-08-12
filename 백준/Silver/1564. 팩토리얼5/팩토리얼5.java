import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		long num = Integer.parseInt(bfr.readLine());
		long sum = 1;
		
		for (long i = 1; i <= num; i++) {
			sum *= i;
			while(sum % 10 == 0) {
				sum /= 10;
			}
			sum %= 1000000000000L;
		}
		
		// 값에서 0이 부족한 경우들 
		sum %= 100000;
		if (sum < 10000) {
			bfw.write("0");
		}
		if (sum < 1000) {
			bfw.write("0");
		}
		if (sum < 100) {
			bfw.write("0");
		}
		if (sum < 10) {
			bfw.write("0");
		}
		bfw.write(String.valueOf(sum));
		bfw.flush();
		bfw.close();
	}
}