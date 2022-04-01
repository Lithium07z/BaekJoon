import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String[] arr = bfr.readLine().split(" ");
    	int a = Integer.parseInt(arr[0]);
    	int b = Integer.parseInt(arr[1]);
    	int v = Integer.parseInt(arr[2]);
    	
    	if (a - b == 1) { // a - b 1이면 v - b 바로 도출됨  
    		bfw.write(String.valueOf(v - b));
    		bfw.flush();
    		bfw.close();
    	} else if ((v - a) % (a - b) != 0) { 
    		// 도착지점에 딱 맞는지 확인, 한번만 더 가면되는 위치(v - a)를 (a - b) 내가 하루에 이동하는 거리로 나눴을 때 나머지가 0이 아니면  
    		bfw.write(String.valueOf((v - a) / (a - b) + 2)); // 한번 이상은 가야되는 거니까 v - a에 + 2
    		bfw.flush();
    		bfw.close();
    	} else if ((v - a) % (a - b) == 0) { 
    		// 도착지점에 딱 맞는지 확인, 한번만 더 가면되는 위치(v - a)를 (a - b) 내가 하루에 이동하는 거리로 나눴을 때 나머지가 0이면  
    		bfw.write(String.valueOf((v - a) / (a - b) + 1)); // v - a까지 가서 a만큼만 올라가면 되니까 + 1
    		bfw.flush();
    		bfw.close();
    	}
    }
}