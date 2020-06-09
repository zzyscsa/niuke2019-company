package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 顺时针打印数字矩阵 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true) {
            String[] strs = bf.readLine().split(" ");
            int M = Integer.parseInt(strs[0]);
            int N = Integer.parseInt(strs[1]);
            if(M==-1) break;
            String[][] mat = new String[M][N];
            for(int i = 0; i < M; i++) {
                mat[i] = bf.readLine().split(" ");
            }
            sb = func(mat);
            System.out.println(sb.substring(0, sb.length()-1));
        }
    }
    private static StringBuffer func(String[][] mat) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int x = 0, y = 0, k = 0;
        StringBuffer sb = new StringBuffer();
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int a = m*n;
        int t = 0;
        while(t++<a) {
            sb.append(mat[x][y]+",");
            visited[x][y] = true;
            int tx = x+dx[k];
            int ty = y+dy[k];
            if(tx<0||tx>=m||ty<0||ty>=n||visited[tx][ty]) {
                k = (k+1)%4;
                x = x+dx[k];
                y = y+dy[k];
            } else {
                x = tx;
                y = ty;
            }
        }
        return sb;
    }
}
