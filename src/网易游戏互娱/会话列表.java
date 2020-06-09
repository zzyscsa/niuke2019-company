package 网易游戏互娱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 会话列表 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine().trim());
        String[] strs ;
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine().trim());
            strs = bf.readLine().split(" ");
            Set<Integer> set = new HashSet<>();
            StringBuffer sb = new StringBuffer();
            for(int j = n-1; j >= 0; j--) {
                int a = Integer.parseInt(strs[j]);
                if(set.contains(a)) continue;
                set.add(a);
                sb.append(a+" ");
            }
            System.out.println(sb.delete(sb.length()-1, sb.length()).toString());
        }
    }
}
