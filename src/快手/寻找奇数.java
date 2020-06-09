package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 寻找奇数 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        String[] strs = bf.readLine().split(" ");
        int res = 0;
        for(int i = 0; i < n; i++) {
            res ^= Integer.parseInt(strs[i]);
        }
        System.out.println(res);
    }

}
