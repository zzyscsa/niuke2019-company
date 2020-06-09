package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 写一段程序判断IP字符串是否属于内网IP {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split("\\.");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        if(a==10||a==127) {
            System.out.println(1);
            return;
        }
        else if(a==172) {
            if(b<=31&&b>=16) {
                System.out.println(1);
                return;
            }
        } else if(a==192) {
            if(b==168) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
