import java.util.Map;

public class Solution004 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n == 0) {
            if (m % 2 == 0)
                return ((double) nums2[m/2] + (double) nums2[m/2-1])/2;
            else
                return nums2[m/2];
        }
        if (m == 0) {
            if (n % 2 == 0)
                return ((double) nums1[n/2] + (double) nums1[n/2-1])/2;
            else
                return nums1[n/2];
        }
        int len = (n + m) / 2;
        int r = Math.min(n, len);
        int l = Math.max(0, n - len);
        if (n > m && (n + m) % 2 == 1) {
            r++;
            l--;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            int i = mid;
            int j = len - i;
            if (i == 0 || j == m) {
                if (nums2[j-1] <= nums1[i]) {
                    int x = nums2[j-1];
                    int y = nums1[i];
                    if (j < m) y = Math.min(y, nums2[j]);
                    if (i > 0) x = Math.max(x, nums1[i-1]);
                    return ans(x, y, n, m);
                } else {
                    l = mid + 1;
                    continue;
                }
            }
            if (j == 0 || i == n) {
                if (nums1[i-1] <= nums2[j]) {
                    int x = nums1[i-1];
                    int y = nums2[j];
                    if (i < n) y = Math.min(y, nums1[i]);
                    if (j > 0) x = Math.max(x, nums2[j-1]);
                    return ans(x, y, n, m);
                } else {
                    r = mid - 1;
                    continue;
                }
            }
            if (nums2[j-1] <= nums1[i] && nums1[i-1] <= nums2[j]) {
                return ans(Math.max(nums2[j-1], nums1[i-1]), Math.min(nums1[i], nums2[j]), n, m);
            } else if (nums2[j-1] > nums1[i]) {
                l = mid + 1;
            } else if (nums1[i-1] > nums2[j]) {
                r = mid - 1;
            }
        }
        return 0;
    }

    private static double ans(double x, double y, int n, int m) {
        if ((n+m)%2==0) {
            return (x+y)/2;
        } else {
            return y;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3};
        int[] b = {1};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
