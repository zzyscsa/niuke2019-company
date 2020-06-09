package 网易游戏互娱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 时钟 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine().trim());
        StringBuffer res;
        for(int i = 0; i < t; i++) {
            res = new StringBuffer(bf.readLine());
            if(res.charAt(0)>'2') {
                res.setCharAt(0, '0');
            } else if(res.charAt(0)=='2') {
                if(res.charAt(1)>'3') {
                    res.setCharAt(0, '0');
                }
            }
            if(res.charAt(3)>'5') {
                res.setCharAt(3, '0');
            }
            if(res.charAt(6)>'5') {
                res.setCharAt(6, '0');
            }
            System.out.println(res.toString());
        }
    }
}
