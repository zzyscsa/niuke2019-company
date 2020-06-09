package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 把一个32-bit整型转成二进制，其中包含多少个1，比如5的二进制表达是101，其中包含2个1
 * */
public class 二进制中有多少个1 {
    /*
     * num & num-1能清除num最右边的1
     * eg:8（1000）= 7（0111）+ 1（0001），所以8 & 7 = （1000）&（0111）= 0（0000），清除了8最右边的1
     * 7（0111）= 6（0110）+ 1（0001），所以7 & 6 = （0111）&（0110）= 6（0110），清除了7的二进制表示中最右边的1
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int res = 0;
        while(n>0) {
            n = n&(n-1);
            res++;
        }
        System.out.println(res);
    }
}
