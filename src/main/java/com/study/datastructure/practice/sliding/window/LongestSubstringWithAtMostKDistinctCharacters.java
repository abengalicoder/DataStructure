package com.study.datastructure.practice.sliding.window;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Longest Substring with K Distinct Characters
 * Problem: Given a string, find the length of the longest substring with exactly k distinct characters.
 *
 * Input: "araaci", k = 2
 *
 * Output: 4 ("araa")
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    @Test
    public void test() {
        assertEquals("araaci = 4", longestSubstringWithKDistinct("araaci", 2), 4);
        assertEquals("araaci = 1", longestSubstringWithKDistinct("araaci", 1), 2);
        assertEquals("cbbebi = 3", longestSubstringWithKDistinct("cbbebi", 3), 5);
        assertEquals("abcabcabc = 2", longestSubstringWithKDistinct("abcabcabc", 2), 2);
        assertEquals("eceba = 2", longestSubstringWithKDistinct("eceba", 2), 3);
        assertEquals("aaaa = 1", longestSubstringWithKDistinct("aaaa", 1), 4);
        assertEquals("abcde = 5", longestSubstringWithKDistinct("abcde", 5), 5);
        assertEquals("aabacbebebe = 3", longestSubstringWithKDistinct("aabacbebebe", 3), 7);

        assertEquals("araaci = 4", longestSubstringWithKDistinctOptimal("araaci", 2), 4);
        assertEquals("araaci = 1", longestSubstringWithKDistinctOptimal("araaci", 1), 2);
        assertEquals("cbbebi = 3", longestSubstringWithKDistinctOptimal("cbbebi", 3), 5);
        assertEquals("abcabcabc = 2", longestSubstringWithKDistinctOptimal("abcabcabc", 2), 2);
        assertEquals("eceba = 2", longestSubstringWithKDistinctOptimal("eceba", 2), 3);
        assertEquals("aaaa = 1", longestSubstringWithKDistinctOptimal("aaaa", 1), 4);
        assertEquals("abcde = 5", longestSubstringWithKDistinctOptimal("abcde", 5), 5);
        assertEquals("aabacbebebe = 3", longestSubstringWithKDistinctOptimal("aabacbebebe", 3), 7);
    }

    public static int longestSubstringWithKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() < k) {
            return 0;
        }

        int right = 0;
        Set<Character> set = new HashSet<>();
        String maxWindow = "", window = "";

        while (right < s.length()) {
            char c = s.charAt(right);
            set.add(c);
            if (set.size() <= k) {
                window += c;
            } else {
                maxWindow = window;
                char temp = window.charAt(0);
                window = window.substring(1);
                if (window.indexOf(temp) == -1) {
                    set.remove(temp);
                }
                window += c;
            }
            right++;
        }

        if (maxWindow.length() == 0 && window.length() > 0) {
            maxWindow = window;
        }
        if (window.length() > maxWindow.length()) {
            maxWindow = window;
        }
        return maxWindow.length();
    }

    public static int longestSubstringWithKDistinctOptimal(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int maxLen = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}
