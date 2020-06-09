package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 机器人移动范围 {
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);
        boolean[][] flag = new boolean[m][n];
        bfs(0,0,flag,m,n,k);
        System.out.println(cnt);
    }
    private static void bfs(int x, int y, boolean[][] flag, int m, int n, int k) {
        if(x<0||x>=m||y<0||y>=n||flag[x][y]||!func(x,y,k))
            return;
        cnt++;
        flag[x][y] = true;
        for(int i = 0; i < 4; i++) {
            bfs(x+dx[i], y+dy[i], flag, m, n, k);
        }
    }
    private static boolean func(int x, int y, int k) {
        int res = 0;
        while(x>0) {
            res += x%10;
            x /= 10;
        }
        while(y>0) {
            res += y%10;
            y /= 10;
        }
        return res<=k;
    }

}
