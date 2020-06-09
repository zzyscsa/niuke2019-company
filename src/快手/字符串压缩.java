package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 字符串压缩 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int cnt = 1;
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)) {
                cnt++;
            } else {
                sb.append(cnt+"");
                sb.append(s.charAt(i-1));
                cnt = 1;
            }
        }
        sb.append(cnt);
        sb.append(s.charAt(s.length()-1));
        System.out.println(sb);
    }
}
