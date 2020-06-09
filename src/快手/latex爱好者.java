package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class latex爱好者 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int P = Integer.parseInt(strs[1]); //不多于P页
        int H = Integer.parseInt(strs[2]); //高
        int W = Integer.parseInt(strs[3]); //宽
        strs = bf.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int left = 1;
        int right = Math.min(H, W);
        int ans = 0;
        while(left <= right) {
            int mid = left+(right-left)/2; //当前字体大小
            int row = H/mid; //每页row行
            int col = W/mid; //每行col个字
            int res = 0; //总共需要多少行
            for(int i = 0; i < N; i++) {
                int temp = arr[i]/col; //当前段需要多少行
                if(arr[i]%col!=0)
                    temp++; //多余的部分也要占一行,下一段就另起一行
                res += temp;
            }
            if(res<=row*P) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(ans);
    }
}
