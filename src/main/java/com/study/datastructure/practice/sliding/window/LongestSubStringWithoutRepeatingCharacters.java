package com.study.datastructure.practice.sliding.window;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 *  Longest Substring Without Repeating Characters
 * Problem: Return the length of the longest substring without repeating characters.
 *
 * Input: "abcabcbb"
 *
 * Output: 3 ("abc")
 */
public class LongestSubStringWithoutRepeatingCharacters {

    @Test
    public void Test() {
      /*  assertEquals("abcabcbb", 3, longestSubstringWithoutRepeatingCharacters("abcabcbb"));        // "abc"
        assertEquals("bbbbb", 1, longestSubstringWithoutRepeatingCharacters("bbbbb"));              // "b"
        assertEquals("pwwkew", 3, longestSubstringWithoutRepeatingCharacters("pwwkew"));            // "wke"
        assertEquals("", 0, longestSubstringWithoutRepeatingCharacters(""));            */            // ""
        assertEquals("aaab", 2, longestSubstringWithoutRepeatingCharacters("aaab"));                  // "ab"
        assertEquals("dvdf", 3, longestSubstringWithoutRepeatingCharacters("dvdf"));                // "vdf"
        assertEquals("abcbdefgh", 7, longestSubstringWithoutRepeatingCharacters("abcbdefgh"));      // "cbdefgh"
        assertEquals("tmmzuxt", 5, longestSubstringWithoutRepeatingCharacters("tmmzuxt"));          // "mzuxt"
        assertEquals("abcdefga", 7, longestSubstringWithoutRepeatingCharacters("abcdefga"));        // "abcdefg"
        assertEquals("abcdefghij", 10, longestSubstringWithoutRepeatingCharacters("abcdefghij"));   // "abcdefghij"

    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int max = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            Character c = s.charAt(right);
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right);
            } else {
                if(map.size() > max) {
                    max = map.size();
                }
                // remove the old repeated chars
                int charAtIndex = map.get(c);
                while(left < charAtIndex) {
                    map.remove(s.charAt(left));
                    left++;
                }
                // add new char to string
                map.put(c, right);
            }
            right++;
        }

        if (max == 0 && map.size() > 0) {
            max = map.size();
        }
        if (map.size() > max) {
            max = map.size();
        }
        return max;
    }
}
