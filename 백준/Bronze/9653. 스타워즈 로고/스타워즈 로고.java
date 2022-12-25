import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		bfw.write("    8888888888  888    88888\n   88     88   88 88   88  88\n    8888  88  88   88  88888\n       88 88 888888888 88   88\n88888888  88 88     88 88    888888\n\n88  88  88   888    88888    888888\n88  88  88  88 88   88  88  88\n88 8888 88 88   88  88888    8888\n 888  888 888888888 88  88      88\n  88  88  88     88 88   88888888");
		bfw.flush();
		bfw.close();
	}
}