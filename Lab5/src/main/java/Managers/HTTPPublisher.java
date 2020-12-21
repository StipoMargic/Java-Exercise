package Managers;

import Classes.Sensor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HTTPPublisher {
    private HttpClient client;
    public HttpRequest request;
    private String address;
    private List<Sensor> sensors;

    public HTTPPublisher(String address, List<Sensor> sensors) {
        this.address = address;
        this.sensors = sensors;
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .proxy(ProxySelector.of(new InetSocketAddress("www-proxy.com", 8080)))
                .build();
    }

    public void publish(String data) throws IOException, InterruptedException {
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.address))
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();
    }
}
