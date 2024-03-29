package tech_stuff.java_concepts.threads;

import com.sun.net.httpserver.Request;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class HypotheticalServerCall {

    void handle(Request request, Response response) throws MalformedURLException, InterruptedException {
        var url1 = URI.create("https://jsonmock.hackerrank.com/api/countries/search?name=india").toURL();
        var url2 = URI.create("https://jsonmock.hackerrank.com/api/countries/search?name=uganda").toURL();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var future1 = executor.submit(() -> fetchURL(url1));
            var future2 = executor.submit(() -> fetchURL(url2));
            response.send(future1.get() + future2.get());
        } catch (ExecutionException e) {
            response.fail(e);
        } catch (InterruptedException e) {
            if (Thread.interrupted())  // Clears interrupted status!
                throw new InterruptedException();
        }
    }

    String fetchURL(URL url) throws IOException {
        try (var in = url.openStream()) {
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}

class Response {
    void send(String response) {
        // send response
    }

    void fail(Exception e) {
        // send error response
    }
}
