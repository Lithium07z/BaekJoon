import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bfr.readLine();
        String lp = "A";
        String cp = str;
        int ct = 0;
        
        if (cp.length() == 1) {
        	cp = "0" + str;
        }
        
        while (!lp.equals(str)) {
            if (str.length() == 1) {        	
            	str = "0" + str;
            }
            int a = Character.getNumericValue(str.charAt(0)) + Character.getNumericValue(str.charAt(1));
            if (String.valueOf(a).length() == 2) { 
            	str = String.valueOf(str.charAt(1)) + String.valueOf(a).charAt(1);
            	lp = cp;
            	ct++;
            } else {
            	str = String.valueOf(str.charAt(1)) + String.valueOf(a);
            	lp = cp;
            	ct++;
            } 
        }
        System.out.println(ct);
    }
}