package general;

/**
 * Input: fixed-size array of characters, containing:
 *
 * 0 or more leading spaces
 * 0 or more words separated by 1 or more spaces
 * 0 or more trailing spaces
 * Output: the same array where spaces are re-distributed between the words in such a way that they are:
 *
 * no more leading spaces
 * no more trailing spaces
 * roughly the same space gaps between the words. i.e. the minimum and the maximum number of spaces
 * between the words can not differ by more than 1.
 * Restriction: in-place algorithm. Do not use additional space for copying the characters.
 *
 * Example:
 * Input: "....word1.....word2.....word3....."
 * Output: "word1.........word2..........word3"
 * Gaps: 10 and 9
 */
public class RedistributeSpaces {


    public static String newWord(String word) {
        int numOfSpaces = numOfSpaces(word);
        String[] words = word.split("\\s+");
        int numOfWords = words.length;

        System.out.println("Num of spaces: " + numOfSpaces + " | words: " + numOfWords);

        // to equally redistribute spaces
        int div = numOfSpaces/(numOfWords-1);

        //to find the remaining spaces
        int rem = numOfSpaces%(numOfWords-1);

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(String str : words) {
            int extra = rem > 0 ? 1 : 0;
            sb.append(str);
            if (count < words.length) { // to prevent spaces at the end
                sb.append(" ".repeat(div + extra));
            }
            count++;
            rem--;
        }

        return sb.toString();
    }

    private static int numOfWords(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }

        return 0;
    }

    private static int numOfSpaces(String word) {
        int numOfSpaces = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                numOfSpaces++;
            }
        }
        return numOfSpaces;
    }



    public static void main(String[] args) {
        String word = "word1     word2     word3   word4 word5 "; //"....word1.....word2.....word3.....";
        //String word = "word1     word2     word3"; //"....word1.....word2.....word3.....";

        System.out.println(RedistributeSpaces.newWord(word));
    }
}
