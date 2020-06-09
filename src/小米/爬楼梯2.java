package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 爬楼梯2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());

        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        BigInteger c = new BigInteger("2");
        for(int i = 4; i <= n; i++) {
            BigInteger temp = a.add(c);
            a = b;
            b = c;
            c = temp;
        }
        System.out.println(c);
    }
}
