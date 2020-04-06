/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);

            List<String> list;
            if (!hash.containsKey(s)) {
                list = new ArrayList<>();
            } else {
                list = hash.get(s);
            }
            list.add(str);
            hash.put(s, list);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : hash.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
