package _leetcodegoogle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
    class Solution {

        public List<String> wordBreak(String s, List<String> wordDict) {
            return backtrack(s, wordDict, new HashMap<>());
        }

        public List<String> backtrack(String s, List<String> wordDict, Map<String, List<String>> map) {
            if (map.containsKey(s)) {
                return map.get(s);
            }

            List<String> result = new ArrayList<>();
            for (String word : wordDict)
                if (s.startsWith(word)) {
                    String next = s.substring(word.length());
                    if (next.length() == 0) {
                        result.add(word);
                    } else {
                        for (String sub : backtrack(next, wordDict, map)) {
                            result.add(word + " " + sub);
                        }
                    }
                }
            map.put(s, result);
            return result;
        }
    }
}
