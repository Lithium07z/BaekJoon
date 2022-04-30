import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		bfw.write("         ,r\'\"7\n");
		bfw.write("r`-_   ,'  ,/\n");
		bfw.write(" \\. \". L_r'\n");
		bfw.write("   `~\\/\n");
		bfw.write("      |\n");
		bfw.write("      |");
		bfw.flush();
		bfw.close();
	}
}