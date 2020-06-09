package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class 分布式集群消息传递 {
    //leetcode 743
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        str = str.substring(1, str.length()-1);
        String[] ss = str.split(",");
        int n = Integer.parseInt(bf.readLine().trim());
        int k = Integer.parseInt(bf.readLine().trim());
        Map<Integer, Integer> dist = new HashMap<>(); //起始点到该点的距离
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < ss.length; i += 3) {
            int a = Integer.parseInt(ss[i].substring(1,ss[i].length() ));
            int b = Integer.parseInt(ss[i + 1]);
            int c= Integer.parseInt(ss[i + 2].substring(0,ss[i+2].length()-1));
            if(!graph.containsKey(a))
                graph.put(a, new ArrayList<int[]>());
            graph.get(a).add(new int[] {b,c});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((o1, o2)->o1[0]-o2[0]); //距离小的排在前面
        heap.offer(new int[]{0, k}); //起始点，（距离，点）
        while(!heap.isEmpty()) {
            int[] info = heap.poll();
            int distance = info[0];
            int node = info[1];
            if(dist.containsKey(node)) continue;
            dist.put(node, distance);
            if(graph.containsKey(node)) { //这个点还能到达其他地方
                for(int[] edge : graph.get(node)) {
                    int nei = edge[0];
                    int dis = edge[1];
                    if(!dist.containsKey(nei)) {
                        heap.offer(new int[]{distance+dis, nei});
                    }
                }
            }
        }
        if(dist.size()!=n) { //有点没法到达
            System.out.println(-1);
            return;
        }
        int res = 0;
        for(int value : dist.values()) {
            res = Math.max(res, value);
        }
        System.out.println(res);
    }
}