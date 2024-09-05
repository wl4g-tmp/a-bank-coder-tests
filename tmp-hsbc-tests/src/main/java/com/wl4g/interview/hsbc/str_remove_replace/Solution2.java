package com.wl4g.interview.hsbc.str_remove_replace;

public class Solution2 {
    public static String cleanString(String s) {
        StringBuilder result = new StringBuilder(s);
        int i = 0;
        while (i < result.length() - 2) {
            if (result.charAt(i) == result.charAt(i + 1) && result.charAt(i) == result.charAt(i + 2)) {
                char newChar = (char) (result.charAt(i) - 1);
                if (newChar < 'a') {
                    newChar = 'z';
                }
                result.replace(i, i + 3, String.valueOf(newChar));
                return result.toString();
            }
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "abcccbad";
        String current = input;
        System.out.println("INPUT: " + input);
        System.out.println("OUTPUT:");

        while (true) {
            String previous = current;
            String next = cleanString(current);
            String replacement = findReplacement(previous, next);
            if (!replacement.isEmpty()) {
                System.out.println("-> " + next + ", " +
                        replacement + " is replaced by " +
                        next.charAt(previous.indexOf(replacement)));
                current = next;
            } else if (!current.equals(next)) {
                System.out.println("-> " + next);
                current = next;
            } else {
                break;
            }
        }
    }

    private static String findReplacement(String previous, String current) {
        for (int i = 0; i < previous.length() - 2; i++) {
            if (previous.charAt(i) == previous.charAt(i + 1) &&
                    previous.charAt(i) == previous.charAt(i + 2) &&
                    (i >= current.length() || current.charAt(i) != previous.charAt(i))) {
                return previous.substring(i, i + 3);
            }
        }
        return "";
    }
}