package com.study.datastructure.practice.sliding.window;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MinimumWindowSubstring {

    @Test
    public void test() {
        assertEquals("CBBFFFFA", minWindow("BBUDOECODENCBBFFFFAXXXXX", "ABC"));
        // Exact match at start
        assertEquals("ABC", minWindow("ABCDEF", "ABC"));     // "ABC" is the smallest window

// Exact match at end
        assertEquals("CDE", minWindow("ABCDE", "CDE"));      // match is at the end

// Characters scattered with repetition
        assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC")); // original example

// Characters appear multiple times
        assertEquals("ab", minWindow("aaab", "ab"));         // must include both a and b

// t contains repeating chars
        assertEquals("abc", minWindow("aaabc", "abc"));      // has to pick at least 2 a's

// s == t
        assertEquals("xyz", minWindow("xyz", "xyz"));         // entire string is the answer

// No match possible
        assertEquals("", minWindow("abc", "xyz"));            // t contains characters not in s

// Multiple possible windows
        assertEquals("abdec", minWindow("aabdec", "abc"));      // smallest valid window

// Large string, small target
        assertEquals("t", minWindow("thisisaverylongstringwithtinit", "t"));  // single char

// All characters same in t and repeated in s
        assertEquals("aaa", minWindow("aaaaaa", "aaa"));       // exact 3 a's needed
    }

    /*public static String minWindow(String s, String t) {
        int left = 0, right = 0;
        int startIndex = 0, endIndex = 0;
        char startChar = ' ';
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (t.contains(String.valueOf(ch))) {
                if (map.size() == 0) {
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                    startIndex = right;
                    startChar = ch;
                    right++;
                } else {
                    if (startChar == ch) {
                        map.put(ch, map.getOrDefault(ch, 0) + 1);
                        startIndex = right;
                        right++;
                    } else {
                        map.put(ch, map.getOrDefault(ch, 0) + 1);
                        if (map.size() == t.length()) {
                            endIndex = right;
                            right++;
                        } else {
                            right++;
                        }
                    }
                }
            } else {
                right++;
            }
        }

        return s.substring(startIndex, endIndex+1);
    }*/
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char ch : t.toCharArray()) {
            targetFreq.put(ch, targetFreq.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0;
        int matched = 0; // total characters matched according to required frequency
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (targetFreq.containsKey(ch)) {
                windowFreq.put(ch, windowFreq.getOrDefault(ch, 0) + 1);

                if (windowFreq.get(ch).intValue() <= targetFreq.get(ch).intValue()) {
                    matched++;
                }
            }

            // Try to shrink the window from the left if all characters are matched
            while (matched == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                if (targetFreq.containsKey(leftChar)) {
                    windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                    if (windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                        matched--;
                    }
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }

}
