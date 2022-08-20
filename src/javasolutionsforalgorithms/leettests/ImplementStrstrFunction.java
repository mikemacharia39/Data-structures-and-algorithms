package javasolutionsforalgorithms.leettests;


class ImplementStrstrFunction {
    public static void main(String[] args) {

        //String haystack = "hello"; String needle = "ll";
        //Output: 2

        //String haystack = "aaaaa"; String needle = "bba";
        //Output: -1

        String haystack = "", needle = "";
        //Output: 0


        ImplementStrstrFunction implementStrstrFunction = new ImplementStrstrFunction();

        System.out.println(implementStrstrFunction.strStr(haystack, needle));
    }
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;
        if (needle.length() >= 1 && haystack.length() == 0) {
            return -1;
        }

        int j = 0;
        int needleLength = needle.length();
        int threshold = haystack.length() - needle.length();
        for (int i = 0; i <= threshold; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
