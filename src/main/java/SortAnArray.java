public class SortAnArray {
    //    给你一个整数数组 nums，请你将该数组升序排列。
//
//             
//
//    示例 1：
//
//    输入：nums = [5,2,3,1]
//    输出：[1,2,3,5]
//    示例 2：
//
//    输入：nums = [5,1,1,2,0,0]
//    输出：[0,0,1,1,2,5]
//             
//
//    提示：
//
//            1 <= nums.length <= 50000
//            -50000 <= nums[i] <= 50000
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/sort-an-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//    public static int[] sortArray(int[] nums) {
//
//        return nums;
//    }
    static int[] tmp;

    public static int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }


    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        int[] res = sortArray(nums);
        for (int i = 0; i < res.length; i++) {

            System.out.println(res[i]);
        }
    }
}
