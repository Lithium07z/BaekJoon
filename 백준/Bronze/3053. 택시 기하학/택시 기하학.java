import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		double value = Double.parseDouble(bfr.readLine());
		
		
		bfw.write(String.format("%6f\n", value * value * Math.PI));
		bfw.write(String.format("%6f\n", value * value * 2));
		bfw.flush();
		bfw.close();
	}
}