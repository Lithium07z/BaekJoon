import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int loop = Integer.parseInt(bfr.readLine()); // 전체 케이스 반복 횟수 
    	int[] value = new int[loop];
    	
    	for (int i = 0; i < loop; i++) {
    		int k = Integer.parseInt(bfr.readLine()); // 층수
    		int n = Integer.parseInt(bfr.readLine()); // 호수
    		int[] arr = new int[n]; // 호별 인원을 누적시켜서 저장할 배열 
    		int count = 0;
    		
    		for (int j = 0; j < n; j++) { 
    			arr[j] = j + 1; // 배열에 0층 인원 초기화
    		}
    		
    		for (int a = 0; a < n * k; a++) { // 호 * 층 만큼 반복 
    			if (count == 0) { // 모든 층의 첫번째 집에는 1명이 삶
    				arr[0] = 1; // 1로 초기화 해주고
    				count++; // count 증가
    			} else { // 그 이외의 경우에는 
    				arr[count] += arr[count - 1]; // 그 전 값이랑 누적해서 다시 넣어줌 
    				count++; // count 증가 
    			}
    			if (count == n) { // count가 호수랑 같아지면 한 층이 완료됬으니
    				count = 0; // 다시 0부터 시작 ArrayIndexOutOfBounds 예방
    			}
			}
    		value[i] = arr[n - 1];
    	}
    	for (int i = 0; i < value.length; i++) {
    		bfw.write(String.valueOf(value[i]) + "\n");
    	}
    	bfw.flush();
    	bfw.close();
    }
}