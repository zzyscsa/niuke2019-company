package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 求x到y的最少计算次数 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(",");
        int x = Integer.parseInt(strs[0]);
        int y = Integer.parseInt(strs[1]);
        min = Math.abs(y-x);//最多就Math.abs(y-x)次
        dfs(x, y, 0);
        System.out.println(min);
    }
    private static void dfs(int sum, int target, int cnt) {
        if(cnt>=min)
            return;
        if(sum==target) {
            min = Math.min(min, cnt);
            return;
        }
        if(sum>target) {
            min = Math.min(min, sum-target+cnt);
            return;
        } else {
            dfs(sum-1, target, cnt+1);
            dfs(sum+1, target, cnt+1);
            dfs(sum*2, target, cnt+1);
        }
    }
}
