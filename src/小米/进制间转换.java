package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 进制间转换 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        bf.close();
        long n = Long.parseLong(strs[0]);
        int m = Integer.parseInt(strs[1]);
        long temp = 0;
        StringBuffer sb = new StringBuffer();
        if(n==0) {
            System.out.println(0);
            return;
        }
        while(n>=0) {
            temp = n%m;
            sb.append(temp);
            n /= m;
        }
        sb.reverse();
        System.out.println(sb);
    }
}
