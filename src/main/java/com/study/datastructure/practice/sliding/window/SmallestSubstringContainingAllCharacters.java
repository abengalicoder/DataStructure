package com.study.datastructure.practice.sliding.window;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SmallestSubstringContainingAllCharacters {

    @Test
    public void test() {
        assertEquals("abdec", smallestWindow("aabdec", Set.of('a', 'b', 'c')));     // includes all 'a', 'b', 'c'
        assertEquals("abc", smallestWindow("abcabdebac", Set.of('a', 'b', 'c')));   // "bca" is shortest with a,b,c
        assertEquals("this", smallestWindow("this is a test string", Set.of('t', 'i', 's'))); // "tist"
        assertEquals("abbc", smallestWindow("aabbcc", Set.of('a', 'b', 'c')));    // Whole string
        assertEquals("abc", smallestWindow("abc", Set.of('a', 'b', 'c')));          // Perfect match
        assertEquals("", smallestWindow("abc", Set.of('a', 'b', 'd')));            // 'd' is missing
        assertEquals("cab", smallestWindow("cabefgecdaecf", Set.of('a', 'b', 'c'))); // "cab" earliest match
    }

    private static String smallestWindow(String s, Set<Character> words) {
        if (s == null || s.length() == 0 || words == null || words.size() == 0 || words.size() > s.length()) {
            return "";
        }

        Map<Character, Integer> targetFrequency = new HashMap<>();
        words.forEach(character -> targetFrequency.put(character, 1));

        int left = 0, right = 0, startIndex = 0, matchedCharacter = 0;
        int minLength = Integer.MAX_VALUE;

        Map<Character, Integer> windowCharacterFrequency = new HashMap<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (targetFrequency.containsKey(currentChar)) {
                windowCharacterFrequency.put(currentChar, windowCharacterFrequency.getOrDefault(currentChar, 0) + 1);

                if (windowCharacterFrequency.get(currentChar) <= targetFrequency.get(currentChar)) {
                    matchedCharacter++;
                }
            }

            while (matchedCharacter == words.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                Character leftChar = s.charAt(left);
                if (targetFrequency.containsKey(leftChar)) {
                    windowCharacterFrequency.put(leftChar, windowCharacterFrequency.get(leftChar) - 1);

                    if (windowCharacterFrequency.get(leftChar) <  targetFrequency.get(leftChar)) {
                        matchedCharacter--;
                    }
                }
                left++;
            }

            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
