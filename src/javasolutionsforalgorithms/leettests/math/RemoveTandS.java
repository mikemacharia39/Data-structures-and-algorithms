package javasolutionsforalgorithms.leettests.math;

/**
 * text = My name is John Doe. I come from Nairobi
 *
 * Remove all 'a'
 * Extract the 5 word
 * Replace all 'm' with 'o'
 *
 */
public class RemoveTandS {

    /**
     *
     * @param text
     * @return
     */
    public String removeString(String text) {
        text = text.replaceAll("a", "");

        String[] strings = text.split("\\s+");

        int k = 1;
        String found = "";
        for (String s : strings) {
            if (k == 5) {
                found = s;
            }
            k++;
        }

        text = text.replaceAll("m", "o");

        return text;
    }
}
