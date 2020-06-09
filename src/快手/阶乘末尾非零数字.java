package 快手;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class 阶乘末尾非零数字 {
    //规律是每次用最右非零的两个数乘下一个数，如果下一个数末尾有0，则去除0乘，比如如果是20，那就乘2
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        if(n==0) {
            System.out.println(1);
            return;
        }
        int res = 1;
        for(int i = 1; i <= n; i++) {
            int temp = i;
            res = res*temp;
            while(res%10==0) {
                res /= 10;
            }
            res = res%100;
        }
        System.out.println(res%10);
    }
}
