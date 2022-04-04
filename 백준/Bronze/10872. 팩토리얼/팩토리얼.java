import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int value = Integer.parseInt(bfr.readLine());
		
		cal(value, 1, 1);
	}
	
	public static void cal(int value, int sum, int i) {
		if (i == value) {
			System.out.println(sum);
			return;
		} else if (value <= 1) {
			System.out.println(1);
			return;
		}
		sum *= i + 1; 
		i++;
		cal(value, sum, i);
	}
}