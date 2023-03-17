import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long arr[][] = new long[2][4];
		
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BigInteger BA0 = new BigInteger(String.valueOf(arr[0][0] - arr[0][2]));
		BigInteger BA1 = new BigInteger(String.valueOf(arr[0][1] - arr[0][3]));
		BigInteger BC0 = new BigInteger(String.valueOf(arr[1][0] - arr[0][2]));
		BigInteger BC1 = new BigInteger(String.valueOf(arr[1][1] - arr[0][3]));
		BigInteger BD0 = new BigInteger(String.valueOf(arr[1][2] - arr[0][2]));
		BigInteger BD1 = new BigInteger(String.valueOf(arr[1][3] - arr[0][3]));
		BigInteger AC0 = new BigInteger(String.valueOf(arr[1][0] - arr[0][0]));
		BigInteger AC1 = new BigInteger(String.valueOf(arr[1][1] - arr[0][1]));
		BigInteger AD0 = new BigInteger(String.valueOf(arr[1][2] - arr[0][0]));
		BigInteger AD1 = new BigInteger(String.valueOf(arr[1][3] - arr[0][1]));
		BigInteger zero = new BigInteger("0");
		
		if ( (((BA0.multiply(BC1)).subtract((BA1.multiply(BC0)))).multiply((BA0.multiply(BD1)).subtract((BA1.multiply(BD0))))).compareTo(zero) == -1 && 
				(((BC0.multiply(BD1)).subtract((BC1.multiply(BD0)))).multiply((AC0.multiply(AD1)).subtract((AC1.multiply(AD0))))).compareTo(zero) == -1)  {
			bw.write("1");
		} else {
			bw.write("0");
		}
		
		bw.flush();
		bw.close();
	}	
}