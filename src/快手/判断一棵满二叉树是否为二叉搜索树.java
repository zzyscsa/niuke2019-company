package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 判断一棵满二叉树是否为二叉搜索树 {
    public static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(",");
        dfs(strs, 0);
        for(int i = 1; i < list.size(); i++) {
            if(Integer.parseInt(list.get(i))<Integer.parseInt(list.get(i-1))) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
    //中序遍历
    private static void dfs(String[] strs, int i) {
        if(i>=strs.length||"None".equals(strs[i])) return;
        dfs(strs, i*2+1); //左子树
        list.add(strs[i]);
        dfs(strs, i*2+2); //右子树
    }
}
