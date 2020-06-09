package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最优分割 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        strs = bf.readLine().split(" ");
        int sum = 0;
        int max = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        System.out.println(binarySearch(arr, m, n, max, sum));
    }
    //二分逼近
    /*
     * 假设存在一个最大值的最小值 x,反过来划分数组。子数组的权值都比x要小，如果组数小于m，说明 x 还可以再小；
     * 组数大于m，说明 x 需要变大，以容纳更多的数。减小分组数。如果组数等于m，x也可能再小
     * 考虑边界情况，现在把每个元素分成一组，那么x的最小值就是数组中最大的值；把数组当成一个组，那么x就是数组元素之和。
     * 即 max(arr) <= x <= sum(arr)
     * 因为每一组都是连续的，只要每一组累加的和大于了x，那么当前元素就要放到下一组，记录有多少组即可。
     *
     * 我们通过二分逼近来确定这个x的值。
     * 在于这个“逼近”，这道题是在连续的数值范围中逼近，换句话说，每个组的和一定在范围之内，因此正确答案是不会被跳过的；
     * */
    public static int binarySearch(int[] arr, int m, int n, int left, int right) {
        int res = right;
        while(left<=right) {
            int mid = left+(right-left)/2;
            int sum = 0;
            int cnt = 1; //记录数组个数
            for(int i = 0; i < n; i++) {
                //当前子数组的和加上当前元素比mid还大，那必须将当前元素归为下一个子数组中，sum重新计算新子数组的和
                if(sum+arr[i]>mid) {
                    cnt++;
                    sum = arr[i];
                } else { //当前子数组的和比mid小，继续加
                    sum += arr[i];
                }
            }
            //如果分完之后组数小于等于m说明，mid还可以更小，即上面思路里说的x还能更小 右区间缩小到mid-1；
            if(cnt<=m) {
                right = mid-1;
                res = Math.min(res, mid);
            } else {
                left = mid+1;
            }
        }
        return res;
    }

}
