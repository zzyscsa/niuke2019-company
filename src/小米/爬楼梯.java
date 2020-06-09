package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 爬楼梯 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("2");
        BigInteger c = new BigInteger("3");
        if(n==1) {
            System.out.println(1);
            return;
        }
        if(n==2) {
            System.out.println(2);
            return;
        }
        for(int i = 2; i < n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
