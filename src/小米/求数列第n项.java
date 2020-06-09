package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 求数列第n项 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine().trim());
        long a = 1, b = 1, sum = 2, c = 0;
        if(n==1||n==2) {
            System.out.println(n-1);
            return;
        }
        while(sum<n) {
            c = a+b;
            sum += c;
            a = b;
            b = c;
        }
        System.out.println(sum-c);
    }
}
