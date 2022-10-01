package javasolutionsforalgorithms.branches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParseSampleCSV {
    /**
     * Given the below data input, parse it to extract the below json:
     *
     * productId, name, description, cost
     * 1, cup, it is a cup, $10
     * 2, water, water bottle, $$3
     * 3, soap, bar soap, $2
     * 4, fruits, 'banana, apples', $5
     *
     * The below out is expected
     * [
     * {
     *     "productId": 1,
     *     "name":"cup",
     *     "description": "it is a cup",
     *     "cost": "$10"
     * },
     * {
     *     "productId": 2,
     *     "name":"water",
     *     "description": "it is a cup",
     *     "cost": "$10"
     * }
     * ]
     *
     */

    public static List<HashMap<String, String>> parseSampleCSV(String input) {

        String[] rowItems = input.split("\n");

        String[] header = rowItems[0].split(",");

        return extractRowItems(rowItems, header);
    }

    public static List<HashMap<String, String>> extractRowItems(String[] rowItems, String[] header) {
        int columnCount = header.length;
        List<HashMap<String, String>> hashMapList = new ArrayList<>();
        for (int row = 1; row < rowItems.length; row++) {
            String[] rowData = extractRowData(rowItems[row]);
            HashMap<String, String> mapData = new HashMap<>();
            for (int i = 0; i < columnCount; i++) {
                mapData.put(header[i], rowData[i]);
            }
            hashMapList.add(mapData);
        }
        return hashMapList;
    }

    public static String[] extractRowData(String rowData) {
        if (rowData.contains("'")) {
            int n = 0;
            List<String> stringList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            while (n < rowData.length()) {
                if (rowData.charAt(n) == ',') {
                    stringList.add(sb.toString());
                    sb = new StringBuilder();
                    n++;
                } else if (rowData.charAt(n) == '\'') {
                    n++;
                    while (n < rowData.length() && rowData.charAt(n) != '\'') {
                        sb.append(rowData.charAt(n));
                        n++;
                    }
                    n++;
                } else {
                    sb.append(rowData.charAt(n));
                    n++;
                }
            }
            stringList.add(sb.toString());

            return stringList.toArray(new String[0]);
        } else {
            return rowData.split(",");
        }
    }


    public static void main(String[] args) {
        String input = "" +
                "productId, name, description, cost\n" +
                "1, cup, it is a cup, $10\n" +
                "2, water, water bottle, $3\n" +
                "3, soap, bar soap, $2\n" +
                "4, fruits, 'banana,apples', $5";


        List<HashMap<String, String>> output = ParseSampleCSV.parseSampleCSV(input);

        System.out.println(output);
    }
}
