package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 找缺失数字 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(",");
        int n = strs.length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            res ^= i;
            res ^= Integer.parseInt(strs[i]);
        }
        res ^= n;
        System.out.println(res);
    }
}
