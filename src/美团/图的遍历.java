package 美团;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 给定一张包含N个点、N-1条边的无向连通图，节点从1到N编号，每条边的长度均为1。假设你从1号节点出发并打算遍历所有节点，那么总路程至少是多少？
 * 	输入：4
		1 2
		1 3
		3 4
	输出: 4
 * */
public class 图的遍历 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        String[] strs = null;
        //建立图
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < n-1; i++) {
            strs = bf.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.offer(1);
        visited[1] = true;
        int max = -1;
        int count = 0;
        //每条边都会走两次，但是最长的一条边只走一次。
        while(!queue.isEmpty()) {
            max++;
            int size = queue.size();
            while(size-->0) {
                int a = queue.poll();
                for(int b : graph[a]) {
                    if(visited[b]) continue;
                    count += 2;
                    queue.offer(b);
                    visited[b] = true;
                }
            }
        }
        System.out.println(count-max);
    }
}
