package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 地鼠逃跑计划 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int m;
    static int n;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(bf.readLine().trim());
        n = Integer.parseInt(bf.readLine().trim());
        int x = Integer.parseInt(bf.readLine().trim());
        int y = Integer.parseInt(bf.readLine().trim());
        int k = Integer.parseInt(bf.readLine().trim());
        bfs(x, y, k);
        System.out.println(cnt);
    }
    private static void bfs(int x, int y, int k) {
        if(x>=m||x<0||y>=n||y<0) {
            if(k>=0)
                cnt++;
            return;
        }
        if(k<0) {
            return;
        }
        for(int t = 0; t < 4; t++) {
            bfs(x+dx[t], y+dy[t], k-1);
        }
    }
}
/*
 *    0 0 0 0 0 0
 *
 * */
