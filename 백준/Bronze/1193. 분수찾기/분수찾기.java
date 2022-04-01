import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 1; // 라인 위치
		int num = Integer.parseInt(bfr.readLine());
		while (true) { // num번째 분수는 몇번째 라인에 있는지 
			if (num <= count) { // 라인이랑 num 같아지면 탈출
				break;
			}
			num -= count; 
			count++; // count 증가;
		}
		int m = count - num + 1;
		int c = num;
		if (count % 2 == 0) { // 짝수 라인인 경우만
			bfw.write(c + "/" + m);
			bfw.flush();
			bfw.close();
		} else {
			bfw.write(m + "/" + c);
			bfw.flush();
			bfw.close();
		} 
	}
}
