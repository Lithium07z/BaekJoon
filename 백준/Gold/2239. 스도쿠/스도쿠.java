import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean row[][] = new boolean[10][10];
	static boolean column[][] = new boolean[10][10];
	static boolean square[][] = new boolean[10][10];
	static int sudoku[][] = new int[10][10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = (short) (temp.charAt(j) - '0');
				
				if (sudoku[i][j] != 0) {
					row[i][sudoku[i][j]] = true;
					column[j][sudoku[i][j]] = true;
					square[Square(i, j)][sudoku[i][j]] = true;
				}
			}
		}

		DFS(0);
	}

	public static boolean DFS(int idx) throws IOException {
		if (idx == 81) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			System.exit(0);
		}

		int x = idx / 9;
		int y = idx % 9;
		if (sudoku[x][y] != 0) {
			DFS(idx + 1);
		} else {
			int sq = Square(x, y);
			
			for (int i = 1; i <= 9; i++) {
				if (!(row[x][i] || column[y][i] || square[sq][i])) {
					row[x][i] = column[y][i] = square[sq][i] = true;
					sudoku[x][y] = i;

					if (DFS(idx + 1)) {
						return true;
					}

					sudoku[x][y] = 0;
					row[x][i] = column[y][i] = square[sq][i] = false;
				}
			}
		}
		
		return false;	
	}
	
	public static int Square(int i, int j) {
		return (i / 3) * 3 + (j / 3);
	}
}