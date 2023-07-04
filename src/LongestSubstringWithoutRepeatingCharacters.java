package src;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println("======================================");
        System.out.println(lengthOfLongestSubstring_version2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring_version2("pwwkew"));
        System.out.println(lengthOfLongestSubstring_version2("bbbbb"));
        System.out.println(lengthOfLongestSubstring_version2(" "));
        System.out.println("=======================================");
        System.out.println(lengthOfLongestSubstring_optimized("abcabcbb"));
        System.out.println(lengthOfLongestSubstring_optimized("pwwkew"));
        System.out.println(lengthOfLongestSubstring_optimized("bbbbb"));
        System.out.println(lengthOfLongestSubstring_optimized(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        int l = s.length();
        int start = 0;
        int max = 0;

        while (start <= l-1 ) {
            StringBuilder builder = new StringBuilder();
            int subMax = 0;
            for (int i=start; i <= l-1; i++) {
                char ch = s.charAt(i);

                if (builder.indexOf(ch + "") != -1) {
                    break;
                }

                builder.append(ch);
                subMax = builder.length();
            }
            if (subMax > max) max = subMax;
            start++;
        }
        return max;
    }

    public static int lengthOfLongestSubstring_version2(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (builder.indexOf(String.valueOf(s.charAt(j))) != -1) {
                    break;
                }
                builder.append(s.charAt(j));
                maxLength = Math.max(maxLength, builder.length());
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring_optimized(String s) {
        int maxLength = 0;
        Map<String, Integer> map = new HashMap<>();
        int lPointer = 0;
        int rPointer = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(String.valueOf(s.charAt(i)));
            rPointer++;
            if (index != null && index >= lPointer && index <= rPointer) {
                lPointer = index + 1;
            } else {
                maxLength = Math.max(maxLength, rPointer - lPointer);
            }
            map.put(String.valueOf(s.charAt(i)), i);
        }
        return maxLength;
    }
}
