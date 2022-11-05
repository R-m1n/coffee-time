package src.main.java.com.algorithms.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A Java implementation of String Manipulation algorithms.
 * 
 * @author R-m1n
 */
public class Strings {
    /**
     * @param str
     * @return number of vowels in input.
     */
    public static int countVowels(String str) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int count = 0;
        for (char letter : str.toLowerCase().toCharArray())
            if (vowels.contains(letter))
                count++;

        return count;
    }

    /**
     * @param str
     * @return reverse of input.
     */
    public static String reverse(String str) {
        if (str == null)
            return "";

        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--)
            reversed.append(str.charAt(i));

        return reversed.toString();
    }

    /**
     * @param sentence
     * @return words in the input in reverse order.
     */
    public static String reWords(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    /**
     * @param str
     * @param other
     * @return true if other is a rotation of str, else false.
     */
    public static boolean isRotation(String str, String other) {
        if (str == null || other == null)
            return false;

        return (str.length() == other.length()) && (str.concat(str).contains(other));
    }

    /**
     * @param str
     * @return input with duplicate items removed.
     */
    public static String removeDuplicate(String str) {
        if (str == null)
            return "";

        Set<Character> seen = new HashSet<>();
        StringBuilder output = new StringBuilder();

        for (char ch : str.toCharArray())
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }

        return output.toString();
    }

    /**
     * @param str
     * @return the character with the highest frequency in the input.
     */
    public static char highestFrequency(String str) {
        if (str.isEmpty() || str == null)
            throw new IllegalArgumentException();

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        char highest = ' ';
        int max = 0;
        for (char ch : map.keySet())
            if (map.get(ch) > max) {
                highest = ch;
                max = map.get(ch);
            }

        return highest;
    }

    /**
     * @param str
     * @return input with all of its words capitalized.
     */
    public static String capitalize(String str) {
        if (str == null || str.trim().isEmpty())
            return "";

        String[] sentences = str.trim().replaceAll(" +", " ").split(" ");

        for (int i = 0; i < sentences.length; i++)
            sentences[i] = sentences[i].substring(0, 1).toUpperCase()
                    + sentences[i].substring(1).toLowerCase();

        return String.join(" ", sentences).trim();
    }

    /**
     * @param str
     * @param other
     * @return true if other is an anagram of str, else false.
     */
    public static boolean isAnagram(String str, String other) {
        if (str == null
                || other == null
                || str.isEmpty()
                || other.isEmpty()
                || str.length() != other.length())

            return false;

        Set<Character> seen = new HashSet<>();

        for (char ch : str.trim().toCharArray())
            seen.add(ch);

        for (char ch : other.trim().toCharArray())
            if (!seen.contains(ch))
                return false;

        return true;
    }

    /**
     * @param str
     * @return true if input is palindrome, else false.
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty())
            return false;

        int i = 0;
        int j = str.length() - 1;
        while (i < j)
            if (str.charAt(i++) != str.charAt(j--))
                return false;

        return true;
    }
}
