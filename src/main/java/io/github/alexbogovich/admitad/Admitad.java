package io.github.alexbogovich.admitad;

import feign.*;
import io.github.alexbogovich.admitad.response.adv.AdmitadAdvResponse;
import io.github.alexbogovich.admitad.response.token.OAuth2Token;

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

    @RequestLine("POST /token/")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
            "Authorization: Basic {base64}",
    })
    @Body("grant_type=client_credentials&client_id={clientId}&scope={scope}")
    OAuth2Token token(@Param("clientId") String clientId, @Param("scope") String scope, @Param("base64") String baseAuthToken);
}
