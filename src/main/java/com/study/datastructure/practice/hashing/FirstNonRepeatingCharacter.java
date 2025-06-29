package com.study.datastructure.practice.hashing;

/*
HT: First Non-Repeating Character ( ** Interview Question)
You have been given a string of lowercase letters.

Write a function called firstNonRepeatingChar(String) that finds the first non-repeating character in the given string using a hash table (HashMap). If there is no non-repeating character in the string, the function should return null.

For example, if the input string is "leetcode", the function should return "l" because "l" is the first character that appears only once in the string. Similarly, if the input string is "hello", the function should return "h" because "h" is the first non-repeating character in the string.

Return type: Character
*/

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

    }

    private static Character firstNonRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);
        }

        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) == 1) {
                return charArray[i];
            }
        }
        return null;
    }
}
