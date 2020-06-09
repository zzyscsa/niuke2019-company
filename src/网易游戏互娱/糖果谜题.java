package 网易游戏互娱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 糖果谜题 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < strs.length; i++) {
            int a = Integer.parseInt(strs[i]);
            if(a==0) {
                res++;
                continue;
            }
            if(map.containsKey(a)) {
                int value = map.get(a);
                if(value==a+1) {
                    res += a+1;
                    map.put(a, 1);
                } else
                    map.put(a, value+1);
            } else {
                map.put(a, 1);
            }
        }
        for(Integer key : map.keySet()) {
            res += key+1;
        }
        System.out.println(res);
    }
}
