package 字节跳动;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 万万没想到之聪明的编辑 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        for(int t = 0; t < n; t++) {
            String s = bf.readLine();
            StringBuffer sb = new StringBuffer();
            sb.append(s.charAt(0));
            int cnt = 1;
            int pre = 0;

            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i)==s.charAt(i-1)) {
                    cnt++;
                    if(cnt>2 || cnt==2&&pre==2) {
                        cnt--;
                        continue;
                    }
                    sb.append(s.charAt(i));
                } else {
                    pre = cnt;
                    cnt = 1;
                    sb.append(s.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}