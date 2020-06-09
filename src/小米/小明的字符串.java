package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 小明的字符串 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int t = Integer.parseInt(strs[1]);
        String s = bf.readLine();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < t; i++) {
            strs = bf.readLine().split(" ");
            int type = Integer.parseInt(strs[0]);
            int x = Integer.parseInt(strs[1]);
            if(type == 1) {
                temp.append(sb.substring(n-x));
                temp.append(sb.substring(0, n-x));
                sb.delete(0, sb.length());
                sb.append(temp);
                temp.delete(0, temp.length());
            } else {
                System.out.println(sb.charAt(x));
            }
        }
    }
}
