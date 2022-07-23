package general;

import java.util.StringTokenizer;

public class RedistributeSpaces {


    public static String newWord(String word) {

        int numOfWords = numOfWords(word);
        int numOfSpaces = numOfSpaces(word);



        return word;
    }

    private static int numOfWords(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        StringTokenizer tokens = new StringTokenizer(word);
        return tokens.countTokens();
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

        RedistributeSpaces.newWord(word);
    }
}
