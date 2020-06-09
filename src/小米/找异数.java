package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Pair {
    public String key;
    public int value;
    Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class 找异数 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        ArrayList<Pair> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        while( !(str=bf.readLine()).equals("END") ) {
            String[] strs = str.split("#");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1], n);
            map.put(m, map.getOrDefault(m, 0)+1);
            list.add(new Pair(str, m));
        }
        boolean flag = true;
        for(Pair s : list) {
            if(map.get(s.value)==1) {
                flag = false;
                System.out.println(s.key);
            }
        }
        if(flag) System.out.println("None");
    }
}
