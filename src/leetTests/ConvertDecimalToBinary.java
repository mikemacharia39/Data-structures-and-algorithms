package leetTests;

public class ConvertDecimalToBinary {

    public static void main(String[] args) {
        ConvertDecimalToBinary toBinary = new ConvertDecimalToBinary();
        int x = 11;
        System.out.println(toBinary.toBinary(x));
    }

    public String toBinary(int n) {
        if (n <= 1 ) {
            return String.valueOf(n);
        }
        return toBinary(n / 2) + n % 2;
    }
}
