package 字节跳动;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Pair {
    public int x;
    public int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Pair))
            return false;
        Pair other = (Pair) obj;
        if(x==other.x&&y==other.y)
            return true;
        return false;
    }
}

public class 特征提取 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int m = Integer.parseInt(bf.readLine().trim());
        String[] strs;
        for(int k = 0; k < n; k++) {
            int max = 0;
            Map<Pair, Integer> map = new HashMap<>();
            Set<Pair>[] set = new Set[m];
            for(int i = 0; i < m; i++) {
                set[i] = new HashSet<>();
                strs = bf.readLine().split(" ");
                int t = Integer.parseInt(strs[0]);
                int index = 1;
                for(int j = 0; j < t; j++) {
                    int x = Integer.parseInt(strs[index++]);
                    int y = Integer.parseInt(strs[index++]);
                    Pair p = new Pair(x, y);
                    set[i].add(p);
                }
                for(Pair p : set[i]) {
                    if(i>0 && set[i-1].contains(p)) {
                        map.put(p, map.get(p)+1);
                    } else {
                        map.put(p, 1);
                    }
                    max = Math.max(max, map.get(p));
                }
            }
            System.out.println(max);
        }
    }
}
