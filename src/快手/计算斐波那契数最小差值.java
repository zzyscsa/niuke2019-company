package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 计算斐波那契数最小差值 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int a = 0;
        int b = 1;
        while(b<n) {
            int t = a+b;
            a = b;
            b = t;
        }
        System.out.println(Math.min(b-n, n-a));
    }
}
