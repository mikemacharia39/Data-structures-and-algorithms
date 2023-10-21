package javasolutionsforalgorithms.revision_v2.hackerrank.array;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DiscountedPriceRestAPI {

    /**
     * For now this just explores how we can invoke an endpoint and get results
     * <a href="https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false">...</a>
     */
    public static Map<String, Double> getDiscountedPrice() {
        String vsCurrency = "usd";
        String order = "market_cap_desc";
        int perPage = 10;
        int page = 0;
        String sparkline = "false";
        String endpoint = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=" + vsCurrency
                + "&order=" + order
                + "&per_page=" + perPage
                + "&page=" + page
                + "&sparkline=" + sparkline;
        Map<String, Double> cryptoMap = new HashMap<>();
        try {
            JSONArray jsonArray = getJsonArray(endpoint);

            for (int i = 0; i < jsonArray.length(); i++) {
                cryptoMap.put(jsonArray.getJSONObject(i).getString("id"),
                        jsonArray.getJSONObject(i).getDouble("current_price"));
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return cryptoMap;
    }

    @NotNull
    private static JSONArray getJsonArray(String endpoint) throws IOException, JSONException {
        URL url = new URL(endpoint);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String output = "";
        StringBuilder sb = new StringBuilder();

        while ((output = br.readLine()) != null) {
            sb.append(output);
        }

        return new JSONArray(sb.toString());
    }
}
