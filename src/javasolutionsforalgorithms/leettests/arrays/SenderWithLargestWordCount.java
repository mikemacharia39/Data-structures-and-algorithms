package javasolutionsforalgorithms.leettests.arrays;

import java.util.Map;
import java.util.TreeMap;

/**
 * You have a chat log of n messages.
 * You are given two string arrays messages and senders where messages[i] is a message sent by senders[i].
 *
 * A message is list of words that are separated by a single space with no leading or trailing spaces.
 * The word count of a sender is the total number of words sent by the sender.
 * Note that a sender may send more than one message.
 *
 * Return the sender with the largest word count.
 * If there is more than one sender with the largest word count, return the one with the lexicographically largest name.
 *
 * Note:
 * Uppercase letters come before lowercase letters in lexicographical order.
 * "Alice" and "alice" are distinct.
 *
 * Example 1:
 *
 * Input: messages = ["How is leetcode for everyone","Leetcode is useful for practice"], senders = ["Bob","Charlie"]
 * Output: "Charlie"
 * Explanation: Bob sends a total of 5 words.
 * Charlie sends a total of 5 words.
 * Since there is a tie for the largest word count, we return the sender with the lexicographically larger name, Charlie.
 */
public class SenderWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {

        // sorts the keys in order
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < senders.length; i++) {
            int wordCount = wordCount(messages[i]);
            map.put(senders[i], map.getOrDefault(senders[i], 0) + wordCount);
        }

        // this will sort values in order
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(x -> x.getKey())
                .reduce((a,b) -> b).get(); // then gets the last element
    }

    private int wordCount(String message) {
        return message.split(" ").length;
    }
}
