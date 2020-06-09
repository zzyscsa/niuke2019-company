package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 数组操作 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int[] arr = new int[strs.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(strs[i]);
        int i = 0, j = arr.length-1;
        while(i<j) {
            if(arr[i]%2==0&&arr[j]%2!=0) {
                i++;
                j--;
            } else if(arr[i]%2!=0&&arr[j]%2==0) {
                swap(arr, i, j);
                i++;
                j--;
            } else if(arr[i]%2==0&&arr[j]%2==0) {
                i++;
            } else if(arr[i]%2!=0&&arr[j]%2!=0) {
                j--;
            }
        }
        for(int k = 0; k < arr.length-1; k++)
            System.out.print(arr[k]+" ");
        System.out.println(arr[arr.length-1]);
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
