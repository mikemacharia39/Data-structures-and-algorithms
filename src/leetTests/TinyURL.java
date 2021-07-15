package leetTests;

import java.util.HashMap;
import java.util.Map;

public class TinyURL {

    Map<Integer, String> map = new HashMap();
    String host = "http://tinyurl.com/";

    public static void main(String[] args) {

        TinyURL tinyURL = new TinyURL();

        String shortURL = tinyURL.encode("bestfromeurope.co.ke");
        System.out.println("Encode to shortURL: " + shortURL);

        System.out.println("Decode to longURL:" + tinyURL.decode(shortURL));
    }

    public String encode(String longUrl) {
        int key = longUrl.hashCode();
        map.put(key, longUrl);
        // -655336098 = bestfromeurope.co.ke
        return host+key;
    }

    public String decode(String shortUrl) {
        int key = Integer.parseInt(shortUrl.replace(host,""));
        return map.get(key);
    }
}
