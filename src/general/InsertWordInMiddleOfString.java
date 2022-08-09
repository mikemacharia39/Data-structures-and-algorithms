package general;

/**
 * Adding a word in a string,
 * This does not handle mid but just gives a concept for how you can do it
 */
public class InsertWordInMiddleOfString {

    public void insertWordUsingStringBuilder() {
        String str = "Java 1.0";
        String word = " Tutorial ";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(str);
        stringBuilder.insert(str.length()/2, word);

        System.out.println("With string builder: new string: " + stringBuilder.toString());
    }

    public void insertWordUsingSubstring() {
        String str = "Java  1.0";
        String word = "Tutorial";

        str = str.substring(0, 5) + word + str.substring(5);

        System.out.println("With sub string: new string: " + str);
    }

    public static void main(String[] args) {
        InsertWordInMiddleOfString insertWordInMiddleOfString = new InsertWordInMiddleOfString();

        insertWordInMiddleOfString.insertWordUsingStringBuilder();
        insertWordInMiddleOfString.insertWordUsingSubstring();
    }
}
