package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 将满二叉树转化为求和树 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs1 = bf.readLine().split(" "); //前序
        String[] strs2 = bf.readLine().split(" "); //中序
        int[] arr = new int[strs2.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(strs2[i]);
        func(arr, 0, arr.length-1);
        for(int i = 0; i < arr.length-1; i++)
            System.out.print(arr[i]+" ");
        System.out.println(arr[arr.length-1]);
    }
    private static void func(int[] arr, int start, int end) {
        if(start==end) {
            arr[start] = 0;
            return;
        }
        int mid = start + (end-start)/2;
        int sum = 0;
        for(int i = start; i < mid; i++)
            sum  += arr[i];
        arr[mid] = sum;
        sum = 0;
        for(int i = mid+1; i <= end; i++)
            sum += arr[i];
        arr[mid] += sum;
        func(arr, start, mid-1);
        func(arr, mid+1, end);
    }
}
