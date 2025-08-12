import java.util.*;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();

        // Initialize map with first char of each word
        for (String word : words) {
            char firstChar = word.charAt(0);
            map.computeIfAbsent(firstChar, k -> new LinkedList<>()).add(word);
        }

        int count = 0;

        // Traverse string s
        for (char c : s.toCharArray()) {
            Queue<String> queue = map.getOrDefault(c, new LinkedList<>());
            int size = queue.size();

            while (size-- > 0) {
                String word = queue.poll();

                if (word.length() == 1) {
                    count++;  // fully matched
                } else {
                    // move next char into its bucket
                    String next = word.substring(1);
                    char nextChar = next.charAt(0);
                    map.computeIfAbsent(nextChar, k -> new LinkedList<>()).add(next);
                }
            }
        }

        return count;
    }
}
