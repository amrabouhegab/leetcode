package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int num: nums1) {
            System.out.println(num);
        }
        System.out.println("======================================================");
        int[] nums3 = new int[]{0};
        int[] nums4 = new int[]{1};
        merge(nums3, 0, nums4, 1);
        for (int num: nums3) {
            System.out.println(num);
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        int i = m - 1;
        int j = n -1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[last] = nums1[i];
                i--;
            } else {
                nums1[last] = nums2[j];
                j--;
            }
            last--;
        }
    }

}
