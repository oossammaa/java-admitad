package io.github.alexbogovich.admitad;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import io.github.alexbogovich.admitad.response.adv.AdmitadAdvResponse;

import java.util.Map;

public interface Admitad {
    @RequestLine("GET /advcampaigns/website/{adSpace}/")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Authorization: Bearer {token}"
    })
    AdmitadAdvResponse adv(
            @Param("token") String token,
            @Param("adSpace") String adSpace,
            @QueryMap Map<String, Object> queryMap
    );
}
