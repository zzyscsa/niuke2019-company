package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 密码破译 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while( (str=bf.readLine())!=null ) {
            StringBuffer sb = new StringBuffer();
            StringBuffer res = new StringBuffer();
            dfs(str, 0, sb, res);
            System.out.println(res.deleteCharAt(res.length()-1));
        }
    }
    private static void dfs(String s, int index, StringBuffer sb, StringBuffer res) {
        if(index>=s.length()) {
            res.append(sb+" ");
            return;
        }
        int num = Integer.parseInt(s.substring(index, index+1));
        if(num>=1&&num<=9) {
            sb.append((char)(num-1+'a'));
            dfs(s, index+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(index+1<s.length()&&s.charAt(index)!='0') {
            num = Integer.parseInt(s.substring(index, index+2));
            if(num>=10&&num<=26) {
                sb.append((char)(num-1+'a'));
                dfs(s, index+2, sb, res);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
