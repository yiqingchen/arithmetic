import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] r = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    r[0] = i;
                    r[1] = j;
                    return r;
                }
            }
        }
        return r;
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int[] twoSum3(int[] nums, int target) {
        int m = 0, n = 0, k, board = 0;
        int[] res = new int[2];
        int[] tmp1 = new int[nums.length];
        System.arraycopy(nums, 0, tmp1, 0, nums.length);
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (nums[i] + nums[j] < target)
                i++;
            else if (nums[i] + nums[j] > target)
                j--;
            else if (nums[i] + nums[j] == target) {
                m = i;
                n = j;
                break;
            }
        }
        for (k = 0; k < nums.length; k++) {
            if (tmp1[k] == nums[m]) {
                res[0] = k;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp1[i] == nums[n] && i != k)
                res[1] = i;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] r = twoSum1(nums, target);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
        System.out.println("===========");
    }
}
