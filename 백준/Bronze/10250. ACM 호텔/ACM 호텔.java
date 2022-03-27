import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int loop = Integer.parseInt(bfr.readLine()); // 전체 반복횟수 저장
    	String[] arr = new String [3]; // 호텔의 층 수, 각 층의 방 수, 몇 번째 손님인지 넣을 배열 
    	String value[] = new String[loop];
    	
    	for (int i = 0; i < loop; i++) {
    		int count = 1; // 방 호수 끝번호 
    		arr = bfr.readLine().split(" "); // 공백을 기준으로 잘라서 넣음 
    		int h = Integer.parseInt(arr[0]); // 호텔 층 수 
        	int w = Integer.parseInt(arr[1]); // 각 층의 방 수
        	int n = Integer.parseInt(arr[2]); // 몇 번째 손님인지 
    		if (n > h) { // 손님이 호텔 층 수 보다 높은 번째에 왔다면  
    			while(n - h > 0) { // 0이하로 내려가기 전까지 계속 뺌 
        			n -= h; // 계속 빼서 누적 
        			count += 1; // 그때마다 1층씩 누적 
        		}
    			if (count < 10) {
    				value[i] = String.valueOf(n) + "0" + String.valueOf(count); // n은 결국 아래에서부터 몇층까지 가는지 알 수 있고 count로 몇번째 방인지 알 수 있음
    			} else {
    				value[i] = String.valueOf(n) + String.valueOf(count); // count가 10이상이면 0 빼기
    			}
    		} else { // 아니면 전부 X01 번째 방이니까 n + 01번째 방 
    			value[i] = String.valueOf(n) + "01";
    		}
    	}
    	for (String s : value) { // 출력 ㄱㄱ
    		bfw.write(s + "\n");
    	}
    	bfw.flush();
		bfw.close();
    }
}