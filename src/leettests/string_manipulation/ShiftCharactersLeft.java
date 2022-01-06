package leettests.string_manipulation;

public class ShiftCharactersLeft {

    public static void main (String[] args) {
        String input = "Stackoverflow";
        for(int i = input.length()-1; i > 0 ; i--){
            input = shift(input);

            System.out.println(input);
        }
    }

    public static String shift(String s) {
//        return s.substring(1) + s.charAt(0);
        return s.charAt(s.length()-1) + s.substring(0, s.length()-1);
    }

}
