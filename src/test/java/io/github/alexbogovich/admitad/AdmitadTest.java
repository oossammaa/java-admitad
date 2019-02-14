package io.github.alexbogovich.admitad;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import feign.mock.MockTarget;
import feign.mock.RequestKey;
import io.github.alexbogovich.admitad.response.token.OAuth2Token;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdmitadTest {
    private Admitad admitad;
    private MockClient mockClient;
    private AdmitadFeignProvider provider;
    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        provider = new AdmitadFeignProvider();
        mockClient = new MockClient();
        admitad = provider.getAdmitadFeignBuilder()
                .client(mockClient)
                .target(new MockTarget<>(Admitad.class));
    }

    @Test
    public void authToken() throws JsonProcessingException {
        RequestKey requestKey = RequestKey.builder(HttpMethod.POST, "/token/")
                .body("grant_type=client_credentials&client_id=123&scope=a b c")
                .build();
        OAuth2Token expected = OAuth2Token.builder()
                .username("username")
                .firstName("firstname")
                .lastName("lastname")
                .language("lang")
                .accessToken("access token")
                .tokenType("token type")
                .id(567L)
                .expiresIn(666L)
                .build();
        mockClient.add(requestKey, 200, mapper.writeValueAsString(expected));

        Base64 b = new Base64();
        String baseToken = b.encodeAsString("test1:test1".getBytes());
        OAuth2Token token = admitad.token("123", "a b c", baseToken);
        Assertions.assertEquals(expected, token);
    }

    @AfterEach
    void tearDown() {
    }
}
