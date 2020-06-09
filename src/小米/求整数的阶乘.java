package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 求整数的阶乘 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        BigInteger res = new BigInteger("1");
        for(int i = 1; i <= n; i++) {
            String s = i+"";
            BigInteger a = new BigInteger(s);
            res = res.multiply(a);
        }
        System.out.println(res.toString());
    }
}
