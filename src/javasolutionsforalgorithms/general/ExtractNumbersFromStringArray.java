package javasolutionsforalgorithms.general;

public class ExtractNumbersFromStringArray {

    public static void extractNumbersFromStringArray(String[] arr) {
        for (String s : arr) {
            String[] split = s.split(", ");
            int x = Integer.parseInt(split[0].substring(1));
            int y = Integer.parseInt(split[1].substring(0, split[1].length() - 1));
            System.out.printf("x: %d, y: %d%n", x, y);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"(1, -1)", "(-2, 2)", "(-3, -3)", "(1, 1)"};
        extractNumbersFromStringArray(arr);
    }
}
