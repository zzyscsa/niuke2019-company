package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 比赛名次 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        String[] strs;
        while( (str=bf.readLine())!=null ) {
            strs = str.split(" ");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);
            int[] arr = new int[n+1]; //计算输的场次
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); //记录输赢关系
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            for(int i = 0; i < m; i++) {
                strs = bf.readLine().split(" ");
                int a = Integer.parseInt(strs[0]);
                int b = Integer.parseInt(strs[1]);
                arr[b]++;
                if(!map.containsKey(a)) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(b);
                    map.put(a, list);
                } else {
                    ArrayList<Integer> list = map.get(a);
                    list.add(b);
                    map.put(a, list);
                }
            }
            for(int i = 1; i <= n; i++) {
                if(arr[i]==0) { //没输过
                    queue.offer(i);
                }
            }
            StringBuffer sb = new StringBuffer();
            while(!queue.isEmpty()) {
                int win = queue.poll();
                sb.append(win);
                sb.append(" ");
                //遍历被他战胜的人
                ArrayList<Integer> list = map.get(win);
                for(int i = 0; list!=null&&i < list.size(); i++) {
                    int loser = list.get(i);
                    arr[loser]--;
                    if(arr[loser]==0)
                        queue.offer(loser); //比如b只输给了a，c没输过，那么只要a排在b的前面，然后b和c的地位就是均等的了。
                }
            }
            System.out.println(sb.deleteCharAt(sb.length()-1));
        }
    }
}
