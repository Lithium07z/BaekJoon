import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int size = Integer.parseInt(bfr.readLine());
		int arr[][] = new int[size][size];
		boolean[][] visited = new boolean[size][size];
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < size; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = true;
			}
		}
		
		if (move(0, 0, arr, visited)) {
			bfw.write("HaruHaru");
		} else {
			bfw.write("Hing");
		}
		bfw.flush();
		bfw.close();
	}
	
	public static boolean move(int x, int y, int arr[][], boolean[][] visited) {
		if (x >= arr.length) {
			return false;
		}
		if (y >= arr.length) {
			return false;
		}
		if(visited[x][y] == false)  {
			return false;
		}
		if (arr[x][y] == -1) {
			return true;
		} else {
			if (arr[x][y] == 0) {
				return false;
			}
			return visited[x][y] = move(x + arr[x][y], y, arr,visited) || move(x, y + arr[x][y], arr,visited);
		}
	}
}