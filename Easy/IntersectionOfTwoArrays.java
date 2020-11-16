package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                set.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2])
                index1++;
            else
                index2++;
        }

        return set.stream().mapToInt(Integer::valueOf).toArray();
    }
}
