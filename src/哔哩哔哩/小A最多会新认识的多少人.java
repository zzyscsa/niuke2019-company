package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 小A参加了一个n人的活动，每个人都有一个唯一编号i(i>=0 & i<n)，其中m对相互认识，在活动中两个人可以通过互相都认识的一个人介绍认识。现在问活动结束后，小A最多会认识多少人？
 *
 * 输入描述:
第一行聚会的人数：n（n>=3 & n<10000）；
第二行小A的编号: ai（ai >= 0 & ai < n)；
第三互相认识的数目: m（m>=1 & m
< n(n-1)/2）；
第4到m+3行为互相认识的对，以','分割的编号。
输出描述:
输出小A最多会新认识的多少人？
 * */

public class 小A最多会新认识的多少人 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int a = Integer.parseInt(bf.readLine().trim());
        int m = Integer.parseInt(bf.readLine().trim());
        String[] strs;
        int cnt = 0;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        for(int i = 0; i < m; i++) {
            strs = bf.readLine().split(",");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
            union(parent, x, y);
            if(x==a || y==a)
                cnt--;  //已经认识的不算新认识的
        }
        int t = find(parent, a);
        for(int i = 0; i < n; i++) {
            if(find(parent, i)==t)
                cnt++;
        }
        System.out.println(cnt-1);  //除去认识自己
    }

    //并查集
    private static int find(int[] parent, int x) {
        while(parent[x]!=x) {
            //路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    private static void union(int[] parent, int x, int y) {
        int x_father = find(parent, x);
        int y_father = find(parent, y);
        if(x_father != y_father) {
            parent[x_father] = y_father;
        }
    }
}
