package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 比较两个版本字符串version1和version2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        String[] v1 = strs[0].split("\\.");
        String[] v2 = strs[1].split("\\.");
        int len = Math.max(v1.length, v2.length);
        for(int i = 0; i < len; i++) {
            int t1 = v1.length==i ? 0:Integer.parseInt(v1[i]);
            int t2 = v2.length==i ? 0:Integer.parseInt(v2[i]);
            if(t1>t2) {
                System.out.println(1);
                return;
            } else if(t1<t2) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(0);
    }
}
