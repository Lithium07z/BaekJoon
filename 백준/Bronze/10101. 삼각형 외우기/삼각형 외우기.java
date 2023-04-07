import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<Integer> set = new HashSet<Integer>();
		int sum = 0;

		for (int i = 0; i < 3; i++) {
			int v = Integer.parseInt(br.readLine());
			set.add(v);
			sum += v;
		}

		if (sum == 180) {
			if (set.size() == 1) {
				bw.write("Equilateral");
			} else if (set.size() == 2) {
				bw.write("Isosceles");
			} else if (set.size() == 3) {
				bw.write("Scalene");
			}
		} else {
			bw.write("Error");
		}
		bw.flush();
		bw.close();
	}
}