package io.github.alexbogovich.admitad;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import io.github.alexbogovich.admitad.response.product.ProductResponse;

import java.util.Map;

public interface AdmitadProduct {
    @RequestLine("GET /{lang}/webmaster/websites/{adSpace}/products/export_adv_products/")
    @Headers({
            "Accept: application/xml",
    })
    ProductResponse product(
            @Param("lang") String lang,
            @Param("adSpace") String adSpace,
            @QueryMap Map<String, Object> queryMap
    );
}
