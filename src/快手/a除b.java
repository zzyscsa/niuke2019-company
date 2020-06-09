package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class a除b {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        if(a%b==0) {
            System.out.println(a/b);
            return;
        }
        Map<Integer,Integer> map = new HashMap<>(); //保存每个余数出现的位置
        StringBuffer sb = new StringBuffer();
        sb.append(a/b+".");
        while(a!=0) {
            if(map.containsKey(a)) {
                sb.append(")");
                sb.insert(map.get(a), "(");
                break;
            }
            a = a%b;
            map.put(a, sb.length());
            a *= 10;
            sb.append(a/b);
            a = a%b;
        }
        System.out.println(sb);
    }
}
