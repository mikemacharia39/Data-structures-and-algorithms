package javasolutionsforalgorithms.hackerrank.arrays;

/**
 * Two words are anagrams of one another if their letters can be rearranged to form the other word.
 *
 * Given a string, split it into two contiguous substrings of equal length.
 * Determine the minimum number of characters to change to make the two substrings into anagrams of one another.
 *
 * Example abccde
 *
 * Break  into two parts: 'abc' and 'cde'.
 * Note that all letters have been used, the substrings are contiguous and their lengths are equal.
 * Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde' which are anagrams.
 * Two changes were necessary.
 */
public class AnagramMidEquality {

    public static int anagram(String s) {
        //aaabbb   -> 3
        //ab       -> 1
        //abc      -> -1
        //mnop     -> 2
        //xyyx     -> 0
        //xaxbbbxx -> 1

        if (s.length()%2 != 0) {
            return -1;
        }

        int len = s.length();
        int count = 0;
        String s1 = s.substring(0,len/2);
        String s2 = s.substring(len/2,len);
        char[] s1Chars = s1.toCharArray();
        for (char c : s1Chars){
            int index = s2.indexOf(c);
            if (index == -1){
                count++;
            } else {
                // this removes the character at the index, so that it is not used again in subsequent iterations
                s2 = s2.substring(0,index)+s2.substring(index+1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] testStrings = {"aaabbb", "ab", "abc", "mnop", "xyyx", "xaxbbbxx"};

        for (String testString : testStrings) {
            System.out.println("TestString: " + testString + "\t" + AnagramMidEquality.anagram(testString));
        }
    }

}
