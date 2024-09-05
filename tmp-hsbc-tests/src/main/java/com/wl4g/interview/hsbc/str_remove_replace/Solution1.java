package com.wl4g.interview.hsbc.str_remove_replace;

/**
 * The {@link Solution1}
 *
 * @author James Wong
 * @version v1.0 Wednesday
 * @since v1.0
 */
public class Solution1 {

    /**
     * <p>
     * 对于仅包含字母 a-z 的给定字符串，如果 3 个或更多连续字符相同，则将其从字符串中删除。重复此过程，直到相邻的相同字符不超过 3 个。
     * 示例：
     * INPUT：aabcccbbad
     * OUTPUT：
     * -> aabbbad
     * -> aaad
     * -> d
     * </p>
     */
    public static void main(String[] args) {
        removeConsecutiveDuplicates("aabcccbbad"); // 输出: d
    }

    public static void removeConsecutiveDuplicates(String input) {
        System.out.println("--------- boundary ---------");
        String last = null, current = input;
        while (!(current = doCleanString(current)).equals(last)) {
            last = current;
        }
    }

    private static String doCleanString(String s) {
        StringBuilder result = new StringBuilder(s);
        boolean changed;

        do {
            changed = false;
            int i = 0;
            while (i < result.length()) {
                int j = i;
                while (j < result.length() && result.charAt(j) == result.charAt(i)) {
                    j++;
                }
                if (j - i >= 3) {
                    result.delete(i, j);
                    changed = true;
                    System.out.println("-> " + result);
                } else {
                    i = j;
                }
            }
        } while (changed);

        return result.toString();
    }
}
