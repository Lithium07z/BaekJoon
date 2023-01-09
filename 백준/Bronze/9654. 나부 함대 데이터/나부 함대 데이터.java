import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));	
		bfw.write("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\nN2 Bomber      Heavy Fighter  Limited    21        \nJ-Type 327     Light Combat   Unlimited  1         \nNX Cruiser     Medium Fighter Limited    18        \nN1 Starfighter Medium Fighter Unlimited  25        \nRoyal Cruiser  Light Combat   Limited    4");
		bfw.flush();
		bfw.close();
	}
}