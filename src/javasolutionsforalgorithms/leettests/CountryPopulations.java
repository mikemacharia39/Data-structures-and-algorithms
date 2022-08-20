package javasolutionsforalgorithms.leettests;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * I want to assume they pass two arguments
 * 1. country and
 * 2. minimum population per "state"
 *
 * Find the number of states that meet this criteria
 */
public class CountryPopulations {

    private static HttpURLConnection con;
    //private static JSONArray arr;
    static void getCountries(String s, int p) throws MalformedURLException {
        int total = 0;

        try {
            URL myURL = new URL("https://jsonmock.hackerrank.com/api/countries/search?name="+s);
            con = (HttpURLConnection) myURL.openConnection();
            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }

                System.out.println("" + content.toString());

                JSONObject strToJSON = new JSONObject(content.toString());
                JSONArray dataArray = strToJSON.getJSONArray("data");
                StringBuilder statesWithPop = new StringBuilder();
                statesWithPop.append("Countries with population > ");
                statesWithPop.append(p);
                statesWithPop.append(" are ");
                for (int i = 0; i < dataArray.length(); i++) {
                    int population = dataArray.getJSONObject(i).getInt("population");
                    if (population > p) {
                        total++;
                        statesWithPop.append(" name: ");
                        statesWithPop.append(dataArray.getJSONObject(i).getString("name"));
                        statesWithPop.append(" population: ");
                        statesWithPop.append(dataArray.getJSONObject(i).getString("population"));
                    }
                }

                System.out.println(statesWithPop.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            System.out.println("Total= " + total);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        CountryPopulations.getCountries("india", 1);
    }

}
