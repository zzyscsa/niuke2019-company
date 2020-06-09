package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 扭蛋机 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine().trim());
        StringBuffer sb = new StringBuffer();
        while(n>0) {
            if(n%2 == 0) {
                sb.append("3");
                n = (n-2)/2;
            } else {
                sb.append("2");
                n = (n-1)/2;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}