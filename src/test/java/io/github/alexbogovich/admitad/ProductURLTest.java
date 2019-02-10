package io.github.alexbogovich.admitad;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductURLTest {
    @Test
    public void parseProductUrl() throws URISyntaxException {
        String url = "http://export.admitad.com/ru/webmaster/websites/666/products/export_adv_products/?user=testuser&code=ter123&feed_id=14216&format=xml";
        ProductURL productUrl = new ProductURL(url);
        assertEquals("666", productUrl.getAdSpace());
        Map<String, Object> query = new HashMap<>();
        query.put("user", "testuser");
        query.put("code", "ter123");
        query.put("feed_id", "14216");
        query.put("format", "xml");

        assertEquals(query, productUrl.getQuery());
    }
}
