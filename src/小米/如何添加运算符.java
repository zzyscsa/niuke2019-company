package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 如何添加运算符 {
    static int cnt = 0;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        dfs(1, 0);
        System.out.println(cnt);
    }
    private static void dfs(int index, int sum) {
        if(index==n+1&&sum==m) {
            cnt++;
            return;
        }
        int temp = 0;
        for(int i = index; i <= n; i++) {
            temp = temp*10+i;
            dfs(i+1, sum+temp);
            if(index!=1)
                dfs(i+1, sum-temp);
        }
    }
}
