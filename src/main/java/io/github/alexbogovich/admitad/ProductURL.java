package io.github.alexbogovich.admitad;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
@ToString
public class ProductURL {
    private final String url;
    private final String adSpace;
    private final Map<String, Object> query;

    public ProductURL(String url) throws URISyntaxException {
        this.url = url;
        URI uri = new URI(url);
        this.query = URLEncodedUtils.parse(uri, Charset.forName("UTF-8"))
                .stream()
                .collect(Collectors.toMap(NameValuePair::getName, NameValuePair::getValue));
        int start = uri.getPath().indexOf("/websites/");
        int offset = "/websites/".length();
        int end = uri.getPath().indexOf("/products/");
        this.adSpace = uri.getPath().substring(start + offset, end);
    }
}
