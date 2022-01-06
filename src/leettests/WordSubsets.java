package leettests;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public static void main(String[] args) {
        WordSubsets wordSubsets = new WordSubsets();

        String[] A = {"amazon","apple","facebook","google","leetcode"};
        String[] B = {"e","oo"};
        // [facebook, google]

        System.out.println(wordSubsets.wordSubsets(A, B).toString());
    }

    public List<String> wordSubsets(String[] A, String[] B) {

        List<String> list = new ArrayList<>();
        for (String strInA : A) {
            String stringAdup = strInA;
            for (int g = 0;  g < B.length; g++) {
                strInA = stringAdup;

                char[] inBchar = B[g].toCharArray();
                for (int v = 0; v < inBchar.length; v++) {
                    if (strInA.contains(String.valueOf(inBchar[v]))) {
                        int posInStr = strInA.indexOf(inBchar[v]);
                        strInA = strInA.substring(0, posInStr) + "" + strInA.substring(posInStr+1);
                    }
                }
            }
        }

        return list;
    }

    public List<String> wordSubsets2(String[] A, String[] B) {

        List<String> exclusions = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (String strInA : A) {
            String stringAdup = strInA;
            for (String strInB : B) {
                strInA = stringAdup;
                for (int i = 0; i < strInB.length(); i++) {
                    if (!strInA.contains(String.valueOf(strInB.charAt(i)))) {
                        if (list.contains(stringAdup)) {
                            list.remove(list.indexOf(stringAdup));
                        }
                        exclusions.add(stringAdup);
                    } else {
                        int posInStr = strInA.indexOf(strInB.charAt(i));
                        strInA = strInA.substring(0, posInStr) + "" + strInA.substring(posInStr+1);
                        if (!list.contains(stringAdup) && !exclusions.contains(stringAdup)) {
                            list.add(stringAdup);
                        }
                    }
                }
            }
        }

        return list;
    }

}
