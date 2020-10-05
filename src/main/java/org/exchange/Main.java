package org.exchange;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String mainURI = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request;
        HttpResponse response;
        URI uri;
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                uri = URI.create(mainURI + "&valcode=" + args[i]);
                request = HttpRequest.newBuilder(uri)
                        .header("Accept", "application/json")
                        .GET()
                        .build();
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
            }
        } else {
            uri = URI.create(mainURI);
            request = HttpRequest.newBuilder(uri)
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
    }
}
