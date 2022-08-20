package javasolutionsforalgorithms.leettests;

public class ConvertBinaryToIntegerAndViseversa {

    public static void main(String[] args) {

        ConvertBinaryToIntegerAndViseversa converter = new ConvertBinaryToIntegerAndViseversa();
        String toBinary = converter.toBinaryString(29);
        System.out.println("Binary: " + toBinary);
        int decimal = converter.toDecimal(toBinary);
        System.out.println("Decimal: " + decimal);
    }

    private String toBinaryString(int value) {

        return Integer.toBinaryString(value);
    }

    private int toDecimal(String binary) {

        return Integer.parseInt(binary, 2);
    }
}
