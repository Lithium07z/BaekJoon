import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.function.Function;

public class Main {
	static Function<Integer, Integer> fib;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int result = 0;
		int loop = Integer.parseInt(bfr.readLine());
		
		fib = (n) -> {
			return n > 1 ? fib.apply(n - 1) + fib.apply(n - 2) : n;
		};

		for (int i = 0; i < loop + 1; i++) {
			result = fib.apply(i);
		}
		bfw.write(String.valueOf(result));
		bfw.flush();
		bfw.close();
	}
}