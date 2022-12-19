import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		bfw.write("       _.-;;-._\n'-..-'|   ||   |\n'-..-'|_.-;;-._|\n'-..-'|   ||   |\n'-..-'|_.-''-._|");
		bfw.flush();
		bfw.close();
	}
}