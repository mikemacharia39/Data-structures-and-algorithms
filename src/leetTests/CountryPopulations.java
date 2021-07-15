package leetTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CountryPopulations {

    private static HttpURLConnection con;
    //private static JSONArray arr;
    static void getCountries(String s, int p) throws MalformedURLException {
        int total = 0;

        try {
            URL myURL = new URL("https://jsonmock.hackerrank.com/api/countries/search?name="+s);

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {

                    content.append(line);
                    content.append(System.lineSeparator());
                }

//                JSONObject obj = new JSONObject(content.toString());
//                arr = obj.getJSONArray("data");
//                for (int i = 0; i < arr.length(); i++) {
//                    int post_id = arr.getJSONObject(i).getInt("population");
//                    if(post_id > p){
//                        c++;
//                    }
//                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //System.out.println(c);

        } finally {

            con.disconnect();
        }
    }

}
