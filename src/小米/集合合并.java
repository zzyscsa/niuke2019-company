package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 并查集 */
class DJS {
    public static int[] fa = new int[100000001];

    DJS() {
        for(int i = 0; i < 10000001; i++)
            fa[i] = i;
    }

    public static int find(int a) {
        while(fa[a]!=a) {
            fa[a] = fa[fa[a]];
            a = fa[a];
        }
        return a;
    }

    public static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if(p1==p2) return;
        fa[p1] = p2;
    }
}


public class 集合合并 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        DJS djs = new DJS();
        Set<Integer> set = new HashSet<Integer>();
        String[] strs;
        for(int i = 0; i < n; i++) {
            strs = bf.readLine().split(" ");
            if(strs.length==1) set.add(Integer.parseInt(strs[0]));
            for(int j = 0; j < strs.length-1; j++) {
                int a = Integer.parseInt(strs[j]);
                int b = Integer.parseInt(strs[j+1]);
                djs.union(a, b);
                set.add(a);
                set.add(b);
            }
        }
        int max = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int k : set) {
            int fa = djs.find(k);
            if(map.containsKey(fa)) {
                map.put(fa, map.get(fa)+1);
                max = Math.max(max, map.get(fa));
            } else {
                count++;
                map.put(fa, 1);
                max = Math.max(max, 1);
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}
