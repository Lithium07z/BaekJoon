import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int value = Integer.parseInt(bfr.readLine()); // 값 입력받음
		int f = 0; // 5갯수 세는 카운터
		int t = 0; // 3갯수 세는 카운터
		int e = 0; // 예외되는 경우 카운터
		
		while (value > 0) { // value가 양수일때만 
			if ((value - 5) % 3 == 0 && value > 2) { // 5빼고 3으로 나눠지는지 검사, 2이상 일때만 검사
				value -= 5; // 나눠지는 수면 5빼고 반복문 다시 돌리기
				f += 1; // 5 뺐으니까 5카운트 올려줌 
			} else if ((value - 3) % 5 == 0) { // 3빼고 5로 나눠지는지 검사
				value -= 3; // 나눠지는 수면 3빼고 반복문 다시 돌리기
				t += 1; // 3 뺏으니까 3카운트 올려줌 
			} else if ((value - 5) % 5 == 0) { // 5빼고 5로 나눠지는지 검사
				value -= 5;
				f += 1;
			} else if ((value - 3) % 3 == 0) { // 3빼고 3으로 나눠지는지 검사
				value -= 3;
				t += 1;
			} else {
				value -= 5;
				e += 1; // 모두 예외인 경우 e를 올림
			}
		}
		if (t == 0 && f == 0 & e > 0) { // t, f모두 0인데 e만 오르면 예외 경우만 걸린 경우니 
			e = -1; // e에 -1 넣어 출력 
		}
		bfw.write(String.valueOf(t + f + e));
		bfw.flush();
		bfw.close();
	}
}