public class Solution001 {

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i=0;i<n;i++)
            for (int j=i+1;j<n;j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ans = twoSum(nums, 9);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
