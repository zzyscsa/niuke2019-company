package 字节跳动;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 找零 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int a = 1024-n; //找零
        int res = 0;
        if(a%64==0) {
            System.out.println(a/64);
            return;
        } else {
            res += a/64;
            a %= 64;
        }
        if(a%16==0) {
            System.out.println(res+a/16);
            return;
        } else {
            res += a/16;
            a %= 16;
        }
        if(a%4==0) {
            System.out.println(res+a/4);
            return;
        } else {
            res += a/4;
            a %= 4;
        }
        System.out.println(res+a);
    }
}
